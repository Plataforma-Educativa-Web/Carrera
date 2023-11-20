package pe.cibertec.ProyectoFinal.ApiCarrera.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.ProyectoFinal.ApiCarrera.dao.CarreraRepository;
import pe.cibertec.ProyectoFinal.ApiCarrera.entity.Carrera;
import pe.cibertec.ProyectoFinal.ApiCarrera.exception.EntityNotFoundException;
import pe.cibertec.ProyectoFinal.ApiCarrera.service.CarreraService;

@Service

public class CarreraServiceImpl implements CarreraService{
    
    @Autowired
    
    private CarreraRepository carreraRepository;

    @Override
    public List<Carrera> findAll() {
        
        return (List<Carrera>) carreraRepository.findAll();
        
    }

    @Override
    public Carrera buscarPorId(Long id) {
        
        return carreraRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Carrera no encontrada con el id "+id.toString()));
        
    }

    @Override
    public Carrera findByNombre(String nombre) {
        return carreraRepository.findByNombre(nombre).orElseThrow(() -> new EntityNotFoundException("Carrera no encontrada con el nombre"+nombre.toString()));
    }

    @Override
    public Carrera agregarCarrera(Carrera carrera) {
        
        return carreraRepository.save(carrera);
        
    }

    @Override
    public Carrera actualizarCarrera(Carrera carrera) {
        
        var CarreraF = carreraRepository.findById(carrera.getId()).get();
        CarreraF.setNombre(carrera.getNombre());
        CarreraF.setDescripcion(carrera.getDescripcion());
        CarreraF.setDuracion(carrera.getDuracion());
        
        return carreraRepository.save(CarreraF);
        
    }

    @Override
    public void eliminarCarrera(Long id) {
        
        var CarreraF = carreraRepository.findById(id).get();
        
        carreraRepository.delete(CarreraF);
        
    }


    
}
