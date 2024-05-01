package co.com.pragma.usecase.tournament;

import co.com.pragma.model.tournament.View;
import co.com.pragma.model.tournament.ViewSale;
import co.com.pragma.model.tournament.config.ErrorCode;
import co.com.pragma.model.tournament.config.PragmaException;
import co.com.pragma.model.tournament.gateways.UserRepository;
import co.com.pragma.model.tournament.gateways.ViewRepository;
import co.com.pragma.model.tournament.gateways.ViewSaleRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class ViewSaleUseCase {

    private final ViewSaleRepository viewSaleRepository;
    private final ViewRepository viewRepository;
    private final UserRepository userRepository;

    public ViewSale save(ViewSale viewSale){
        boolean existUser = userRepository.exitsById(viewSale.getIdUser());
        boolean existView = viewRepository.existById(viewSale.getIdView());
        if(!existUser){
            throw new PragmaException(ErrorCode.B409007);
        }
        View view = viewRepository.findByIdView(viewSale.getIdView());
        viewSale.setSalePrice(view.getEntrancePrice());
        viewSale.setCommission(Math.round(viewSale.getSalePrice()*0.1));
        viewSale.setUniqueCode(UUID.randomUUID().toString());
        return viewSaleRepository.saveViewSale(viewSale);
    }

}
