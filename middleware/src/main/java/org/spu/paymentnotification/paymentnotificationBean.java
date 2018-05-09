package org.spu.paymentnotification;

import java.sql.Date;

public class paymentnotificationBean {
	private int paymentnotification_Id ;
	private int paymentnotification_Completed_Id;
	private Date paymentnotification_Date;;
	private String paymentnotification_Message;
	
	public int getPaymentnotification_Id() {
		return paymentnotification_Id;
	}
	public void setPaymentnotification_Id(int paymentnotification_Id) {
		this.paymentnotification_Id = paymentnotification_Id;
	}
	public int getPaymentnotification_Completed_Id() {
		return paymentnotification_Completed_Id;
	}
	public void setPaymentnotification_Completed_Id(int paymentnotification_Completed_Id) {
		this.paymentnotification_Completed_Id = paymentnotification_Completed_Id;
	}
	public Date getPaymentnotification_Date() {
		return paymentnotification_Date;
	}
	public void setPaymentnotification_Date(Date paymentnotification_Date) {
		this.paymentnotification_Date = paymentnotification_Date;
	}
	public String getPaymentnotification_Message() {
		return paymentnotification_Message;
	}
	public void setPaymentnotification_Message(String paymentnotification_Message) {
		this.paymentnotification_Message = paymentnotification_Message;
	}
	
	
	
	
	
	
}