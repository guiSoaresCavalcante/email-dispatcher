package com.infnet.emaildispatcher.application.port.out.crm;

import com.infnet.emaildispatcher.application.domain.model.crm.Deal;

import java.util.List;

public interface ICrmProvider {
    List<Deal> getAllDeals();
    Deal getDealById(Integer dealId);
}
