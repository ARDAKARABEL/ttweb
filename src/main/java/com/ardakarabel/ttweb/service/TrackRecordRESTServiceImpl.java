package com.ardakarabel.ttweb.service;

import com.ardakarabel.ttweb.model.TrackRecord;
import com.ardakarabel.ttweb.rest.TrackRecordRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service("recordRESTService")
public class TrackRecordRESTServiceImpl implements TrackRecordRESTService {

    TrackRecordRest trackRecordRest;

    @Autowired
    public void setRecordRest(TrackRecordRest trackRecordRest) {
        this.trackRecordRest = trackRecordRest;
    }

    @Override
    public List<TrackRecord> getByEmail(String email) { return trackRecordRest.getByEmail(email); }

    @Override
    public List<TrackRecord> getAll() {
        return trackRecordRest.getAll();
    }

    @Override
    public boolean add(TrackRecord trackRecord) {
        return trackRecordRest.add(trackRecord);
    }

}
