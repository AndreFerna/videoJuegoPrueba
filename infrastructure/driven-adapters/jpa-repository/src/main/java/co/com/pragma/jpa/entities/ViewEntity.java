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
@Entity(name = "vista")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ViewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vista;
    private String url;
    private LocalDateTime fecha;
    private Long id_torneo;
    private boolean gratuito;
    private Long aforo;

}
