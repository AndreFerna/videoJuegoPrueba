package co.com.pragma.jpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity(name = "torneo")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TournamentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_torneo;
    private String nombre;
    private String descripcion;
    private LocalDateTime fecha_inicio;
    private LocalDateTime fecha_fin;
    private Long precio_entrada;
    private Long aforo;
    private String identificacion;
    private int id_categoria;
    private int id_tipo_juego;
}

