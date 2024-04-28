package co.com.pragma.jpa.repository;

import co.com.pragma.jpa.entities.ViewEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPAViewRepository extends CrudRepository<ViewEntity, Long>, QueryByExampleExecutor<ViewEntity> {

    @Query("select count(*) from vista v where v.id_torneo = ?1 and v.gratuito = true")
    int countFreeViewsPerTournament(Long toeurnamentId);
}
