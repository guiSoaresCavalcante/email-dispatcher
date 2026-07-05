package com.infnet.emaildispatcher.adapter.out.http.crm.ploomes.dto.mapper;

import com.infnet.emaildispatcher.adapter.out.http.crm.ploomes.dto.GetContactResponse;
import com.infnet.emaildispatcher.adapter.out.http.crm.ploomes.dto.GetDealsResponse;
import com.infnet.emaildispatcher.application.domain.model.crm.Contact;
import com.infnet.emaildispatcher.application.domain.model.crm.Deal;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PloomesMapper {

    public List<Deal> getDealsToDomain(GetDealsResponse response) {
        return response.value().stream()
                .map(dealData -> new Deal(
                        dealData.id(),
                        dealData.title(),
                        null,
                        dealData.createDate()
                ))
                .toList();
    }

    public Deal getDealWithContactToDomain(GetDealsResponse.DealData dealData, GetContactResponse.ContactData contactData) {
        Contact contact = new Contact(
                contactData.id(),
                contactData.name(),
                contactData.legalName(),
                contactData.note(),
                contactData.email()
        );
        return new Deal(
                dealData.id(),
                dealData.title(),
                contact,
                dealData.createDate()
        );
    }
}
