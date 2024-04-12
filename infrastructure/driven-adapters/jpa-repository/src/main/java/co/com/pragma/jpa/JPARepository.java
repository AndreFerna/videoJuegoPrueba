package co.com.pragma.jpa;

import co.com.pragma.jpa.entities.TournamentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPARepository extends CrudRepository<TournamentEntity, Long>, QueryByExampleExecutor<TournamentEntity> {
}
