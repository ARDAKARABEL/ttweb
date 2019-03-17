package com.ardakarabel.ttweb.model;

import com.ardakarabel.ttweb.config.TrackRecordConstants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class TrackRecordBase {
    // form:input - start
    private String start;
    // form:input - end
    private String end;
    // form:input - email
    private String email;

    public TrackRecordBase(TrackRecord trackRecord){
        DateFormat df = new SimpleDateFormat(TrackRecordConstants.PATTERN);
        df.setTimeZone( TimeZone.getTimeZone( "UTC" ) );
        this.setEmail(trackRecord.getEmail());
        this.setStart(df.format(trackRecord.getStart()));
        this.setEnd(df.format(trackRecord.getEnd()));
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
