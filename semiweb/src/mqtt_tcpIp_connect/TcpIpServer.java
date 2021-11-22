package mqtt_tcpIp_connect;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpIpServer extends Thread{
	
	ServerSocket server = null;
	Socket client = null;
	InetAddress clientIp = null;
			
	@Override
	public void run() {
		try {
			server = new ServerSocket(12345);
			System.out.println("?���? ?��?��!!");
			
			while(true) {
				client = server.accept();
				if(client != null) {
					clientIp = client.getInetAddress();
					System.out.println("?��?��?�� ?��?��?��?��?�� ip: "+clientIp.getHostAddress());
					
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
