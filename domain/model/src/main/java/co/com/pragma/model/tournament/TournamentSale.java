package co.com.pragma.model.tournament;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class TournamentSale {
    private Long salePrice;
    private Long commission;
    private String uniqueCode;
    private String idUser;
    private Long idTournament;

}
