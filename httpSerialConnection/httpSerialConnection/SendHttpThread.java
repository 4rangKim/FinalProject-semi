package httpSerialConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SendHttpThread {
	String urlmapping = "http://192.168.0.140/semiweb/getdata.mc";
	URL url;
	String data;
	HttpURLConnection connect;
	BufferedReader br;
	
	public SendHttpThread(String data) {
		this.data = data;
	}
	
	public void sendHttp() {
		Thread send = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("sendhttpthreadÀÇ data°ª:"+data);
				if(data != null && data != "") {
					try {
					
						url = new URL(urlmapping+"?temp="+data);
						connect = (HttpURLConnection) url.openConnection();
						connect.setReadTimeout(5000);
						connect.setRequestMethod("POST");
						connect.getInputStream();
						br = new BufferedReader(new InputStreamReader(connect.getInputStream()));
						
					
					}catch (IOException e) {
						e.printStackTrace();
					} finally {
						connect.disconnect();
						if(br != null) {
							try {
								br.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}else {
					System.out.println("³Î!!");
				}
			}
		});
		send.start();
	}
}
