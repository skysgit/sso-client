package com.cn.app.client.http.vo;
public class TransResultSet
{
  private int code;
  private String responseData;

  public int getCode()
  {
    return this.code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getResponseData() {
    return this.responseData;
  }

  public void setResponseData(String responseData) {
    this.responseData = responseData;
  }
}