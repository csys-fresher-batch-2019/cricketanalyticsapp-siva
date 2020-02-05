package com.csys;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MatchDataDaoImp implements MatchDataDao {

	public void addMatchDetail(String capNo, String format, int runs, String status) throws Exception {
		// TODO Auto-generated method stub
		Connection res = TestConnection1.getConnection();
		// Statement stmt = res.createStatement();
		String sqladd = "insert into match_data values (?,?,?,?)";
		PreparedStatement arr = res.prepareStatement(sqladd);
		arr.setString(1, capNo);
		arr.setString(2, format);
		arr.setInt(3, runs);
		arr.setString(4, status);
		arr.executeUpdate();
		System.out.println("Added");
	}

	public void deleteMatchDetail(String status) throws Exception {
		// TODO Auto-generated method stub
		Connection res = TestConnection1.getConnection();
		// Statement stmt = res.createStatement();
		String sqladd = "delete from match_data where status =?";
		PreparedStatement arr = res.prepareStatement(sqladd);
		arr.setString(1, status);
		arr.executeUpdate();
		System.out.println("Deleted");
	}

	public void updateCareer(String capNo, String format, int runs) throws Exception {
		// TODO Auto-generated method stub
		Connection ci = TestConnection1.getConnection();
		Statement stmt = ci.createStatement();
		ResultSet rs=stmt.executeQuery("select cap_no,match_id from player_career where cap_no='" + capNo + "' and match_id='"
				+ format + "'");
		if(rs.next()) {
			CallableStatement cs = ci.prepareCall("{ call update_career(?,?,?)}");
			cs.setString(1, capNo);
			cs.setString(2, format);
			cs.setInt(3, runs);
			//System.out.println("gdfgfg");
			cs.execute();
			System.out.println("UPDATED");
			
		}
	else {
				System.out.println("Please create player Career");
			//	TestNewCareerDetails.main(null);
			   
			}
		}
}
