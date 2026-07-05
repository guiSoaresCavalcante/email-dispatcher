package com.infnet.emaildispatcher.adapter.in.email;

import com.infnet.emaildispatcher.adapter.in.email.dto.DispatchEmailRequest;
import com.infnet.emaildispatcher.adapter.in.email.dto.SendEmailRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/dispatch-email")
public class DispatchEmailController implements SwaggerDispatchEmailController {

    @Override
    public ResponseEntity<Void> dispatchEmail(DispatchEmailRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Void> sendEmail(SendEmailRequest request) {
        return null;
    }
}
