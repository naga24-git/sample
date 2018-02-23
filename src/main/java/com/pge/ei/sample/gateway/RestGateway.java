package com.pge.ei.sample.gateway;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

@Service
public class RestGateway {

	//@Value("${userName}")
	private String userName;

	//@Value("${password}")
	private String password;

	private static final Logger LOGGER = Logger.getLogger(RestGateway.class);

	public RestTemplate getRestTemplate() {
		CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier())
				.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(userName, password));
		return restTemplate;
	}

	// This method converts the response from Json to object
	public Object getObjectResponse(String url, HttpMethod method) {
		LOGGER.info("getObjectResponse method start");
		String body = getStringResponse(url, method);
		Object fileParameterResponse = new Gson().fromJson(body, Object.class);
		LOGGER.info("getObjectResponse method end");
		return fileParameterResponse;
	}

	// This method calls the RestTemplate to get response
	public String getStringResponse(String url, HttpMethod method) {
		LOGGER.info("getStringResponse method start");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<String> responseEntity = getRestTemplate().exchange(url, method, entity, String.class);
		String body = responseEntity.getBody();
		LOGGER.info("getStringResponse method end");
		return body;
	}

}
