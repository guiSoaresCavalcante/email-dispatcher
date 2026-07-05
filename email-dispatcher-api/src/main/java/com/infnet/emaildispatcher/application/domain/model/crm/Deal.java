package com.infnet.emaildispatcher.application.domain.model.crm;

import java.util.Date;

public record Deal(
        Integer id,
        String title,
        Contact contact,
        Date createDate

) {
}
