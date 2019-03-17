package com.ardakarabel.ttweb.validator;

import com.ardakarabel.ttweb.model.TrackRecordEmail;
import com.ardakarabel.ttweb.service.TrackRecordDBService;
import com.ardakarabel.ttweb.service.TrackRecordRESTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class RecordSearchFormValidator implements Validator {

    @Autowired
    @Qualifier("emailValidatorX")
    EmailValidator emailValidator;

    @Autowired
    TrackRecordRESTService trackRecordRESTService;

    @Autowired
    TrackRecordDBService trackRecordDBService;

    @Override
    public boolean supports(Class<?> clazz) {
        return TrackRecordEmail.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        TrackRecordEmail trackRecord = (TrackRecordEmail) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.recordForm.email");

        if(!emailValidator.valid(trackRecord.getEmail())){
            errors.rejectValue("email", "Pattern.recordForm.email");
        }

    }

}