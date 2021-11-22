package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Service;
import com.vo.UserVO;

@Controller
public class MainController {

	private Logger data_log = 
			Logger.getLogger("data"); 
	
	
	@RequestMapping("/main.mc")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/plantdetail.mc")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "plantdetail");
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/humi.mc")
	@ResponseBody
	public void iotdata(HttpServletRequest request) throws IOException {
		String humi = request.getParameter("humi");
		double f_humi = Double.parseDouble(humi);
		System.out.println("습도 : "+f_humi);
		data_log.debug("습도 : "+f_humi);
		
	}
}





