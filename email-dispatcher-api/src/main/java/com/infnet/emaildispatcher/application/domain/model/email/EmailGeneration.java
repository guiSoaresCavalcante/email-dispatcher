package com.infnet.emaildispatcher.application.domain.model.email;

public record EmailGeneration(
        String email,
        String dealTitle,
        String contactName,
        String informationNote,
        String additionalInformation
) {
}
