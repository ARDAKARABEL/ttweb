package com.ardakarabel.ttweb.service;

import com.ardakarabel.ttweb.model.TrackRecord;

import java.util.List;

public interface TrackRecordDBService{

    List<TrackRecord> getByEmail(String email);
    List<TrackRecord> getAll();
    TrackRecord getById(Integer id);
    void delete(Integer id);
    void deleteByEmail(String email);
    void addOrUpdate(TrackRecord trackRecord);

}
