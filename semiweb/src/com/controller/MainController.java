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

	private Logger data_log = 
			Logger.getLogger("data"); 
	
	
	@Resource(name="plantinfoservice")
	Service<String, PlantInfoVO> service;
	
	@RequestMapping("/main.mc")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/plantdetail.mc")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
//		try {
//			List<PlantInfoVO> infolist = service.get();
//			PlantInfoVO latestinfo = infolist.get(0);
//			//mv.addObject("infolist", infolist);
//			//mv.addObject("latestinfo", latestinfo);
//			//System.out.println(latestinfo);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		mv.addObject("center", "plantdetail");
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/plantajax.mc")
	@ResponseBody
	public void uu(HttpServletResponse response) throws IOException {
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//List<PlantInfoVO> infolist = null;
		//PlantInfoVO latestinfo = infolist.get(0);
		JSONArray ja = new JSONArray();
		try {
			List<PlantInfoVO> infolist = service.get();
			PlantInfoVO latestinfo = infolist.get(0);
			
			JSONObject jo = new JSONObject();
			jo.put("temp", latestinfo.getTem());
			jo.put("lux", latestinfo.getLux());
			jo.put("humi", latestinfo.getHumi());
			ja.add(jo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(ja.toJSONString());

		out.print(ja.toJSONString());

		out.close();
	}
//	@RequestMapping("/humi.mc")
//	@ResponseBody
//	public void iotdata(HttpServletRequest request) throws IOException {
//		String humi = request.getParameter("humi");
//		double f_humi = Double.parseDouble(humi);
//		System.out.println("습도 : "+f_humi);
//		data_log.debug("습도 : "+f_humi);
//		PlantInfoVO v = new PlantInfoVO(f_humi);
//		try {
//			service.register(v);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	@RequestMapping("/getdata.mc")
	@ResponseBody
	public void getAndSaveData(HttpServletRequest request) {
		String data = request.getParameter("temp");
		System.out.println("data:"+data);
		Random random = new Random();
		if(data != null && data != "") {
			double temp = Double.parseDouble(data);			
			System.out.println("라떼판다로부터 받은 데이터: "+temp);
			PlantInfoVO info = new PlantInfoVO(temp, random.nextInt(80), random.nextInt(1000));
			try {
				service.register(info);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}





