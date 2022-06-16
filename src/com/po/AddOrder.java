package com.po;

import java.util.Date;

public class AddOrder {
	
	private int deliverystate;
	private String id;

    private Double money;
	@Override
	public String toString() {
		return "AddOrder [deliverystate=" + deliverystate + ", id=" + id
				+ ", money=" + money + ", receiverinfo=" + receiverinfo
				+ ", paystate=" + paystate + ", ordertime=" + ordertime
				+ ", user_id=" + user_id + "]";
	}

	private String receiverinfo;

    private Integer paystate;

    private Date ordertime;

    private Integer user_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getReceiverinfo() {
        return receiverinfo;
    }

    public void setReceiverinfo(String receiverinfo) {
        this.receiverinfo = receiverinfo == null ? null : receiverinfo.trim();
    }

    public Integer getPaystate() {
        return paystate;
    }

    public void setPaystate(Integer paystate) {
        this.paystate = paystate;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public int getDeliverystate() {
		return deliverystate;
	}

	public void setDeliverystate(int deliverystate) {
		this.deliverystate = deliverystate;
	}

}
