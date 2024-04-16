package co.com.pragma.jpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@Entity(name = "tipo_juego")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GameTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipo_juego;
    private String nombre;
    private Long cant_jugadores;
    private Long id_categoria;

}
