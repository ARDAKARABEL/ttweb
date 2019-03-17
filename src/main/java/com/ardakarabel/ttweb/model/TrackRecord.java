package com.ardakarabel.ttweb.model;

import com.ardakarabel.ttweb.config.TrackRecordConstants;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

public class TrackRecord {

    // form:input - start
    @DateTimeFormat(pattern = TrackRecordConstants.PATTERN)
    Date start;
    // form:input - end
    @DateTimeFormat(pattern = TrackRecordConstants.PATTERN)
    Date end;
    // form:input - email
    String email;
    // form:hidden - id
    Integer id = null;
    // timestamp
    private Timestamp timestamp;

    public String getEmail() { return email; }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getStart() { return start; }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {return end; }

    public void setEnd(Date end) {
        this.end = end;
    }

    public boolean isNew() { return (this.getId() == null); }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

}
