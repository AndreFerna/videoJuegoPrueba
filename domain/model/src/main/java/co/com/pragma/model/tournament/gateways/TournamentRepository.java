package co.com.pragma.model.tournament.gateways;

import co.com.pragma.model.tournament.Tournament;

public interface TournamentRepository {

    Tournament saveTournament(Tournament tournament, Long categoryId);
    int countTournamentsOrganizer(String id);
    void deleteById(Long id);
    boolean existById(Long id);
    Tournament findByIdTournament(Long id);

}
