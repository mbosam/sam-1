package org.spu.card_design;

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
import org.spu.card_design.card_DesignBean;

@Repository
public class card_DesignDAO {
	@Autowired
	DataSource dataSource;
	public List<card_DesignBean> fetchAllcard_Designs() throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "SELECT card_Design_Id,card_Design_Type,card_Design_Color,card_Design_Desc from card_design";
		List<card_DesignBean> card_DesignList = new ArrayList<card_DesignBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			ResultSet rs = cst.executeQuery();
			while (rs.next()) {

				card_DesignBean card_Design = new card_DesignBean();
				card_Design.setCard_Design_Id(rs.getInt("card_Design_Id"));
				card_Design.setCard_Design_Type(rs.getString("card_Design_Type"));
				card_Design.setCard_Design_Color(rs.getString("setcard_Design_Color"));
				card_Design.setCard_Design_Desc(rs.getString("setcard_Design_Desc"));

				card_DesignList.add(card_Design);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return card_DesignList;
	}

	public List<card_DesignBean> createcard_Design(int card_Design_Id, String card_Design_Type,String card_Design_Color, String card_Design_Desc) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;
String selectSQL = "INSERT INTO card_design(card_Design_Id, card_Design_Type, card_Design_Color, card_Design_Desc) values  (" + genRandomInt() + ", '"+ card_Design_Type + "','" + card_Design_Color + "','" + card_Design_Desc + "')";	
		
		List<card_DesignBean> card_DesignList = new ArrayList<card_DesignBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		card_DesignList = fetchAllcard_Designs();
		return card_DesignList;
	}

	public List<card_DesignBean> updatecard_Design(int card_Design_Id, String card_Design_Type,String card_Design_Color, String card_Design_Desc) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "UPDATE card_Design set card_Design_Type = '" + card_Design_Type + "', card_Design_Color ='" + card_Design_Color+ "', card_Design_Desc ='" + card_Design_Desc
				+ "'  where card_Design_Id=" + card_Design_Id + "";
		List<card_DesignBean> card_DesignList = new ArrayList<card_DesignBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		card_DesignList = fetchAllcard_Designs();
		return card_DesignList;
	}

	public List<card_DesignBean> deletecard_Design(int card_Design_Id) throws SQLException {
		PreparedStatement cst = null;

		Connection conn = null;

		String selectSQL = "DELETE from card_design  where card_Design_Id = " + card_Design_Id;
		List<card_DesignBean> card_DesignList = new ArrayList<card_DesignBean>();

		try {

			conn = dataSource.getConnection();

			cst = conn.prepareStatement(selectSQL);

			cst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		card_DesignList = fetchAllcard_Designs();
		return card_DesignList;
	}

	public int genRandomInt() {

		Random rnd = new Random();
		return rnd.nextInt(30);

	}

}
