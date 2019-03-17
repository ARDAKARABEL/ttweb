package com.ardakarabel.ttweb.rest;

import com.ardakarabel.ttweb.model.TrackRecord;

import java.util.List;

public interface TrackRecordRest {

    List<TrackRecord> getByEmail(String email);
    List<TrackRecord> getAll();
    boolean add(TrackRecord trackRecord);

}
