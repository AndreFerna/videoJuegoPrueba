package co.com.pragma.jpa.helper;

import co.com.pragma.jpa.adapter.JPARepoistoryViewSaleAdapter;
import co.com.pragma.jpa.adapter.JPARepositoryTournamentAdministratorUsers;
import co.com.pragma.jpa.entities.TournamentAdministratorUsersEntity;
import co.com.pragma.jpa.repository.JPATournamentAdministratorUsersRepository;
import co.com.pragma.model.tournament.TournamentAdministratorUsers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.reactivecommons.utils.ObjectMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class JPARepositoryTournamentAdministratorUsersAdapterTest {

    @Mock
    private JPATournamentAdministratorUsersRepository repository;
    @Mock
    private ObjectMapper objectMapper;
    private JPARepositoryTournamentAdministratorUsers adapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        when(objectMapper.map("value", Object.class)).thenReturn("value");

        adapter = new JPARepositoryTournamentAdministratorUsers(repository, objectMapper);
    }

    @Test
    void saveTournamentAdministratorUsersTest(){
        TournamentAdministratorUsers tournamentAdministratorUsers = new TournamentAdministratorUsers(1L, 1L, "1193134338");
        TournamentAdministratorUsersEntity tournamentAdministratorUsersEntity = new TournamentAdministratorUsersEntity(1L, 1L, "1193134338");

        when(repository.save(any(TournamentAdministratorUsersEntity.class))).thenReturn(tournamentAdministratorUsersEntity);
        TournamentAdministratorUsers tournamentAdministratorUsers1 = adapter.saveTournamentAdministratorUsers(tournamentAdministratorUsers);

        Assertions.assertEquals(tournamentAdministratorUsers.getTournamentId(), tournamentAdministratorUsers1.getTournamentId());
    }
}
