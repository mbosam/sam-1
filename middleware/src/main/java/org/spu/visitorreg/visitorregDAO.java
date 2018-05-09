package org.spu.visitorreg;

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
import org.spu.Email.SendGridEmailsController;
import org.spu.visitorreg.visitorregBean;

@Repository
public class visitorregDAO {
	@Autowired
	DataSource dataSource;

	@Autowired
	SendGridEmailsController SendGridEmailsController;

	@Autowired
	SendGridEmailsController sendGridEmailsController;
	public List<visitorregBean> fetchAllvisitorregs() throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "SELECT visitorreg_Id	visitorreg_Name	visitorreg_Contact	visitorreg_Date	visitorreg_Email from visitorregs";
		List<visitorregBean> visitorregList = new ArrayList<visitorregBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			ResultSet rs = cst.executeQuery();
			while (rs.next()) {

				visitorregBean visitorreg = new visitorregBean();
				visitorreg.setVisitorreg_Id(rs.getInt("visitorreg_Id"));
				visitorreg.setVisitorreg_Name(rs.getString("visitorreg_Name"));
				visitorreg.setVisitorreg_Contact(rs.getInt("visitorreg_Contact"));
				visitorreg.setVisitorreg_Date(rs.getDate("visitorreg_Date"));
				visitorreg.setVisitorreg_Email(rs.getString("visitorreg_Email"));

				visitorregList.add(visitorreg);
			}
		}
		
				catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return visitorregList;
	}

	public List<visitorregBean> createvisitorregs(int visitorreg_Id, String visitorreg_Name,int visitorreg_Contact, Date visitorreg_Date, String visitorreg_Email ) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		
	
		String selectSQL = "INSERT INTO visitorregs(visitorreg_Id,visitorreg_Name,visitorreg_Contact,visitorreg_Date,visitorreg_Email) values  (" + genRandomInt() + ", '"+ visitorreg_Name + "','" + visitorreg_Contact + "','" + visitorreg_Date + "','" + visitorreg_Email + "')";	
		List<visitorregBean> visitorregList = new ArrayList<visitorregBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		visitorregList = fetchAllvisitorregs();
		return visitorregList;
	}

	public List<visitorregBean> updatevisitorregs(int visitorreg_Id, String visitorreg_Name,int visitorreg_Contact, Date visitorreg_Date, String visitorreg_Email) throws Exception {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "UPDATE visitorregs set visitorreg_Name = '" + visitorreg_Name + "', visitorreg_Contact ='" + visitorreg_Contact+ "', visitorreg_Date ='" + visitorreg_Date+ "', visitorreg_Email ='" + visitorreg_Email
				+ "'  where visitorreg_Id=" + visitorreg_Id + "";
		List<visitorregBean> visitorregList = new ArrayList<visitorregBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		String visitorregArray[]=new String[1];
		visitorregArray[0]=visitorreg_Email;
		SendGridEmailsController.sendEmail("1","NU",visitorregArray,"Welcome to Card creation system","Your account has been successful created",null,null);
		
		
		visitorregList = fetchAllvisitorregs();
		return visitorregList;
	}

	public List<visitorregBean> deletevisitorregs(int visitorreg_Id) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "DELETE from visitorregs  where  visitorreg_Id = " +  visitorreg_Id;
		List<visitorregBean> visitorregList = new ArrayList<visitorregBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		visitorregList = fetchAllvisitorregs();
		return visitorregList;
	}

	public int genRandomInt() {

		Random rnd = new Random();
		return rnd.nextInt(30);

	}

}
