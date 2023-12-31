package pe.cibertec.ProyectoFinal.ApiCarrera.service;

import java.util.List;
import pe.cibertec.ProyectoFinal.ApiCarrera.dto.CarreraDTO;
import pe.cibertec.ProyectoFinal.ApiCarrera.entity.Carrera;

public interface CarreraService {

    public List<Carrera> findAll();
    
    public CarreraDTO findById(Long id);
    
    public Carrera findByCodigoC(Long codigoC);
    
    public Carrera buscarPorId(Long id);

    public Carrera findByNombre(String nombre);

    public Carrera agregarCarrera(Carrera carrera);

    public Carrera actualizarCarrera(Carrera carrera);

    public void eliminarCarrera(Long id);

}
