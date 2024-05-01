package co.com.pragma.api.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ViewSaleDto {
    private Long salePrice;
    private Long commission;
    private String uniqueCode;
    private String idUser;
    private Long idView;
}
