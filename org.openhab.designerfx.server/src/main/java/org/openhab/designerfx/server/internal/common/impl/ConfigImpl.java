package org.openhab.designerfx.server.internal.common.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.openhab.designerfx.server.common.Config;
import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;

@Component
public class ConfigImpl implements Config {
	
	private Map<String, String> map;
	
	@Override
	public void load(InputStreamReader inputStreamReader) throws IOException {
		map = Maps.newHashMap();
		Properties props = new Properties();
		props.load(inputStreamReader);
		Set<Entry<Object, Object>> es = props.entrySet();
		Iterator<Entry<Object, Object>> it = es.iterator();
		while (it.hasNext()) {
			Entry<Object, Object> entry = it.next();
			String name = (String) entry.getKey();
			String value = (String) entry.getValue();
			map.put(name, value);
		}
	}
	
	@Override
	public String getHost() {
		return map.get("host");
	}
	
	@Override
	public String getPort() {
		return map.get("port");
	}

}
