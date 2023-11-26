package pe.cibertec.ProyectoFinal.ApiCarrera.serviceImpl;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.ProyectoFinal.ApiCarrera.dao.CarreraRepository;
import pe.cibertec.ProyectoFinal.ApiCarrera.dto.CarreraDTO;
import pe.cibertec.ProyectoFinal.ApiCarrera.entity.Carrera;
import pe.cibertec.ProyectoFinal.ApiCarrera.entity.Curso;
import pe.cibertec.ProyectoFinal.ApiCarrera.exception.EntityNotFoundException;
import pe.cibertec.ProyectoFinal.ApiCarrera.service.CarreraService;
import pe.cibertec.ProyectoFinal.ApiCarrera.restClient.CursoRestClient;

@Service
@Slf4j

public class CarreraServiceImpl implements CarreraService {

    @Autowired

    private CarreraRepository carreraRepository;

    @Autowired

    private CursoRestClient apiRestClient;

    @Override
    public List<Carrera> findAll() {
        log.info("Obteniendo todas las carreras");

        return (List<Carrera>) carreraRepository.findAll();

    }

    public List<Curso> findAllCurso() {
        log.info("Obteniendo todos los cursos");

        return (List<Curso>) apiRestClient.findAllCurso();

    }

    @Override
    public CarreraDTO findById(Long id) {
        log.info("Obteniendo todos los cursos");

        Carrera carrera = carreraRepository.findById(id).get();

        Curso curso = apiRestClient.findByCodigo(carrera.getCodigo());

        CarreraDTO carreraDTO = new CarreraDTO();

        carreraDTO.setId(carrera.getId());
        carreraDTO.setCodigoC(carrera.getCodigoC());
        carreraDTO.setNombre(carrera.getNombre());
        carreraDTO.setDescripcion(carrera.getDescripcion());
        carreraDTO.setDuracion(carrera.getDuracion());
        carreraDTO.setCurso(curso);

        return carreraDTO;

    }

    @Override
    public Carrera buscarPorId(Long id) {
        log.info("Buscando carrera por ID: {}", id);

        return carreraRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Carrera no encontrada con el id " + id.toString()));

    }

    @Override
    public Carrera findByNombre(String nombre) {
        log.info("Buscando carrera por nombre: {}", nombre);

        return carreraRepository.findByNombre(nombre).orElseThrow(() -> new EntityNotFoundException("Carrera no encontrada con el nombre" + nombre.toString()));
    }

    @Override
    public Carrera agregarCarrera(Carrera carrera) {
        log.info("Agregando nueva carrera");

        return carreraRepository.save(carrera);

    }

    @Override
    public Carrera actualizarCarrera(Carrera carrera) {
        log.info("Actualizando carrera con ID: {}", carrera.getId());

        var CarreraF = carreraRepository.findById(carrera.getId()).get();
        CarreraF.setCodigoC(carrera.getCodigoC());
        CarreraF.setCodigo(carrera.getCodigo());
        CarreraF.setNombre(carrera.getNombre());
        CarreraF.setDescripcion(carrera.getDescripcion());
        CarreraF.setDuracion(carrera.getDuracion());

        return carreraRepository.save(CarreraF);

    }

    @Override
    public void eliminarCarrera(Long id) {
        log.info("Eliminando carrera con ID: {}", id);

        var CarreraF = carreraRepository.findById(id).get();

        carreraRepository.delete(CarreraF);

    }

    @Override
    public Carrera findByCodigoC(Long codigoC) {
        log.info("Buscando carrera por Código: {}", codigoC);

        return carreraRepository.findByCodigoC(codigoC).orElseThrow(() -> new EntityNotFoundException("Carrera no encontrada con el Codigo" + codigoC.toString()));

    }

}
