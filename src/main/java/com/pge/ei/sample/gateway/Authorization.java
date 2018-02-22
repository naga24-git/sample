package com.pge.ei.sample.gateway;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Base64;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.transport.http.HttpUrlConnectionMessageSender;

public class Authorization extends HttpUrlConnectionMessageSender {
	
	@Value("${authcredentials}")
	private String authCredentials;

	private static final Logger LOGGER = Logger.getLogger(Authorization.class);

	@Override
	protected void prepareConnection(HttpURLConnection connection) {

		String encodedAuthorization = Base64.getEncoder().encodeToString(authCredentials.getBytes());
		connection.setRequestProperty("Authorization", "Basic " + encodedAuthorization);
		try {
			super.prepareConnection(connection);
		} catch (IOException e) {
			LOGGER.error("Error in setting up Authorization Header", e);
		}
	}

}
