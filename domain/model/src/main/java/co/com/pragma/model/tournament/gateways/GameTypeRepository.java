package co.com.pragma.model.tournament.gateways;

import co.com.pragma.model.tournament.GameType;

public interface GameTypeRepository {

    public GameType findByNameGameType(String nameGameType);
}
