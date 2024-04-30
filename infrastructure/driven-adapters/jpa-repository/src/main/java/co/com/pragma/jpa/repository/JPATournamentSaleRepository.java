package co.com.pragma.jpa.repository;

import co.com.pragma.jpa.entities.TournamentSaleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPATournamentSaleRepository extends CrudRepository<TournamentSaleEntity, Long>, QueryByExampleExecutor<TournamentSaleEntity> {
}
