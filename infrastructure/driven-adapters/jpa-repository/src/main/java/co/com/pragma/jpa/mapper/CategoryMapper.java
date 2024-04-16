package co.com.pragma.jpa.mapper;

import co.com.pragma.jpa.entities.CategoryEntity;
import co.com.pragma.model.tournament.Category;

public class CategoryMapper
{
    public static Category toDomain(CategoryEntity categoryEntity){

        return Category.builder()
                .categoryId(categoryEntity.getId_categoria())
                .alias(categoryEntity.getAlias())
                .description(categoryEntity.getDescripcion())
                .build();
    }
}
