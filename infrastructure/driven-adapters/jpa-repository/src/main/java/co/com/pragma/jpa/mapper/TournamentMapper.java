package co.com.pragma.jpa.mapper;

import co.com.pragma.jpa.entities.TournamentEntity;
import co.com.pragma.model.tournament.Tournament;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TournamentMapper {

    public static TournamentEntity toEntity(Tournament tournament){
        System.out.println("Entro toEntity: "+tournament.toString());
        return TournamentEntity.builder()
                .nombre(tournament.getName())
                .descripcion(tournament.getDescription())
                .fecha_inicio(LocalDateTime.parse(tournament.getStartDate(),
                        DateTimeFormatter.ofPattern("yyyyMMddHHmmss")))
                .fecha_fin(LocalDateTime.parse(tournament.getEndDate(),
                        DateTimeFormatter.ofPattern("yyyyMMddHHmmss")))
                .precio_entrada(tournament.getEntrancePrice())
                .aforo(tournament.getCapacity())
                .identificacion("1193134338")
                .id_categoria(1)
                .id_tipo_juego(1)
                .build();
    }

    public static Tournament toDomain(TournamentEntity tournamentEntity){
        System.out.println("Entro toDomain: "+tournamentEntity.toString());
        return Tournament.builder()
                .name(tournamentEntity.getNombre())
                .description(tournamentEntity.getDescripcion())
                .startDate("")//pasar de dateTime a String
                .endDate("")
                .entrancePrice(tournamentEntity.getPrecio_entrada())
                .capacity(tournamentEntity.getAforo())
                .organizer(tournamentEntity.getIdentificacion())
                .category("Accion")//pasar de entero a String
                .gameType("Halo")
                .build();
    }

}
