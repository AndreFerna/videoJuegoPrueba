package co.com.pragma.usecase.tournament;

import co.com.pragma.model.tournament.View;
import co.com.pragma.model.tournament.config.PragmaException;
import co.com.pragma.model.tournament.gateways.TournamentRepository;
import co.com.pragma.model.tournament.gateways.ViewRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class ViewUseCaseTest {

    @Mock
    private ViewRepository viewRepository;
    @Mock
    private TournamentRepository tournamentRepository;
    @InjectMocks
    private ViewUseCase viewUseCase;

    @BeforeEach //metodo de configuracion
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveSuccessfulTest(){
        View view = new View("https://tournamentview.com/view/d2a650ed-4ece-457b-a58b-fed46101e3e9", "2023-07-22T02:01", true, 2L, 100L, "d2a650ed-4ece-457b-a58b-fed46101e3e9", 1000L);

        when(tournamentRepository.existById(anyLong())).thenReturn(true);
        when(viewRepository.countFreeViewsPerTournament(anyLong())).thenReturn(0);
        when(viewRepository.saveView(any(View.class))).thenReturn(view);

        View view1 = viewUseCase.save(view);

        Assertions.assertEquals(view, view1);
    }

    @Test
    void saveTournamentExceptionDoesNotExist(){
        View view = new View("https://tournamentview.com/view/d2a650ed-4ece-457b-a58b-fed46101e3e9", "2023-07-22T02:01", true, 2L, 100L, "d2a650ed-4ece-457b-a58b-fed46101e3e9", 1000L);

        when(tournamentRepository.existById(anyLong())).thenReturn(false);

        Assertions.assertThrows(PragmaException.class, () -> {
            viewUseCase.save(view);
        });
    }

    @Test
    void freeViewException(){
        View view = new View("https://tournamentview.com/view/d2a650ed-4ece-457b-a58b-fed46101e3e9", "2023-07-22T02:01", true, 2L, 100L, "d2a650ed-4ece-457b-a58b-fed46101e3e9", 1000L);

        when(tournamentRepository.existById(anyLong())).thenReturn(true);
        when(viewRepository.countFreeViewsPerTournament(anyLong())).thenReturn(1);

        Assertions.assertThrows(PragmaException.class, () -> {
            viewUseCase.save(view);
        });
    }

}
