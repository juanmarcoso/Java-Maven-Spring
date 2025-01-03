// Paquete donde se encuentra la clase Estudiante
package juan.estudiantes.modelo;

// Importamos las anotaciones necesarias para la configuración de la entidad
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Importamos las anotaciones de Lombok para reducir el boilerplate
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// Anotación que indica que esta clase es una entidad de la base de datos
@Entity

// Anotación que genera el código getter y setter para los atributos de la clase
@Data 

// Anotación que genera un constructor vacío para la clase
@NoArgsConstructor

// Anotación que genera un constructor con todos los atributos de la clase
@AllArgsConstructor

// Anotación que genera el método toString() para la clase
@ToString

public class Estudiante {

    // Atributo que representa la llave primaria de la tabla Estudiante
    // Anotación que indica que este atributo es la llave primaria
    @Id 
    
    // Anotación que asigna un valor automático a la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstudiante;

    // Atributos que representan los campos de la tabla Estudiante
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

}
