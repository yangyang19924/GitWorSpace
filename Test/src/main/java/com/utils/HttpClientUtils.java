package com.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * HttpClient工具类.
 * 需根据实际并发调整参数.
 */
public class HttpClientUtils {
	private final Logger log = LoggerFactory.getLogger(HttpClientUtils.class);

	/**
	 * Defines the socket timeout ({@code SO_TIMEOUT}) in milliseconds,
	 * which is the timeout for waiting for data  or, put differently,
	 * a maximum period inactivity between two consecutive data packets).
	 * <p>
	 * A timeout value of zero is interpreted as an infinite timeout.
	 * A negative value is interpreted as undefined (system default).
	 * </p>
	 * <p>
	 * Default: {@code -1}
	 * </p>
	 */
	private int socketTimeout = 2000;

	/**
	 * Determines the timeout in milliseconds until a connection is established.
	 * A timeout value of zero is interpreted as an infinite timeout.
	 * <p>
	 * A timeout value of zero is interpreted as an infinite timeout.
	 * A negative value is interpreted as undefined (system default).
	 * </p>
	 * <p>
	 * Default: {@code -1}
	 * </p>
	 */
	private int connectTimeout = 2000;

	/**
	 * Returns the timeout in milliseconds used when requesting a connection
	 * from the connection manager. A timeout value of zero is interpreted
	 * as an infinite timeout.
	 * <p>
	 * A timeout value of zero is interpreted as an infinite timeout.
	 * A negative value is interpreted as undefined (system default).
	 * </p>
	 * <p>
	 * Default: {@code -1}
	 * </p>
	 */
	private int connectionRequestTimeout = 10000;

	/**
	 * the maximum total number of connections in the pool.
	 * Default: 20
	 */
	private  int maxConnTotal = 100;

	/**
	 * the maximum number of connections to a particular host.
	 * Default: 2
	 */
	private int maxConnPerRoute = 50;
	/**
	 * single HttpClientUtils instance.
	 */
	private static volatile HttpClientUtils ins;

	/**
	 * single HttpClient instance.
	 */
	private HttpClient client;

	/**
	 * single RequestConfig instance.
	 */
	private RequestConfig config;

	private HttpClientUtils() {
		// first init
		if (config == null) {
			config = RequestConfig.custom()
					.setConnectionRequestTimeout(connectionRequestTimeout)
					.setConnectTimeout(connectTimeout)
					.setSocketTimeout(socketTimeout).build();
		}

		if (client == null) {
			client = HttpClients.custom().setDefaultRequestConfig(config)
					.setMaxConnTotal(maxConnTotal)
					.setMaxConnPerRoute(maxConnPerRoute).build();
		}
	}

	public static HttpClientUtils getInstance() {
		if (ins == null) {
			synchronized (HttpClientUtils.class) {
				if (ins == null) {
					ins = new HttpClientUtils();
				}
			}
		}
		return ins;
	}

	public String doGetWithJsonResult(String uri) {
		String json = null;
		log.debug("========= Call [{}] Start ==========", uri);
		HttpGet request = new HttpGet(uri);
		try {
			request.setConfig(config);
			HttpResponse response = client.execute(request);
			log.debug("Response status code: {}", response.getStatusLine().getStatusCode());
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				json = EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));
				log.debug("Result json : {}", json);
			} else {
				if (response.getEntity() != null) {
					EntityUtils.consume(response.getEntity());
				}
			}
		} catch (Exception e) {
			log.error("HttpClient has exception! message: {}", e.getMessage(), e);
		} finally {
			request.releaseConnection();
		}
		log.debug("========= Call [{}] End ==========", uri);
		return json;
	}


	public String uploadFileWithJsonResult(String uri, File file, Map<String, String> paramMap){
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		FileBody fileBody = new FileBody(file);
		builder.addPart("file", fileBody);
		if (paramMap != null && !paramMap.isEmpty()) {
			for (Map.Entry<String, String> e : paramMap.entrySet()) {
				builder.addTextBody(e.getKey(), e.getValue());
			}
		}
		HttpEntity entity = builder.build();
		return doPostWithJsonResult(uri, entity);
	}

	private String doPostWithJsonResult(String uri, HttpEntity entity) {
		String json = null;
		log.debug("========= Call [{}] Start ==========", uri);
		HttpPost request = new HttpPost(uri);
		try {
			request.setConfig(config);
			request.setEntity(entity);
			HttpResponse response = client.execute(request);
			log.debug("Response status code: {}", response.getStatusLine().getStatusCode());
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				json = EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));
				log.debug("Result json : {}", json);
			} else {
				if (response.getEntity() != null) {
					EntityUtils.consume(response.getEntity());
				}
			}
		} catch (Exception e) {
			log.error("HttpClient has exception! message: {}", e.getMessage(), e);
		} finally {
			request.releaseConnection();
		}
		log.debug("========= Call [{}] End ==========", uri);
		return json;
	}

	public String doPostWithJsonResult(String uri, Map<String, String> paramMap) {
		HttpEntity entity = null;
		List<NameValuePair> params = new ArrayList<NameValuePair>(0);
		if (paramMap != null && !paramMap.isEmpty()) {
			for (String key : paramMap.keySet()) {
				params.add(new BasicNameValuePair(key, paramMap.get(key)));
			}
		}
		try {
			entity = new UrlEncodedFormEntity(params, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return  doPostWithJsonResult(uri, entity);
	}




	public static  void  main(String ...args) {
//		while (true) {
//			new Thread(){
//				@Override
//				public void run() {
//					JSONObject params = new JSONObject();
//					params.put("loginAccount", "13381113363");
//					params.put("loginPsw", "123456");
//					Map<String, String> data = new HashMap<String, String>();
//					data.put("data", params.toJSONString());
//					JSONObject logInResult = JSONObject.parseObject(HttpClientUtils.getInstance().doPostWithJsonResult("http://172.16.102.238:8080/op/commonUtil/getMobileByUserIds.action?userIds=12356,11123", data));
//
//				}
//			}.start();
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}

	}
}
