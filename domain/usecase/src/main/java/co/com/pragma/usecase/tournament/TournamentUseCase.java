package co.com.pragma.usecase.tournament;

import co.com.pragma.model.tournament.Category;
import co.com.pragma.model.tournament.GameType;
import co.com.pragma.model.tournament.Tournament;
import co.com.pragma.model.tournament.config.ErrorCode;
import co.com.pragma.model.tournament.config.PragmaException;
import co.com.pragma.model.tournament.gateways.CategoryRepository;
import co.com.pragma.model.tournament.gateways.GameTypeRepository;
import co.com.pragma.model.tournament.gateways.TournamentRepository;
import co.com.pragma.model.tournament.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class TournamentUseCase {
    private final TournamentRepository tournamentRepository;
    private final CategoryRepository categoryRepository;
    private final GameTypeRepository gameTypeRepository;
    private final UserRepository userRepository;

    public Tournament save(Tournament tournament){
        Category category = categoryRepository.findByAliasCategory(tournament.getCategory());
        GameType gameType = gameTypeRepository.findByNameGameType(tournament.getGameType());
        boolean userExists = userRepository.exitsById(tournament.getOrganizer());
        if(!userExists){
            throw new PragmaException(ErrorCode.B409000);
        }
        if(tournament.isFree()){
            if(tournamentRepository.countTournamentsOrganizer(tournament.getOrganizer()) > 1){
                throw new PragmaException(ErrorCode.B409003);
            }
            tournament.setCapacity(100L);
        }
        return tournamentRepository.saveTournament(tournament, category.getCategoryId(), gameType.getGameTypeId());
    }

}
