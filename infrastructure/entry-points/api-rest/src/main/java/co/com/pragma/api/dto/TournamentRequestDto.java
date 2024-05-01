package co.com.pragma.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TournamentRequestDto {
    @NotNull
    @Schema(example = "Torneo de Halo")
    private String name;
    @NotNull
    @Schema(example = "Se crea para generar un torneo de halo entre varios participantes")
    private String description;
    @NotNull
    @Schema(example = "2023-07-22T02:01:00")
    private String startDate;
    @NotNull
    @Schema(example = "2023-07-22T03:01:00")
    private String endDate;
    @NotNull
    @Schema(example = "10000")
    private Long entrancePrice; //precio entrada
    @NotNull
    @Schema(example = "1193134338")
    private String organizer;
    @NotNull
    @Schema(example = "Accion")
    private String category;
    @NotNull
    @Schema(example = "true")
    private Boolean free;
}
