package com.infnet.emaildispatcher.application.usecase;

import com.infnet.emaildispatcher.application.domain.model.email.Email;
import com.infnet.emaildispatcher.application.domain.model.email.EmailGeneration;
import com.infnet.emaildispatcher.application.port.in.email.IEmailUseCase;
import com.infnet.emaildispatcher.application.port.out.email.IEmailGenerationPublisher;
import com.infnet.emaildispatcher.application.port.out.email.IEmailSender;

public class EmailUseCase implements IEmailUseCase {

    private final IEmailGenerationPublisher emailGenerationPublisher;
    private final IEmailSender emailSender;

    public EmailUseCase(IEmailGenerationPublisher emailGenerationPublisher, IEmailSender emailSender) {
        this.emailGenerationPublisher = emailGenerationPublisher;
        this.emailSender = emailSender;
    }

    @Override
    public void requestEmailGeneration(EmailGeneration emailGeneration) {
        emailGenerationPublisher.publish(emailGeneration);
    }

    @Override
    public void sendEmail(Email email) {
        emailSender.send(email);
    }
}
