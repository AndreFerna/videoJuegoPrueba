package co.com.pragma.api.controller;

import co.com.pragma.api.dto.*;
import co.com.pragma.api.mapper.TournamentSaleDtoMapper;
import co.com.pragma.api.mapper.ViewSaleDtoMapper;
import co.com.pragma.usecase.tournament.TournamentSaleUseCase;
import co.com.pragma.usecase.tournament.ViewSaleUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "api/sale", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Tag(name = "Venta", description = "Creacion de ventas para el torneo y las vistas")
public class SaleController {

    private final TournamentSaleUseCase tournamentSaleUseCase;
    private final ViewSaleUseCase viewSaleUseCase;
    @Operation(summary = "Permite generar una venta de torneo para los participantes")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Respuesta exitosa", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = TournamentSaleResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseErrorDto.class))}),
            @ApiResponse(responseCode = "409", description = "Se representa conflictos con los datos de la solicitud", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseErrorDto.class))})
    })
    @PostMapping("/tournament")
    public TournamentSaleResponseDto save(@RequestBody @Valid TournamentSaleRequestDto tournamentSaleResponseDto){
        return TournamentSaleDtoMapper.tournamentSaleToTournamentSaleDto(tournamentSaleUseCase.save(TournamentSaleDtoMapper.tournamentSaleDtoToTournamentSale(tournamentSaleResponseDto)));
    }

    @Operation(summary = "Permite generar una venta de vista para los visitantes")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Respuesta exitosa", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ViewSaleResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseErrorDto.class))}),
            @ApiResponse(responseCode = "409", description = "Se representa conflictos con los datos de la solicitud", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseErrorDto.class))})
    })
    @PostMapping("/view")
    public ViewSaleResponseDto save(@RequestBody @Valid ViewSaleRequestDto viewSaleResponseDto){
        return ViewSaleDtoMapper.viewSaleToViewSaleDto(viewSaleUseCase.save(ViewSaleDtoMapper.viewSaleDtoToViewSale(viewSaleResponseDto)));
    }


}
