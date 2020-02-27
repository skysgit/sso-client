package com.cn.app.client.base;

import java.util.Date;

public class HttpReq {
	private String interfaceCode;
	private Date requestTime;
	private String uuid;
	private String userId;
	private ReqBodyData data = new ReqBodyData();

	public String getInterfaceCode() {
		return this.interfaceCode;
	}

	public void setInterfaceCode(String interfaceCode) {
		this.interfaceCode = interfaceCode;
	}

	public Date getRequestTime() {
		return this.requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public ReqBodyData getData() {
		return this.data;
	}

	public void setData(ReqBodyData data) {
		this.data = data;
	}
}
