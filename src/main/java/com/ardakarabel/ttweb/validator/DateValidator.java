package com.ardakarabel.ttweb.validator;

import com.ardakarabel.ttweb.config.TrackRecordConstants;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component("dateValidator")
public class DateValidator {

    public boolean valid(final String dateToCheck) {
        if(dateToCheck == null){
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(TrackRecordConstants.PATTERN);
        sdf.setLenient(false);

        try {
            Date date = sdf.parse(dateToCheck);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean validDiff(final String startDiffDate, final String endDiffDate) {

        if(startDiffDate == null || endDiffDate == null || !this.valid(startDiffDate) || !this.valid(endDiffDate)){
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(TrackRecordConstants.PATTERN);
        sdf.setLenient(false);

        try {
            Date startDate = sdf.parse(startDiffDate);
            Date endDate = sdf.parse(endDiffDate);

            return (startDate.before(endDate)) ? false:true;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }
}