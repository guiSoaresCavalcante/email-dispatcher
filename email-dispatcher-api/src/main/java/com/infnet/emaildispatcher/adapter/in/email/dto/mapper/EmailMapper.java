package com.infnet.emaildispatcher.adapter.in.email.dto.mapper;

import com.infnet.emaildispatcher.adapter.in.email.dto.DispatchEmailRequest;
import com.infnet.emaildispatcher.adapter.in.email.dto.SendEmailRequest;
import com.infnet.emaildispatcher.application.domain.model.email.Email;
import com.infnet.emaildispatcher.application.domain.model.email.EmailGeneration;
import org.springframework.stereotype.Component;

@Component
public class EmailMapper {
    public EmailGeneration dispatchEmailRequestToDomain(DispatchEmailRequest request) {
        return new EmailGeneration(
            request.email(),
            request.title(),
            request.contactName(),
            request.note(),
            request.additionalInfo()
        );
    }

    public Email sendEmailRequestToDomain(SendEmailRequest request) {
        return new Email(request.toEmail(), request.subject(), request.body());
    }
}
