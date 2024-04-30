package co.com.pragma.api.controller;

import co.com.pragma.api.dto.TournamentSaleDto;
import co.com.pragma.api.mapper.TournamentSaleDtoMapper;
import co.com.pragma.usecase.tournament.TournamentSaleUseCase;
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
public class TournamentSaleController {

    private final TournamentSaleUseCase tournamentSaleUseCase;

    @PostMapping("/tournament")
    public TournamentSaleDto save(@RequestBody @Valid TournamentSaleDto tournamentSaleDto){
        return TournamentSaleDtoMapper.tournamentSaleToTouernamentSaleDto(tournamentSaleUseCase.save(TournamentSaleDtoMapper.tournamentSaleDtoToTournamentSale(tournamentSaleDto)));
    }

}
