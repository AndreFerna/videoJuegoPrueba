package co.com.pragma.jpa.adapter;

import co.com.pragma.jpa.entities.ViewEntity;
import co.com.pragma.jpa.helper.AdapterOperations;
import co.com.pragma.jpa.mapper.ViewMapper;
import co.com.pragma.jpa.repository.JPAViewRepository;
import co.com.pragma.model.tournament.View;
import co.com.pragma.model.tournament.gateways.ViewRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class JPARepositoryViewAdapter extends AdapterOperations<View, ViewEntity, Long, JPAViewRepository> implements ViewRepository {

    protected JPARepositoryViewAdapter(JPAViewRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, View.class));
    }

    @Override
    public View saveView(View view) {
        ViewEntity viewEntity = saveData(ViewMapper.toEntity(view));
        return ViewMapper.toDomain(viewEntity);
    }
}
