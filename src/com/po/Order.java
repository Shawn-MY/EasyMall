package com.po;



import java.util.Date;

import com.sun.jmx.snmp.Timestamp;

public class Order {
	private String id;
	private double money;
	private String receiverinfo;
	private int paystate;
	private Date ordertime;
	private int user_id;
	private int deliverystate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getReceiverinfo() {
		return receiverinfo;
	}
	public void setReceiverinfo(String receiverinfo) {
		this.receiverinfo = receiverinfo;
	}
	public int getPaystate() {
		return paystate;
	}
	public void setPaystate(int paystate) {
		this.paystate = paystate;
	}

	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public int getDeliverystate() {
		return deliverystate;
	}
	public void setDeliverystate(int deliverystate) {
		this.deliverystate = deliverystate;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", money=" + money + ", receiverinfo="
				+ receiverinfo + ", paystate=" + paystate + ", ordertime="
				+ ordertime + ", user_id=" + user_id + ", deliverystate="
				+ deliverystate + "]";
	}

}
