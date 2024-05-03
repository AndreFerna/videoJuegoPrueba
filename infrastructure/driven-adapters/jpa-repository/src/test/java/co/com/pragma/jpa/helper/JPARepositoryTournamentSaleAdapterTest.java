package co.com.pragma.jpa.helper;

import co.com.pragma.jpa.adapter.JPARepoistoryViewSaleAdapter;
import co.com.pragma.jpa.adapter.JPARepositoryTournamentSaleAdapter;
import co.com.pragma.jpa.entities.TournamentSaleEntity;
import co.com.pragma.jpa.repository.JPATournamentSaleRepository;
import co.com.pragma.model.tournament.TournamentSale;
import co.com.pragma.model.tournament.gateways.TournamentSaleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.reactivecommons.utils.ObjectMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class JPARepositoryTournamentSaleAdapterTest {

    @Mock
    private JPATournamentSaleRepository repository;
    @Mock
    private ObjectMapper objectMapper;
    private JPARepositoryTournamentSaleAdapter adapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        when(objectMapper.map("value", Object.class)).thenReturn("value");

        adapter = new JPARepositoryTournamentSaleAdapter(repository, objectMapper);
    }

    @Test
    void saveTournamentSaleTest(){
        TournamentSale tournamentSale = new TournamentSale(10000L, 1000L, "8c4d843d-e574-4d25-84c4-11bfad79215a", "1193134338", 2L);
        TournamentSaleEntity tournamentSaleEntity = new TournamentSaleEntity(1L, 10000L, 1000L, "8c4d843d-e574-4d25-84c4-11bfad79215a", "1193134338", 2L);

        when(repository.save(any(TournamentSaleEntity.class))).thenReturn(tournamentSaleEntity);
        TournamentSale tournamentSale1 = adapter.saveTournamentSale(tournamentSale);

        Assertions.assertEquals(tournamentSale.getIdTournament(), tournamentSale1.getIdTournament());


    }


}
