package com.csys;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MatchDataDaoImp implements MatchDataDao {

	public void addMatchDetail(String capNo, String format, int runs, String status) throws DBexception {
		// TODO Auto-generated method stub
		String sqladd = "insert into match_data values (?,?,?,?)";
		try	(Connection res = TestConnection1.getConnection();		
			PreparedStatement arr = res.prepareStatement(sqladd);)
		{
		arr.setString(1,capNo);
		arr.setString(2,format);
		arr.setInt(3,runs);
		arr.setString(4,status);
		arr.executeUpdate();
		System.out.println(infoMessages.Add_Match_Detail);
		} 
		catch(Exception e) {
			throw new DBexception(errorMessages.NonSpecifyColumn);
		}
	}
	

	public void deleteMatchDetail(String status) throws Exception {
		// TODO Auto-generated method stub
		String sqladd = "delete from match_data where status =?";
		try(Connection res = TestConnection1.getConnection();
		PreparedStatement arr = res.prepareStatement(sqladd);){
		arr.setString(1, status);
		arr.executeUpdate();
		System.out.println(infoMessages.Delete_Match_Detail);}
		catch(Exception e) {
			throw new DBexception(errorMessages.DeleteStatus);
		}
		}

	public void updateCareer(String capNo, String format, int runs) throws DBexception {
		try(
		Connection ci = TestConnection1.getConnection();
		Statement stmt = ci.createStatement();){
		try(ResultSet rs=stmt.executeQuery("select cap_no,match_id from player_career where cap_no='" + capNo + "' and match_id='"
				+ format + "'");){
		if(rs.next()) {
			try(CallableStatement cs = ci.prepareCall("{ call update_career(?,?,?)}");){
			cs.setString(1, capNo);
			cs.setString(2, format);
			cs.setInt(3, runs);
			//System.out.println("gdfgfg");
			cs.execute();
			System.out.println(infoMessages.Update_Match_detail);
		}}
		}
		}catch(Exception e)
	 {
				throw new DBexception(errorMessages.CreateCareer);
			   
			}
	}}

