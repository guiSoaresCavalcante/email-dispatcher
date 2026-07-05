package com.infnet.emaildispatcher.adapter.out.http.crm.ploomes;

import com.infnet.emaildispatcher.adapter.out.http.crm.ploomes.dto.mapper.PloomesMapper;
import com.infnet.emaildispatcher.application.domain.model.crm.Deal;
import com.infnet.emaildispatcher.application.port.out.crm.ICrmProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PloomesCrmProvider implements ICrmProvider {

    @Value("${crm.ploomes.token}")
    private String token;

    private final IPloomesFeignClient client;
    private final PloomesMapper mapper;

    public PloomesCrmProvider(IPloomesFeignClient client, PloomesMapper mapper) {
        this.client = client;
        this.mapper = mapper;
    }

    @Override
    public List<Deal> getAllDeals() {
        var response = client.getDeals(token);
        return mapper.getDealsToDomain(response);
    }

    @Override
    public Deal getDealById(Integer dealId) {
        String dealFilter = "Id eq " + dealId;
        var dealResponse = client.getDealById(token, dealFilter);
        var dealData = dealResponse.value().getFirst();

        String contactFilter = "Id eq " + dealData.contactId();
        var contactResponse = client.getContactById(token, contactFilter);

        return mapper.getDealWithContactToDomain(dealData, contactResponse.value().getFirst());
    }
}
