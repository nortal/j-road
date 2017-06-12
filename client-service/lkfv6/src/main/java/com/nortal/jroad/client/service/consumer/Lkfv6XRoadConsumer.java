package com.nortal.jroad.client.service.consumer;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.springframework.stereotype.Service;
import org.springframework.ws.transport.http.HttpUrlConnectionMessageSender;

@Service("lkfv6XRoadConsumer")
public class Lkfv6XRoadConsumer extends StandardXRoadConsumer {
	
	public static final int DEFAULT_READ_TIMEOUT = 10000;
	public static final int DEFAULT_CONNECTION_TIMEOUT = 10000;
	
	private int customReadTimeout = DEFAULT_READ_TIMEOUT;
	private int customConnectionTimeout = DEFAULT_CONNECTION_TIMEOUT;
	
	@Override
	protected void initGateway() throws Exception {
		super.initGateway();
		setMessageSender(new CustomHttpUrlConnectionMessageSender());
	}
	
	private class CustomHttpUrlConnectionMessageSender extends HttpUrlConnectionMessageSender {
		
		@Override
		protected void prepareConnection(HttpURLConnection connection) throws IOException {
			super.prepareConnection(connection);
			connection.setReadTimeout(customReadTimeout);
			connection.setConnectTimeout(customConnectionTimeout);
		}
	}
	
	public void setReadTimeout(int timeout) {
		customReadTimeout = timeout;
	}
	
	public void setConnectionTimeout(int timeout) {
		customConnectionTimeout = timeout;
	}
}
