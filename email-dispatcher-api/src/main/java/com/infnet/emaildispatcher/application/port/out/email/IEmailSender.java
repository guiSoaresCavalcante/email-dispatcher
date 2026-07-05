package com.infnet.emaildispatcher.application.port.out.email;

import com.infnet.emaildispatcher.application.domain.model.email.Email;

public interface IEmailSender {
    void send(Email email);
}
