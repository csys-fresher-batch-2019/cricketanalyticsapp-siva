package com.csys;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.formatruns;

public class PlayerCareerDaoImp implements PlayerCareerDao {

	public void newCareerDetails(String capNo, String format, int matches, int runs, int fifty, int hundred, int best)
			throws Exception {
		// TODO Auto-generated method stub
		Connection con1 = TestConnection1.getConnection();
		Statement stmt = con1.createStatement();
		ResultSet res =stmt.executeQuery("select cap_no from player_list where cap_no='" + capNo + "'");
		if(res.next()) {
			ResultSet rs =stmt.executeQuery("select cap_no,match_id from player_career where cap_no='" + capNo+"' and match_id='" + format + "'");
			if (rs.next()) {
				String sqladd = "insert into player_career(cap_no,match_id,matches,runs,fifty,hundred,high_score) values('"
						+ capNo + "','" + format + "','" + matches + "','" + runs + "','" + fifty + "','" + hundred
						+ "','" + best + "')";
				System.out.println(sqladd);
				int rows = stmt.executeUpdate(sqladd);
				System.out.println(rows);
			} else {
				System.out.println("Already career exist");
				System.out.println("Please ensure capNo or format");
			}
		} else {
			System.out.println("Please create player Profile");
		}
	}

	public ArrayList<Integer> getformatdetails(String capNo, String format) throws Exception {
		Connection con1 = TestConnection1.getConnection();
		Statement stmt = con1.createStatement();
		String det = "select matches,runs,fifty,hundred,high_score from player_career where cap_no = '" + capNo
				+ "' and match_id = '" + format + "'";
		System.out.println(det);

		ArrayList<Integer> task = new ArrayList<Integer>();
		ResultSet rs = stmt.executeQuery(det);

		if (rs.next()) {
			// PlayerCareer pc = new PlayerCareer();
			// System.out.println("matches" + "\t" + "runs" + "\t" + "fifty" + "\t" +
			// "hundred" + "\t" + "high_score");
			task.add(rs.getInt("matches"));
			task.add(rs.getInt("runs"));
			task.add(rs.getInt("fifty"));
			task.add(rs.getInt("hundred"));
			task.add(rs.getInt("high_score"));

			// pc.format = rs.getString("match_id");
			// pc.capNo = rs.getString("cap_no");
			// pc.matches = rs.getInt("matches");
			// pc.runs = rs.getInt("runs");
			// pc.fifty = rs.getInt("fifty");
			// pc.hundred = rs.getInt("hundred");
			// pc.best = rs.getInt("high_score");
			// task.add(pc);

			// TODO Auto-generated method stub

		}
		return task;
	}

	public ArrayList<PlayerCareer> getdetails(String name) throws Exception {
		Connection con1 = TestConnection1.getConnection();
		Statement stmt = con1.createStatement();
		ArrayList<PlayerCareer> task = new ArrayList<PlayerCareer>();
		// String det = "select * from player_career where cap_no = '"+capNo+"'";
		ResultSet res = stmt.executeQuery("select player_name from player_list where upper(player_name)=upper('" + name + "')");
		if (res.next()) {
			String det = "select * from player_career where cap_no =(select cap_no from player_list where upper(player_name) =upper('"
					+ name + "'))";
			System.out.println(det);
			System.out.println(name.toUpperCase());

			ResultSet rs = stmt.executeQuery(det);

			while (rs.next()) {
				PlayerCareer pc = new PlayerCareer();
				pc.format = rs.getString("match_id");
				pc.capNo = rs.getString("cap_no");
				pc.matches = rs.getInt("matches");
				pc.runs = rs.getInt("runs");
				pc.fifty = rs.getInt("fifty");
				pc.hundred = rs.getInt("hundred");
				pc.best = rs.getInt("high_score");
				task.add(pc);
			}
		} else {
			System.out.println("Player does not exist");
		}

		return task;
	}

