package org.spu.completedorder;

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
@Repository

public class completedorderDAO {
	@Autowired
	DataSource dataSource;

	public List<completedorderBean> fetchAllcompletedOrders() throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "SELECT completed_Id,completed_Order_Id,completed_Date from completedorder";
		List<completedorderBean> completedorderList = new ArrayList<completedorderBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			ResultSet rs = cst.executeQuery();
			while (rs.next()) {

				completedorderBean completedorder = new completedorderBean();
				completedorder.setCompleted_Id(rs.getInt("completed_Id"));
				completedorder.setCompleted_Order_Id(rs.getInt("completed_Order_Id"));
				completedorder.setCompleted_Date(rs.getDate("completed_Date"));

				completedorderList.add(completedorder);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return completedorderList;
	}

	public List<completedorderBean> createcompletedorder(int completed_Id, int completed_Order_Id,Date completed_Date) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		 String selectSQL = "INSERT INTO completedorder(completed_Id,completed_Order_Id,completed_Date) values  (" + genRandomInt() + ", '"+ completed_Order_Id + "','" + completed_Date  + "')";
		
		List<completedorderBean> completedorderList = new ArrayList<completedorderBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		completedorderList = fetchAllcompletedOrders();
		return completedorderList;
	}

	public List<completedorderBean> updatecompletedorder(int completed_Id, int completed_Order_Id,Date completed_Date) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "UPDATE completedOrder set completed_Order_Id = '" + completed_Order_Id + "',  ='" + "', completed_Date ='" + completed_Date
				+ "'  where completed_Id=" + completed_Id + "";
		List<completedorderBean> completedorderList = new ArrayList<completedorderBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		completedorderList = fetchAllcompletedOrders();
		return completedorderList;
	}

	public List<completedorderBean> deletecompletedOrder(int completed_Id) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "DELETE from completedorder  where completed_Id = " + completed_Id;
		List<completedorderBean> completedorderList = new ArrayList<completedorderBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		completedorderList = fetchAllcompletedOrders();
		return completedorderList;
	}

	public int genRandomInt() {

		Random rnd = new Random();
		return rnd.nextInt(30);

	}

}
