package com.cn.app.client.service;

import com.cn.app.client.base.HttpReq;
import com.cn.app.client.base.HttpResp;

public abstract interface UserCenterService{
	  public abstract HttpResp userLogin(HttpReq httpReq);
	  
}
