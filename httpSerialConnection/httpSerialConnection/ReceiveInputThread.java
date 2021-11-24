package httpSerialConnection;

import java.io.IOException;
import java.io.InputStream;

public class ReceiveInputThread {
	InputStream serialIn;
	
	public ReceiveInputThread(InputStream serialIn) {
		this.serialIn = serialIn;
	}
	
	public void connect() {
		Thread send = new Thread(new Runnable() {
			
			@Override
			public void run() {
				byte[] buffer = new byte[1024];
				int len = -1;
				
				try {
					if((len=serialIn.read(buffer)) >-1){
						String data = new String(buffer, 0 ,len);
						System.out.println("receiveinputthreadÀÇ data°ª:"+data.trim());
						SendHttpThread send = new SendHttpThread(data.trim());
						send.sendHttp();
					}
					Thread.sleep(5000);
				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		send.start();
	}
}
