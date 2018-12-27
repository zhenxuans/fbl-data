package me.robbie.fbl.data.handler;

import java.net.URI;
import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;

import me.robbie.fbl.common.DataHandler;
import me.robbie.fbl.data.handler.HttpClientFactory;
import me.robbie.fbl.data.model.footballdata.ResponseData;

public abstract class AbstractFblDataHandler implements DataHandler {

	protected HttpClientFactory factory = HttpClientFactory.getInstance();
	
	protected HashMap<String, String> headers = new HashMap<String, String>();
	
	public AbstractFblDataHandler() {
	}
	
	protected <T> T parse(String uriString, Class<T> clazz) {
		URI uri = URI.create(uriString);
		ResponseData resp = factory.get(uri, headers);
		if(resp.getResponseCode() == 200) {
			T t = JSONObject.parseObject(resp.getContent(), clazz);
			return t;
		}
		
		return null;
	}
}