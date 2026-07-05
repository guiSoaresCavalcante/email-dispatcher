package com.infnet.emaildispatcher.adapter.in.crm.dto;

import com.infnet.emaildispatcher.application.domain.model.crm.Deal;

import java.util.List;

public record GetAllDealsResponse(
        List<Deal> value
) {
}
