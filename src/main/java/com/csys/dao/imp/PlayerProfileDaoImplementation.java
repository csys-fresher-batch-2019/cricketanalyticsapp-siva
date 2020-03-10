package com.csys.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.csys.dao.PlayerProfileDao;
import com.csys.exceptionmsg.DBexception;
import com.csys.exceptionmsg.errorMessages;
import com.csys.exceptionmsg.infoMessages;
import com.csys.model.PlayerProfile;
import com.csys.util.Logger;
import com.csys.util.TestConnection1;

public class PlayerProfileDaoImplementation implements PlayerProfileDao {

	Logger logger = new Logger();

	// create new player
	public void addPlayer(String capNo, String name, String nation, String style, int debutYear) throws DBexception {
		String add = "insert into player_list(cap_no,player_name,nation,batting_style,debut_year) values (?,?,?,?,?)";
		try (Connection con1 = TestConnection1.getConnection(); PreparedStatement stmt = con1.prepareStatement(add);) {
			boolean check = validateplayerprofile(capNo);
			if (check) {
				stmt.setString(1, capNo);
				stmt.setString(2, name);
				stmt.setString(3, nation);
				stmt.setString(4, style);
				stmt.setInt(5, debutYear);
				logger.info(add);
				int rows = stmt.executeUpdate();
				logger.info(rows);
				PlayerCareerDaoImp method = new PlayerCareerDaoImp();
				method.createNewCareer(capNo);
				logger.info(infoMessages.Insert_Message);
			} else {
				logger.info(infoMessages.Duplicate_message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBexception(errorMessages.NonSpecifyColumn, e);
		}

	}

	// update retired year
	public int updateRetiredYear(String capNo, int year) throws DBexception {
		int row = 0;
		String sql = "update player_list set retired_year = ? where cap_no = ?";
		try (Connection con1 = TestConnection1.getConnection(); PreparedStatement st = con1.prepareStatement(sql);) {
			st.setInt(1, year);
			st.setString(2, capNo);
			logger.info(sql);
			row = st.executeUpdate();
			logger.info(infoMessages.Updation);
		} catch (SQLException e) {
			throw new DBexception(errorMessages.Invalid_capNo, e);
		}
		return row;
	}

	// List Players by Team
	public List<PlayerProfile> playerlist(String nation) throws DBexception {
		String sql = "select cap_no,player_name,batting_style,debut_year from player_list where nation =? and retired_year = 0";
		try (Connection con1 = TestConnection1.getConnection(); PreparedStatement stmt = con1.prepareStatement(sql);) {
			stmt.setString(1, nation);
			logger.info(sql);
			try (ResultSet rs = stmt.executeQuery();) {
				List<PlayerProfile> pl = new ArrayList<PlayerProfile>();
				while (rs.next()) {
					PlayerProfile pp = new PlayerProfile();
					pp.capNo = rs.getString("cap_no");
					pp.name = rs.getString("player_name");
					pp.style = rs.getString("batting_style");
					pp.debutYear = rs.getInt("debut_year");
					pl.add(pp);
				}
				return pl;
			}
		} catch (SQLException e) {
			throw new DBexception(errorMessages.Invalid_nation, e);
		}
	}

	// List Player Name
	public List<String> getPlayerName() throws DBexception {
		try (Connection con1 = TestConnection1.getConnection(); Statement stmt = con1.createStatement();) {
			String sql = "select player_name from player_list";
			logger.info(sql);
			try (ResultSet rs = stmt.executeQuery(sql);) {
				List<String> pl = new ArrayList<String>();
				while (rs.next()) {
					String name = rs.getString("player_name");
					pl.add(name);
				}
				return pl;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBexception(e);
		}
	}

	// Check Existing Player
	public boolean validateplayerprofile(String capNo) throws DBexception {
		boolean check = true;
		String valid = "select cap_no from player_career where cap_no=?";
		try (Connection con1 = TestConnection1.getConnection();
				PreparedStatement stmt = con1.prepareStatement(valid);) {
			stmt.setString(1, capNo);
			try (ResultSet res = stmt.executeQuery();) {
				if (res.next()) {
					check = false;
				}
			}
			con1.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBexception(errorMessages.Invalid_capNo, e);
		}
		return check;
	}

	@Override
	// Check Retired Player
	public boolean validateretiredplayer(String capno) throws DBexception {
		String valid = "select cap_no from player_list where cap_no=? and retired_year!=0";
		boolean check = false;
		try (Connection con1 = TestConnection1.getConnection();
				PreparedStatement stmt = con1.prepareStatement(valid);) {
			try (ResultSet res = stmt.executeQuery();) {
				if (res.next()) {
					check = true;
				}
			}
			con1.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBexception(errorMessages.Invalid_capNo, e);
		}
		return check;
	}

}
