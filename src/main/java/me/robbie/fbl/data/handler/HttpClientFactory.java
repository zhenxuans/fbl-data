package me.robbie.fbl.data.handler;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;

import me.robbie.fbl.data.model.footballdata.ResponseData;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class HttpClientFactory {

	private volatile static HttpClientFactory factory;
	private CloseableHttpClient httpClient;
	
	private HttpClientFactory() {
		
	}
	
	public static HttpClientFactory getInstance() {
		if(factory == null) {
			
			synchronized (HttpClientFactory.class) {
				if(factory == null)
					factory = new HttpClientFactory();
			}
		}
		
		return factory;
	}
	
	public ResponseData get(URI uri, HashMap<String, String> headers) {
		
		httpClient = HttpClients.createDefault();
		
		try {
			HttpGet req = new HttpGet(uri);
			
			if(headers != null)
				headers.forEach((key, value) -> req.addHeader(key, value));
			
			CloseableHttpResponse resp = (CloseableHttpResponse)httpClient.execute(req);
			
			ResponseData respData = new ResponseData();
			Header[] respHeaders = resp.getAllHeaders();
			HashMap<String, String> respHeadersMap = new HashMap<String, String>();
			for(Header respHeader : respHeaders) {
				respHeadersMap.put(respHeader.getName(), respHeader.getValue());
			}
			respData.setHeaders(respHeadersMap);
			respData.setResponseCode(resp.getStatusLine().getStatusCode());
			respData.setReasonPhrase(resp.getStatusLine().getReasonPhrase());
			
			HttpEntity entity = resp.getEntity();
			String content = EntityUtils.toString(entity, Charset.forName("utf8"));
			respData.setContent(content);
			log.debug(respData.toString());
			
			return respData;
		} catch (Exception e) {
			log.error(e.getMessage());
			for(StackTraceElement ste : e.getStackTrace()) {
				log.error(ste.toString());
			}
		}
		finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				log.error(e.getMessage());
			}
		}
		
		return null;
	}

}
