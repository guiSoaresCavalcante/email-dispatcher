package com.infnet.emaildispatcher.application.port.out.crm;

public interface ICrmProviderFactory {
    ICrmProvider create(CrmProviderType type);
}
