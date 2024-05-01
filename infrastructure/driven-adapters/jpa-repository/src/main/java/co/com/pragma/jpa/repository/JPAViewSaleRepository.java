package co.com.pragma.jpa.repository;

import co.com.pragma.jpa.entities.ViewSaleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPAViewSaleRepository extends CrudRepository<ViewSaleEntity, Long>, QueryByExampleExecutor<ViewSaleEntity> {
}
