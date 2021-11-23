package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Service;
import com.vo.PlantInfoVO;

@Controller
public class MainController {
	MyMqtt_Pub_client client;
	private Logger data_log = 
			Logger.getLogger("data");
	
	public MainController() {
		client = new MyMqtt_Pub_client();
		
	}
	
	@Resource(name="plantinfoservice")
	Service<String, PlantInfoVO> service;
	
	@RequestMapping("/main.mc")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/plantdetail.mc")
	public ModelAndView detail(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String water = request.getParameter("water");
		System.out.println(water);
		if(water!=null) {
			client.send("water", water);			
		}
		mv.addObject("center", "plantdetail");
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/plantajax.mc")
	@ResponseBody
	public void uu(HttpServletResponse response) throws IOException {
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		JSONArray ja = new JSONArray();
		try {
			List<PlantInfoVO> infolist = service.get();
			PlantInfoVO latestinfo = infolist.get(0);
			
			JSONObject jo = new JSONObject();
			jo.put("temp", latestinfo.getTem());
			jo.put("lux", latestinfo.getLux());
			jo.put("humi", latestinfo.getHumi());
			ja.add(jo);
			
			FcmUtil.sendServer(latestinfo.getTem(),  latestinfo.getLux(), latestinfo.getHumi());
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(ja.toJSONString());
		out.print(ja.toJSONString());
		out.close();
		
	}
	
	@RequestMapping("/getdata.mc")
	@ResponseBody
	public void getAndSaveData(HttpServletRequest request) {
		String data = request.getParameter("temp");
		System.out.println("data:"+data);
		Random random = new Random();
		if(data != null && data != "") {
			int temp = Integer.parseInt(data);			
			System.out.println("라떼판다로부터 받은 데이터: "+temp);
			PlantInfoVO info = new PlantInfoVO(temp, random.nextInt(80), random.nextInt(1000));
			try {
				service.register(info);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping("/plantInfo.mc")
	@ResponseBody
	public void iotdata(HttpServletRequest request) throws IOException {
		String temp = request.getParameter("temp");
		String humi = request.getParameter("humi");
		String lux = request.getParameter("lux");
		int tempVal = Integer.parseInt(temp);
		int humiVal = Integer.parseInt(humi);
		int luxVal = Integer.parseInt(lux);
		System.out.println("temperature : "+tempVal+" humidity : "+humiVal+" brightness : "+luxVal);
		//data_log.debug("습도 : "+f_humi);
		PlantInfoVO v = new PlantInfoVO(tempVal, humiVal, luxVal);
		try {
			service.register(v);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
}





