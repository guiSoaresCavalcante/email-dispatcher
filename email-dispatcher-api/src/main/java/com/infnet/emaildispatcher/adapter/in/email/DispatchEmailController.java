package com.infnet.emaildispatcher.adapter.in.email;

import com.infnet.emaildispatcher.adapter.in.email.dto.DispatchEmailRequest;
import com.infnet.emaildispatcher.adapter.in.email.dto.SendEmailRequest;
import com.infnet.emaildispatcher.adapter.in.email.dto.mapper.EmailMapper;
import com.infnet.emaildispatcher.application.port.in.email.IEmailUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/dispatch-email")
public class DispatchEmailController implements SwaggerDispatchEmailController {

    private final IEmailUseCase useCase;
    private final EmailMapper mapper;

    public DispatchEmailController(IEmailUseCase useCase, EmailMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<Void> dispatchEmail(DispatchEmailRequest request) {
        useCase.requestEmailGeneration(mapper.dispatchEmailRequestToDomain(request));
        return ResponseEntity.accepted().build();
    }

    @Override
    public ResponseEntity<Void> sendEmail(SendEmailRequest request) {
        useCase.sendEmail(mapper.sendEmailRequestToDomain(request));
        return ResponseEntity.ok().build();
    }
}
