package com.wifi.util.msg;

public class MessageHeader {
	
	final static String MSG_ID_TAG = "msgid";
	final static String HW_ID_TAG = "hwid";
	final static String SRC_IP_TAG = "srcip";
	final static String TARGET_IP_TAG = "targetip";
	final static String MAGIC_TAG = "magic";
	final static String LICENSE_TAG = "license";
	final static String DEV_MAC_TAG = "devmac";
	
	private int msgId = -1;
	private String hwId = null;
	private String srcIp = null;
	private String targetIp = null;
	private String magic = null;
	private String license = null;
	private String devMac = null;
	
	public int getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgIdStr) {
		try {
			this.msgId = Integer.parseInt(msgIdStr);
		} catch (Exception e) {
			System.err.println("Parse msg id fail! " + msgIdStr);
			this.msgId = -1;
		}
	}
	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}
	
	public String getHwId() {
		return hwId;
	}
	public void setHwId(String hwId) {
		this.hwId = hwId;
	}
	public String getSrcIp() {
		return srcIp;
	}
	public void setSrcIp(String srcIp) {
		this.srcIp = srcIp;
	}
	public String getTargetIp() {
		return targetIp;
	}
	public void setTargetIp(String targetIp) {
		this.targetIp = targetIp;
	}
	public String getMagic() {
		return magic;
	}
	public void setMagic(String magic) {
		this.magic = magic;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getDevMac() {
		return devMac;
	}
	public void setDevMac(String devMac) { 
		this.devMac = devMac;
	}
	
	public MessageHeader()	{
		
	}

	public String toString() {
		return "Header+" +
			 "\n      |  MSGID:" + this.msgId +
			 "\n      |   HWID:" + this.hwId +
			 "\n      |LICENSE:" + this.license +
			 "\n      |  MAGIC:" + this.magic +
			 "\n      | DEVMAC:" + this.devMac +
			 "\n      |  SRCIP:" + this.srcIp +
			 "\n      |  TRGIP:" + this.targetIp;
	}
	
}
