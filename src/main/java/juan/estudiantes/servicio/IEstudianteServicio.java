// Paquete donde se encuentra la interfaz IEstudianteServicio
package juan.estudiantes.servicio;

// Importamos la clase List de Java para trabajar con colecciones
import java.util.List;

// Importamos la clase Estudiante del modelo
import juan.estudiantes.modelo.Estudiante;

// Interfaz que define el servicio para la entidad Estudiante
public interface IEstudianteServicio {

    // Método que lista todos los estudiantes
    public List<Estudiante> listarEstudiantes();

    // Método que busca un estudiante por su ID
    public Estudiante buscarEstudianteId(Integer idEstudiante);

    // Método que guarda un estudiante en la base de datos
    public void guardarEstudiante(Estudiante estudiante);

    // Método que elimina un estudiante de la base de datos
    public void eliminarEstudiante(Estudiante estudiante);
    
}