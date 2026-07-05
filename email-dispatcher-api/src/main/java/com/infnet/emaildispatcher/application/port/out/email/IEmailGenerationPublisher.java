package com.infnet.emaildispatcher.application.port.out.email;

import com.infnet.emaildispatcher.application.domain.model.email.EmailGeneration;

public interface IEmailGenerationPublisher {
    void publish(EmailGeneration emailGeneration);
}
