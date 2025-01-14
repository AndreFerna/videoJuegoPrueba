package co.com.pragma.model.tournament;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class View {
    private String url;
    private String date;
    private boolean isFree;
    private Long idTournament;
    private Long aforo;
    private String uniqueCode;
    private Long entrancePrice;

}
