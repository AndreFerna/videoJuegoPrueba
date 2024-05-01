package co.com.pragma.usecase.tournament;

import co.com.pragma.model.tournament.Tournament;
import co.com.pragma.model.tournament.TournamentSale;
import co.com.pragma.model.tournament.config.ErrorCode;
import co.com.pragma.model.tournament.config.PragmaException;
import co.com.pragma.model.tournament.gateways.TournamentRepository;
import co.com.pragma.model.tournament.gateways.TournamentSaleRepository;
import co.com.pragma.model.tournament.gateways.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class TournamentSaleUseCase {

    private final TournamentSaleRepository tournamentSaleRepository;
    private final TournamentRepository tournamentRepository;
    private final UserRepository userRepository;

    public TournamentSale save(TournamentSale tournamentSale) {
        boolean existUser = userRepository.exitsById(tournamentSale.getIdUser());
        if(!existUser){
            throw new PragmaException(ErrorCode.B409007);
        }
        Tournament tournament = tournamentRepository.findByIdTournament(tournamentSale.getIdTournament());
        tournamentSale.setSalePrice(tournament.getEntrancePrice());
        tournamentSale.setCommission(Math.round(tournamentSale.getSalePrice()*0.1));
        tournamentSale.setUniqueCode(UUID.randomUUID().toString());
        return tournamentSaleRepository.saveTournamentSale(tournamentSale);
    }

}
