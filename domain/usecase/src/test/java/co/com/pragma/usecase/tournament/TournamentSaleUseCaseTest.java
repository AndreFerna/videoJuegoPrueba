package co.com.pragma.usecase.tournament;

import co.com.pragma.model.tournament.Tournament;
import co.com.pragma.model.tournament.TournamentSale;
import co.com.pragma.model.tournament.config.PragmaException;
import co.com.pragma.model.tournament.gateways.TournamentRepository;
import co.com.pragma.model.tournament.gateways.TournamentSaleRepository;
import co.com.pragma.model.tournament.gateways.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class TournamentSaleUseCaseTest {


    @Mock
    private TournamentSaleRepository tournamentSaleRepository;
    @Mock
    private TournamentRepository tournamentRepository;
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private TournamentSaleUseCase tournamentSaleUseCase;

    @BeforeEach //metodo de configuracion
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveSuccessfulTest(){
        Tournament tournament = new Tournament(1L, "Prueba", "Descripcion prueba", "2023-07-22T02:01:00", "2023-07-22T03:01:00", 10000L, 100L, "1193134338", "Accion", "8cb7d00e-78d6-4050-a413-f5deca49a3a2", true );
        TournamentSale tournamentSale = new TournamentSale(10000L, 1000L, "5afa9522-31bb-48bc-aa08-050eafcdb7d0", "1193134338", 2L);

        when(userRepository.exitsById(anyString())).thenReturn(true);
        when(tournamentRepository.findByIdTournament(anyLong())).thenReturn(tournament);
        when(tournamentSaleRepository.saveTournamentSale(any())).thenReturn(tournamentSale);

        TournamentSale tournamentSaleResponse = tournamentSaleUseCase.save(tournamentSale);

        Assertions.assertEquals(tournamentSaleResponse.getIdUser(), tournamentSale.getIdUser());
    }

    @Test
    void saveExceptionTest(){
        TournamentSale tournamentSale = new TournamentSale(10000L, 1000L, "5afa9522-31bb-48bc-aa08-050eafcdb7d0", "1234567890", 2L);

        when(userRepository.exitsById(anyString())).thenReturn(false);

        // Cuando intentes guardar la venta con un usuario no existente, debería lanzar una PragmaException
        Assertions.assertThrows(PragmaException.class, () -> {
            tournamentSaleUseCase.save(tournamentSale);
        });
    }

}
