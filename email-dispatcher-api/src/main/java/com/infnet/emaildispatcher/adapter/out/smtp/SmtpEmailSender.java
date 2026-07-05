package com.infnet.emaildispatcher.adapter.out.smtp;

import com.infnet.emaildispatcher.application.domain.model.email.Email;
import com.infnet.emaildispatcher.application.port.out.email.IEmailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SmtpEmailSender implements IEmailSender {

    private final JavaMailSender mailSender;

    public SmtpEmailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void send(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email.toEmail());
        message.setSubject(email.subject());
        message.setText(email.body());
        mailSender.send(message);
    }
}
