package co.com.pragma.jpa.adapter;

import co.com.pragma.jpa.entities.TournamentAdministratorUsersEntity;
import co.com.pragma.jpa.helper.AdapterOperations;
import co.com.pragma.jpa.mapper.TournamentAdministratorUserMapper;
import co.com.pragma.jpa.repository.JPATournamentAdministratorUsersRepository;
import co.com.pragma.model.tournament.TournamentAdministratorUsers;
import co.com.pragma.model.tournament.gateways.TournamentAdministratorUsersRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JPARepositoryTournamentAdministratorUsers extends AdapterOperations<TournamentAdministratorUsers, TournamentAdministratorUsersEntity, Long, JPATournamentAdministratorUsersRepository> implements TournamentAdministratorUsersRepository {


    public JPARepositoryTournamentAdministratorUsers(JPATournamentAdministratorUsersRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, TournamentAdministratorUsers.class));
    }

    @Override
    public TournamentAdministratorUsers saveTournamentAdministratorUsers(TournamentAdministratorUsers tournamentAdministratorUsers) {
        TournamentAdministratorUsersEntity  tournamentAdministratorUsersEntity = saveData(TournamentAdministratorUserMapper.toEntity(tournamentAdministratorUsers));
        return TournamentAdministratorUserMapper.toDomain(tournamentAdministratorUsersEntity);
    }
}