	public List<PlayerCareer> best(String format, int r) throws Exception {

		Connection con = TestConnection1.getConnection();
		Statement stmt = con.createStatement();
		if (r == 1) {
			String sql = "select l.player_name,c.high_score from player_list l,player_career c where c.match_id='"
					+ format + "' and l.cap_no = c.cap_no order by high_score DESC";
			ResultSet res = stmt.executeQuery(sql);
			ArrayList<PlayerCareer> bst = new ArrayList<PlayerCareer>();
			while (res.next()) {
				PlayerCareer p = new PlayerCareer();
				p.playerName = res.getString("player_name");
				p.best = res.getInt("high_score");
				bst.add(p);
			}
			return bst;
		} else if (r == 2) {
			String sql1 = "select l.player_name,c.hundred from player_list l,player_career c where c.match_id='"
					+ format + "' and l.cap_no = c.cap_no order by hundred DESC";
			ResultSet re = stmt.executeQuery(sql1);
			List<PlayerCareer> bst = new ArrayList<PlayerCareer>();
			while (re.next()) {
				PlayerCareer p = new PlayerCareer();
				p.playerName = re.getString("player_name");
				p.hundred = re.getInt("hundred");
				bst.add(p);
			}
			return bst;
		} else if (r == 3) {
			String sql2 = "select l.player_name,c.fifty from player_list l,player_career c where c.match_id='" + format
					+ "' and l.cap_no = c.cap_no order by fifty DESC";
			ResultSet rs = stmt.executeQuery(sql2);
			List<PlayerCareer> bst = new ArrayList<PlayerCareer>();
			while (rs.next()) {
				PlayerCareer p = new PlayerCareer();
				p.playerName = rs.getString("player_name");
				p.fifty = rs.getInt("fifty");
				bst.add(p);
			}
			return bst;
		} else if (r == 4) {
			String sql3 = "select l.player_name,c.runs from player_list l,player_career c where c.match_id='" + format
					+ "' and l.cap_no = c.cap_no order by runs DESC";
			ResultSet rl = stmt.executeQuery(sql3);
			List<PlayerCareer> bst = new ArrayList<PlayerCareer>();
			while (rl.next()) {
				PlayerCareer p = new PlayerCareer();
				p.playerName = rl.getString("player_name");
				p.runs = rl.getInt("runs");
				bst.add(p);
			}
			return bst;
		}
		return null;
	}

	public List<formatruns> searchbyformatruns(String format, int runs) throws Exception {
		// TODO Auto-generated method stub
		Connection con = TestConnection1.getConnection();
		Statement stmt = con.createStatement();
		String sql = "select l.player_name,c.runs from player_list l,player_career c where c.match_id='" + format
				+ "' and c.runs>+" + runs + " and l.cap_no=c.cap_no order by runs DESC";
		// System.out.println(sql);
		ResultSet res = stmt.executeQuery(sql);
		List<formatruns> bst = new ArrayList<formatruns>();
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
			System.out.println("None of the player cross the mark");
		}
		// System.out.println(8976);
		return bst;

	}

	public void updaterank(String format) throws Exception {
		Connection con = TestConnection1.getConnection();
		Statement stmt = con.createStatement();
		String sql = "select l.cap_no,l.player_name,l.nation,c.average from player_list l,player_career c where c.match_id='"
				+ format + "'and l.cap_no = c.cap_no order by c.average DESC";
		System.out.println(sql);
		ResultSet res = stmt.executeQuery(sql);
		// ArrayList<PlayerCareer> bst = new ArrayList<PlayerCareer>();
		System.out.println("Assigning Rank");
		int rank = 1;
		while (res.next()) {
			PlayerCareer ad = new PlayerCareer();
			ad.capNo = res.getString("cap_no");
			System.out.println("CapNo:" + ad.capNo);
			String sql1 = "update player_career set ranks=" + rank + " where cap_no ='" + ad.capNo + "' and match_id='"
					+ format + "'";
			stmt = con.createStatement();
			int row = stmt.executeUpdate(sql1);
			System.out.println(row);
			System.out.println(sql1);
			rank++;
		}
		System.out.println("Rank updated");
	}

	public List<PlayerCareer> displaytopbatsman(String format, int n) throws Exception {
		// TODO Auto-generated method stub
		Connection con = TestConnection1.getConnection();
		Statement stmt = con.createStatement();
		String sql = " select l.player_name,l.nation,c.average,c.ranks from player_list l,player_career c where c.match_id='"+format+"' and l.cap_no=c.cap_no and ranks <="+n+"order by ranks asc";
        ResultSet rs = stmt.executeQuery(sql);
		List<PlayerCareer> dtb = new ArrayList<PlayerCareer>();
		    	while (rs.next()) {
				PlayerCareer pc = new PlayerCareer();
				pc.playerName = rs.getString("player_name");
				pc.nation = rs.getString("nation");
				pc.average = rs.getFloat("average");
				pc.ranks = rs.getInt("ranks");
				dtb.add(pc);
				
			}
		return dtb;
	}

	public ArrayList<PlayerCareer> listallPlayersCareer(String format) throws Exception {
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
	}
	

// task.add(obj);
// System.out.println(rs.getString("cap_no")+" "+rs.getString("match_id")+"
// "+rs.getInt("matches")+" "+rs.getInt("runs")+" "+rs.getInt("fifty")+"
// "+rs.getInt("hundred")+" "+rs.getInt("high_score"));
// for (PlayerCareer playerCareer : task) {
// System.out.println("\n"+playerCareer);
// }