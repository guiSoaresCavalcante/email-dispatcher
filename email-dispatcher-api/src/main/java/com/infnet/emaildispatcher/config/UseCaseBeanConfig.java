package com.infnet.emaildispatcher.config;

import com.infnet.emaildispatcher.application.port.in.crm.ICrmUseCase;
import com.infnet.emaildispatcher.application.port.in.email.IEmailUseCase;
import com.infnet.emaildispatcher.application.port.out.crm.CrmProviderType;
import com.infnet.emaildispatcher.application.port.out.crm.ICrmProviderFactory;
import com.infnet.emaildispatcher.application.port.out.email.IEmailGenerationPublisher;
import com.infnet.emaildispatcher.application.usecase.CrmUseCase;
import com.infnet.emaildispatcher.application.usecase.EmailUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfig {

    @Bean
    public ICrmUseCase crmUseCase(ICrmProviderFactory crmProviderFactory) {
        return new CrmUseCase(crmProviderFactory, CrmProviderType.PLOOMES);
    }

    @Bean
    public IEmailUseCase emailUseCase(IEmailGenerationPublisher emailGenerationPublisher) {
        return new EmailUseCase(emailGenerationPublisher);
    }
}
