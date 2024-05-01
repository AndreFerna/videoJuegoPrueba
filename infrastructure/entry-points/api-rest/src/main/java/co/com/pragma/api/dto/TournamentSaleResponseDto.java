package co.com.pragma.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TournamentSaleResponseDto {
    @NotNull
    @Schema(example = "10000")
    private Long salePrice;
    @NotNull
    @Schema(example = "1000")
    private Long commission;
    @NotNull
    @Schema(example = "dc9f321a-b7ba-4ad5-93d9-0f6089bae67d")
    private String uniqueCode;
    @NotNull
    @Schema(example = "1193134338")
    private String idUser;
    @NotNull
    @Schema(example = "2")
    private Long idTournament;

}
