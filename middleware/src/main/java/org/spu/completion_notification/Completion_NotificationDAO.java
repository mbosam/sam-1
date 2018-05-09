package org.spu.completion_notification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.spu.completion_notification.completion_notificationBean;
@Repository

public class Completion_NotificationDAO {
	@Autowired
	DataSource dataSource;

	public List<completion_notificationBean> fetchAllCompletion_Notifications() throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "SELECT Comp_Not_Id	Comp_Not_Completed_Id	Comp_Not_Date	Comp_Not_Message from completionnotification";
		List<completion_notificationBean> completionnotificationList = new ArrayList<completion_notificationBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			ResultSet rs = cst.executeQuery();
			while (rs.next()) {

				completion_notificationBean completionnotification = new completion_notificationBean();
				completionnotification.setComp_Not_Id(rs.getInt("Comp_Not_Id"));
				completionnotification.setComp_Not_Completed_Id(rs.getInt("Comp_Not_Completed_Id"));
				completionnotification.setComp_Not_Date(rs.getDate("Comp_Not_Date"));
				completionnotification.setComp_Not_Message(rs.getString("setComp_Not_Message"));

				completionnotificationList.add(completionnotification);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return completionnotificationList;
	}

	public List<completion_notificationBean> createCompletion_Notification(int Comp_Not_Id, int Comp_Not_Completed_Id,Date Comp_Not_Date,String Comp_Not_Message) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "INSERT INTO Completion_Notification(Comp_Not_Id	,Comp_Not_Completed_Id,	Comp_Not_Date,	Comp_Not_Message) values  (" + genRandomInt() + ", '"
				+ Comp_Not_Id + "','" + Comp_Not_Completed_Id + "','" + Comp_Not_Date + "','" + Comp_Not_Message + "')";

	
		
		List<completion_notificationBean> completionnotificationList = new ArrayList<completion_notificationBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		completionnotificationList = fetchAllCompletion_Notifications();
		return completionnotificationList;
	}

	public List<completion_notificationBean> updateCompletion_Notification(int Comp_Not_Id, int Comp_Not_Completed_Id,Date Comp_Not_Date,String Comp_Not_Message) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "UPDATE Completion_Notification set Comp_Not_Completed_Id = '" + Comp_Not_Completed_Id + "', Comp_Not_Date ='" + Comp_Not_Date+ "', Comp_Not_Message ='" + Comp_Not_Message
				+ "'  where Comp_Not_Id=" + Comp_Not_Id + "";
		List<completion_notificationBean> completionnotificationList = new ArrayList<completion_notificationBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		completionnotificationList = fetchAllCompletion_Notifications();
		return completionnotificationList;
	}

	public List<completion_notificationBean> deleteCompletion_Notification(int Comp_Not_Id) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "DELETE from Completion_Notification  where int Comp_Not_Id = " +  Comp_Not_Id;
		List<completion_notificationBean> completionnotificationList = new ArrayList<completion_notificationBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		completionnotificationList = fetchAllCompletion_Notifications();
		return completionnotificationList;
	}

	public int genRandomInt() {

		Random rnd = new Random();
		return rnd.nextInt(30);

	}

}
