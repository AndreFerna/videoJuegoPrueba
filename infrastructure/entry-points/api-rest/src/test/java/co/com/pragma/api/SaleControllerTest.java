package co.com.pragma.api;

import co.com.pragma.api.controller.SaleController;
import co.com.pragma.api.dto.TournamentSaleRequestDto;
import co.com.pragma.api.dto.TournamentSaleResponseDto;
import co.com.pragma.api.dto.ViewSaleRequestDto;
import co.com.pragma.api.dto.ViewSaleResponseDto;
import co.com.pragma.model.tournament.TournamentSale;
import co.com.pragma.model.tournament.ViewSale;
import co.com.pragma.usecase.tournament.TournamentSaleUseCase;
import co.com.pragma.usecase.tournament.ViewSaleUseCase;
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

public class SaleControllerTest {
    @Mock
    private TournamentSaleUseCase tournamentSaleUseCase;
    @Mock
    private ViewSaleUseCase viewSaleUseCase;
    @InjectMocks
    private SaleController saleController;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveTournamentSale(){
        TournamentSaleRequestDto tournamentSaleRequestDto = new TournamentSaleRequestDto("1193134338", 2L);
        TournamentSale tournamentSale = new TournamentSale(10000L, 1000L, "8c4d843d-e574-4d25-84c4-11bfad79215a", "1193134338", 2L);

        when(tournamentSaleUseCase.save(any(TournamentSale.class))).thenReturn(tournamentSale);
        TournamentSaleResponseDto tournamentSaleResponseDto = saleController.save(tournamentSaleRequestDto);

        Assertions.assertEquals(tournamentSaleRequestDto.getIdTournament(), tournamentSaleResponseDto.getIdTournament());
    }

    @Test
    void saveViewSale(){
        ViewSaleRequestDto viewSaleRequestDto = new ViewSaleRequestDto("1193134338", 1L);
        ViewSale viewSale = new ViewSale(1000L, 100L, "b795b1fe-b9a4-4df2-b3d7-d9ad0eb91db3", "1193134338", 1L);

        when(viewSaleUseCase.save(any(ViewSale.class))).thenReturn(viewSale);

        ViewSaleResponseDto viewSaleResponseDto = saleController.save(viewSaleRequestDto);

        Assertions.assertEquals(viewSaleRequestDto.getIdView(), viewSaleResponseDto.getIdView());

    }


}
