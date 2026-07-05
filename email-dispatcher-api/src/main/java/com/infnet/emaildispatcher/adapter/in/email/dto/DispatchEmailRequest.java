package com.infnet.emaildispatcher.adapter.in.email.dto;


public record DispatchEmailRequest(
        String email,
        String title,
        String contactName,
        String note,
        String additionalInfo

) {
}
