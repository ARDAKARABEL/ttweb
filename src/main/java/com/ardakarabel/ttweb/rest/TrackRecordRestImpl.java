package com.ardakarabel.ttweb.rest;

import com.ardakarabel.ttweb.config.TrackRecordConstants;
import com.ardakarabel.ttweb.model.TrackRecord;
import com.ardakarabel.ttweb.model.TrackRecordBase;
import com.ardakarabel.ttweb.service.TrackRecordDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Repository
public class TrackRecordRestImpl implements TrackRecordRest {

    private Client client = ClientBuilder.newClient();
    private String email;
    private TrackRecordDBService trackRecordDBService;

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public boolean supports(Class<?> clazz) {
        return TrackRecord.class.equals(clazz);
    }

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Autowired
    public void setTrackRecordDBService(TrackRecordDBService trackRecordDBService) {
        this.trackRecordDBService = trackRecordDBService;
    }

    @Override
    public List<TrackRecord> getByEmail(String email) {

        WebTarget recordsWebTarget = client.target(TrackRecordConstants.REST_URI).path(TrackRecordConstants.REST_RECORDS).queryParam("email", email);
        this.email = email;
        return getTrackRecords(recordsWebTarget);
    }

    @Override
    public boolean add(TrackRecord trackRecord) {
        WebTarget addWebTarget = client.target(TrackRecordConstants.REST_URI).path(TrackRecordConstants.REST_RECORDS);
        TrackRecordBase trackRecordBase = new TrackRecordBase(trackRecord);
        MultivaluedMap<String, String> formData = new MultivaluedHashMap<>();
        formData.add("email", trackRecordBase.getEmail());
        formData.add("start", trackRecordBase.getStart());
        formData.add("end", trackRecordBase.getEnd());
        Response response = addWebTarget.request().post(Entity.form(formData));
        return (response.getStatus() == 200) ? true : false;
    }

    @Override
    public List<TrackRecord> getAll() {

        WebTarget recordsWebTarget = client.target(TrackRecordConstants.REST_URI).path(TrackRecordConstants.REST_RECORDS);
        return getTrackRecords(recordsWebTarget);

    }

    private List<TrackRecord> getTrackRecords(WebTarget recordsWebTarget) {
        Invocation.Builder invocationBuilder = recordsWebTarget.request(MediaType.APPLICATION_JSON);
        try {
            Response response = invocationBuilder.get();
            if (response.getStatus() == 200) {
                TrackRecord[] trackRecords = response.readEntity(TrackRecord[].class);
                List<TrackRecord> trackRecordList = Arrays.asList(trackRecords);
                if (trackRecordList.get(0) != null) {
                    trackRecordDBService.deleteByEmail(email);
                    for (TrackRecord trackRecord : trackRecordList) {
                        trackRecordDBService.addOrUpdate(trackRecord);
                    }
                } else {
                    if (email != null) {
                        trackRecordDBService.deleteByEmail(email);
                    }
                }
                return trackRecordList;
            }
        } catch (Exception e) {
            return null;
        }

        return null;
    }

}
