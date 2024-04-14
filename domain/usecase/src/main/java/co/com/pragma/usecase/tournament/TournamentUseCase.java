package co.com.pragma.usecase.tournament;

import co.com.pragma.model.tournament.Tournament;
import co.com.pragma.model.tournament.gateways.TournamentRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class TournamentUseCase {
    private final TournamentRepository tournamentRepository;

    public Tournament save(Tournament tournament){
        Tournament tournament1 = tournamentRepository.saveTournament(tournament);
        System.out.println("************** "+tournament1);
        return tournament1;
    }

}
