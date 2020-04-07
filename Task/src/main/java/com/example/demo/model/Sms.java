package com.example.demo.model;

public class Sms {
	private int tokenid;
	private String mob;
	private String templatemsg;
	public int getTokenid() {
		return tokenid;
	}
	public void setTokenid(int tokenid) {
		this.tokenid = tokenid;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	
	public String getTemplatemsg() {
		return templatemsg;
	}
	public void setTemplatemsg(String templatemsg) {
		this.templatemsg = templatemsg;
	}
	@Override
	public String toString() {
		return "Sms [tokenid=" + tokenid + ", mob=" + mob + ", templatemsg=" + templatemsg + "]";
	}
	

}
