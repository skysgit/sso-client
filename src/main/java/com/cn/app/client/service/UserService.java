package com.cn.app.client.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.app.client.base.HttpReq;
import com.cn.app.client.base.HttpResp;

public abstract interface UserService{
	  public abstract HttpResp userLogin(HttpServletRequest request , HttpServletResponse response);
}
