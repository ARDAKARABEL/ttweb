package com.ardakarabel.ttweb.service;

import com.ardakarabel.ttweb.dao.TrackRecordDao;
import com.ardakarabel.ttweb.model.TrackRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("recordDBService")
public class TrackRecordDBServiceImpl implements TrackRecordDBService {

    TrackRecordDao trackRecordDao;

    @Autowired
    public void setRecordDao(TrackRecordDao trackRecordDao) {
        this.trackRecordDao = trackRecordDao;
    }

    @Override
    public List<TrackRecord> getByEmail(String email) { return trackRecordDao.getByEmail(email); }

    @Override
    public List<TrackRecord> getAll() {
        return trackRecordDao.getAll();
    }

    @Override
    public TrackRecord getById(Integer id) {
        return trackRecordDao.getById(id);
    }

    @Override
    public void addOrUpdate(TrackRecord trackRecord) {

        if (getById(trackRecord.getId())==null) {
            trackRecordDao.add(trackRecord);
        } else {
            trackRecordDao.update(trackRecord);
        }
    }

    @Override
    public void delete(Integer id) {
        trackRecordDao.delete(id);
    }

    @Override
    public void deleteByEmail(String email) {
        trackRecordDao.deleteByEmail(email);
    }

}
