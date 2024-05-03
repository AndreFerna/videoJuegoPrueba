package co.com.pragma.jpa.helper;

import co.com.pragma.jpa.adapter.JPARepoistoryViewSaleAdapter;
import co.com.pragma.jpa.adapter.JPARepositoryViewAdapter;
import co.com.pragma.jpa.entities.ViewEntity;
import co.com.pragma.jpa.repository.JPAViewRepository;
import co.com.pragma.model.tournament.View;
import co.com.pragma.model.tournament.config.PragmaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.reactivecommons.utils.ObjectMapper;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class JPARepositoryViewAdapterTest {
    @Mock
    private JPAViewRepository repository;
    @Mock
    private ObjectMapper objectMapper;
    private JPARepositoryViewAdapter adapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        when(objectMapper.map("value", Object.class)).thenReturn("value");

        adapter = new JPARepositoryViewAdapter(repository, objectMapper);
    }

    @Test
    void saveViewTest(){
        View view = new View("https://tournamentview.com/view/e8f681b8-33d0-4fba-b5d0-731250b1580d", "2023-07-22T02:01:00", true, 2L, 100L, "e8f681b8-33d0-4fba-b5d0-731250b1580d",1000L);
        ViewEntity viewEntity = new ViewEntity(1L, "https://tournamentview.com/view/e8f681b8-33d0-4fba-b5d0-731250b1580d", LocalDateTime.now(), 2L, true,  100L, "e8f681b8-33d0-4fba-b5d0-731250b1580d",1000L);

        when(repository.save(any(ViewEntity.class))).thenReturn(viewEntity);

        View view1 = adapter.saveView(view);

        Assertions.assertEquals(view.getIdTournament(), view1.getIdTournament());
    }

    @Test
    void countFreeViewsPerTournamentTest(){
        when(repository.countFreeViewsPerTournament(anyLong())).thenReturn(0);

        int number = adapter.countFreeViewsPerTournament(1L);

        Assertions.assertEquals(number, 0);
    }

    @Test
    void existByIdTest(){
        when(repository.existsById(anyLong())).thenReturn(true);

        boolean status = adapter.existById(1L);

        Assertions.assertEquals(status, true);
    }

    @Test
    void findByIdViewTest(){
        ViewEntity viewEntity = new ViewEntity(1L, "https://tournamentview.com/view/e8f681b8-33d0-4fba-b5d0-731250b1580d", LocalDateTime.now(), 2L, true,  100L, "e8f681b8-33d0-4fba-b5d0-731250b1580d",1000L);

        when(repository.findById(anyLong())).thenReturn(Optional.of(viewEntity));

        View view = adapter.findByIdView(1L);

        Assertions.assertEquals(view.getIdTournament(), viewEntity.getId_torneo());
    }

    @Test
    void findByIdViewExceptionTest(){
        when(repository.findById(anyLong())).thenReturn(Optional.empty());

        Assertions.assertThrows(PragmaException.class, () -> {
            adapter.findByIdView(0L);
        });

    }

}
