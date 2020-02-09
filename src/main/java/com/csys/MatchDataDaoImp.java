package com.csys;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MatchDataDaoImp implements MatchDataDao {

	public void addMatchDetail(String capNo, String format, int runs, String status) throws DBexception {
		String sql = "select cap_no from player_list where cap_no =?";
		try (Connection res = TestConnection1.getConnection();
				PreparedStatement ps = res.prepareStatement(sql);){	
			    ps.setString(1, capNo);
			    ResultSet rs = ps.executeQuery();
			    if(rs.next()) {		
		String sqladd = "insert into match_data values (?,?,?,?)";
		try(PreparedStatement arr = res.prepareStatement(sqladd);)
		{
		arr.setString(1,capNo);
		arr.setString(2,format);
		arr.setInt(3,runs);
		arr.setString(4,status);
		arr.executeUpdate();
		System.out.println(infoMessages.Add_Match_Detail);
		}}} 
		catch(Exception e) {
			throw new DBexception(errorMessages.CreateProfile);
		}
	}
	

	public void deleteMatchDetail(String status) throws Exception {
		// TODO Auto-generated method stub
		String sqladd = "delete from match_data where status =?";
		try(Connection res = TestConnection1.getConnection();){
		try(PreparedStatement arr = res.prepareStatement(sqladd);){
		arr.setString(1, status);
		arr.executeUpdate();
		System.out.println(infoMessages.Delete_Match_Detail);}}
		catch(Exception e) {
			throw new DBexception(errorMessages.DeleteStatus);
		}
		}

	public void updateCareer(String capNo, String format, int runs) throws DBexception {
		
		try(Connection ci = TestConnection1.getConnection();
		CallableStatement cs = ci.prepareCall("{ call update_career(?,?,?)}");){
			cs.setString(1, capNo);
			cs.setString(2, format);
			cs.setInt(3, runs);
		    cs.execute();
			System.out.println(infoMessages.Update_Match_detail);
		}catch(Exception e){
	 
				throw new DBexception(errorMessages.CreateProfile);
		}
	}
	
	public boolean checkMatchDataDuringInsertion(String capNo,String format,int runs,String status) throws Exception{
		boolean check = false;
		String sql ="select cap_no,match_type,runs,status from match_data where cap_no=? and match_type=? and runs=? and status=?";
		try(Connection ci = TestConnection1.getConnection();
				PreparedStatement arr  = ci.prepareStatement(sql);){
			arr.setString(1, capNo);
			arr.setString(2, format);
			arr.setInt(3, runs);
			arr.setString(4, status);
			System.out.println(sql);
			try(ResultSet rs = arr.executeQuery()){
				if(rs.next()) {
					check = true;
					//System.out.println("verification success");
					//System.out.println(check);
				}
				else {
					System.out.println(infoMessages.Check_Data);
				}
			}
			
		}catch( Exception e ) {
			e.printStackTrace();
		}
		return check;
		
	}
	
}
