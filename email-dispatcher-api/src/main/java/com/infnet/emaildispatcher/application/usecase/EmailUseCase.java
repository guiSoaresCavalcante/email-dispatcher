package com.infnet.emaildispatcher.application.usecase;

import com.infnet.emaildispatcher.application.domain.model.email.Email;
import com.infnet.emaildispatcher.application.domain.model.email.EmailGeneration;
import com.infnet.emaildispatcher.application.port.in.email.IEmailUseCase;
import com.infnet.emaildispatcher.application.port.out.email.IEmailGenerationPublisher;

public class EmailUseCase implements IEmailUseCase {

    private final IEmailGenerationPublisher emailGenerationPublisher;

    public EmailUseCase(IEmailGenerationPublisher emailGenerationPublisher) {
        this.emailGenerationPublisher = emailGenerationPublisher;
    }

    @Override
    public void requestEmailGeneration(EmailGeneration emailGeneration) {
        emailGenerationPublisher.publish(emailGeneration);
    }

    @Override
    public void sendEmail(Email email) {

    }
}
