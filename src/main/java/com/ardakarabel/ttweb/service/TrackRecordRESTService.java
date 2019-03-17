package com.ardakarabel.ttweb.service;

import com.ardakarabel.ttweb.model.TrackRecord;

import java.util.List;

public interface TrackRecordRESTService {

    List<TrackRecord> getByEmail(String email);
    List<TrackRecord> getAll();
    boolean add(TrackRecord trackRecord);

}
