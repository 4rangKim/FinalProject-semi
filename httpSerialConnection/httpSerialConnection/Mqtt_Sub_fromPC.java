package httpSerialConnection;

import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Mqtt_Sub_fromPC implements MqttCallback{
	SerialArduinoLEDControl serialObj;
	String server;
	String clientId;
	MqttClient mqttClient;
	MqttConnectOptions mqttOption;
	OutputStream serialOut;
	ReceivefromMqttThread receive;
	
	public Mqtt_Sub_fromPC init(String server, String clientId, OutputStream serialOut) {
		this.server = server;
		this.clientId = clientId;
		this.serialOut = serialOut;
					
		mqttOption = new MqttConnectOptions();
		mqttOption.setCleanSession(true);
		mqttOption.setKeepAliveInterval(30);
		
		try {
			mqttClient = new MqttClient(server, clientId);
			mqttClient.setCallback(this);
			mqttClient.connect(mqttOption);
			System.out.println("Connected");
		} catch (MqttException e) {
			e.printStackTrace();
		}
		
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
		System.out.println("====================메세지 수신======================");
		System.out.println("토픽: "+topic);
		System.out.println("메세지: "+message);
		System.out.println("id: "+message.getId());
		
		receive = new ReceivefromMqttThread(new String(message.getPayload()), serialOut);
		receive.start();
	}
	
	public boolean subscribe(String topic) {
		try {
			if(topic != null) {
				mqttClient.subscribe(topic, 0);
				System.out.println("Subscribe");
			}
		} catch (MqttException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public MqttClient getMqttClient() {
		return mqttClient;
	}
	
	public void setOut(OutputStream serialOut) {
		this.serialOut = serialOut;
	}
}
