package co.com.pragma.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
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
    @JsonInclude(JsonInclude.Include.NON_NULL)  //etique para no mostrar parametro si llega null
    private Long capacity;
    private String organizer;
    private String category;
    private String uniqueCode;
    private boolean isFree;
}
