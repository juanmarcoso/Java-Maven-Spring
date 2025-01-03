// Paquete donde se encuentra la interfaz EstudianteRepositorio
package juan.estudiantes.repositorio;

// Importamos la interfaz JpaRepository de Spring Data JPA
import org.springframework.data.jpa.repository.JpaRepository;

// Importamos la clase Estudiante del modelo
import juan.estudiantes.modelo.Estudiante;

// Interfaz que define el repositorio para la entidad Estudiante
// Extiende de JpaRepository para heredar sus métodos CRUD
public interface EstudianteRepositorio extends JpaRepository<Estudiante, Integer> {

    // No es necesario agregar métodos aquí, ya que JpaRepository proporciona métodos CRUD básicos
    // Sin embargo, se pueden agregar métodos personalizados para consultas específicas
    // Por ejemplo: @Query("SELECT e FROM Estudiante e")
    // List<Estudiante> listarEstudiantes();

}