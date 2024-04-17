package co.com.pragma.api.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TournamentDto {
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private Long entrancePrice; //precio entrada
    private String organizer;
    private String category;
    private String gameType;
    private String uniqueCode;
    private boolean isFree;
}
