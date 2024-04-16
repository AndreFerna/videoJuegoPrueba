package co.com.pragma.jpa.repository;

import co.com.pragma.jpa.entities.GameTypeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPAGameTypeRepository extends CrudRepository<GameTypeEntity, Long>, QueryByExampleExecutor<GameTypeEntity> {

    GameTypeEntity findByNombre(String nombre);
}
