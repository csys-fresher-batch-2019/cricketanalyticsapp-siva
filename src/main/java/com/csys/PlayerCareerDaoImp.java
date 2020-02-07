package com.csys;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.formatruns;

public class PlayerCareerDaoImp implements PlayerCareerDao {

	public void newCareerDetails(String capNo, String format, int matches, int runs, int fifty, int hundred, int best)
			throws DBexception {
		try(Connection con1 = TestConnection1.getConnection();
		Statement stmt = con1.createStatement();){
		try(ResultSet res =stmt.executeQuery("select cap_no from player_list where cap_no='" + capNo + "'");){
		if(res.next()) {
			try(ResultSet rs =stmt.executeQuery("select cap_no,match_id from player_career where cap_no='" + capNo+"' and match_id='" + format + "'");){
			if (rs.next()) {
				String sqladd = "insert into player_career(cap_no,match_id,matches,runs,fifty,hundred,high_score) values('"
						+ capNo + "','" + format + "','" + matches + "','" + runs + "','" + fifty + "','" + hundred
						+ "','" + best + "')";
				System.out.println(sqladd);
				int rows = stmt.executeUpdate(sqladd);
				System.out.println(rows);
				System.out.println(infoMessages.Insert_Message);}}}
			} catch(Exception e) {
				throw new DBexception(infoMessages.Duplicate_message);
			}
		} catch(Exception e) {
			throw new DBexception (errorMessages.CreateCareer);
		}
	}

	

	public ArrayList<PlayerCareer> getdetails(String name) throws DBexception {
		try(Connection con1 = TestConnection1.getConnection();
		Statement stmt = con1.createStatement();){
		ArrayList<PlayerCareer> task = new ArrayList<>();
		// String det = "select * from player_career where cap_no = '"+capNo+"'";
		try(ResultSet res = stmt.executeQuery("select player_name from player_list where upper(player_name)=upper('" + name + "')");){
		if (res.next()) {
			String det = "select * from player_career where cap_no =(select cap_no from player_list where upper(player_name) =upper('"
					+ name + "'))";
			System.out.println(det);
			System.out.println(name.toUpperCase());

			try(ResultSet rs = stmt.executeQuery(det);){

			while (rs.next()) {
				PlayerCareer pc = new PlayerCareer();
				pc.format = rs.getString("match_id");
				pc.capNo = rs.getString("cap_no");
				pc.matches = rs.getInt("matches");
				pc.runs = rs.getInt("runs");
				pc.fifty = rs.getInt("fifty");
				pc.hundred = rs.getInt("hundred");
				pc.best = rs.getInt("high_score");
				pc.average=rs.getFloat("average");
				pc.ranks = rs.getInt("ranks");
				task.add(pc);
			}}}}return task;
		} catch(Exception e) {
			throw new DBexception (errorMessages.Invalid_Name);
		}
		
	}

	public List<PlayerCareer> best(String format, int r) throws DBexception {
        try(Connection con = TestConnection1.getConnection();
		Statement stmt = con.createStatement();){
		if (r == 1) {
			String sql = "select l.player_name,c.high_score from player_list l,player_career c where c.match_id='"
					+ format + "' and l.cap_no = c.cap_no order by high_score DESC";
			try(ResultSet res = stmt.executeQuery(sql);){
			List<PlayerCareer> bst = new ArrayList<>();
			while (res.next()) {
				PlayerCareer p = new PlayerCareer();
				p.playerName = res.getString("player_name");
				p.best = res.getInt("high_score");
				bst.add(p);
			}
			return bst;
			}
			
		} else if (r == 2) {
			String sql1 = "select l.player_name,c.hundred from player_list l,player_career c where c.match_id='"
					+ format + "' and l.cap_no = c.cap_no order by hundred DESC";
			try(ResultSet re = stmt.executeQuery(sql1);){
			List<PlayerCareer> bst = new ArrayList<>();
			while (re.next()) {
				PlayerCareer p = new PlayerCareer();
				p.playerName = re.getString("player_name");
				p.hundred = re.getInt("hundred");
				bst.add(p);
			}
			return bst;
		} }else if (r == 3) {
			String sql2 = "select l.player_name,c.fifty from player_list l,player_career c where c.match_id='" + format
					+ "' and l.cap_no = c.cap_no order by fifty DESC";
			try(ResultSet rs = stmt.executeQuery(sql2);){
			List<PlayerCareer> bst = new ArrayList<PlayerCareer>();
			while (rs.next()) {
				PlayerCareer p = new PlayerCareer();
				p.playerName = rs.getString("player_name");
				p.fifty = rs.getInt("fifty");
				bst.add(p);
			}
			return bst;
		} }else if (r == 4) {
			String sql3 = "select l.player_name,c.runs from player_list l,player_career c where c.match_id='" + format
					+ "' and l.cap_no = c.cap_no order by runs DESC";
			try(ResultSet rl = stmt.executeQuery(sql3);){
			List<PlayerCareer> bst = new ArrayList<>();
			while (rl.next()) {
				PlayerCareer p = new PlayerCareer();
				p.playerName = rl.getString("player_name");
				p.runs = rl.getInt("runs");
				bst.add(p);
			}
			return bst;
		}}}catch(Exception e) {
			throw new DBexception(errorMessages.Invalid_Format_case);
		}
        return null;
		
	}

