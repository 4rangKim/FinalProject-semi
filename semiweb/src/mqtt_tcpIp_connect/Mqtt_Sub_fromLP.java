package mqtt_tcpIp_connect;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Mqtt_Sub_fromLP implements MqttCallback{
	private MqttClient mqttClient;
	private MqttConnectOptions mqttOption;
	ServerSocket server = null;
	Socket client = null;
	InetAddress clientIp = null;
	TcpServer tcpServer;
	AndroidSender sender;
	
	public Mqtt_Sub_fromLP init(String server, String clientId) {
		mqttOption = new MqttConnectOptions();
		mqttOption.setCleanSession(true);
		mqttOption.setKeepAliveInterval(30);
		try {
			mqttClient = new MqttClient(server, clientId);
			mqttClient.setCallback(this);
			mqttClient.connect(mqttOption);
		} catch (MqttException e) {
			e.printStackTrace();
		}
		tcpServer = new TcpServer();
		tcpServer.start();
		return this;
	}
	@Override
	public void connectionLost(Throwable arg0) {
		
	}
	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		
	}
	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		System.out.println("==============MqttÎ©îÏÑ∏Ïß? ?àò?ã†===============");
		System.out.println("?Ü†?îΩ: "+topic);
		System.out.println("Î©îÏÑ∏Ïß?: "+message);
		System.out.println("id: "+message.getId());
		
		sender = new AndroidSender(tcpServer.getClient(), new String(message.getPayload()));
		sender.send();
	}
	
	public boolean subscribe(String topic) {
		try {
			if(topic != null) {
			mqttClient.subscribe(topic, 0); 
			}
		} catch (MqttException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public class TcpServer extends Thread{
		@Override
		public void run() {
			try {
				server = new ServerSocket(12345);
				System.out.println("?ÑúÎ≤? ?ãú?ûë!!");
				
				while(true) {
					client = server.accept();
					if(client != null) {
						clientIp = client.getInetAddress();
						System.out.println("?†ë?Üç?ïú ?Å¥?ùº?ù¥?ñ∏?ä∏ ip: "+clientIp.getHostAddress());
						new ReceivefromAndroidThread(client, mqttClient).start();
					}
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public Socket getClient() {
			return client;
		}
		
		public ServerSocket getServer() {
			return server;
		}
	}
	
}