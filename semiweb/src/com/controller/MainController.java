package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Service;
import com.vo.PlantInfoVO;
import com.vo.UserVO;

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
		try {
			List<PlantInfoVO> infolist = service.get();
			mv.addObject("infolist", infolist);
			System.out.println(infolist);
		} catch (Exception e) {
			e.printStackTrace();
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
		List<PlantInfoVO> infolist = null;
		try {
			infolist = service.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONArray ja = new JSONArray();
		for(PlantInfoVO u:infolist) {
			JSONObject jo = new JSONObject();
			jo.put("temp", u.getTem());
			jo.put("lux", u.getLux());
			jo.put("humi", u.getHumi());
			ja.add(jo);
		}
		System.out.println(ja.toJSONString());

		out.print(ja.toJSONString());

		out.close();
	}
	@RequestMapping("/humi.mc")
	@ResponseBody
	public void iotdata(HttpServletRequest request) throws IOException {
		String humi = request.getParameter("humi");
		double f_humi = Double.parseDouble(humi);
		System.out.println("습도 : "+f_humi);
		data_log.debug("습도 : "+f_humi);
		PlantInfoVO v = new PlantInfoVO(f_humi);
		try {
			service.register(v);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}





