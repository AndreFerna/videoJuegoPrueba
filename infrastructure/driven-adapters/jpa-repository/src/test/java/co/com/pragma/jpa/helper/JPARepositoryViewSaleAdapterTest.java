package co.com.pragma.jpa.helper;

import co.com.pragma.jpa.adapter.JPARepoistoryViewSaleAdapter;
import co.com.pragma.jpa.entities.ViewSaleEntity;
import co.com.pragma.jpa.repository.JPAViewSaleRepository;
import co.com.pragma.model.tournament.ViewSale;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.reactivecommons.utils.ObjectMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class JPARepositoryViewSaleAdapterTest {

    @Mock
    private JPAViewSaleRepository repository;
    @Mock
    private ObjectMapper objectMapper;
    private JPARepoistoryViewSaleAdapter adapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        when(objectMapper.map("value", Object.class)).thenReturn("value");

        adapter = new JPARepoistoryViewSaleAdapter(repository, objectMapper);
    }


    @Test
    void saveSuccessfulTest(){
        ViewSale viewSale = new ViewSale(1000L, 100L, "86d34244-3611-45ee-81ae-2b6f19aaff3a", "1193134338", 1L);
        ViewSaleEntity viewSaleEntity = new ViewSaleEntity(1L, 1000L, 100L, "86d34244-3611-45ee-81ae-2b6f19aaff3a", "1193134338", 1L);

        when(repository.save(any(ViewSaleEntity.class))).thenReturn(viewSaleEntity);

        ViewSale viewSale1 = adapter.saveViewSale(viewSale);

        Assertions.assertEquals(viewSale.getUniqueCode(), viewSale1.getUniqueCode());
    }

}