	public List<formatruns> searchbyformatruns(String format, int runs) throws DBexception {
		try(Connection con = TestConnection1.getConnection();
		Statement stmt = con.createStatement();){
		String sql = "select l.player_name,c.runs from player_list l,player_career c where c.match_id='" + format
				+ "' and c.runs>+" + runs + " and l.cap_no=c.cap_no order by runs DESC";
		
		try(ResultSet res = stmt.executeQuery(sql);){
		List<formatruns> bst = new ArrayList<>();
		boolean res1 = false;

		while (res.next()) {
			formatruns p = new formatruns(sql, runs);
			p.playerName = res.getString("player_name");
			p.runs = res.getInt("runs");
			bst.add(p);
			res1 = true;
		}
		if (res1) {
		} else {
			System.out.println(infoMessages.Out_of_boundary);
		}return bst;
		}
	}catch(Exception e) {
		throw new DBexception(errorMessages.Invalid_Format);
	}
	}

	public void updaterank(String format) throws DBexception {
		try(Connection con = TestConnection1.getConnection();
		Statement stmt = con.createStatement();){
		String sql = "select l.cap_no,l.player_name,l.nation,c.average from player_list l,player_career c where c.match_id='"
				+ format + "'and l.cap_no = c.cap_no order by c.average DESC";
		System.out.println(sql);
		try(ResultSet res = stmt.executeQuery(sql);){
		int rank = 1;
		while (res.next()) {
			PlayerCareer ad = new PlayerCareer();
			ad.capNo = res.getString("cap_no");
			System.out.println("CapNo:" + ad.capNo);
			String sql1 = "update player_career set ranks=" + rank + " where cap_no ='" + ad.capNo + "' and match_id='"
					+ format + "'";
			try (Statement stm = con.createStatement();){
			int row = stm.executeUpdate(sql1);
			System.out.println(row);
			System.out.println(sql1);
			rank++;
		}} System.out.println(infoMessages.Updation);
		}}catch	(Exception e) {
			throw new DBexception(errorMessages.Invalid_Format);
		}
	}

	public List<PlayerCareer> displaytopbatsman(String format, int n) throws Exception {
		try(Connection con = TestConnection1.getConnection();
		Statement stmt = con.createStatement();){
		String sql = " select l.player_name,l.nation,c.average,c.ranks from player_list l,player_career c where c.match_id='"+format+"' and l.cap_no=c.cap_no and ranks <="+n+"order by ranks asc";
        try(ResultSet rs = stmt.executeQuery(sql);){
		List<PlayerCareer> dtb = new ArrayList<>();
		    	while (rs.next()) {
				PlayerCareer pc = new PlayerCareer();
				pc.playerName = rs.getString("player_name");
				pc.nation = rs.getString("nation");
				pc.average = rs.getFloat("average");
				pc.ranks = rs.getInt("ranks");
				dtb.add(pc);
			}
		return dtb;
        }}catch(Exception e) {
        	throw new DBexception(errorMessages.Invalid_Format_case);
        }
	}
}

	/*public ArrayList<PlayerCareer> listallPlayersCareer(String format) throws Exception {
		// TODO Auto-generated method stub
		Connection con1 = TestConnection1.getConnection();
		Statement stmt = con1.createStatement();
		String sql = "select * from player_career where match_id ='"+format+"'" ;
		System.out.println(sql);
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList<PlayerCareer> pl = new ArrayList<PlayerCareer>();
		while(rs.next()) {
			PlayerCareer pc =new PlayerCareer();
			pc.capNo = rs.getString("cap_no");
			pc.format  = rs.getString("match_id");
			pc.matches =rs.getInt("matches");
			pc.runs =rs.getInt("runs");
			pc.fifty = rs.getInt("fifty");
			pc.hundred = rs.getInt("hundred");
			pc.best = rs.getInt("high_score");
			pc.average = rs.getFloat("average");
			pc.ranks = rs.getInt("ranks");
            pl.add(pc);
			}
		return pl;
	}
	}*/
	

// task.add(obj);
// System.out.println(rs.getString("cap_no")+" "+rs.getString("match_id")+"
// "+rs.getInt("matches")+" "+rs.getInt("runs")+" "+rs.getInt("fifty")+"
// "+rs.getInt("hundred")+" "+rs.getInt("high_score"));
// for (PlayerCareer playerCareer : task) {
// System.out.println("\n"+playerCareer);
// }