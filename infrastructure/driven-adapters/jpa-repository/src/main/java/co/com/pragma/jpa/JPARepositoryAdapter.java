package co.com.pragma.jpa;

import co.com.pragma.jpa.entities.TournamentEntity;
import co.com.pragma.jpa.helper.AdapterOperations;
import co.com.pragma.jpa.mapper.TournamentMapper;
import co.com.pragma.model.tournament.Tournament;
import co.com.pragma.model.tournament.gateways.TournamentRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class JPARepositoryAdapter extends AdapterOperations<Tournament, TournamentEntity, Long, JPARepository> implements TournamentRepository
{

    public JPARepositoryAdapter(JPARepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Tournament.class));
    }


    @Override
    public Tournament saveTournament(Tournament tournament) {
        System.out.println("Entro aqui");
        return TournamentMapper.toDomain(saveData(TournamentMapper.toEntity(tournament)));

    }
}
