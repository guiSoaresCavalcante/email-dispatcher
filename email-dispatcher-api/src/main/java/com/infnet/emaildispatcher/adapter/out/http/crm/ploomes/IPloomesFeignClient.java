package com.infnet.emaildispatcher.adapter.out.http.crm.ploomes;

import com.infnet.emaildispatcher.adapter.out.http.crm.ploomes.dto.GetContactResponse;
import com.infnet.emaildispatcher.adapter.out.http.crm.ploomes.dto.GetDealsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "${crm.ploomes.name}",
        url = "${crm.ploomes.url}"
)
public interface IPloomesFeignClient {

    @GetMapping("/Deals")
    GetDealsResponse getDeals(@RequestHeader("User-Key") String userKey);

    @GetMapping("/Deals")
    GetDealsResponse getDealById(@RequestHeader("User-Key") String userKey,
                                 @RequestParam("$filter") String filter);

    @GetMapping("/Contacts")
    GetContactResponse getContactById(@RequestHeader("User-Key") String userKey,
                                      @RequestParam("$filter") String filter);
}
