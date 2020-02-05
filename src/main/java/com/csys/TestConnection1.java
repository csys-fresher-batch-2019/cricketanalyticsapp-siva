package com.csys;



import java.sql.Connection;
import java.sql.DriverManager;



public class TestConnection1 {
	
	/*public static void main(String[] args) throws Exception {
		System.out.println(getConnection());
	}*/
	public static Connection getConnection() throws Exception {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 String server = "192.168.56.215";
		// String server = "CSLH2006";
		 Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@"+ server + ":1521:XE","system","oracle");
			System.out.println(connection);
			return connection;
	}
}

	/*public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
         Connection con=getConnection();
         Statement stmt = con.createStatement();
         String movieName= "ASURAN";
         //String theaterName="PVR";
         String sql="select theatre_name, ticket_cost from movie_theatre where movie_id=(select movie_id from movies where movie_name='"+movieName+"')";
         System.out.println(sql);
         //String query="select * from movies";
 		 //String que="update player_list set batting_style = 'Left Hand Batsman' where cap_no = 'e226'";
 		 //String que1="update player_list set player_name='MS Dhoni' where player_name='Mahendra Singh Dhoni' ";
 		 ResultSet rs = stmt.executeQuery(sql);
 		// System.out.println("TheatreName" +" "+ "PRICE");
 		 while(rs.next()) {
 			
 		 System.out.println(rs.getString("theatre_name")+"  "+ rs.getInt("ticket_cost"));
 		 }
 		
 		//stmt.executeUpdate(que);
 		//stmt.executeUpdate(que1);
 	//System.out.println("No of rows inserted:"+rows);rs.getString("theatre_name")
 	}
	}*/

