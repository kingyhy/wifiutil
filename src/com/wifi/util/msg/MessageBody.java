package com.wifi.util.msg;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MessageBody {
	private Map<String, String> itemsMap;
	
	public Map<String, String> getItemsMap() {
		return itemsMap;
	}

	public void setItemsMap(Map<String, String> itemsMap) {
		this.itemsMap = itemsMap;
	}

	public String toString() {
		String string = "Body:";
		if (itemsMap != null) {
			Set<String> key = itemsMap.keySet();
	        for (Iterator<String> it = key.iterator(); it.hasNext();) {
	            String s = it.next();
	            string += "\n" + s + " : " + itemsMap.get(s);
	        }
		}
		return string;
	}
}
