package co.com.pragma.api.mapper;

import co.com.pragma.api.dto.TournamentSaleRequestDto;
import co.com.pragma.api.dto.TournamentSaleResponseDto;
import co.com.pragma.model.tournament.TournamentSale;

public class TournamentSaleDtoMapper {
    public static TournamentSale tournamentSaleDtoToTournamentSale(TournamentSaleRequestDto tournamentSaleResponseDto){
        return TournamentSale.builder()
                .idUser(tournamentSaleResponseDto.getIdUser())
                .idTournament(tournamentSaleResponseDto.getIdTournament())
                .build();
    }

    public static TournamentSaleResponseDto tournamentSaleToTournamentSaleDto (TournamentSale tournamentSale){
        return TournamentSaleResponseDto.builder()
                .salePrice(tournamentSale.getSalePrice())
                .commission(tournamentSale.getCommission())
                .uniqueCode(tournamentSale.getUniqueCode())
                .idUser(tournamentSale.getIdUser())
                .idTournament(tournamentSale.getIdTournament())
                .build();
    }

}
