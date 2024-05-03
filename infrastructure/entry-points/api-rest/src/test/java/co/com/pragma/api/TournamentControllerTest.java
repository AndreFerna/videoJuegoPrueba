package co.com.pragma.api;

import co.com.pragma.api.controller.TournamentController;
import co.com.pragma.api.dto.TournamentRequestDto;
import co.com.pragma.api.dto.TournamentResponseDto;
import co.com.pragma.api.dto.ViewRequestDto;
import co.com.pragma.api.dto.ViewResponseDto;
import co.com.pragma.api.mapper.TournamentDtoMapper;
import co.com.pragma.model.tournament.Tournament;
import co.com.pragma.model.tournament.View;
import co.com.pragma.usecase.tournament.TournamentUseCase;
import co.com.pragma.usecase.tournament.ViewUseCase;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class TournamentControllerTest {
    @Mock
    private TournamentUseCase tournamentUseCase;
    @Mock
    private ViewUseCase viewUseCase;
    @InjectMocks
    private TournamentController tournamentController;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveTournament(){
        TournamentRequestDto tournamentRequestDto = new TournamentRequestDto("Torneo de Halo", "Se crea para generar un torneo de halo entre varios participantes", "2023-07-22T02:01:00", "2023-07-22T03:01:00", 10000L, "1193134338", "Accion", true);

        Tournament tournament = new Tournament(1L, "Torneo de Halo", "Se crea para generar un torneo de halo entre varios participantes", "2023-07-22T02:01:00", "2023-07-22T03:01:00", 10000L, 100L, "1193134338", "Accion", "6c6354df-3134-4c72-a438-c555df494759", true);

        when(tournamentUseCase.save(any(Tournament.class))).thenReturn(tournament);

        TournamentResponseDto tournamentResponseDto = tournamentController.save(tournamentRequestDto);

        Assertions.assertEquals(tournamentRequestDto.getOrganizer(), tournamentResponseDto.getOrganizer());
    }

    @Test
    void saveView(){
        ViewRequestDto viewRequestDto = new ViewRequestDto("2023-07-22T02:01:00", true, 2L, 1000L);
        View view = new View("https://tournamentview.com/view/e8f681b8-33d0-4fba-b5d0-731250b1580d", "2023-07-22T02:01", true, 2L, 100L, "e8f681b8-33d0-4fba-b5d0-731250b1580d", 1000L);

        when(viewUseCase.save(any(View.class))).thenReturn(view);

        ViewResponseDto viewResponseDto = tournamentController.save(viewRequestDto);

        Assertions.assertEquals(viewResponseDto.getIdTournament(), viewRequestDto.getIdTournament());

    }

}
