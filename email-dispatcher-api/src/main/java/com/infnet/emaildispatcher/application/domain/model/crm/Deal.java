package com.infnet.emaildispatcher.application.domain.model.crm;


public record Deal(
        Integer id,
        String title,
        Contact contact,
        String createDate

) {
}
