package com.cn.app.client.http.service;

import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.cn.app.client.http.vo.TransResultSet;

@Service
public class HttpClientService {

	public static final int DATAERROR_CODE = 9999;
	private static final String APPLICATION_JSON = "application/json";
	private static final String CONTENT_TYPE_TEXT_JSON = "text/json";
	public static final String CHARTFORINF = "UTF-8";

	public TransResultSet doPostTran(String hostUrl, Object requestObj,
			String charset) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(hostUrl);
		String jsonString = JSON.toJSONString(requestObj);
		System.out.println(
				"======================httpPost通讯请求数据=========================");
		System.out.println(jsonString);
		System.out.println(
				"======================httpPost通讯请求数据=========================");
		String encoderJson = URLEncoder.encode(jsonString, charset);
		StringEntity se = new StringEntity(encoderJson);
		se.setContentType("text/json");
		se.setContentEncoding(
				new BasicHeader("Content-Type", "application/json"));
		TransResultSet resultSet = new TransResultSet();
		try {
			httppost.setEntity(se);
			CloseableHttpResponse response = httpclient.execute(httppost);
			try {
				int statusCode = response.getStatusLine().getStatusCode();
				resultSet.setCode(statusCode);
				if (statusCode == 200) {
					HttpEntity resEntity = response.getEntity();
					String result = URLDecoder
							.decode(EntityUtils.toString(resEntity), charset);
					System.out.println(
							"===========================httpPost通讯返回数据========================");
					System.out.println(result);
					System.out.println(
							"===========================httpPost通讯返回数据========================");
					resultSet.setResponseData(result);
				}
			} finally {
				response.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultSet.setCode(9999);
			return resultSet;
		} finally {
			httpclient.close();
		}
		return resultSet;
	}

	public TransResultSet doPostTranNotEncode(String hostUrl, Object requestObj)
			throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(hostUrl);
		String jsonString = JSON.toJSONString(requestObj);
		System.out.println(
				"======================httpPost通讯请求数据=========================");
		System.out.println(hostUrl);
		System.out.println(jsonString);
		System.out.println(
				"======================httpPost通讯请求数据=========================");
		StringEntity se = new StringEntity(jsonString, "UTF-8");
		httppost.setHeader("Accept", "application/json");
		se.setContentType("application/json");
		se.setContentEncoding(
				new BasicHeader("Content-Type", "application/json"));
		TransResultSet resultSet = new TransResultSet();
		try {
			httppost.setEntity(se);
			CloseableHttpResponse response = httpclient.execute(httppost);
			try {
				int statusCode = response.getStatusLine().getStatusCode();
				resultSet.setCode(statusCode);
				if (statusCode == 200) {
					HttpEntity resEntity = response.getEntity();
					String result = EntityUtils.toString(resEntity);
					System.out.println(
							"===========================httpPost通讯返回数据========================");
					System.out.println(result);
					System.out.println(
							"===========================httpPost通讯返回数据========================");
					resultSet.setResponseData(result);
				}
			} finally {
				response.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultSet.setCode(9999);
			return resultSet;
		} finally {
			httpclient.close();
		}
		return resultSet;
	}

	public TransResultSet doGetTran(String hostUrl) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(hostUrl);
		TransResultSet resultSet = new TransResultSet();
		try {
			CloseableHttpResponse response = httpclient.execute(httpGet);
			try {
				int statusCode = response.getStatusLine().getStatusCode();
				resultSet.setCode(statusCode);
				if (statusCode == 200) {
					HttpEntity resEntity = response.getEntity();
					String result = EntityUtils.toString(resEntity, "UTF-8");
					System.out.println(
							"===============================================");
					System.out.println(hostUrl);
					System.out.println(result);
					System.out.println(
							"===============================================");
					resultSet.setResponseData(result);
				}
			} finally {
				response.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultSet.setCode(9999);
			return resultSet;
		} finally {
			httpclient.close();
		}
		return resultSet;
	}
}
