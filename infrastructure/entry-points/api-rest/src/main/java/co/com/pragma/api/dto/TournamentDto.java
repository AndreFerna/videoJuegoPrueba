package co.com.pragma.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TournamentDto {
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private Long entrancePrice; //precio entrada
    private Long capacity;
    private String organizer;
    private String category;


}
