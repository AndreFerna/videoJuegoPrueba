package co.com.pragma.jpa.repository;

import co.com.pragma.jpa.entities.TournamentAdministratorUsersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPATournamentAdministratorUsersRepository extends CrudRepository<TournamentAdministratorUsersEntity, Long>, QueryByExampleExecutor<TournamentAdministratorUsersEntity> {
}