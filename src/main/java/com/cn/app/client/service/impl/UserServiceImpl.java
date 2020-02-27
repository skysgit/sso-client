package com.cn.app.client.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.app.client.base.HttpReq;
import com.cn.app.client.base.HttpResp;
import com.cn.app.client.service.UserCenterService;
import com.cn.app.client.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserCenterService userCenterService;

	@Override
	public HttpResp userLogin(HttpServletRequest request,
			HttpServletResponse response) {
		HttpReq httpReq = new HttpReq();
		
		HttpResp httpResp = userCenterService.userLogin(httpReq);
		return httpResp;
	}

}