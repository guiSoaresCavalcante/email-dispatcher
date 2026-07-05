package com.infnet.emaildispatcher.adapter.in.email;

import com.infnet.emaildispatcher.adapter.in.email.dto.DispatchEmailRequest;
import com.infnet.emaildispatcher.adapter.in.email.dto.SendEmailRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "E-mail Dispatcher", description = "Endpoints para gerenciar o envio de e-mails")
public interface SwaggerDispatchEmailController {

    @Operation(
            summary = "Dispara o e-mail",
            description = "Inicia o processo de envio de e-mail. Busca informa no CRM e publica a ação na fila"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Processo iniciado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping("/")
    ResponseEntity<Void> dispatchEmail(@RequestBody DispatchEmailRequest request);


    @Operation(
            summary = "Envia o e-mail",
            description = "URL de callback que receberá a resposta do serviço responsável pela geração do e-mail"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "E-mail enviado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping("/send")
    ResponseEntity<Void> sendEmail(@RequestBody SendEmailRequest request);
}
