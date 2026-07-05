package com.infnet.emaildispatcher.adapter.out.crm.ploomes;

import com.infnet.emaildispatcher.application.domain.model.crm.Deal;
import com.infnet.emaildispatcher.application.port.out.crm.ICrmProvider;

import java.util.List;

public class PloomesCrmProvider implements ICrmProvider {

    @Override
    public List<Deal> getAllDeals() {
        return List.of();
    }

    @Override
    public Deal getDealById(Integer dealId) {
        return null;
    }
}
