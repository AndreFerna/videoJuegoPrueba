package co.com.pragma.usecase.tournament;

import co.com.pragma.model.tournament.View;
import co.com.pragma.model.tournament.config.ErrorCode;
import co.com.pragma.model.tournament.config.PragmaException;
import co.com.pragma.model.tournament.gateways.ViewRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class ViewUseCase {
    private final ViewRepository viewRepository;

    public View save(View view){
        if(view.isFree()){
            if(viewRepository.countFreeViewsPerTournament(view.getIdTournament()) > 0){
                throw new PragmaException(ErrorCode.B409004);
            }
            view.setAforo(200L);
        }
        view.setUrl("https://tournamentview.com/view/"+ UUID.randomUUID().toString());
        return viewRepository.saveView(view);
    }

}
