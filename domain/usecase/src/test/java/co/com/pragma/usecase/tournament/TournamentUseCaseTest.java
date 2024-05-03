package co.com.pragma.usecase.tournament;

import co.com.pragma.model.tournament.Category;
import co.com.pragma.model.tournament.Tournament;
import co.com.pragma.model.tournament.TournamentAdministratorUsers;
import co.com.pragma.model.tournament.config.PragmaException;
import co.com.pragma.model.tournament.gateways.CategoryRepository;
import co.com.pragma.model.tournament.gateways.TournamentAdministratorUsersRepository;
import co.com.pragma.model.tournament.gateways.TournamentRepository;
import co.com.pragma.model.tournament.gateways.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class TournamentUseCaseTest {
    @Mock
    private TournamentRepository tournamentRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private TournamentAdministratorUsersRepository tournamentAdministratorUsersRepository;
    @InjectMocks
    private TournamentUseCase tournamentUseCase;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveSuccessfulTest(){
        Category category = new Category(1L, "Prueba", "Accion");
        Tournament tournament = new Tournament(1L, "Prueba", "Descripcion prueba", "2023-07-22T02:01:00", "2023-07-22T03:01:00", 10000L, 100L, "1193134338", "Accion", "8cb7d00e-78d6-4050-a413-f5deca49a3a2", true );
        TournamentAdministratorUsers tournamentAdministratorUsers = new TournamentAdministratorUsers(1L, 1L, "1193134338");

        when(categoryRepository.findByAliasCategory(anyString())).thenReturn(category);
        when(userRepository.exitsById(anyString())).thenReturn(true);
        when(tournamentRepository.countTournamentsOrganizer(anyString())).thenReturn(0);
        when(tournamentRepository.saveTournament(any(Tournament.class), anyLong())).thenReturn(tournament);
        when(tournamentAdministratorUsersRepository.saveTournamentAdministratorUsers(any(TournamentAdministratorUsers.class))).thenReturn(tournamentAdministratorUsers);

        Tournament tournament1 = tournamentUseCase.save(tournament);

        Assertions.assertEquals(tournament1.getIdTournament(), tournament.getIdTournament());
    }

    @Test
    void saveUserExceptionTest(){
        Tournament tournament = new Tournament(1L, "Prueba", "Descripcion prueba", "2023-07-22T02:01:00", "2023-07-22T03:01:00", 10000L, 100L, "1193134338", "Accion", "8cb7d00e-78d6-4050-a413-f5deca49a3a2", true );

        when(userRepository.exitsById(anyString())).thenReturn(false);

        // Cuando intentes guardar el torneo con un usuario no existente, debería lanzar una PragmaException
        Assertions.assertThrows(PragmaException.class, () -> {
            tournamentUseCase.save(tournament);
        });

    }

    @Test
    void saveExceptionFreeTournaments(){
        Tournament tournament = new Tournament(1L, "Prueba", "Descripcion prueba", "2023-07-22T02:01:00", "2023-07-22T03:01:00", 10000L, 100L, "1193134338", "Accion", "8cb7d00e-78d6-4050-a413-f5deca49a3a2", true );

        when(userRepository.exitsById(anyString())).thenReturn(true);
        when(tournamentRepository.countTournamentsOrganizer(anyString())).thenReturn(2);

        Assertions.assertThrows(PragmaException.class, () -> {
            tournamentUseCase.save(tournament);
        });
    }

    @Test
    void saveExceptionDoesNotCreateTournament(){
        Category category = new Category(1L, "Prueba", "Accion");
        Tournament tournament = new Tournament(1L, "Prueba", "Descripcion prueba", "2023-07-22T02:01:00", "2023-07-22T03:01:00", 10000L, 100L, "1193134338", "Accion", "8cb7d00e-78d6-4050-a413-f5deca49a3a2", true );

        when(categoryRepository.findByAliasCategory(anyString())).thenReturn(category);
        when(userRepository.exitsById(anyString())).thenReturn(true);
        when(tournamentRepository.countTournamentsOrganizer(anyString())).thenReturn(0);
        when(tournamentRepository.saveTournament(any(Tournament.class), anyLong())).thenReturn(null);

        Assertions.assertThrows(PragmaException.class, () -> {
            tournamentUseCase.save(tournament);
        });
    }

   @Test
    void saveExceptionDoesNotCreateTournamentAdministrator(){
       Category category = new Category(1L, "Prueba", "Accion");
       Tournament tournament = new Tournament(1L, "Prueba", "Descripcion prueba", "2023-07-22T02:01:00", "2023-07-22T03:01:00", 10000L, 100L, "1193134338", "Accion", "8cb7d00e-78d6-4050-a413-f5deca49a3a2", true );
       TournamentAdministratorUsers tournamentAdministratorUsers = new TournamentAdministratorUsers(1L, 1L, "1193134338");

       when(categoryRepository.findByAliasCategory(anyString())).thenReturn(category);
       when(userRepository.exitsById(anyString())).thenReturn(true);
       when(tournamentRepository.countTournamentsOrganizer(anyString())).thenReturn(0);
       when(tournamentRepository.saveTournament(any(Tournament.class), anyLong())).thenReturn(tournament);
       when(tournamentAdministratorUsersRepository.saveTournamentAdministratorUsers(any(TournamentAdministratorUsers.class))).thenReturn(null);

       Assertions.assertThrows(PragmaException.class, () -> {
           tournamentUseCase.save(tournament);
       });
   }





}
