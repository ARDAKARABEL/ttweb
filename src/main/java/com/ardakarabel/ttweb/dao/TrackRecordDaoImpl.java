package com.ardakarabel.ttweb.dao;

import com.ardakarabel.ttweb.model.TrackRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TrackRecordDaoImpl implements TrackRecordDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public TrackRecord getById(Integer id) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		String sql = "SELECT * FROM records WHERE id=:id";

		TrackRecord result = null;
		try {
			result = namedParameterJdbcTemplate.queryForObject(sql, params, new TrackRecordMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

		return result;

	}

	@Override
	public List<TrackRecord> getByEmail(String email) {

		String sql = "SELECT * FROM records where email=:email";
		List<TrackRecord> result = namedParameterJdbcTemplate.query(sql, new TrackRecordMapper());

		return result;

	}

	@Override
	public List<TrackRecord> getAll() {

		String sql = "SELECT * FROM records ORDER BY TIMESTAMP DESC";
		List<TrackRecord> result = namedParameterJdbcTemplate.query(sql, new TrackRecordMapper());

		return result;

	}

	@Override
	public void add(TrackRecord trackRecord) {

		String sql = "REPLACE INTO records(EMAIL, START, END) "
				+ "VALUES ( :email, :start, :end)";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(trackRecord));

	}

	@Override
	public void update(TrackRecord trackRecord) {

		String sql = "REPLACE INTO records (START, END, EMAIL) VALUES( :start, :end, :email )";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(trackRecord));

	}

	@Override
	public void delete(Integer id) {

		String sql = "DELETE FROM records WHERE id= :id";
		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id", id));

	}

	@Override
	public void deleteByEmail(String email) {

		String sql = "DELETE FROM records WHERE email= :email";
		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("email", email));

	}

	private SqlParameterSource getSqlParameterByModel(TrackRecord trackRecord) {

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("email", trackRecord.getEmail());
		paramSource.addValue("start", trackRecord.getStart());
		paramSource.addValue("end", trackRecord.getEnd());
		paramSource.addValue("timestamp", trackRecord.getTimestamp());

		return paramSource;
	}

	private static final class TrackRecordMapper implements RowMapper<TrackRecord> {

		public TrackRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
			TrackRecord trackRecord = new TrackRecord();
			trackRecord.setEmail(rs.getString("email"));
			trackRecord.setStart(rs.getTimestamp("start"));
			trackRecord.setEnd(rs.getTimestamp("end"));
			trackRecord.setTimestamp(rs.getTimestamp("timestamp"));
			return trackRecord;
		}
	}

}