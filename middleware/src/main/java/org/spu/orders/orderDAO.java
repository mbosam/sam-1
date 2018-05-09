package org.spu.orders;

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
import org.spu.orders.orderBean;

@Repository
public class orderDAO {
	@Autowired
	DataSource dataSource;

	public List<orderBean> fetchAllorders() throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "SELECT order_Id,order_VisitorReg_Id,order_Card_Design_Id,order_Date,order_Quantity from orders";
		List<orderBean> orderList = new ArrayList<orderBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			ResultSet rs = cst.executeQuery();
			while (rs.next()) {

				orderBean order = new orderBean();
				order.setOrder_Id(rs.getInt("order_Id"));
				order.setOrder_VisitorReg_Id(rs.getInt("order_VisitorReg_Id"));
				order.setOrder_Card_Design_Id(rs.getInt("order_Card_Design_Id"));
				order.setOrder_Date(rs.getDate("order_Date"));
				order.setOrder_Quantity(rs.getInt("setorder_Quantity"));

				
				
				orderList.add(order);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return orderList;
	}

	public List<orderBean> createorders(int order_Id, int order_VisitorReg_Id,int order_Card_Design_Id,Date order_Date,int order_Quantity) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "INSERT INTO orders(order_Id,order_VisitorReg_Id,order_Card_Design_Id,order_Date,order_Quantity) values  (" + genRandomInt() + ", '"
				+ order_VisitorReg_Id + "','" + order_Card_Design_Id + "','" + order_Date+"' ,'" + order_Quantity+"' )";

	
		
		List<orderBean> orderList = new ArrayList<orderBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		orderList = fetchAllorders();
		return orderList;
	}

	public List<orderBean> updateorders(int order_Id, int order_VisitorReg_Id,int order_Card_Design_Id,Date order_Date,int order_Quantity) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "UPDATE orders set order_VisitorReg_Id = '" + order_VisitorReg_Id + "', order_Card_Design_Id ='" + order_Card_Design_Id+ "', order_Date ='" + order_Date+ "', order_Quantity ='" + order_Quantity
				+ "'  where order_Id=" + order_Id + "";
		List<orderBean> orderList = new ArrayList<orderBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		orderList = fetchAllorders();
		return orderList;
	}

	public List<orderBean> deleteorders(int order_Id) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "DELETE from orders  where order_Id = " + order_Id;
		List<orderBean> orderList = new ArrayList<orderBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		orderList = fetchAllorders();
		return orderList;
	}

	public int genRandomInt() {

		Random rnd = new Random();
		return rnd.nextInt(30);

	}

}
