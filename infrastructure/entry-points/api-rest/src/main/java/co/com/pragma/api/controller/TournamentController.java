package co.com.pragma.api.controller;
import co.com.pragma.api.dto.*;
import co.com.pragma.api.mapper.TournamentDtoMapper;
import co.com.pragma.api.mapper.ViewDtoMapper;
import co.com.pragma.usecase.tournament.TournamentUseCase;
import co.com.pragma.usecase.tournament.ViewUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/tournament", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Tag(name = "Torneo", description = "Creacion de torneo y vistas")
public class TournamentController {
    private final TournamentUseCase tournamentUseCase;
    private final ViewUseCase viewUseCase;

    @Operation(summary = "Permite crear torneos gratuitos y pagos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Respuesta exitosa", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = TournamentResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseErrorDto.class))}),
            @ApiResponse(responseCode = "409", description = "Se presentan conflictos con los datos de la solicitud", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseErrorDto.class))})
    })
    @PostMapping
    public TournamentResponseDto save(@RequestBody @Valid TournamentRequestDto tournamentDto) {
      return TournamentDtoMapper.tournamentToTounamentDto(tournamentUseCase.save(TournamentDtoMapper.tournamentDtoToTournament(tournamentDto)));
    }
    @Operation(summary = "Permite crear vistas gratuitas y pagas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Respuesta exitosa", content = {@Content(mediaType = "appliction/json", schema = @Schema(implementation = ViewResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseErrorDto.class))}),
            @ApiResponse(responseCode = "409", description = "Se presentan conflictos con los datos de la solicitud", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ResponseErrorDto.class))})
    })
    @PostMapping("/view")
    public ViewResponseDto save(@RequestBody @Valid ViewRequestDto viewResponseDto) {
        return ViewDtoMapper.viewToViewDto(viewUseCase.save(ViewDtoMapper.viewDtoToView(viewResponseDto)));
    }

}
