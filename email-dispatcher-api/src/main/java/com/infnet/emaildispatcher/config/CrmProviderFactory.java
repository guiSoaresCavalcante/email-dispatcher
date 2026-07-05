package com.infnet.emaildispatcher.config;

import com.infnet.emaildispatcher.adapter.out.crm.ploomes.PloomesCrmProvider;
import com.infnet.emaildispatcher.application.port.out.crm.CrmProviderType;
import com.infnet.emaildispatcher.application.port.out.crm.ICrmProvider;
import com.infnet.emaildispatcher.application.port.out.crm.ICrmProviderFactory;
import org.springframework.stereotype.Component;

@Component
public class CrmProviderFactory implements ICrmProviderFactory {
    @Override
    public ICrmProvider create(CrmProviderType type) {
        return switch (type) {
            case PLOOMES -> new PloomesCrmProvider();
            default -> throw new UnsupportedOperationException("Crm Provider not implemented yet");
        };
    }
}
