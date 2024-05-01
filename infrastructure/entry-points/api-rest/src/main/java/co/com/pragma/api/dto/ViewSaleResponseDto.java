package co.com.pragma.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ViewSaleResponseDto {
    @NotNull
    @Schema(example = "1000")
    private Long salePrice;
    @NotNull
    @Schema(example = "100")
    private Long commission;
    @NotNull
    @Schema(example = "fee07440-f854-4c36-9674-9dc5ae16c8b4")
    private String uniqueCode;
    @NotNull
    @Schema(example = "1193134338")
    private String idUser;
    @NotNull
    @Schema(example = "1")
    private Long idView;

}
