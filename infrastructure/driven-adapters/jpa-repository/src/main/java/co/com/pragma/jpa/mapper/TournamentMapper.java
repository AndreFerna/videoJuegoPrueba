package co.com.pragma.jpa.mapper;

import co.com.pragma.jpa.entities.TournamentEntity;
import co.com.pragma.model.tournament.Tournament;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TournamentMapper {

    public static TournamentEntity toEntity(Tournament tournament, Long categoryId, Long gameTypeId){
        return TournamentEntity.builder()
                .nombre(tournament.getName())
                .descripcion(tournament.getDescription())
                .fecha_inicio(LocalDateTime.parse(tournament.getStartDate(),
                        DateTimeFormatter.ofPattern("yyyyMMddHHmmss")))
                .fecha_fin(LocalDateTime.parse(tournament.getEndDate(),
                        DateTimeFormatter.ofPattern("yyyyMMddHHmmss")))
                .precio_entrada(tournament.getEntrancePrice())
                .aforo(tournament.getCapacity())
                .identificacion(tournament.getOrganizer())
                .id_categoria(categoryId)
                .id_tipo_juego(gameTypeId)
                .build();
    }

    //
    public static Tournament toDomain(TournamentEntity tournamentEntity, String categoryAlias, String gameTypeName){
        /**todo Hacer desarrollo de recibir el alias de la categoria y el nombre del tipo de juego**/
        return Tournament.builder()
                .name(tournamentEntity.getNombre())
                .description(tournamentEntity.getDescripcion())
                .startDate("")//pasar de dateTime a String
                .endDate("")
                .entrancePrice(tournamentEntity.getPrecio_entrada())
                .capacity(tournamentEntity.getAforo())
                .organizer(tournamentEntity.getIdentificacion())
                .category(categoryAlias)//pasar de entero a String
                .gameType(gameTypeName)
                .build();
    }

}
