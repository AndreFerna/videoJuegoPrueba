package co.com.pragma.api.mapper;

import co.com.pragma.api.dto.ViewSaleRequestDto;
import co.com.pragma.api.dto.ViewSaleResponseDto;
import co.com.pragma.model.tournament.ViewSale;
public class ViewSaleDtoMapper {

    public static ViewSale viewSaleDtoToViewSale(ViewSaleRequestDto viewSaleResponseDto){
        return ViewSale.builder()
                .idUser(viewSaleResponseDto.getIdUser())
                .idView(viewSaleResponseDto.getIdView())
                .build();
    }

    public static ViewSaleResponseDto viewSaleToViewSaleDto(ViewSale viewSale){
        return ViewSaleResponseDto.builder()
                .salePrice(viewSale.getSalePrice())
                .commission(viewSale.getCommission())
                .uniqueCode(viewSale.getUniqueCode())
                .idUser(viewSale.getIdUser())
                .idView(viewSale.getIdView())
                .build();
    }

}
