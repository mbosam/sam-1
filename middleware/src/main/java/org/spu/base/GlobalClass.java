package org.spu.base;
    import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	import javax.sql.DataSource;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	@Service
	public class GlobalClass {

		@Autowired
		DataSource dataSource;
		
		
		public GlobalClass(){}

		
		//Send Sms
		
		public String getvisitorreg_Contact(int visitorreg_Contact) throws SQLException {

			PreparedStatement cst = null;

			Connection conn = null;

			String selectSQL = "SELECT visitorreg_Contact from visitorregvisitorreg_Contact where visitorreg_Contact =" + visitorreg_Contact +"";
			String contact = null;

			try {

				conn = dataSource.getConnection();

				cst = conn.prepareStatement(selectSQL);

				ResultSet rs = cst.executeQuery();
				while (rs.next()) {

					contact = rs.getString("visitorreg_Contact");

				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn.close();
			}
			// System.out.println("ORG_TYPE: " + ORG_TYPE);
			return contact;

		}
		
		//Send email

		public String getCustomer_email(int visitorreg_Contact) throws SQLException {

			PreparedStatement cst = null;

			Connection conn = null;

			String selectSQL = "SELECT visitorreg_Contact from visitorreg where visitorreg_Contact =" + visitorreg_Contact + "";
			String email = null;

			try {

				conn = dataSource.getConnection();

				cst = conn.prepareStatement(selectSQL);

				ResultSet rs = cst.executeQuery();
				while (rs.next()) {

					email = rs.getString("Customer_email");

				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn.close();
			}
			// System.out.println("ORG_TYPE: " + ORG_TYPE);
			return email;

		}


}
