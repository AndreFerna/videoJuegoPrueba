package co.com.pragma.api.mapper;

import co.com.pragma.api.dto.TournamentSaleDto;
import co.com.pragma.model.tournament.TournamentSale;

public class TournamentSaleDtoMapper {
    public static TournamentSale tournamentSaleDtoToTournamentSale(TournamentSaleDto tournamentSaleDto){
        return TournamentSale.builder()
                .idUser(tournamentSaleDto.getIdUser())
                .idTournament(tournamentSaleDto.getIdTournament())
                .build();
    }

    public static TournamentSaleDto tournamentSaleToTouernamentSaleDto (TournamentSale tournamentSale){
        return TournamentSaleDto.builder()
                .salePrice(tournamentSale.getSalePrice())
                .commission(tournamentSale.getCommission())
                .uniqueCode(tournamentSale.getUniqueCode())
                .idUser(tournamentSale.getIdUser())
                .idTournament(tournamentSale.getIdTournament())
                .build();
    }

}
