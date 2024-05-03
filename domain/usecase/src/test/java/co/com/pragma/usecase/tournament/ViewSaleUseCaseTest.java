package co.com.pragma.usecase.tournament;

import co.com.pragma.model.tournament.View;
import co.com.pragma.model.tournament.ViewSale;
import co.com.pragma.model.tournament.config.PragmaException;
import co.com.pragma.model.tournament.gateways.UserRepository;
import co.com.pragma.model.tournament.gateways.ViewRepository;
import co.com.pragma.model.tournament.gateways.ViewSaleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class ViewSaleUseCaseTest {

    @Mock
    private ViewSaleRepository viewSaleRepository;
    @Mock
    private ViewRepository viewRepository;
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private ViewSaleUseCase viewSaleUseCase;

    @BeforeEach
        //metodo de configuracion
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveSuccessfulTest(){
        ViewSale viewSale = new ViewSale(1000L, 100L, "86d34244-3611-45ee-81ae-2b6f19aaff3a", "1193134338", 1L);
        View view = new View("https://tournamentview.com/view/d2a650ed-4ece-457b-a58b-fed46101e3e9", "2023-07-22T02:01", true, 2L, 100L, "d2a650ed-4ece-457b-a58b-fed46101e3e9", 1000L);

        when(userRepository.exitsById(anyString())).thenReturn(true);
        when(viewRepository.existById(anyLong())).thenReturn(true);
        when(viewRepository.findByIdView(anyLong())).thenReturn(view);
        when(viewSaleRepository.saveViewSale(any(ViewSale.class))).thenReturn(viewSale);

        ViewSale viewSale1 = viewSaleUseCase.save(viewSale);

        Assertions.assertEquals(viewSale1, viewSale);
    }

    @Test
    void saveExceptionTest(){
        ViewSale viewSale = new ViewSale(1000L, 100L, "86d34244-3611-45ee-81ae-2b6f19aaff3a", "1193134338", 1L);

        when(userRepository.exitsById(anyString())).thenReturn(false);

        Assertions.assertThrows(PragmaException.class, () -> {
            viewSaleUseCase.save(viewSale);
        });
    }

}
