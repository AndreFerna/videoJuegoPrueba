package co.com.pragma.jpa.adapter;

import co.com.pragma.jpa.repository.JPATournamentRepository;
import co.com.pragma.jpa.entities.TournamentEntity;
import co.com.pragma.jpa.helper.AdapterOperations;
import co.com.pragma.jpa.mapper.TournamentMapper;
import co.com.pragma.model.tournament.Tournament;
import co.com.pragma.model.tournament.config.ErrorCode;
import co.com.pragma.model.tournament.config.PragmaException;
import co.com.pragma.model.tournament.gateways.TournamentRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JPARepositoryTournamentAdapter extends AdapterOperations<Tournament, TournamentEntity, Long, JPATournamentRepository> implements TournamentRepository {

    public JPARepositoryTournamentAdapter(JPATournamentRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Tournament.class));
    }


    @Override
    public Tournament saveTournament(Tournament tournament, Long categoryId) {
        TournamentEntity tournamentEntity = saveData(TournamentMapper.toEntity(tournament, categoryId));
        if(tournamentEntity != null){
            String categoryAlias = tournament.getCategory();
            return TournamentMapper.toDomain(tournamentEntity, categoryAlias);
        }
        return null;
    }

    @Override
    public int countTournamentsOrganizer(String id) {
        return repository.countTournamentsOrganizer(id);
    }

    @Override
    public void deleteById(Long id) {
        deleteById(id);
    }

    @Override
    public boolean existById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public Tournament findByIdTournament(Long id) {
        Optional<TournamentEntity> tournamentEntity = repository.findById(id);
        if(!tournamentEntity.isPresent()){
            throw new PragmaException(ErrorCode.B409006);
        }
        return TournamentMapper.toDomain(tournamentEntity.get(), "");
    }


}
