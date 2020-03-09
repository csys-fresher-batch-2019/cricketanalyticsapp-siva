package com.csys.dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
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

	public void addPlayer(String capNo, String name, String nation, String style, int debutYear) throws Exception {

		try (Connection con1 = TestConnection1.getConnection(); Statement stmt = con1.createStatement();) {
			boolean check = validateplayerprofile(capNo);
			if (check) {
				String add = "insert into player_list(cap_no,player_name,nation,batting_style,debut_year) values ('"
						+ capNo + "','" + name + "','" + nation + "','" + style + "'," + debutYear + ")";
				logger.info(add);
				int rows = stmt.executeUpdate(add);
				logger.info(rows);
				PlayerCareerDaoImp method = new PlayerCareerDaoImp();
				method.createNewCareer(capNo);
				logger.info(infoMessages.Insert_Message);
			} else {
				logger.info(infoMessages.Duplicate_message);
			}
		} catch (Exception e) {
			throw new DBexception(errorMessages.NonSpecifyColumn);
		}

	}

	public int updateRetiredYear(String capNo, int year) throws DBexception {
		int row = 0;
		try (Connection con1 = TestConnection1.getConnection(); Statement st = con1.createStatement();) {
			String sql = "update player_list set retired_year = " + year + " where cap_no = '" + capNo + "'";
			logger.info(sql);
			row = st.executeUpdate(sql);
			logger.info(infoMessages.Updation);
		} catch (Exception e) {
			throw new DBexception(errorMessages.Invalid_capNo);
		}
		return row;
	}

	public List<PlayerProfile> playerlist(String nation) throws DBexception {
		try (Connection con1 = TestConnection1.getConnection(); Statement stmt = con1.createStatement();) {
			String sql = "select cap_no,player_name,batting_style,debut_year from player_list where nation ='" + nation
					+ "' and retired_year = 0";
			logger.info(sql);
			try (ResultSet rs = stmt.executeQuery(sql);) {
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
		} catch (Exception e) {
			throw new DBexception(errorMessages.Invalid_nation);
		}
	}

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
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBexception(errorMessages.Connection);
		}
	}

	public boolean validateplayerprofile(String capNo) throws Exception {
		boolean check = true;
		try (Connection con1 = TestConnection1.getConnection(); Statement stmt = con1.createStatement();) {
			try (ResultSet res = stmt.executeQuery("select cap_no from player_career where cap_no='" + capNo + "'");) {
				if (res.next()) {
					check = false;
				}
			}
			con1.close();
		}
		return check;
	}

	@Override
	public boolean validateretiredplayer(String capno) throws Exception {

		boolean check = false;
		try (Connection con1 = TestConnection1.getConnection(); Statement stmt = con1.createStatement();) {
			try (ResultSet res = stmt
					.executeQuery("select cap_no from player_list where cap_no='" + capno + "' and retired_year!=0");) {
				if (res.next()) {
					check = true;
				}
			}
			con1.close();
		}
		return check;
	}

}
