package co.com.pragma.api.controller;
import co.com.pragma.api.dto.TournamentDto;
import co.com.pragma.api.mapper.TournamentDtoMapper;
import co.com.pragma.model.tournament.Tournament;
import co.com.pragma.usecase.tournament.TournamentUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/tournament", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class TournamentController {
    private final TournamentUseCase tournamentUseCase;


    @PostMapping
    public TournamentDto save(@RequestBody TournamentDto tournamentDto) {
      return TournamentDtoMapper.tournamentToTounamentDto(tournamentUseCase.save(TournamentDtoMapper.tournamentDtoToTournament(tournamentDto)));
    }
}
