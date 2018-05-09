package org.spu.completedorder;

import java.sql.Date;

public class completedorderBean {
	private int completed_Id;
	private int completed_Order_Id;
	private Date completed_Date;
	public int getCompleted_Id() {
		return completed_Id;
	}
	public void setCompleted_Id(int completed_Id) {
		this.completed_Id = completed_Id;
	}
	public int getCompleted_Order_Id() {
		return completed_Order_Id;
	}
	public void setCompleted_Order_Id(int completed_Order_Id) {
		this.completed_Order_Id = completed_Order_Id;
	}
	public Date getCompleted_Date() {
		return completed_Date;
	}
	public void setCompleted_Date(Date completed_Date) {
		this.completed_Date = completed_Date;
	}
	
	
	
}
