package com.infnet.emaildispatcher.adapter.in.crm.dto;

import com.infnet.emaildispatcher.application.domain.model.crm.Deal;

public record GetByIdResponse(
        Deal value
) {
}
