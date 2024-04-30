package co.com.pragma.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ViewDto {
    private String url;
    private String date;
    private boolean free;
    private Long idTournament;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long aforo;
    private String uniqueCode;

}
