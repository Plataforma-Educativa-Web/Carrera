package pe.cibertec.ProyectoFinal.ApiCarrera.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.ProyectoFinal.ApiCarrera.entity.Carrera;

public interface CarreraRepository extends JpaRepository<Carrera, Long> {
    
    Optional<Carrera> findByNombre (String nombre);
    
}
