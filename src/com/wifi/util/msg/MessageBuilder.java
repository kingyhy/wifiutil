package com.wifi.util.msg;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Branch;
import org.dom4j.Comment;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.DocumentType;
import org.dom4j.Element;
import org.dom4j.InvalidXPathException;
import org.dom4j.Node;
import org.dom4j.ProcessingInstruction;
import org.dom4j.QName;
import org.dom4j.Visitor;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;
import org.xml.sax.EntityResolver;

public class MessageBuilder {
	
	private String xmlText = null;
	
	public MessageBuilder () {
		
	}
	
	public MessageBuilder (String xmlTxt) {
		this.xmlText = xmlTxt;
	}
	
	public MessageBuilder setXMLText(String xmlTxt) {
		xmlText = xmlTxt;
		return this;
	}
	
	@SuppressWarnings("unchecked")
	public AppMessage buildAppMessage() throws DocumentException {
		AppMessage msg = new AppMessage();
		try {
			Document document = DocumentHelper.parseText(this.xmlText);
			Element rootElt = document.getRootElement();
			if (!rootElt.getName().equals(AppMessage.MESSAGE_TAG)) {
				System.err.println("The xml message tag is incorrect!" + rootElt.getName());
				return null;
			}
			
            Element headElt = rootElt.element(AppMessage.HEADER_TAG); 
            if (headElt == null) {
            	System.err.println("The message content is incorrect [no message header]!");
				return null;
            }
            
            MessageHeader header = new MessageHeader();
            
            header.setDevMac(headElt.elementTextTrim(MessageHeader.DEV_MAC_TAG));
            header.setHwId(headElt.elementTextTrim(MessageHeader.HW_ID_TAG));
            header.setLicense(headElt.elementTextTrim(MessageHeader.LICENSE_TAG));
            header.setMagic(headElt.elementTextTrim(MessageHeader.MAGIC_TAG));
            header.setMsgId(headElt.elementTextTrim(MessageHeader.MSG_ID_TAG));
            header.setSrcIp(headElt.elementTextTrim(MessageHeader.SRC_IP_TAG));
            header.setTargetIp(headElt.elementTextTrim(MessageHeader.TARGET_IP_TAG));
            msg.setHeader(header);
            System.out.println(header);
            
            Element bodyElt = rootElt.element(AppMessage.BODY_TAG);
            if (bodyElt == null) {
            	System.out.println("The message doesn't exists message body!");
            } else {
            	MessageBody body = new MessageBody();
            	Map<String, String> map = new HashMap<>();
            	Iterator<Element> bdyIterator = bodyElt.elementIterator();
            	while (bdyIterator.hasNext()) {
					Element element = bdyIterator.next();
					map.put(element.getName(), element.getTextTrim());
				}
            	body.setItemsMap(map);
            	msg.setBody(body);
            	System.out.println(body);
            }
			
		} catch (Exception e) {
			System.err.println("parse error: " + e.getMessage());
			return null;
		}
		
		return msg;
	}
}
