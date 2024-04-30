package co.com.pragma.usecase.tournament;

import co.com.pragma.model.tournament.View;
import co.com.pragma.model.tournament.config.ErrorCode;
import co.com.pragma.model.tournament.config.PragmaException;
import co.com.pragma.model.tournament.gateways.TournamentRepository;
import co.com.pragma.model.tournament.gateways.ViewRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class ViewUseCase {
    private final ViewRepository viewRepository;

    private final TournamentRepository tournamentRepository;

    public View save(View view){
        boolean existTournament = tournamentRepository.existById(view.getIdTournament());
        if (!existTournament) {
            throw new PragmaException(ErrorCode.B409006);
        }
        if(view.isFree()){
            if(viewRepository.countFreeViewsPerTournament(view.getIdTournament()) > 0){
                throw new PragmaException(ErrorCode.B409004);
            }
            view.setAforo(200L);
        }
        String uniqueCode = UUID.randomUUID().toString();
        view.setUrl("https://tournamentview.com/view/" + uniqueCode);
        view.setUniqueCode(uniqueCode);
        return viewRepository.saveView(view);
    }

}
