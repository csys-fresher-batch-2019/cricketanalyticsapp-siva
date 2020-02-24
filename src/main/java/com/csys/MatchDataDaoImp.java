package com.csys;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MatchDataDaoImp implements MatchDataDao {
	Logger logger = new Logger();
 
	public void addMatchDetail(String capNo, String format, int runs) throws DBexception {
		try (Connection res = TestConnection1.getConnection();){
		String sqladd = "insert into match_data values (?,?,?)";
		try(PreparedStatement arr = res.prepareStatement(sqladd);){
		arr.setString(1,capNo);
		arr.setString(2,format);
		arr.setInt(3,runs);
		arr.executeUpdate();
		logger.info(infoMessages.Add_Match_Detail);
		}}
		catch(Exception e) {
			e.printStackTrace();
			throw new DBexception(errorMessages.CreateProfile);
		}
	}
	

	public void deleteMatchDetail() throws Exception {
		
		String sqladd = "delete from match_data where status ='updated'";
		try(Connection res = TestConnection1.getConnection();){
		try(Statement arr = res.createStatement();){
		arr.executeUpdate(sqladd);
		logger.info(infoMessages.Delete_Match_Detail);}}
		catch(Exception e) {
			throw new DBexception(errorMessages.DeleteStatus);
		}
		}

	public void updateCareer() throws DBexception {
		
		try(Connection ci = TestConnection1.getConnection();
		CallableStatement cs = ci.prepareCall("{ call update_career(?,?,?)}");){
			try(Statement stmt = ci.createStatement();){
				ResultSet rs = stmt.executeQuery("select * from match_data where status ='yet to update'");
				while(rs.next()) {
					String capNo = rs.getString("cap_no");
					 String format = rs.getString("match_type");
					int runs = rs.getInt("runs");
					cs.setString(1, capNo);
					cs.setString(2, format);
					cs.setInt(3, runs);
				    cs.execute();
				}
							
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
					
				}
				else {
					logger.info(infoMessages.Check_Data);
				}
			}
			
		}catch( Exception e ) {
			e.printStackTrace();
		}
		return check;
		
	}


	
	
}
