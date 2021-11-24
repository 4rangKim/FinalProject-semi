package httpSerialConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ReceivefromMqttThread extends Thread{
	String message;
	OutputStream serialOut;
	
	public ReceivefromMqttThread(String message, OutputStream serialOut) {
		super();
		this.message = message;
		this.serialOut = serialOut;
	}
	
	
	@Override
	public void run() {
		try {
			System.out.println("수신된 메세지: "+message);
			if(message.equals("1")) {
				serialOut.write('o');
			}else if(message.equals("0")) {
				serialOut.write('f');
			}else if(message.equals("on")) {
				serialOut.write('o');
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
