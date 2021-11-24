package httpSerialConnection;

import java.io.InputStream;
import java.io.OutputStream;


public class HttpSerialConnectionServer {
	SerialArduinoLEDControl serialObj;
	Mqtt_Sub_fromPC mqttSerial;
	OutputStream serialOut;
	
	public HttpSerialConnectionServer() {
		serialObj = new SerialArduinoLEDControl();
		serialObj.connect("COM5");
		serialOut = serialObj.getOutput();
		mqttSerial = new Mqtt_Sub_fromPC();
		mqttSerial.init("tcp://192.168.0.140:1883", "semII", serialOut).subscribe("water");
	}
	
	public void connect() {
		Thread start = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					InputStream serialIn = serialObj.getInput();
					
					ReceiveInputThread receive = new ReceiveInputThread(serialIn);
					receive.connect();
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		start.start();
	}
	
	public static void main(String[] args) {
		new HttpSerialConnectionServer().connect();
	}

}
