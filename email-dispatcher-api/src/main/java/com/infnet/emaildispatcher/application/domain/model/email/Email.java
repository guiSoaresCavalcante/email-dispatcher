package com.infnet.emaildispatcher.application.domain.model.email;

public record Email(
        String toEmail,
        String subject,
        String body
) {
}
