package com.infnet.emaildispatcher.application.port.in.email;

import com.infnet.emaildispatcher.application.domain.model.email.Email;
import com.infnet.emaildispatcher.application.domain.model.email.EmailGeneration;

public interface IEmailUseCase {
    void requestEmailGeneration(EmailGeneration emailGeneration);
    void sendEmail(Email email);
}
