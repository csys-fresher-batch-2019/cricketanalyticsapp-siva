package com.csys.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.csys.dao.PlayerCareerDao;
import com.csys.exception.DBexception;
import com.csys.exception.errorMessages;
import com.csys.exception.infoMessages;
import com.csys.model.PlayerCareer;
import com.csys.model.formatruns;
import com.csys.util.Logger;
import com.csys.util.TestConnection1;

public class PlayerCareerDaoImp implements PlayerCareerDao {
	Logger logger = new Logger();

	// create career for new player in all formats
	public void createNewCareer(String capNo) throws DBexception {
		createOdiCareer(capNo);
		createTestCareer(capNo);
		createT20Career(capNo);
	}

	// create t20 career
	public void createT20Career(String capNo) throws DBexception {
		String query = "insert into player_career(cap_no,match_id,matches,runs,fifty,hundred,high_score) values(?,?,?,?,?,?,?)";
		try (Connection con1 = TestConnection1.getConnection();) {
			try (PreparedStatement stmt = con1.prepareStatement(query);) {
				stmt.setString(1, capNo);
				stmt.setString(2, "t20");
				stmt.setInt(3, 0);
				stmt.setInt(4, 0);
				stmt.setInt(5, 0);
				stmt.setInt(6, 0);
				stmt.setInt(7, 0);
				stmt.executeUpdate();
				logger.info(infoMessages.Insert_Message);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBexception(e);
		}
	}

	// create test career
	public void createTestCareer(String capNo) throws DBexception {
		String query = "insert into player_career(cap_no,match_id,matches,runs,fifty,hundred,high_score) values(?,?,?,?,?,?,?)";
		try (Connection con1 = TestConnection1.getConnection();
				PreparedStatement stmt = con1.prepareStatement(query);) {
			stmt.setString(1, capNo);
			stmt.setString(2, "test");
			stmt.setInt(3, 0);
			stmt.setInt(4, 0);
			stmt.setInt(5, 0);
			stmt.setInt(6, 0);
			stmt.setInt(7, 0);
			stmt.executeUpdate();
			logger.info(infoMessages.Insert_Message);
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new DBexception(e1);
		}

	}

	// create odi career
	public void createOdiCareer(String capNo) throws DBexception {
		String query = "insert into player_career(cap_no,match_id,matches,runs,fifty,hundred,high_score) values(?,?,?,?,?,?,?)";
		try (Connection con1 = TestConnection1.getConnection();
				PreparedStatement stmt = con1.prepareStatement(query);) {
			stmt.setString(1, capNo);
			stmt.setString(2, "odi");
			stmt.setInt(3, 0);
			stmt.setInt(4, 0);
			stmt.setInt(5, 0);
			stmt.setInt(6, 0);
			stmt.setInt(7, 0);
			stmt.executeUpdate();
			logger.info(infoMessages.Insert_Message);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBexception(errorMessages.Connection, e);
		}
	}

	// Get career details for given player
	public ArrayList<PlayerCareer> getDetails(String name) throws DBexception {
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
		} catch (SQLException e) {
			throw new DBexception(e);
		}

	}

	// List highScore along with playername for given format in a descending order
	public List<PlayerCareer> listHighScore(String format) throws DBexception {
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
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBexception(e);
		}
	}

	// List number of hundreds along with playername for given format in a
	// descending order
	public List<PlayerCareer> listHundred(String format) throws DBexception {
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
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBexception(errorMessages.Invalid_Format, e);
		}
	}

	// List number of fifties along with playername for given format in a descending
	// order
	public List<PlayerCareer> listFifties(String format) throws DBexception {
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
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBexception(errorMessages.Invalid_Format, e);
		}
	}

	// List more of runs along with player name for given format in a descending
	// order
	public List<PlayerCareer> listRuns(String format) throws DBexception {
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
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBexception(errorMessages.Invalid_Format, e);
		}

	}

	public List<formatruns> searchByFormatRuns(String format, int runs) throws DBexception {
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
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBexception(errorMessages.Invalid_Format, e);
		}
	}

	// Update rank
	public void updateRank(String format) throws DBexception {
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
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBexception(errorMessages.Invalid_Format, e);
		}
	}

	// Display Top Batsman for given format
	public List<PlayerCareer> displayTopBatsman(String format, int n) throws DBexception {
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
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBexception(errorMessages.Invalid_Format_case, e);
		}
	}

}
