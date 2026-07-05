package com.infnet.emaildispatcher.adapter.in.crm;

import com.infnet.emaildispatcher.adapter.in.crm.dto.GetAllResponse;
import com.infnet.emaildispatcher.adapter.in.crm.dto.GetByIdResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v1/crm")
public class CrmController implements SwaggerCrmController {

    @Override
    public ResponseEntity<GetAllResponse> getAllDeals() {
        return null;
    }

    @Override
    public ResponseEntity<GetByIdResponse> getDealById(Integer dealId) {
        return null;
    }
}
