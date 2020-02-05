package com.csys;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public  class PlayerProfileDaoImplementation implements PlayerProfileDao {

			
		public void addPlayer(String capNo, String name, String nation, String style,int debutYear) throws Exception {
		// TODO Auto-generated method stub
			Connection con1 = TestConnection1.getConnection();
			Statement stmt = con1.createStatement();
			ResultSet rs = stmt.executeQuery("select cap_no from player_list where cap_no='"+capNo+"'");
			if(rs.next()) {

				System.out.println("capno already exist");
			}
			else {
				String add = "insert into player_list(cap_no,player_name,nation,batting_style,debut_year) values ('"+capNo+"','"+name+"','"+nation+"','"+style+"',"+debutYear+")";
				System.out.println(add);
				int rows =stmt.executeUpdate(add);
			System.out.println(rows);
			}
	}

		public void updatePlayer(String capNo,int year) throws Exception {
			// TODO Auto-generated method stub
			Connection con1 = TestConnection1.getConnection();
			Statement st = con1.createStatement();
			ResultSet rs = st.executeQuery("select cap_no from player_list where cap_no='"+capNo+"'");
			if(rs.next()) {
			String sql = "update player_list set retired_year = "+year+" where cap_no = '"+capNo+"'";
			System.out.println(sql);
			int rows = st.executeUpdate(sql);
			System.out.println("Updated");
			}
			else {
				System.out.println("Enter the valid cap number");
			}
		}

		public List<PlayerProfile> playerlist() throws Exception {
			// TODO Auto-generated method stub
			Connection con1 = TestConnection1.getConnection();
			Statement stmt = con1.createStatement();
			String sql = "select * from player_list";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			List<PlayerProfile> pl = new ArrayList<PlayerProfile>();
			while(rs.next()) {
				PlayerProfile pp =new PlayerProfile();
				pp.capNo = rs.getString("cap_no");
				pp.name  = rs.getString("player_name");
				pp.nation =rs.getString("nation");
				pp.style =rs.getString("batting_style");
				pp.debutYear = rs.getInt("debut_year");
				//pp.retiredYear = rs.getInt("retired_year");
				pl.add(pp);
			}
			return pl;
		}	
}

