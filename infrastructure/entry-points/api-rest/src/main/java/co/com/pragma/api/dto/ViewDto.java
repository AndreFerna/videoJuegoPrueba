package co.com.pragma.api.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ViewDto {
    private String date;
    private boolean isFree;
    private Long idTournament;

}
