package org.spu.payment;

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
import org.spu.payment.paymentBean;

@Repository
public class paymentDAO {
	@Autowired
	DataSource dataSource;

	public List<paymentBean> fetchAllpayments() throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "SELECT payment_Id, payment_Order_Id ,payment_Amount,payment_Date,payment_Mode from payment";
		List<paymentBean> paymentList = new ArrayList<paymentBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			ResultSet rs = cst.executeQuery();
			while (rs.next()) {

				paymentBean payment = new paymentBean();
				payment.setPayment_Id (rs.getInt("payment_Id"));
				payment.setPayment_Order_Id(rs.getInt("payment_Order_Id"));
				payment.setPayment_Amount(rs.getFloat("payment_Amount"));
				payment.setPayment_Date(rs.getDate("payment_Date"));
				payment.setPayment_Mode(rs.getString("payment_Mode"));

				paymentList.add(payment);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return paymentList;
	}

	public List<paymentBean> createpayment(int payment_Id, int payment_Order_Id,float payment_Amount,Date payment_Date,String payment_Mode) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		

	
		String selectSQL = "INSERT INTO payment(payment_Id,payment_Order_Id,payment_Amount,payment_Date,payment_Mode) values  (" + genRandomInt() + ", '"+ payment_Order_Id + "','" + payment_Amount + "','" + payment_Date + "','" + payment_Mode + "')";

		List<paymentBean> paymentList = new ArrayList<paymentBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		paymentList = fetchAllpayments();
		return paymentList;
	}

	public List<paymentBean> updatepayment(int payment_Id, int payment_Order_Id,float payment_Amount,Date payment_Date,String payment_Mode) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "UPDATE payment set payment_Order_Id = '" + payment_Order_Id + "', payment_Amount ='" + payment_Amount
				+ "'  where payment_Id=" + payment_Id + "";
		List<paymentBean> paymentList = new ArrayList<paymentBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		paymentList = fetchAllpayments();
		return paymentList;
	}

	public List<paymentBean> deletepayment(int payment_Id) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "DELETE from payment  where payment_Id = " + payment_Id;
		List<paymentBean> paymentList = new ArrayList<paymentBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		paymentList = fetchAllpayments();
		return paymentList;
	}

	public int genRandomInt() {

		Random rnd = new Random();
		return rnd.nextInt(30);

	}
}
