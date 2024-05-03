package co.com.pragma.jpa.adapter;

import co.com.pragma.jpa.entities.ViewEntity;
import co.com.pragma.jpa.helper.AdapterOperations;
import co.com.pragma.jpa.mapper.ViewMapper;
import co.com.pragma.jpa.repository.JPAViewRepository;
import co.com.pragma.model.tournament.View;
import co.com.pragma.model.tournament.config.ErrorCode;
import co.com.pragma.model.tournament.config.PragmaException;
import co.com.pragma.model.tournament.gateways.ViewRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Function;

@Component
public class JPARepositoryViewAdapter extends AdapterOperations<View, ViewEntity, Long, JPAViewRepository> implements ViewRepository {

    public JPARepositoryViewAdapter(JPAViewRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, View.class));
    }

    @Override
    public View saveView(View view) {
        ViewEntity viewEntity = saveData(ViewMapper.toEntity(view));
        return ViewMapper.toDomain(viewEntity);
    }

    @Override
    public int countFreeViewsPerTournament(Long tournamentId) {
        return repository.countFreeViewsPerTournament(tournamentId);
    }

    @Override
    public boolean existById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public View findByIdView(Long id) {
        Optional<ViewEntity> viewEntity = repository.findById(id);
        if(!viewEntity.isPresent()){
            throw new PragmaException(ErrorCode.B409008);
        }
        return ViewMapper.toDomain(viewEntity.get());
    }
}
