package com.infnet.emaildispatcher.adapter.in.email.dto;

public record SendEmailRequest(
        String toEmail,
        String subject,
        String body
) {
}
