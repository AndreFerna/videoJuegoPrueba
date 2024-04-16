package co.com.pragma.jpa.mapper;

import co.com.pragma.jpa.entities.GameTypeEntity;
import co.com.pragma.model.tournament.GameType;

public class GameTypeMapper {

    public static GameType toDomain(GameTypeEntity gameTypeEntity){
        return GameType.builder()
                .gameTypeId(gameTypeEntity.getId_tipo_juego())
                .name(gameTypeEntity.getNombre())
                .numberPlayers(gameTypeEntity.getCant_jugadores())
                .categoryId(gameTypeEntity.getId_categoria())
                .build();
    }
}
