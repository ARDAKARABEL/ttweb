package com.ardakarabel.ttweb.dao;

import com.ardakarabel.ttweb.model.TrackRecord;

import java.util.List;

public interface TrackRecordDao {

	List<TrackRecord> getByEmail(String email);
	TrackRecord getById(Integer id);
	List<TrackRecord> getAll();
	void add(TrackRecord trackRecord);
	void update(TrackRecord trackRecord);
	void delete(Integer id);
	void deleteByEmail(String email);

}