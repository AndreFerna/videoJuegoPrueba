package co.com.pragma.api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TournamentDto {
    @NotNull
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
