// Paquete donde se encuentra la clase EstudianteServicio
package juan.estudiantes.servicio;

// Importamos la clase List de Java para trabajar con colecciones
import java.util.List;

// Importamos las anotaciones de Spring para la inyección de dependencias y la configuración del servicio
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Importamos la clase Estudiante del modelo
import juan.estudiantes.modelo.Estudiante;

// Importamos la interfaz EstudianteRepositorio para la interacción con la base de datos
import juan.estudiantes.repositorio.EstudianteRepositorio;

// Anotación que indica que esta clase es un servicio de Spring
@Service 
public class EstudianteServicio implements IEstudianteServicio{

    // Anotación que inyecta la dependencia del EstudianteRepositorio
    @Autowired
    private EstudianteRepositorio estudianteRepositorio;

    // Método que lista todos los estudiantes
    @Override
    public List<Estudiante> listarEstudiantes() {
        // Utilizamos el método findAll() del EstudianteRepositorio para obtener la lista de estudiantes
        List<Estudiante> estudiantes = estudianteRepositorio.findAll();
        return estudiantes;
    }

    // Método que busca un estudiante por su ID
    @Override
    public Estudiante buscarEstudianteId(Integer idEstudiante) {
        // Utilizamos el método findById() del EstudianteRepositorio para obtener el estudiante con el ID especificado
        // Si no se encuentra el estudiante, devuelve null
        Estudiante estudiante = estudianteRepositorio.findById(idEstudiante).orElse(null);
        return estudiante;
    }

    // Método que guarda un estudiante en la base de datos
    @Override
    public void guardarEstudiante(Estudiante estudiante) {
        // Utilizamos el método save() del EstudianteRepositorio para guardar el estudiante
        estudianteRepositorio.save(estudiante);
    }

    // Método que elimina un estudiante de la base de datos
    @Override
    public void eliminarEstudiante(Estudiante estudiante) {
        // Utilizamos el método delete() del EstudianteRepositorio para eliminar el estudiante
        estudianteRepositorio.delete(estudiante);
    }
}