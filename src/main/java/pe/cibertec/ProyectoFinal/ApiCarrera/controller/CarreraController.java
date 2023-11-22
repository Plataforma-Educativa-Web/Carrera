package pe.cibertec.ProyectoFinal.ApiCarrera.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.ProyectoFinal.ApiCarrera.dto.CarreraDTO;
import pe.cibertec.ProyectoFinal.ApiCarrera.entity.Carrera;
import pe.cibertec.ProyectoFinal.ApiCarrera.entity.Curso;
import pe.cibertec.ProyectoFinal.ApiCarrera.service.ApiRestClient;
import pe.cibertec.ProyectoFinal.ApiCarrera.service.CarreraService;

@RestController
@RequestMapping("/api/v1/carrera")

public class CarreraController {

    @Autowired
    
    private CarreraService carreraService;

    @Autowired
    
    private ApiRestClient apiRestClient;
    
    @GetMapping("/findAll")
    
    public ResponseEntity<List<Carrera>> findAll() {
        
        return new ResponseEntity<>(carreraService.findAll(),HttpStatus.OK);
        
    }
    
    @GetMapping("/findAllCurso")
    
    public ResponseEntity<List<Curso>> findAllCurso() {
        
        return new ResponseEntity<>(apiRestClient.findAllCurso(),HttpStatus.OK);
        
    }
    
    
    @GetMapping("/findById/{id}")
    
    public ResponseEntity<CarreraDTO> findById(@PathVariable Long id) {
        
        return new ResponseEntity<>(carreraService.findById(id), HttpStatus.OK);
        
    }
    
    
    @GetMapping("/buscarPorId/{id}")
    
    public ResponseEntity<Carrera> buscarPorId(@PathVariable Long id) {
        
        return new ResponseEntity<>(carreraService.buscarPorId(id), HttpStatus.OK);
        
    }
    
    @GetMapping("/findByNombre/{nombre}")
    
    public ResponseEntity<Carrera> findByNombre(@PathVariable String nombre) {
        
        return new ResponseEntity<>(carreraService.findByNombre(nombre),HttpStatus.OK);
        
    }
    
    @PostMapping("/agregarCarrera")
    
    public ResponseEntity<Carrera> agregarCarrera(@RequestBody Carrera carrera) {
        
        return new ResponseEntity<>(carreraService.agregarCarrera(carrera),HttpStatus.CREATED);
        
    }
    
    @PutMapping("/actualizarCarrera")
    
    public ResponseEntity<Carrera> actualizarCarrera(@RequestBody Carrera carrera) {
        
        return new ResponseEntity<>(carreraService.actualizarCarrera(carrera),HttpStatus.OK);
        
    }
    
    @DeleteMapping("/eliminarCarrera/{id}")
    
    public void eliminarCarrera(@PathVariable Long id) {
        
        carreraService.eliminarCarrera(id);
        
    }
    
    
}
