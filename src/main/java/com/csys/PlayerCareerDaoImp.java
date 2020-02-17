package com.csys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlayerCareerDaoImp implements PlayerCareerDao {

	public void createNewCareer(String capNo) throws DBexception {
							try (Connection con1 = TestConnection1.getConnection(); 
							Statement stmt = con1.createStatement();) {
					String sqladd1 = "insert into player_career(cap_no,match_id,matches,runs,fifty,hundred,high_score) values('"
							+ capNo + "','odi',0,0,0,0,0)";
					String sqladd2 = "insert into player_career(cap_no,match_id,matches,runs,fifty,hundred,high_score) values('"
							+ capNo + "','test',0,0,0,0,0)";
					String sqladd3 = "insert into player_career(cap_no,match_id,matches,runs,fifty,hundred,high_score) values('"
							+ capNo + "','t20',0,0,0,0,0)";
					System.out.println(sqladd1);
					int rows = stmt.executeUpdate(sqladd1);
					int rows1 = stmt.executeUpdate(sqladd2);
					int rows2 = stmt.executeUpdate(sqladd3);
					System.out.println(rows);
					System.out.println(rows1);
					System.out.println(rows2);
					System.out.println(infoMessages.Insert_Message);
					
				} catch (Exception e) {
			      e.printStackTrace();
		}
				}
	

	public ArrayList<PlayerCareer> getdetails(String name) throws DBexception {
		try (Connection con1 = TestConnection1.getConnection(); Statement stmt = con1.createStatement();) {
			ArrayList<PlayerCareer> task = new ArrayList<>();
			// String det = "select * from player_career where cap_no = '"+capNo+"'";
			try (ResultSet res = stmt.executeQuery(
					"select player_name from player_list where upper(player_name)=upper('" + name + "')");) {
				if (res.next() == true) {
					String det = "select * from player_career where cap_no =(select cap_no from player_list where upper(player_name) =upper('"
							+ name + "'))";
					System.out.println(det);
					System.out.println(name.toUpperCase());

					try (ResultSet rs = stmt.executeQuery(det);) {

						while (rs.next()) {
							PlayerCareer pc = new PlayerCareer();
							pc.format = rs.getString("match_id");
							pc.capNo = rs.getString("cap_no");
							pc.matches = rs.getInt("matches");
							pc.runs = rs.getInt("runs");
							pc.fifty = rs.getInt("fifty");
							pc.hundred = rs.getInt("hundred");
							pc.best = rs.getInt("high_score");
							pc.average = rs.getFloat("average");
							pc.ranks = rs.getInt("ranks");
							task.add(pc);
						}
					}
				} else {
					System.out.println(errorMessages.Invalid_Name);
				}
			}
			return task;
		} catch (Exception e) {
			throw new DBexception(errorMessages.Invalid_Name);
		}

	}

	public List<PlayerCareer> listhighScore(String format) throws DBexception {
		try (Connection con = TestConnection1.getConnection(); Statement stmt = con.createStatement();) {
			String sql = "select l.player_name,c.high_score from player_list l,player_career c where c.match_id='"
					+ format + "' and l.cap_no = c.cap_no and high_score>100 order by high_score DESC";
			try (ResultSet res = stmt.executeQuery(sql);) {
				List<PlayerCareer> bst = new ArrayList<>();
				while (res.next()) {
					PlayerCareer p = new PlayerCareer();
					p.playerName = res.getString("player_name");
					p.best = res.getInt("high_score");
					bst.add(p);
				}
				return bst;
			}
		} catch (Exception e) {
			throw new DBexception(errorMessages.Invalid_Format);
		}
	}

	public List<PlayerCareer> listhundred(String format) throws Exception {
		try (Connection con = TestConnection1.getConnection(); Statement stmt = con.createStatement();) {
			String sql1 = "select l.player_name,c.hundred from player_list l,player_career c where c.match_id='"
					+ format + "' and l.cap_no = c.cap_no and hundred>0 order by hundred DESC";
			try (ResultSet re = stmt.executeQuery(sql1);) {
				List<PlayerCareer> bst = new ArrayList<>();
				while (re.next()) {
					PlayerCareer p = new PlayerCareer();
					p.playerName = re.getString("player_name");
					p.hundred = re.getInt("hundred");
					bst.add(p);
				}
				return bst;
			}
		} catch (Exception e) {
			throw new DBexception(errorMessages.Invalid_Format);
		}
	}

	public List<PlayerCareer> listfifties(String format) throws Exception {

		try (Connection con = TestConnection1.getConnection(); Statement stmt = con.createStatement();) {
			String sql2 = "select l.player_name,c.fifty from player_list l,player_career c where c.match_id='" + format
					+ "' and l.cap_no = c.cap_no and fifty>0 order by fifty DESC";
			try (ResultSet rs = stmt.executeQuery(sql2);) {
				List<PlayerCareer> bst = new ArrayList<PlayerCareer>();
				while (rs.next()) {
					PlayerCareer p = new PlayerCareer();
					p.playerName = rs.getString("player_name");
					p.fifty = rs.getInt("fifty");
					bst.add(p);
				}
				return bst;
			}
		} catch (Exception e) {
			throw new DBexception(errorMessages.Invalid_Format);
		}
	}

	public List<PlayerCareer> listruns(String format) throws Exception {

		try (Connection con = TestConnection1.getConnection(); Statement stmt = con.createStatement();) {
			String sql3 = "select l.player_name,c.runs from player_list l,player_career c where c.match_id='" + format
					+ "' and l.cap_no = c.cap_no and runs>1000 order by runs DESC";
			try (ResultSet rl = stmt.executeQuery(sql3);) {
				List<PlayerCareer> bst = new ArrayList<>();
				while (rl.next()) {
					PlayerCareer p = new PlayerCareer();
					p.playerName = rl.getString("player_name");
					p.runs = rl.getInt("runs");
					bst.add(p);
				}
				return bst;
			}
		} catch (Exception e) {
			throw new DBexception(errorMessages.Invalid_Format);
		}

	}

	public List<formatruns> searchbyformatruns(String format, int runs) throws DBexception {
		try (Connection con = TestConnection1.getConnection(); Statement stmt = con.createStatement();) {
			String sql = "select l.player_name,c.runs from player_list l,player_career c where c.match_id='" + format
					+ "' and c.runs>" + runs + " and l.cap_no=c.cap_no order by runs DESC";

			try (ResultSet res = stmt.executeQuery(sql);) {
				List<formatruns> bst = new ArrayList<>();
				boolean res1 = false;

				while (res.next()) {
					formatruns p = new formatruns();
					p.setPlayerName(res.getString("player_name"));
					p.setRuns(res.getInt("runs"));
					bst.add(p);
					res1 = true;
				}
				if (res1) {
				} else {
					System.out.println(infoMessages.Out_of_boundary);
				}
				return bst;
			}
		} catch (Exception e) {
			throw new DBexception(errorMessages.Invalid_Format);
		}
	}

	public void updaterank(String format) throws Exception {
		try(Connection con = TestConnection1.getConnection();
		Statement stmt = con.createStatement();){
		String sql = "select c.cap_no, l.player_name,l.nation,c.average from player_list l,player_career c where c.match_id='"
				+ format + "'and l.cap_no=c.cap_no and l.retired_year= 0 and c.average>0 order by c.average DESC";
		System.out.println(sql);
		try(ResultSet res = stmt.executeQuery(sql);){
		int rank = 1;
		while (res.next()) {
			// System.out.println(sql);
			PlayerCareer ad = new PlayerCareer();
			ad.setCapNo(res.getString("cap_no"));
			System.out.println("CapNo:" + ad.getCapNo());
			String sql1 = "update player_career set ranks=" + rank + " where cap_no ='" + ad.getCapNo()
					+ "' and match_id='" + format + "'";

			try(Statement stm = con.createStatement();){
			
				int row = stm.executeUpdate(sql1);
				System.out.println(row);
				System.out.println(sql1);
				rank++;
			
		}}
		System.out.println(infoMessages.Updation);
	}}catch(Exception e) {
		throw new DBexception (errorMessages.Invalid_Format);
	}}

	public List<PlayerCareer> displaytopbatsman(String format, int n) throws Exception {
		try (Connection con = TestConnection1.getConnection(); Statement stmt = con.createStatement();) {
			String sql = " select l.player_name,l.nation,c.average,c.ranks from player_list l,player_career c where c.match_id='"
					+ format + "' and l.cap_no=c.cap_no and ranks <=" + n + "order by ranks asc";
			try (ResultSet rs = stmt.executeQuery(sql);) {
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
			}
		} catch (Exception e) {
			throw new DBexception(errorMessages.Invalid_Format_case);
		}
	}

	public boolean checkinsertCareerDetailForSpecificFormat(String capNo, String format) throws Exception {
		boolean valid = false;
		String check = "select cap_no,match_id from player_career where cap_no=? and match_id=?";
		try (Connection connect = TestConnection1.getConnection();
				PreparedStatement pst = connect.prepareStatement(check);) {
			pst.setString(1, capNo);
			pst.setString(2, format);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					valid = true;
				}
			}

		}
		return valid;
	}

	public void insertCareerDetailForSpecificFormat(String capNo, String format, int matches, int runs, int fifty,
			int hundred, int best, float average) throws Exception {
		String insert = "insert into player_career(cap_no,match_id,matches,runs,fifty,hundred,high_score,average) values (?,?,?,?,?,?,?,?) ";
		try (Connection connect = TestConnection1.getConnection();
				PreparedStatement pst = connect.prepareStatement(insert);) {
			pst.setString(1, capNo);
			pst.setString(2, format);
			pst.setInt(3, matches);
			pst.setInt(4, runs);
			pst.setInt(5, fifty);
			pst.setInt(6, hundred);
			pst.setInt(7, best);
			pst.setFloat(8, average);
			pst.executeUpdate();
			System.out.println(infoMessages.Insert_Message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean validateplayercareer(String capNo,String format) throws Exception{
		boolean check = true;		
		try (Connection con1 = TestConnection1.getConnection(); 
				Statement stmt = con1.createStatement();) {
			try (ResultSet res = stmt.executeQuery("select cap_no,match_id from player_career where cap_no='" + capNo + "' and match_id ='"+format+"'");) {
				if (res.next()) {
					check = false;
	}}con1.close();}
				return check;
}
	}