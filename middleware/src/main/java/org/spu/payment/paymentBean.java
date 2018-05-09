package org.spu.payment;

import java.sql.Date;

public class paymentBean {
	private int payment_Id;
	private int payment_Order_Id;
	private float payment_Amount;
	private Date payment_Date;
	private String payment_Mode;
	
	public int getPayment_Id() {
		return payment_Id;
	}
	public void setPayment_Id(int payment_Id) {
		this.payment_Id = payment_Id;
	}
	public int getPayment_Order_Id() {
		return payment_Order_Id;
	}
	public void setPayment_Order_Id(int payment_Order_Id) {
		this.payment_Order_Id = payment_Order_Id;
	}
	public float getPayment_Amount() {
		return payment_Amount;
	}
	public void setPayment_Amount(float payment_Amount) {
		this.payment_Amount = payment_Amount;
	}
	public Date getPayment_Date() {
		return payment_Date;
	}
	public void setPayment_Date(Date payment_Date) {
		this.payment_Date = payment_Date;
	}
	public String getPayment_Mode() {
		return payment_Mode;
	}
	public void setPayment_Mode(String payment_Mode) {
		this.payment_Mode = payment_Mode;
	}
	
	
	
	
}
