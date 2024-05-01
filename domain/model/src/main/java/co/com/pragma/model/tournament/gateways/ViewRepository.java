package co.com.pragma.model.tournament.gateways;

import co.com.pragma.model.tournament.View;

public interface ViewRepository {

    View saveView(View view);
    int countFreeViewsPerTournament(Long tournamentId);
    boolean existById(Long id);
    View findByIdView(Long id);

}
