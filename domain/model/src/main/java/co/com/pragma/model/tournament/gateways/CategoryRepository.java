package co.com.pragma.model.tournament.gateways;

import co.com.pragma.model.tournament.Category;

public interface CategoryRepository {

    public Category findByAliasCategory(String nameCategory);

}
