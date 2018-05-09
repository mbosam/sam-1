package org.spu.login;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.util.Random;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

@Repository
public class loginDAO {


	@Autowired
	DataSource dataSource;

	public List<loginBean> fetchAlllogins() throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "SELECT 	login_Id, login_Username,login_Password,login_Rank from login";
		List<loginBean> loginList = new ArrayList<loginBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			ResultSet rs = cst.executeQuery();
			while (rs.next()) {

				loginBean login = new loginBean();
				login.setLogin_Id(rs.getInt("login_Id"));
				login.setLogin_Username(rs.getString("login_Username"));
				login.setLogin_Password(rs.getString("login_Password"));
				login.setLogin_Rank(rs.getString("login_Rank"));
                loginList.add(login);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return loginList;
	}

	public List<loginBean> createlogin( int login_Id, String login_Username, String login_Password,String login_Rank) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "INSERT INTO login(login_Id, login_Username, login_Password, login_Rank) values  (" + genRandomInt() + ", '"+ login_Username + "','" + login_Password + "','" + login_Rank + "')";	
		
		
		List<loginBean> loginList = new ArrayList<loginBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		loginList = fetchAlllogins();
		return loginList;
	}

	public List<loginBean> updatelogin(int login_Id, String login_Username, String login_Password,String login_Rank) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "UPDATE login set login_Username = '" + login_Username + "', login_Password ='" + login_Password + "', login_Rank ='" + login_Rank
				+ "'  where login_Id=" + login_Id + "";
		List<loginBean> loginList = new ArrayList<loginBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		loginList = fetchAlllogins();
		return loginList;
	}

	public List<loginBean> deletelogin(BigDecimal login_Id) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "DELETE from login  where login_Id = " + login_Id;
		List<loginBean> loginList = new ArrayList<loginBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		loginList = fetchAlllogins();
		return loginList;
	}

	public int genRandomInt() {

		Random rnd = new Random();
		return rnd.nextInt(30);

	}

}
