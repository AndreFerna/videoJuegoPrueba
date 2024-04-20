package co.com.pragma.usecase.tournament;

import co.com.pragma.model.tournament.View;
import co.com.pragma.model.tournament.gateways.ViewRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class ViewUseCase {
    private final ViewRepository viewRepository;

    public View save(View view){
        view.setUrl("https://tournamentview.com/view/"+ UUID.randomUUID().toString());
        return viewRepository.saveView(view);
    }

}
