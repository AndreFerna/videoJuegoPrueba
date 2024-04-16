package co.com.pragma.model.tournament;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class GameType {
    private Long gameTypeId;
    private String name;
    private Long numberPlayers;
    private Long categoryId;

}
