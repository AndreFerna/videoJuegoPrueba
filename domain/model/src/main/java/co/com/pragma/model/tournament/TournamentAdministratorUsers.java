package co.com.pragma.model.tournament;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class TournamentAdministratorUsers {

    private Long adminUserTournamentId;
    private Long tournamentId;
    private String userId;

}
