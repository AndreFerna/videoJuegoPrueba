package co.com.pragma.jpa.mapper;

import co.com.pragma.jpa.entities.ViewSaleEntity;
import co.com.pragma.model.tournament.ViewSale;

public class ViewSaleMapper {
    public static ViewSaleEntity toEntity(ViewSale viewSale){
        return ViewSaleEntity.builder()
                .precio_venta(viewSale.getSalePrice())
                .comision(viewSale.getCommission())
                .codigo_unico(viewSale.getUniqueCode())
                .identificacion(viewSale.getIdUser())
                .id_vista(viewSale.getIdView())
                .build();
    }

    public static ViewSale toDomain (ViewSaleEntity viewSaleEntity){
        return ViewSale.builder()
                .salePrice(viewSaleEntity.getPrecio_venta())
                .commission(viewSaleEntity.getComision())
                .uniqueCode(viewSaleEntity.getCodigo_unico())
                .idUser(viewSaleEntity.getIdentificacion())
                .idView(viewSaleEntity.getId_vista())
                .build();
    }

}
