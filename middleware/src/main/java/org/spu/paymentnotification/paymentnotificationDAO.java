package org.spu.paymentnotification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Random;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.spu.paymentnotification.paymentnotificationBean;

@Repository
public class paymentnotificationDAO {
	@Autowired
	DataSource dataSource;

	public List<paymentnotificationBean> fetchAllpaymentnotifications() throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;
		 
		 
		 
		

		String selectSQL = "SELECT paymentnotification_Id, paymentnotification_Completed_Id , paymentnotification_Date,paymentnotification_Message from paymentnotification";
		List<paymentnotificationBean> paymentnotificationList = new ArrayList<paymentnotificationBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			ResultSet rs = cst.executeQuery();
			while (rs.next()) {

				paymentnotificationBean paymentnotification = new paymentnotificationBean();
				paymentnotification.setPaymentnotification_Id(rs.getInt("paymentnotification_Id"));
				paymentnotification.setPaymentnotification_Completed_Id(rs.getInt("paymentnotification_Completed_Id"));
				paymentnotification.setPaymentnotification_Date(rs.getDate("paymentnotification_Date"));
				paymentnotification.setPaymentnotification_Message(rs.getString("paymentnotification_Message"));

				paymentnotificationList.add(paymentnotification);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return paymentnotificationList;
	}

	public List<paymentnotificationBean> createpaymentnotification(int paymentnotification_Id, int paymentnotification_Completed_Id, Date paymentnotification_Date,String paymentnotification_Message) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;
         String selectSQL = "INSERT INTO paymentnotification(paymentnotification_Id,paymentnotification_Completed_Id,paymentnotification_Date,paymentnotification_Message) values  (" + genRandomInt() + ", '"+ paymentnotification_Completed_Id + "','" + paymentnotification_Date + "','" + paymentnotification_Message + "')";
		
		List<paymentnotificationBean> paymentnotificationList = new ArrayList<paymentnotificationBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		paymentnotificationList = fetchAllpaymentnotifications();
		return paymentnotificationList;
	}

	public List<paymentnotificationBean> updatepaymentnotification(int paymentnotification_Id, int paymentnotification_Completed_Id, Date paymentnotification_Date,String paymentnotification_Message) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "UPDATE paymentnotification set paymentnotification_Id = '" + paymentnotification_Id + "', paymentnotification_Completed_Id = '" + paymentnotification_Completed_Id + "', paymentnotification_Date ='" + paymentnotification_Date+ "', paymentnotification_Message ='" + paymentnotification_Message
				+ "'  where paymentnotification_Id=" + paymentnotification_Id + "";
		List<paymentnotificationBean> paymentnotificationList = new ArrayList<paymentnotificationBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		paymentnotificationList = fetchAllpaymentnotifications();
		return paymentnotificationList;
	}

	public List<paymentnotificationBean> deletepaymentnotification(int  paymentnotification_Id) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "DELETE from paymentnotification  where paymentnotification_Id = " +  paymentnotification_Id;
		List<paymentnotificationBean> paymentnotificationList = new ArrayList<paymentnotificationBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		paymentnotificationList = fetchAllpaymentnotifications();
		return paymentnotificationList;
	}

	public int genRandomInt() {

		Random rnd = new Random();
		return rnd.nextInt(30);

	}

}
