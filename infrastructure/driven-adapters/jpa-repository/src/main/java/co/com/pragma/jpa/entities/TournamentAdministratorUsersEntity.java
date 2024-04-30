package co.com.pragma.jpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@Entity(name = "torneo_usuarios_administradores")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TournamentAdministratorUsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_torneo_usuario_admin;
    private Long id_torneo;
    private String id_usuario;

}
