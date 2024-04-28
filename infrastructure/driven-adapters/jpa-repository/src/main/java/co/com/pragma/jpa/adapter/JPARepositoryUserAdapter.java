package co.com.pragma.jpa.adapter;

import co.com.pragma.jpa.entities.UserEntity;
import co.com.pragma.jpa.helper.AdapterOperations;
import co.com.pragma.jpa.repository.JPAUserRepository;
import co.com.pragma.model.tournament.User;
import co.com.pragma.model.tournament.config.ErrorCode;
import co.com.pragma.model.tournament.config.PragmaException;
import co.com.pragma.model.tournament.gateways.UserRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JPARepositoryUserAdapter extends AdapterOperations<User, UserEntity, String, JPAUserRepository> implements UserRepository {
    protected JPARepositoryUserAdapter(JPAUserRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, User.class));
    }


    @Override
    public boolean exitsById(String id) {
        return repository.existsById(id);
    }
}
