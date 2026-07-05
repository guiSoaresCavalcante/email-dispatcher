package com.infnet.emaildispatcher.application.port.in.crm;

import com.infnet.emaildispatcher.application.domain.model.crm.Deal;

import java.util.List;

public interface ICrmUseCase {
    List<Deal> getAllDeals();
    Deal getDealById(Integer dealId);
}
