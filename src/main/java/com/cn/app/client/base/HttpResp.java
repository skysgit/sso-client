package com.cn.app.client.base;

public class HttpResp {
	private String interfaceCode;
	private String code;
	private String message;
	private String state;
	private RespBodyData data = new RespBodyData();

	public String getInterfaceCode() {
		return this.interfaceCode;
	}

	public void setInterfaceCode(String interfaceCode) {
		this.interfaceCode = interfaceCode;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public RespBodyData getData() {
		return this.data;
	}

	public void setData(RespBodyData data) {
		this.data = data;
	}
}
