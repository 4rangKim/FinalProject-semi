package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.frame.Service;
import com.vo.UserVO;

@Controller
public class UserController {

	@Autowired
	@Qualifier("uservice")
	Service<String, UserVO> service;
	
	
}






