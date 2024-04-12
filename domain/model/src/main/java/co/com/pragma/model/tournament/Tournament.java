package co.com.pragma.model.tournament;
import co.com.pragma.model.tournament.gateways.TournamentRepository;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Tournament{

    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private Long entrancePrice; //precio entrada
    private Long capacity;
    private String organizer;
    private String gameType;
    private String category;


}
