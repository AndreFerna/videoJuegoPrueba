package co.com.pragma.jpa.mapper;

import co.com.pragma.jpa.entities.TournamentSaleEntity;
import co.com.pragma.model.tournament.TournamentSale;

public class TournamentSaleMapper {
    public static TournamentSaleEntity toEntity(TournamentSale tournamentSale){
        return TournamentSaleEntity.builder()
                .precio_venta(tournamentSale.getSalePrice())
                .comision(tournamentSale.getCommission())
                .codigo_unico(tournamentSale.getUniqueCode())
                .identificacion(tournamentSale.getIdUser())
                .id_torneo(tournamentSale.getIdTournament())
                .build();
    }

    public static TournamentSale toDomain(TournamentSaleEntity tournamentSaleEntity){
        return TournamentSale.builder()
                .salePrice(tournamentSaleEntity.getPrecio_venta())
                .commission(tournamentSaleEntity.getComision())
                .uniqueCode(tournamentSaleEntity.getCodigo_unico())
                .idUser(tournamentSaleEntity.getIdentificacion())
                .idTournament(tournamentSaleEntity.getId_torneo())
                .build();
    }
}
