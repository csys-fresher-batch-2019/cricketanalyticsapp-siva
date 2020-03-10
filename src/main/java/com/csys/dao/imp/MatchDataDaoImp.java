package com.csys.dao.imp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.csys.dao.MatchDataDao;
import com.csys.exceptionmsg.DBexception;
import com.csys.exceptionmsg.errorMessages;
import com.csys.exceptionmsg.infoMessages;
import com.csys.model.MatchData;
import com.csys.util.Logger;
import com.csys.util.TestConnection1;

public class MatchDataDaoImp implements MatchDataDao {
	Logger logger = new Logger();

	// Add match summary
	public void addMatchDetail(String capNo, String format, int runs) throws DBexception {
		try (Connection res = TestConnection1.getConnection();) {
			String sqladd = "insert into match_data(cap_no,match_type,runs) values (?,?,?)";
			try (PreparedStatement arr = res.prepareStatement(sqladd);) {
				arr.setString(1, capNo);
				arr.setString(2, format);
				arr.setInt(3, runs);
				arr.executeUpdate();
				logger.info(infoMessages.Add_Match_Detail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBexception(e);
		}
	}

	// Delete match summary
	public void deleteMatchDetail() throws DBexception {

		String sqldelete = "delete from match_data where status =?";
		try (Connection res = TestConnection1.getConnection();
				PreparedStatement arr = res.prepareStatement(sqldelete);) {
			arr.setString(1, "updated");
			arr.executeUpdate();
			logger.info(infoMessages.Delete_Match_Detail);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBexception(e);
		}
	}

	// update career for existing players in respective formats
	public void updateCareer() throws DBexception {
		String status = "yet to update";
		try (Connection ci = TestConnection1.getConnection();
				CallableStatement cs = ci.prepareCall("{ call update_career(?,?,?)}");) {
			List<MatchData> summary = showNotUpdateData(status);
			for (MatchData obj : summary) {
				String capNo = obj.getCapNo();
				String format = obj.getFormat();
				int runs = obj.getRuns();
				cs.setString(1, capNo);
				cs.setString(2, format);
				cs.setInt(3, runs);
				cs.execute();
				PlayerCareerDaoImp object = new PlayerCareerDaoImp();
				object.updaterank(format);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBexception(e);

		}
	}

	@Override
	// view match summary
	public List<MatchData> showmatchdetails(String status) throws DBexception {
		String sql = "select * from match_data where status=?";
		List<MatchData> summary = new ArrayList<>();
		try (Connection ci = TestConnection1.getConnection(); PreparedStatement arr = ci.prepareStatement(sql);) {
			arr.setString(1, status);
			try (ResultSet rs = arr.executeQuery();) {
				while (rs.next()) {
					MatchData md = new MatchData();
					md.setCapNo(rs.getString("cap_no"));
					md.setFormat(rs.getString("match_type"));
					md.setRuns(rs.getInt("runs"));
					md.setStatus(rs.getString("status"));
					summary.add(md);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBexception(e);
		}

		return summary;

	}

	private List<MatchData> showNotUpdateData(String status) throws DBexception {
		String sql = "select cap_no,match_type,runs from match_data where status=?";
		List<MatchData> summary = new ArrayList<>();
		try (Connection ci = TestConnection1.getConnection(); PreparedStatement arr = ci.prepareStatement(sql);) {
			arr.setString(1, "yet to update");
			try (ResultSet rs = arr.executeQuery();) {
				while (rs.next()) {
					MatchData md = new MatchData();
					md.setCapNo(rs.getString("cap_no"));
					md.setFormat(rs.getString("match_type"));
					md.setRuns(rs.getInt("runs"));
					summary.add(md);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBexception(e);
		}

		return summary;

	}
}
