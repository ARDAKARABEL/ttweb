package com.ardakarabel.ttweb.validator;

import com.ardakarabel.ttweb.config.TrackRecordConstants;
import com.ardakarabel.ttweb.model.TrackRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Component
public class RecordFormValidator implements Validator {

    @Autowired
    @Qualifier("emailValidatorX")
    EmailValidator emailValidator;

    @Autowired
    @Qualifier("dateValidator")
    DateValidator dateValidator;
    DateFormat df = new SimpleDateFormat(TrackRecordConstants.PATTERN);

    @Override
    public boolean supports(Class<?> clazz) {
        return TrackRecord.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        TrackRecord trackRecord = (TrackRecord) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.recordForm.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "start", "NotEmpty.recordForm.start");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "end", "NotEmpty.recordForm.end");

        if (!emailValidator.valid(trackRecord.getEmail())) {
            errors.rejectValue("email", "Pattern.recordForm.email");
        }

        if (trackRecord.getStart() != null && !dateValidator.valid(df.format(trackRecord.getStart()))) {
            errors.rejectValue("start", "Pattern.recordForm.date");
        }

        if (trackRecord.getEnd() != null && !dateValidator.valid(df.format(trackRecord.getEnd()))) {
            errors.rejectValue("end", "Pattern.recordForm.date");
        }

        if (trackRecord.getStart() != null && (trackRecord.getEnd() != null)) {
            if (dateValidator.validDiff(df.format(trackRecord.getStart()), df.format(trackRecord.getEnd()))) {
                errors.rejectValue("end", "Logic.recordForm.diff");
            }
        }
    }

}