package com.infnet.emaildispatcher.adapter.in.crm;

import com.infnet.emaildispatcher.adapter.in.crm.dto.GetAllResponse;
import com.infnet.emaildispatcher.adapter.in.crm.dto.GetByIdResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Tag(name = "CRM", description = "Endpoints para recuperar informações cadastradas no CRM e disparar emails")
public interface SwaggerCrmController {

    @Operation(
            summary = "Busca todas as negociações",
            description = "Retorna todas as informaçẽos de negociações cadastradas no CRM"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Informações retornadas com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    @GetMapping("/deals")
    ResponseEntity<GetAllResponse> getAllDeals();


    @Operation(
            summary = "Busca a negociação por ID",
            description = "Retorna as informaçẽos da negociação cadastrada no CRM"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Informação retornada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content)
    })
    @GetMapping("/deals/{id}")
    ResponseEntity<GetByIdResponse> getDealById(@PathVariable Integer dealId);
}
