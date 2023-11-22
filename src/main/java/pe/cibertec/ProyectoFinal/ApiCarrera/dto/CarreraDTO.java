package pe.cibertec.ProyectoFinal.ApiCarrera.dto;

import lombok.Data;
import pe.cibertec.ProyectoFinal.ApiCarrera.entity.Curso;

@Data

public class CarreraDTO {
    
    private Long id;
    private String nombre;
    private String descripcion;
    private String duracion;
    private Curso curso;
    
}
