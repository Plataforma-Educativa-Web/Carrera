package pe.cibertec.ProyectoFinal.ApiCarrera.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private Long codigoC;
    private String nombre;
    private Long codigo;
    private String descripcion;
    private String duracion;

}
