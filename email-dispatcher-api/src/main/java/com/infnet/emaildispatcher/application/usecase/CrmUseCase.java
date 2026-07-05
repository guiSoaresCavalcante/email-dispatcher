package com.infnet.emaildispatcher.application.usecase;

import com.infnet.emaildispatcher.application.domain.model.crm.Deal;
import com.infnet.emaildispatcher.application.port.in.crm.ICrmUseCase;
import com.infnet.emaildispatcher.application.port.out.crm.CrmProviderType;
import com.infnet.emaildispatcher.application.port.out.crm.ICrmProvider;
import com.infnet.emaildispatcher.application.port.out.crm.ICrmProviderFactory;

import java.util.List;

public class CrmUseCase implements ICrmUseCase {

    private final ICrmProviderFactory crmProviderFactory;
    private final CrmProviderType crmProviderType;

    public CrmUseCase(ICrmProviderFactory crmProviderFactory, CrmProviderType crmProviderType) {
        this.crmProviderFactory = crmProviderFactory;
        this.crmProviderType = crmProviderType;
    }

    @Override
    public List<Deal> getAllDeals() {
        ICrmProvider provider = crmProviderFactory.create(crmProviderType);
        return provider.getAllDeals();
    }

    @Override
    public Deal getDealById(Integer dealId) {
        ICrmProvider provider = crmProviderFactory.create(crmProviderType);
        return provider.getDealById(dealId);
    }
}
