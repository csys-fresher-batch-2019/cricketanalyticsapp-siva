package com.csys.dao.imp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.csys.dao.MatchDataDao;
import com.csys.exception.DBexception;
import com.csys.exception.infoMessages;
import com.csys.model.MatchData;
import com.csys.util.Logger;
import com.csys.util.connectionUtil;

public class MatchDataDaoImp implements MatchDataDao {
	Logger logger = new Logger();

	/**
	 * Add match summary
	 *
	 */
	public void addMatchDetail(String capNo, String format, int runs) throws DBexception {
		try (Connection res = connectionUtil.getConnection();) {
			String sql = "insert into match_data(cap_no,match_type,runs) values (?,?,?)";
			try (PreparedStatement pst = res.prepareStatement(sql);) {
				pst.setString(1, capNo);
				pst.setString(2, format);
				pst.setInt(3, runs);
				pst.executeUpdate();
				logger.info(infoMessages.Add_Match_Detail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBexception(e);
		}
	}

	/**
	 * Delete match summary
	 * 
	 */
	public void deleteMatchDetail(String status) throws DBexception {

		String sqldelete = "delete from match_data where status =?";
		try (Connection res = connectionUtil.getConnection();
				PreparedStatement pst = res.prepareStatement(sqldelete);) {
			pst.setString(1, status);
			pst.executeUpdate();
			logger.info(infoMessages.Delete_Match_Detail);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBexception(e);
		}
	}

	/**
	 * update career for existing players in respective formats
	 * 
	 */
	public void updateCareer(String status) throws DBexception {

		String format = null;
		try (Connection ci = connectionUtil.getConnection();
				CallableStatement cs = ci.prepareCall("{ call update_career(?,?,?)}");) {
			List<MatchData> summary = showNotUpdateData(status);
			for (MatchData obj : summary) {
				String capNo = obj.getCapNo();
				format = obj.getFormat();
				int runs = obj.getRuns();
				cs.setString(1, capNo);
				cs.setString(2, format);
				cs.setInt(3, runs);
				cs.execute();
			}
			PlayerCareerDaoImp object = new PlayerCareerDaoImp();
			object.updateRank(format);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBexception(e);

		}
	}

	@Override
	/**
	 * view match summary
	 * 
	 */
	public List<MatchData> showMatchDetails(String status) throws DBexception {
		String sql = "select cap_no,match_type,runs,status from match_data where status=?";
		List<MatchData> summary = new ArrayList<>();
		try (Connection ci = connectionUtil.getConnection(); PreparedStatement pst = ci.prepareStatement(sql);) {
			pst.setString(1, status);
			try (ResultSet rs = pst.executeQuery();) {
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

	/**
	 * Get Non-Updated Data
	 * 
	 */
	private List<MatchData> showNotUpdateData(String status) throws DBexception {
		String sql = "select cap_no,match_type,runs from match_data where status=?";
		List<MatchData> summary = new ArrayList<>();
		try (Connection ci = connectionUtil.getConnection(); PreparedStatement pst = ci.prepareStatement(sql);) {
			pst.setString(1, status);
			try (ResultSet rs = pst.executeQuery();) {
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
