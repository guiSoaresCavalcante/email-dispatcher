package com.infnet.emaildispatcher.adapter.in.crm;

import com.infnet.emaildispatcher.adapter.in.crm.dto.GetAllResponse;
import com.infnet.emaildispatcher.adapter.in.crm.dto.GetByIdResponse;
import com.infnet.emaildispatcher.adapter.in.crm.dto.mapper.CrmMapper;
import com.infnet.emaildispatcher.application.port.in.crm.ICrmUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v1/crm")
public class CrmController implements SwaggerCrmController {

    private final ICrmUseCase useCase;
    private final CrmMapper mapper;

    public CrmController(ICrmUseCase useCase, CrmMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<GetAllResponse> getAllDeals() {
        var deals = useCase.getAllDeals();
        return null;
    }

    @Override
    public ResponseEntity<GetByIdResponse> getDealById(Integer dealId) {
        var deal = useCase.getDealById(dealId);
        return null;
    }
}
