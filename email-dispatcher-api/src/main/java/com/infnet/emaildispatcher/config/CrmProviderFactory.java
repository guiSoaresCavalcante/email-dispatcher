package com.infnet.emaildispatcher.config;

import com.infnet.emaildispatcher.adapter.out.http.crm.ploomes.PloomesCrmProvider;
import com.infnet.emaildispatcher.application.port.out.crm.CrmProviderType;
import com.infnet.emaildispatcher.application.port.out.crm.ICrmProvider;
import com.infnet.emaildispatcher.application.port.out.crm.ICrmProviderFactory;
import org.springframework.stereotype.Component;

@Component
public class CrmProviderFactory implements ICrmProviderFactory {

    private final PloomesCrmProvider ploomesCrmProvider;

    public CrmProviderFactory(PloomesCrmProvider ploomesCrmProvider) {
        this.ploomesCrmProvider = ploomesCrmProvider;
    }

    @Override
    public ICrmProvider create(CrmProviderType type) {
        return switch (type) {
            case PLOOMES -> ploomesCrmProvider;
            default -> throw new UnsupportedOperationException("Crm Provider not implemented yet");
        };
    }
}
