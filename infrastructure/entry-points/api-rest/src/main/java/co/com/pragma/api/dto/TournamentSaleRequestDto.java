package co.com.pragma.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TournamentSaleRequestDto {
    @NotNull
    @Schema(example = "1193134338")
    private String idUser;
    @NotNull
    @Schema(example = "2")
    private Long idTournament;
}
