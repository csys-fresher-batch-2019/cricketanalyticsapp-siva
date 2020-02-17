package com.csys;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MatchDataDaoImp implements MatchDataDao {

	public void addMatchDetail(String capNo, String format, int runs) throws DBexception {
		String sql = "select cap_no from player_list where cap_no =?";
		try (Connection res = TestConnection1.getConnection();
				PreparedStatement ps = res.prepareStatement(sql);){	
			    ps.setString(1, capNo);
			    try(ResultSet rs = ps.executeQuery();){
			    if(rs.next()) {		
		String sqladd = "insert into match_data values (?,?,?)";
		try(PreparedStatement arr = res.prepareStatement(sqladd);)
		{
		arr.setString(1,capNo);
		arr.setString(2,format);
		arr.setInt(3,runs);
		arr.executeUpdate();
		System.out.println(infoMessages.Add_Match_Detail);
		}}} }
		catch(Exception e) {
			e.printStackTrace();
			throw new DBexception(errorMessages.CreateProfile);
		}
	}
	

	public void deleteMatchDetail() throws Exception {
		// TODO Auto-generated method stub
		String sqladd = "delete from match_data where status ='updated'";
		try(Connection res = TestConnection1.getConnection();){
		try(Statement arr = res.createStatement();){
		arr.executeUpdate(sqladd);
		System.out.println(infoMessages.Delete_Match_Detail);}}
		catch(Exception e) {
			throw new DBexception(errorMessages.DeleteStatus);
		}
		}

	public void updateCareer() throws DBexception {
		String format="odi";
		try(Connection ci = TestConnection1.getConnection();
		CallableStatement cs = ci.prepareCall("{ call update_career(?,?,?)}");){
			try(Statement stmt = ci.createStatement();){
				ResultSet rs = stmt.executeQuery("select * from match_data where status ='yet to update'");
				while(rs.next()) {
					String capNo = rs.getString("cap_no");
					 format = rs.getString("match_type");
					int runs = rs.getInt("runs");
					cs.setString(1, capNo);
					cs.setString(2, format);
					cs.setInt(3, runs);
				    cs.execute();
				}
				PlayerCareerDaoImp object = new PlayerCareerDaoImp();
				object.updaterank(format);
			
		}}catch(Exception e){
	 
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
