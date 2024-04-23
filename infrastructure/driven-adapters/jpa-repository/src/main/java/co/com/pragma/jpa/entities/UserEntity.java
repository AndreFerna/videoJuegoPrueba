package co.com.pragma.jpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@Entity(name = "usuario")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    private String identificacion;
    private String nombre;
    private String correo;
    private String clave;
    private int id_rol;

}
