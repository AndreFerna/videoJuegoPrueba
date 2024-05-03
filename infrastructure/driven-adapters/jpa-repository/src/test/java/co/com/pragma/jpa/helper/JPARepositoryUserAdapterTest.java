package co.com.pragma.jpa.helper;

import co.com.pragma.jpa.adapter.JPARepoistoryViewSaleAdapter;
import co.com.pragma.jpa.adapter.JPARepositoryUserAdapter;
import co.com.pragma.jpa.repository.JPAUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.reactivecommons.utils.ObjectMapper;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class JPARepositoryUserAdapterTest {

    @Mock
    private JPAUserRepository repository;
    @Mock
    private ObjectMapper objectMapper;
    private JPARepositoryUserAdapter adapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        when(objectMapper.map("value", Object.class)).thenReturn("value");

        adapter = new JPARepositoryUserAdapter(repository, objectMapper);
    }

    @Test
    void exitsByIdTest(){
        when(repository.existsById(anyString())).thenReturn(true);

        boolean status = adapter.exitsById("1193134338");

        Assertions.assertEquals(status, true);
    }




}
