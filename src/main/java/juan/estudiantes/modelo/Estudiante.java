package juan.estudiantes.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
// boilerplate - codigo repetitivo
// codigo get & set agregados:
@Data 
// Constructor vacio:
@NoArgsConstructor
// Agregamos el constructor con todos los argumentos: 
@AllArgsConstructor
@ToString

public class Estudiante {

    // Para declarar que es la llave primaria
    @Id 
    // Para asignarle valor a la llave primaria de forma automatica
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstudiante;

    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

}
