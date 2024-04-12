package co.com.pragma.jpa.entities;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@Entity(name = "torneo")
public class TournamentEntity {
    private Long id_torneo;
    private String nombre;
    private String descripcion;
    private LocalDateTime fecha_inicio;
    private LocalDateTime fecha_fin;
    private Long precio_entrada;
    private Long aforo;
    private String identificacion;
    private int id_tipo_juego;
    private int id_categoria;

}
