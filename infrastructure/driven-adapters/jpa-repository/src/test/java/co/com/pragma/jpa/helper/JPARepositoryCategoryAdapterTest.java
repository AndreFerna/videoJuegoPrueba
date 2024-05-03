package co.com.pragma.jpa.helper;

import co.com.pragma.jpa.adapter.JPARepositoryCategoryAdapter;
import co.com.pragma.jpa.entities.CategoryEntity;
import co.com.pragma.jpa.repository.JPACategoryRepository;
import co.com.pragma.model.tournament.Category;
import co.com.pragma.model.tournament.config.PragmaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.reactivecommons.utils.ObjectMapper;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


public class JPARepositoryCategoryAdapterTest {

    @Mock
    private JPACategoryRepository repository;
    @Mock
    private ObjectMapper objectMapper;
    private JPARepositoryCategoryAdapter adapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        when(objectMapper.map("value", Object.class)).thenReturn("value");

        adapter = new JPARepositoryCategoryAdapter(repository, objectMapper);
    }

    @Test
    void findByAliasCategoryTest(){
        CategoryEntity categoryEntity = new CategoryEntity(1L, "Prueba", "Accion");

        when(repository.findByAlias(anyString())).thenReturn(categoryEntity);

        Category category = adapter.findByAliasCategory(categoryEntity.getAlias());

        Assertions.assertEquals(categoryEntity.getId_categoria(), category.getCategoryId());
    }

    @Test
    void findByAliasCategoryExceptionTest(){

        when(repository.findByAlias(anyString())).thenReturn(null);

        Assertions.assertThrows(PragmaException.class, () -> {
            adapter.findByAliasCategory("Prueba");
        });

    }

}
