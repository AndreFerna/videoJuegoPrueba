package co.com.pragma.jpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@Entity(name = "venta_vista")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ViewSaleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_venta_vista;
    private Long precio_venta;
    private Long comision;
    private String codigo_unico;
    private String identificacion;
    private Long id_vista;

}
