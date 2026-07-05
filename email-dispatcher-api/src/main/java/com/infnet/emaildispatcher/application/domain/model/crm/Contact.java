package com.infnet.emaildispatcher.application.domain.model.crm;

public record Contact(
        Integer id,
        String name,
        String legalName,
        String infoNotes,
        String email
) {
}
