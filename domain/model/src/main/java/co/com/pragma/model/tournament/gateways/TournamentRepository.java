package co.com.pragma.model.tournament.gateways;

import co.com.pragma.model.tournament.Tournament;

public interface TournamentRepository {

    public Tournament saveTournament(Tournament tournament, Long categoryId, Long gameTypeId);


}
