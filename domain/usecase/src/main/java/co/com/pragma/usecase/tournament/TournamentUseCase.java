package co.com.pragma.usecase.tournament;

import co.com.pragma.model.tournament.Category;
import co.com.pragma.model.tournament.GameType;
import co.com.pragma.model.tournament.Tournament;
import co.com.pragma.model.tournament.gateways.CategoryRepository;
import co.com.pragma.model.tournament.gateways.GameTypeRepository;
import co.com.pragma.model.tournament.gateways.TournamentRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class TournamentUseCase {
    private final TournamentRepository tournamentRepository;
    private final CategoryRepository categoryRepository;
    private final GameTypeRepository gameTypeRepository;

    public Tournament save(Tournament tournament){
        Category category = categoryRepository.findByAliasCategory(tournament.getCategory());
        GameType gameType = gameTypeRepository.findByNameGameType(tournament.getGameType());
        if(tournament.isFree()){
            tournament.setCapacity(500L);
        }
        Tournament tournamentSave = tournamentRepository.saveTournament(tournament, category.getCategoryId(), gameType.getGameTypeId());
        return tournamentSave;
    }

}
