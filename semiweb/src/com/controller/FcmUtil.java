package com.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;


@Controller
public class FcmUtil {
	public final static String API_KEY = "AAAAQyjhJfU:APA91bG-DNTp11i_5IWvwBQ6OP6ls3iPGRj8x3gOqFeinPYowYjlGgRB5jBlyTZPg-0096QnF04qAAPVhKrQ0EyzJVf7Q8FBeWVrjb9C2kLUtqsOIiTO_aPaCJ4mZW-Emua65gNuO2Wc";
	public final static String URL = "https://fcm.googleapis.com/fcm/send";


	public static void sendServer(int temp, int humi, int lux) throws Exception{
		URL url = new URL(URL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Authorization", "key=" + API_KEY);

		conn.setDoOutput(true);

		/*
		 * JSONObject notification = new JSONObject(); notification.put("title",
		 * "타이틀 입니다."); notification.put("body", "바디 입니다.");
		 */
		
		JSONObject sdata = new JSONObject();
		sdata.put("c1", temp+"");
		sdata.put("c2", humi+"");
		sdata.put("c3", lux+"");
		
		JSONObject body = new JSONObject();
		/* body.put("notification", notification); */
		body.put("data",sdata);
		body.put("to", "dhwjGxrZRfOiJ7U12qQ4nq:APA91bHXokT_Bv2K0F4RFiG6EvXtsTr92soAjOiLnnbJmcMNcJsXV28Eu4EoHFhakX_8Mz-Mr3oCqVkjgqFC5MkcJI6KHh7QzGZX6FqtUUX7Vz8ne0hWZ2RIIYKntfLsMhe4D0lEg-5I");

		OutputStream os = conn.getOutputStream();

		// 서버에서 날려서 한글 깨지는 사람은 아래처럼 UTF-8로 인코딩
		os.write(body.toJSONString().getBytes("UTF-8"));
		os.flush();
		os.close();

		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

	}

}
