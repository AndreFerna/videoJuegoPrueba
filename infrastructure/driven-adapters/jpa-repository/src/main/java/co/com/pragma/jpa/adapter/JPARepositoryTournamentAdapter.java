package co.com.pragma.jpa.adapter;

import co.com.pragma.jpa.repository.JPATournamentRepository;
import co.com.pragma.jpa.entities.TournamentEntity;
import co.com.pragma.jpa.helper.AdapterOperations;
import co.com.pragma.jpa.mapper.TournamentMapper;
import co.com.pragma.model.tournament.Tournament;
import co.com.pragma.model.tournament.gateways.TournamentRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JPARepositoryTournamentAdapter extends AdapterOperations<Tournament, TournamentEntity, Long, JPATournamentRepository> implements TournamentRepository
{

    public JPARepositoryTournamentAdapter(JPATournamentRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Tournament.class));
    }


    @Override
    public Tournament saveTournament(Tournament tournament, Long categoryId, Long gameTypeId) {
        TournamentEntity tournamentEntity = saveData(TournamentMapper.toEntity(tournament, categoryId, gameTypeId));
        if(tournamentEntity != null){
            String categoryAlias = tournament.getCategory();
            String gameTypeName = tournament.getGameType();
            return TournamentMapper.toDomain(tournamentEntity, categoryAlias, gameTypeName);
        }
        return null;
    }

    @Override
    public int countTournamentsOrganizer(String id) {
        return repository.countTournamentsOrganizer(id);
    }
}
