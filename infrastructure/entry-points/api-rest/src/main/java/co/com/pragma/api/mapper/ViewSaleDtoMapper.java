package co.com.pragma.api.mapper;

import co.com.pragma.api.dto.ViewSaleDto;
import co.com.pragma.model.tournament.ViewSale;
public class ViewSaleDtoMapper {

    public static ViewSale viewSaleDtoToViewSale(ViewSaleDto viewSaleDto){
        return ViewSale.builder()
                .idUser(viewSaleDto.getIdUser())
                .idView(viewSaleDto.getIdView())
                .build();
    }

    public static ViewSaleDto viewSaleToViewSaleDto(ViewSale viewSale){
        return ViewSaleDto.builder()
                .salePrice(viewSale.getSalePrice())
                .commission(viewSale.getCommission())
                .uniqueCode(viewSale.getUniqueCode())
                .idUser(viewSale.getIdUser())
                .idView(viewSale.getIdView())
                .build();
    }

}
