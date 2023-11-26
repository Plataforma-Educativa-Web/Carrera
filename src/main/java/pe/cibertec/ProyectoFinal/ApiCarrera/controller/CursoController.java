package pe.cibertec.ProyectoFinal.ApiCarrera.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.ProyectoFinal.ApiCarrera.entity.Curso;
import pe.cibertec.ProyectoFinal.ApiCarrera.restClient.CursoRestClient;

@RestController
@RequestMapping("api/v1/curso")
@Slf4j

public class CursoController {

    @Autowired

    private CursoRestClient apiRestClient;

    @GetMapping("/findAllCurso")

    public ResponseEntity<List<Curso>> findAllCurso() {

        try {
            log.info("Obteniendo todos los cursos");
            return new ResponseEntity<>(apiRestClient.findAllCurso(), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al obtener todos los cursos: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
