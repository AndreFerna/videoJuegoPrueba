package co.com.pragma.jpa.adapter;

import co.com.pragma.jpa.mapper.GameTypeMapper;
import co.com.pragma.jpa.repository.JPAGameTypeRepository;
import co.com.pragma.jpa.entities.GameTypeEntity;
import co.com.pragma.jpa.helper.AdapterOperations;
import co.com.pragma.model.tournament.GameType;
import co.com.pragma.model.tournament.gateways.GameTypeRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JPARepositoryGameTypeAdapter extends AdapterOperations<GameType, GameTypeEntity, Long, JPAGameTypeRepository> implements GameTypeRepository {

    public JPARepositoryGameTypeAdapter(JPAGameTypeRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, GameType.class));
    }

    @Override
    public GameType findByNameGameType(String nameGameType) {
        return GameTypeMapper.toDomain(repository.findByNombre(nameGameType));
    }
}
