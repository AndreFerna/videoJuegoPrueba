package co.com.pragma.jpa.adapter;

import co.com.pragma.jpa.entities.CategoryEntity;
import co.com.pragma.jpa.helper.AdapterOperations;
import co.com.pragma.jpa.mapper.CategoryMapper;
import co.com.pragma.jpa.repository.JPACategoryRepository;
import co.com.pragma.model.tournament.Category;
import co.com.pragma.model.tournament.config.ErrorCode;
import co.com.pragma.model.tournament.config.PragmaException;
import co.com.pragma.model.tournament.gateways.CategoryRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JPARepositoryCategoryAdapter extends AdapterOperations<Category, CategoryEntity, Long, JPACategoryRepository> implements CategoryRepository {

    public JPARepositoryCategoryAdapter(JPACategoryRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Category.class));
    }

    @Override
    public Category findByAliasCategory(String nameCategory) {
        CategoryEntity categoryEntity = repository.findByAlias(nameCategory);
        if(categoryEntity==null){
            throw new PragmaException(ErrorCode.B409001);
        }
        return CategoryMapper.toDomain(categoryEntity);
    }
}
