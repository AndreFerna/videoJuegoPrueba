package co.com.pragma.jpa.mapper;

import co.com.pragma.jpa.entities.TournamentEntity;
import co.com.pragma.model.tournament.Tournament;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TournamentMapper {

    public static TournamentEntity toEntity(Tournament tournament, Long categoryId){
        return TournamentEntity.builder()
                .nombre(tournament.getName())
                .descripcion(tournament.getDescription())
                .fecha_inicio(LocalDateTime.parse(tournament.getStartDate(),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")))
                .fecha_fin(LocalDateTime.parse(tournament.getEndDate(),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")))
                .precio_entrada(tournament.getEntrancePrice())
                .aforo(tournament.getCapacity())
                .identificacion(tournament.getOrganizer())
                .id_categoria(categoryId)
                .codigo_unico(tournament.getUniqueCode())
                .gratuito(tournament.isFree())
                .build();
    }

    //
    public static Tournament toDomain(TournamentEntity tournamentEntity, String categoryAlias){
        return Tournament.builder()
                .idTournament(tournamentEntity.getId_torneo())
                .name(tournamentEntity.getNombre())
                .description(tournamentEntity.getDescripcion())
                .startDate(tournamentEntity.getFecha_inicio().toString())
                .endDate(tournamentEntity.getFecha_fin().toString())
                .entrancePrice(tournamentEntity.getPrecio_entrada())
                .capacity(tournamentEntity.getAforo())
                .organizer(tournamentEntity.getIdentificacion())
                .category(categoryAlias)
                .uniqueCode(tournamentEntity.getCodigo_unico())
                .isFree(tournamentEntity.getGratuito())
                .build();
    }

}
