package com.csys.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.csys.dao.PlayerCareerDao;
import com.csys.exceptionmsg.DBexception;
import com.csys.exceptionmsg.errorMessages;
import com.csys.exceptionmsg.infoMessages;
import com.csys.model.PlayerCareer;
import com.csys.model.formatruns;
import com.csys.util.Logger;
import com.csys.util.TestConnection1;

public class PlayerCareerDaoImp implements PlayerCareerDao {
	Logger logger = new Logger();

	public void createNewCareer(String capNo) throws DBexception {
		try (Connection con1 = TestConnection1.getConnection(); Statement stmt = con1.createStatement();) {
			String sqladd1 = "insert into player_career(cap_no,match_id,matches,runs,fifty,hundred,high_score) values('"
					+ capNo + "','odi',0,0,0,0,0)";
			String sqladd2 = "insert into player_career(cap_no,match_id,matches,runs,fifty,hundred,high_score) values('"
					+ capNo + "','test',0,0,0,0,0)";
			String sqladd3 = "insert into player_career(cap_no,match_id,matches,runs,fifty,hundred,high_score) values('"
					+ capNo + "','t20',0,0,0,0,0)";
			logger.info(sqladd1);
			int rows = stmt.executeUpdate(sqladd1);
			int rows1 = stmt.executeUpdate(sqladd2);
			int rows2 = stmt.executeUpdate(sqladd3);
			logger.info(rows);
			logger.info(rows1);
			logger.info(rows2);
			logger.info(infoMessages.Insert_Message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<PlayerCareer> getdetails(String name) throws DBexception {
		try (Connection con1 = TestConnection1.getConnection(); Statement stmt = con1.createStatement();) {
			ArrayList<PlayerCareer> task = new ArrayList<>();

			try (ResultSet res = stmt.executeQuery(
					"select player_name from player_list where upper(player_name)=upper('" + name + "')");) {
				if (res.next() == true) {
					String det = "select * from player_career where cap_no =(select cap_no from player_list where upper(player_name) =upper('"
							+ name + "'))";
					logger.info(det);
					logger.info(name.toUpperCase());

					try (ResultSet rs = stmt.executeQuery(det);) {

						while (rs.next()) {
							PlayerCareer pc = new PlayerCareer();
							pc.setFormat(rs.getString("match_id"));
							pc.setCapNo(rs.getString("cap_no"));
							pc.setMatches(rs.getInt("matches"));
							pc.setRuns(rs.getInt("runs"));
							pc.setFifty(rs.getInt("fifty"));
							pc.setHundred(rs.getInt("hundred"));
							pc.setBest(rs.getInt("high_score"));
							pc.setAverage(rs.getFloat("average"));
							pc.setRanks(rs.getInt("ranks"));
							task.add(pc);
						}
					}
				} else {
					logger.info(errorMessages.Invalid_Name);
				}
			}
			return task;
		} catch (Exception e) {
			throw new DBexception(errorMessages.Invalid_Name);
		}

	}

	public List<PlayerCareer> listhighScore(String format) throws DBexception {
		String sql = "select l.player_name,c.high_score from player_list l,player_career c where c.match_id=? and l.cap_no = c.cap_no and high_score>100 order by high_score DESC";

		try (Connection con = TestConnection1.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setString(1, format);
			try (ResultSet res = stmt.executeQuery();) {
				List<PlayerCareer> bst = new ArrayList<>();
				while (res.next()) {
					PlayerCareer p = new PlayerCareer();
					p.setplayerName(res.getString("player_name"));
					p.setBest(res.getInt("high_score"));
					bst.add(p);
				}
				return bst;
			}
		} catch (Exception e) {
			throw new DBexception(errorMessages.Invalid_Format);
		}
	}

	public List<PlayerCareer> listhundred(String format) throws Exception {
		String sql = "select l.player_name,c.hundred from player_list l,player_career c where c.match_id=? and l.cap_no = c.cap_no and hundred>0 order by hundred DESC";
		try (Connection con = TestConnection1.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setString(1, format);
			try (ResultSet res = stmt.executeQuery();) {
				List<PlayerCareer> bst = new ArrayList<>();
				while (res.next()) {
					PlayerCareer p = new PlayerCareer();
					p.setplayerName(res.getString("player_name"));
					p.setHundred(res.getInt("hundred"));
					System.out.println(p);
					bst.add(p);
				}
				return bst;
			}
		} catch (Exception e) {
			throw new DBexception(errorMessages.Invalid_Format);
		}
	}

	public List<PlayerCareer> listfifties(String format) throws Exception {
		String sql2 = "select l.player_name,c.fifty from player_list l,player_career c where c.match_id=? and l.cap_no = c.cap_no and fifty>0 order by fifty DESC";
		try (Connection con = TestConnection1.getConnection(); PreparedStatement stmt = con.prepareStatement(sql2);) {
			stmt.setString(1, format);
			try (ResultSet rs = stmt.executeQuery();) {
				List<PlayerCareer> bst = new ArrayList<PlayerCareer>();
				while (rs.next()) {
					PlayerCareer p = new PlayerCareer();
					p.setplayerName(rs.getString("player_name"));
					p.setFifty(rs.getInt("fifty"));
					bst.add(p);
				}
				return bst;
			}
		} catch (Exception e) {
			throw new DBexception(errorMessages.Invalid_Format);
		}
	}

	public List<PlayerCareer> listruns(String format) throws Exception {
		String sql3 = "select l.player_name,c.runs from player_list l,player_career c where c.match_id=? and l.cap_no = c.cap_no and runs>1000 order by runs DESC";
		try (Connection con = TestConnection1.getConnection(); PreparedStatement stmt = con.prepareStatement(sql3);) {
			stmt.setString(1, format);
			try (ResultSet rl = stmt.executeQuery();) {
				List<PlayerCareer> bst = new ArrayList<>();
				while (rl.next()) {
					PlayerCareer p = new PlayerCareer();
					p.setplayerName(rl.getString("player_name"));
					p.setRuns(rl.getInt("runs"));
					bst.add(p);
				}
				return bst;
			}
		} catch (Exception e) {
			throw new DBexception(errorMessages.Invalid_Format);
		}

	}

	public List<formatruns> searchbyformatruns(String format, int runs) throws DBexception {
		String sql = "select l.player_name,c.runs from player_list l,player_career c where c.match_id=? and c.runs>? and l.cap_no=c.cap_no order by runs DESC";
		try (Connection con = TestConnection1.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setString(1, format);
			stmt.setInt(2, runs);
			try (ResultSet res = stmt.executeQuery();) {
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
					logger.info(infoMessages.Out_of_boundary);
				}
				return bst;
			}
		} catch (Exception e) {
			throw new DBexception(errorMessages.Invalid_Format);
		}
	}

	public void updaterank(String format) throws Exception {
		String sql = "select c.cap_no, l.player_name,l.nation,c.average from player_list l,player_career c where c.match_id=? and l.cap_no=c.cap_no and l.retired_year= 0 and c.average>0 order by c.average DESC";
		try (Connection con = TestConnection1.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setString(1, format);

			try (ResultSet res = stmt.executeQuery();) {
				int rank = 1;
				while (res.next()) {
					PlayerCareer ad = new PlayerCareer();
					ad.setCapNo(res.getString("cap_no"));
					logger.info("CapNo:" + ad.getCapNo());
					String sql1 = "update player_career set ranks=? where cap_no=? and match_id=?";
					try (PreparedStatement stm = con.prepareStatement(sql1);) {

						stm.setInt(1, rank);
						stm.setString(2, ad.getCapNo());
						stm.setString(3, format);
						int row = stm.executeUpdate();
						logger.info(row);
						logger.info(sql1);
						rank++;

					}
				}
				logger.info(infoMessages.Updation);
			}
		} catch (Exception e) {
			throw new DBexception(errorMessages.Invalid_Format);
		}
	}

	public List<PlayerCareer> displaytopbatsman(String format, int n) throws Exception {
		String sql = " select l.player_name,l.nation,c.average,c.ranks from player_list l,player_career c where c.match_id=? and l.cap_no=c.cap_no and ranks <=? order by ranks asc";
		try (Connection con = TestConnection1.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setString(1, format);
			stmt.setInt(2, n);
			try (ResultSet rs = stmt.executeQuery();) {
				List<PlayerCareer> dtb = new ArrayList<>();
				while (rs.next()) {
					PlayerCareer pc = new PlayerCareer();
					pc.setplayerName(rs.getString("player_name"));
					pc.setnation(rs.getString("nation"));
					pc.setAverage(rs.getFloat("average"));
					pc.setRanks(rs.getInt("ranks"));
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
			logger.info(infoMessages.Insert_Message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	}