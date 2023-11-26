package pe.cibertec.ProyectoFinal.ApiCarrera.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
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
import pe.cibertec.ProyectoFinal.ApiCarrera.exception.EntityNotFoundException;
import pe.cibertec.ProyectoFinal.ApiCarrera.service.CarreraService;

@RestController
@RequestMapping("api/v1/carrera")
@Slf4j

public class CarreraController {

    @Autowired

    private CarreraService carreraService;

    @GetMapping("/findAll")

    public ResponseEntity<List<Carrera>> findAll() {

        try {
            log.info("Obteniendo todas las carreras");
            return new ResponseEntity<>(carreraService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al obtener todas las carreras: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/findByCodigoC/{codigoC}")

    public ResponseEntity<Carrera> findByCodigoC(@PathVariable Long codigoC) {

        try {
            log.info("Buscando carrera por Código: {}", codigoC);
            return new ResponseEntity<>(carreraService.findByCodigoC(codigoC), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            log.error("Error al buscar carrera por Código {}: {}", codigoC, e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/findById/{id}")

    public ResponseEntity<CarreraDTO> findById(@PathVariable Long id) {

        try {
            log.info("Buscando carrera por ID: {}", id);
            return new ResponseEntity<>(carreraService.findById(id), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            log.error("Error al buscar carrera por ID {}: {}", id, e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/buscarPorId/{id}")

    public ResponseEntity<Carrera> buscarPorId(@PathVariable Long id) {

        try {
            log.info("Buscando carrera por ID: {}", id);
            return new ResponseEntity<>(carreraService.buscarPorId(id), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            log.error("Error al buscar carrera por ID {}: {}", id, e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/findByNombre/{nombre}")

    public ResponseEntity<Carrera> findByNombre(@PathVariable String nombre) {

        try {
            log.info("Buscando carrera por nombre: {}", nombre);
            return new ResponseEntity<>(carreraService.findByNombre(nombre), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            log.error("Error al buscar carrera por nombre {}: {}", nombre, e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/agregarCarrera")

    public ResponseEntity<Carrera> agregarCarrera(@RequestBody Carrera carrera) {

        try {
            log.info("Agregando nueva carrera");
            return new ResponseEntity<>(carreraService.agregarCarrera(carrera), HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error al agregar nueva carrera: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/actualizarCarrera")

    public ResponseEntity<Carrera> actualizarCarrera(@RequestBody Carrera carrera) {
        try {
            log.info("Actualizando carrera con ID: {}", carrera.getId());
            return new ResponseEntity<>(carreraService.actualizarCarrera(carrera), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            log.error("Error al actualizar carrera con ID {}: {}", carrera.getId(), e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/eliminarCarrera/{id}")

    public void eliminarCarrera(@PathVariable Long id) {

        try {
            log.info("Eliminando carrera con ID: {}", id);
            carreraService.eliminarCarrera(id);
        } catch (Exception e) {
            log.error("Error al eliminar carrera con ID {}: {}", id, e.getMessage());
        }

    }

}
