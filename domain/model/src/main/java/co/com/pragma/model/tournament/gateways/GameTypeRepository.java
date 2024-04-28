package co.com.pragma.model.tournament.gateways;

import co.com.pragma.model.tournament.GameType;

public interface GameTypeRepository {

    GameType findByNameGameType(String nameGameType);
}
