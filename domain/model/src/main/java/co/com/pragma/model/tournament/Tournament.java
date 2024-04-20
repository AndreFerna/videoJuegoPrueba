package co.com.pragma.model.tournament;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
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
    private String uniqueCode;
    private boolean isFree;

}
