package co.com.pragma.jpa.helper;

import co.com.pragma.jpa.adapter.JPARepositoryTournamentAdapter;
import co.com.pragma.jpa.entities.TournamentEntity;
import co.com.pragma.jpa.repository.JPATournamentRepository;
import co.com.pragma.model.tournament.Tournament;
import co.com.pragma.model.tournament.config.PragmaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.reactivecommons.utils.ObjectMapper;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class JPARepositoryTournamentAdapterTest {

    @Mock
    private JPATournamentRepository repository;
    @Mock
    private ObjectMapper objectMapper;
    private JPARepositoryTournamentAdapter adapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        when(objectMapper.map("value", Object.class)).thenReturn("value");

        adapter = new JPARepositoryTournamentAdapter(repository, objectMapper);
    }

    @Test
    void saveTournamentTest(){
        Tournament tournament = new Tournament(1L, "Torneo Prueba", "Se crea torneo para probar", "2023-07-22T02:01:00", "2023-07-22T03:01:00", 10000L, 100L,"1193134338", "Accion", "8cb7d00e-78d6-4050-a413-f5deca49a3a2", true);
        TournamentEntity tournamentEntity = new TournamentEntity(1L, "Torneo Prueba", "Se crea torneo para probar", LocalDateTime.now(), LocalDateTime.now(), 10000L, 100L, "1193134338", 1L, "8cb7d00e-78d6-4050-a413-f5deca49a3a2", true);

        when(repository.save(any(TournamentEntity.class))).thenReturn(tournamentEntity);

        Tournament tournament1 = adapter.saveTournament(tournament, 1l);

        Assertions.assertEquals(tournament1.getIdTournament(), tournamentEntity.getId_torneo());
    }

    @Test
    void saveTournamentExceptionTest(){
        Tournament tournament = new Tournament(1L, "Torneo Prueba", "Se crea torneo para probar", "2023-07-22T02:01:00", "2023-07-22T03:01:00", 10000L, 100L,"1193134338", "Accion", "8cb7d00e-78d6-4050-a413-f5deca49a3a2", true);

        when(repository.save(any(TournamentEntity.class))).thenReturn(null);

        Assertions.assertThrows(PragmaException.class, () -> {
            adapter.saveTournament(tournament, 1L);
        });
    }

    @Test
    void countTournamentsOrganizerTest(){
        when(repository.countTournamentsOrganizer(anyString())).thenReturn(1);

        int number = adapter.countTournamentsOrganizer("1193134338");

        Assertions.assertEquals(number, 1);
    }

    @Test
    void existByIdTest(){
        when(repository.existsById(anyLong())).thenReturn(true);

        boolean status = adapter.existById(1L);

        Assertions.assertEquals(status, true);
    }

    @Test
    void findByIdTournamentTest(){
        TournamentEntity tournamentEntity = new TournamentEntity(1L, "Torneo Prueba", "Se crea torneo para probar", LocalDateTime.now(), LocalDateTime.now(), 10000L, 100L, "1193134338", 1L, "8cb7d00e-78d6-4050-a413-f5deca49a3a2", true);
        when(repository.findById(anyLong())).thenReturn(Optional.of(tournamentEntity));

        Tournament tournament = adapter.findByIdTournament(1L);

        Assertions.assertEquals(tournament.getIdTournament(), tournamentEntity.getId_torneo());
    }

    @Test
    void findByIdTournamentExceptionTest(){
        TournamentEntity tournamentEntity = new TournamentEntity(1L, "Torneo Prueba", "Se crea torneo para probar", LocalDateTime.now(), LocalDateTime.now(), 10000L, 100L, "1193134338", 1L, "8cb7d00e-78d6-4050-a413-f5deca49a3a2", true);
        when(repository.findById(anyLong())).thenReturn(Optional.empty());

        Assertions.assertThrows(PragmaException.class, () -> {
            adapter.findByIdTournament(1L);
        });
    }


}
