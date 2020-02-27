package com.cn.app.client.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.cn.app.client.base.HttpResp;
import com.cn.app.client.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String userLogin(HttpServletRequest request,
			HttpServletResponse response) {

		HttpResp httpResp = userService.userLogin(request, response);
		logger.info("========= UserController userLogin: "+JSON.toJSONString(httpResp));
		return "login";
	}

}