package com.controller;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

public class MyMqtt_Pub_client {
	private MqttClient client;
	public MyMqtt_Pub_client(){
		try {
			client = new MqttClient("tcp://192.168.0.140:1883", "myid2");
			client.connect();
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}
	public boolean send(String topic, String msg) {
		MqttMessage message = new MqttMessage();
		message.setPayload(msg.getBytes()); 
		try {
			client.publish(topic, message); 
		} catch (MqttPersistenceException e) {
			e.printStackTrace();
		} catch (MqttException e) {
			e.printStackTrace();
		} 
		System.out.println("Message Published");
		return true;
	}
	
	public void close() {
		try {
			if(client != null) {
				client.disconnect();
				client.close(); 
			} 
		} catch (MqttException e) {
				e.printStackTrace();
			}
		
	}

}
