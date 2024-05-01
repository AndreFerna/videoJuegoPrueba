package co.com.pragma.jpa.adapter;

import co.com.pragma.jpa.entities.ViewSaleEntity;
import co.com.pragma.jpa.helper.AdapterOperations;
import co.com.pragma.jpa.mapper.ViewSaleMapper;
import co.com.pragma.jpa.repository.JPAViewSaleRepository;
import co.com.pragma.model.tournament.ViewSale;
import co.com.pragma.model.tournament.gateways.ViewSaleRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JPARepoistoryViewSaleAdapter extends AdapterOperations<ViewSale, ViewSaleEntity, Long, JPAViewSaleRepository> implements ViewSaleRepository {

    protected JPARepoistoryViewSaleAdapter(JPAViewSaleRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, ViewSale.class));
    }

    @Override
    public ViewSale saveViewSale(ViewSale viewSale) {
        ViewSaleEntity viewSaleEntity = saveData(ViewSaleMapper.toEntity(viewSale));
        return ViewSaleMapper.toDomain(viewSaleEntity);
    }
}
