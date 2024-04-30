package co.com.pragma.usecase.tournament;

import co.com.pragma.model.tournament.Category;
import co.com.pragma.model.tournament.Tournament;
import co.com.pragma.model.tournament.TournamentAdministratorUsers;
import co.com.pragma.model.tournament.config.ErrorCode;
import co.com.pragma.model.tournament.config.PragmaException;
import co.com.pragma.model.tournament.gateways.CategoryRepository;
import co.com.pragma.model.tournament.gateways.TournamentAdministratorUsersRepository;
import co.com.pragma.model.tournament.gateways.TournamentRepository;
import co.com.pragma.model.tournament.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import java.util.Objects;

@RequiredArgsConstructor
public class TournamentUseCase {
    private final TournamentRepository tournamentRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final TournamentAdministratorUsersRepository tournamentAdministratorUsersRepository;

    public Tournament save(Tournament tournament){
        Category category = categoryRepository.findByAliasCategory(tournament.getCategory());
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
        Tournament tournamentSaved = tournamentRepository.saveTournament(tournament, category.getCategoryId());
        if (Objects.isNull(tournamentSaved)) {
            throw new PragmaException(ErrorCode.B409005);
        }
        TournamentAdministratorUsers tournamentAdministratorUsers = tournamentAdministratorUsersRepository.saveTournamentAdministratorUsers(TournamentAdministratorUsers.builder()
                .userId(tournament.getOrganizer())
                .tournamentId(tournamentSaved.getIdTournament())
                .build());

        if (Objects.isNull(tournamentAdministratorUsers)) {
            tournamentRepository.deleteById(tournamentSaved.getIdTournament());
            throw new PragmaException(ErrorCode.B409005);
        }
        return tournamentSaved;
    }

}
