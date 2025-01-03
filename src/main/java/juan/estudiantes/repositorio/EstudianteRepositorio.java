package juan.estudiantes.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import juan.estudiantes.modelo.Estudiante;

public interface EstudianteRepositorio extends JpaRepository<Estudiante, Integer>{

}
