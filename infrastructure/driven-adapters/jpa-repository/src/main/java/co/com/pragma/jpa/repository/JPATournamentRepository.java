package co.com.pragma.jpa.repository;

import co.com.pragma.jpa.entities.TournamentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPATournamentRepository extends CrudRepository<TournamentEntity, Long>, QueryByExampleExecutor<TournamentEntity> {

    @Query("select count(*) from  torneo t where t.gratuito=true and t.identificacion=?1")
    int countTournamentsOrganizer(String id);

}
