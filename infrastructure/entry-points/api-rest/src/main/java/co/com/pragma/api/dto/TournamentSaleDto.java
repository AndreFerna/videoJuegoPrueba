package co.com.pragma.api.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TournamentSaleDto {
    private Long salePrice;
    private Long commission;
    private String uniqueCode;
    private String idUser;
    private Long idTournament;

}
