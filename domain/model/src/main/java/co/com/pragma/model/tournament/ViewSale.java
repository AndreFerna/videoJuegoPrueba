package co.com.pragma.model.tournament;

import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ViewSale {
    private Long salePrice;
    private Long commission;
    private String uniqueCode;
    private String idUser;
    private Long idView;

}
