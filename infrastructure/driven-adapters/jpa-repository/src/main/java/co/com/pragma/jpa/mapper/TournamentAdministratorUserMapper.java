package co.com.pragma.jpa.mapper;

import co.com.pragma.jpa.entities.TournamentAdministratorUsersEntity;
import co.com.pragma.model.tournament.TournamentAdministratorUsers;

public class TournamentAdministratorUserMapper {

    public static TournamentAdministratorUsersEntity toEntity(TournamentAdministratorUsers tournamentAdministratorUsers) {
        return TournamentAdministratorUsersEntity.builder()
                .id_torneo(tournamentAdministratorUsers.getTournamentId())
                .id_usuario(tournamentAdministratorUsers.getUserId())
                .build();
    }

    public static TournamentAdministratorUsers toDomain(TournamentAdministratorUsersEntity tournamentAdministratorUsersEntity){
        return TournamentAdministratorUsers.builder()
                .adminUserTournamentId(tournamentAdministratorUsersEntity.getId_torneo_usuario_admin())
                .tournamentId(tournamentAdministratorUsersEntity.getId_torneo())
                .userId(tournamentAdministratorUsersEntity.getId_usuario())
                .build();
    }

}
