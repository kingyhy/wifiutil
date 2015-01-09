package com.wifi.util.msg;

import java.io.*;
import java.net.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class AppMessage{
	
	final static String MESSAGE_TAG = "appmsg";
	final static String HEADER_TAG = "head";
	final static String BODY_TAG = "body";
	
	private MessageHeader header;
	
	private MessageBody body;
	
	public MessageBody getBody() {
		return body;
	}

	public String toXmlText() {
		if (header == null) {
			return null;
		}
		String xml = "  <?xml version=\"1.0\" encoding=\"UTF-8\"?><" + MESSAGE_TAG + ">";
		xml += "<" + MessageHeader.MSG_ID_TAG +">" + header.getMsgId() + "</" + MessageHeader.MSG_ID_TAG + ">";

		if (header.getDevMac() != null) {
			xml += "<" + MessageHeader.DEV_MAC_TAG +">" + header.getDevMac() + "</" + MessageHeader.DEV_MAC_TAG + ">";
		}
		
		if (header.getHwId() != null) {
			xml += "<" + MessageHeader.HW_ID_TAG +">" + header.getHwId() + "</" + MessageHeader.HW_ID_TAG + ">";
		}
		
		if (header.getLicense() != null) {
			xml += "<" + MessageHeader.LICENSE_TAG +">" + header.getLicense() + "</" + MessageHeader.LICENSE_TAG + ">";
		}
		
		if (header.getMagic() != null) {
			xml += "<" + MessageHeader.MAGIC_TAG +">" + header.getMagic() + "</" + MessageHeader.MAGIC_TAG + ">";
		}
		
		if (header.getSrcIp() != null) {
			xml += "<" + MessageHeader.SRC_IP_TAG +">" + header.getSrcIp() + "</" + MessageHeader.SRC_IP_TAG + ">";
		}
		
		if (header.getTargetIp() != null) {
			xml += "<" + MessageHeader.TARGET_IP_TAG +">" + header.getTargetIp() + "</" + MessageHeader.TARGET_IP_TAG + ">";
		}
		
		xml += "</" + this.MESSAGE_TAG + ">";
		
		return xml;
	}

	public void setBody(MessageBody body) {
		this.body = body;
	}


	public AppMessage() {
		
	}


	public MessageHeader getHeader() {
		return header;
	}


	public void setHeader(MessageHeader header) {
		this.header = header;
	}
}
