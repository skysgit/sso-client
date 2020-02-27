package com.cn.app.client.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.cn.app.client.base.HttpReq;
import com.cn.app.client.base.HttpResp;
import com.cn.app.client.constant.UserInterfaceCode;
import com.cn.app.client.http.service.HttpClientService;
import com.cn.app.client.http.vo.TransResultSet;
import com.cn.app.client.service.UserCenterService;

@RefreshScope
@Service
public class UserCenterServiceImpl implements UserCenterService {

	@Value("${sso-server.url}")
	private String serUrl;
	private static final String NET_ERROR = "与后台通讯异常";
	private static final String DATA_ERROR = "数据解析异常";

	@Autowired
	private HttpClientService httpClientService;

	private HttpResp doUserCenterTrans(HttpReq httpReq) {
		HttpResp httpResp = new HttpResp();
		try {
			TransResultSet resultSet = httpClientService.doPostTran(this.serUrl,
					httpReq, "UTF-8");
			if (resultSet.getCode() == 200) {
				httpResp = (HttpResp) JSON.parseObject(
						resultSet.getResponseData(), HttpResp.class);
			} else {
				httpResp.setCode(String.valueOf(resultSet.getCode()));
				httpResp.setMessage("与后台通讯异常");
			}
		} catch (Exception e) {
			e.printStackTrace();
			httpResp.setCode("9999");
			httpResp.setMessage("数据解析异常");
		}
		return httpResp;
	}

	@Override
	public HttpResp userLogin(HttpReq httpReq) {
		httpReq.setInterfaceCode(UserInterfaceCode.USER_LOGIN);
		httpReq.setRequestTime(new Date());
		return doUserCenterTrans(httpReq);
	}

}