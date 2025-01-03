// Paquete donde se encuentra la clase EstudiantesApplication
package juan.estudiantes;

// Importamos las clases necesarias para la aplicación
import java.util.List;
import java.util.Scanner;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Importamos las clases del modelo y servicio
import juan.estudiantes.modelo.Estudiante;
import juan.estudiantes.servicio.EstudianteServicio;

// Anotación que indica que esta clase es la aplicación principal de Spring Boot
@SpringBootApplication
public class EstudiantesApplication implements CommandLineRunner {

	// Inyectamos la dependencia del servicio EstudianteServicio
	@Autowired
	private EstudianteServicio estudianteServicio;

	// Creamos un logger para la aplicación
	private static final Logger logger = LoggerFactory.getLogger(EstudiantesApplication.class);

	// Obtenemos el salto de línea dependiendo del sistema operativo
	String nl = System.lineSeparator();

	// Método principal de la aplicación
	public static void main(String[] args) {
		// Imprimimos un mensaje de inicio de la aplicación
		logger.info("Iniciando la aplicación...");

		// Iniciamos la aplicación de Spring Boot
		SpringApplication.run(EstudiantesApplication.class, args);

		// Imprimimos un mensaje de fin de la aplicación
		logger.info("Aplicación finalizada...");
	}

	// Método que se ejecuta después de iniciar la aplicación
	@Override
	public void run(String... args) throws Exception {
		// Imprimimos un mensaje de inicio del método run
		logger.info(nl + "Ejecutando el método run!" + nl);

		// Variables para controlar el ciclo de la aplicación
		var salir = false;
		var teclado = new Scanner(System.in);

		// Ciclo principal de la aplicación
		while (!salir) {
			// Mostramos el menú de opciones
			mostrarMenu();

			// Ejecutamos la opción seleccionada
			salir = ejecutarOpciones(teclado);

			// Imprimimos un salto de línea
			logger.info(nl);
		} // Fin ciclo while
	}

	// Método que muestra el menú de opciones
	private void mostrarMenu() {
		// Imprimimos el menú de opciones
		logger.info(nl);
		logger.info("""
				*** Sistema de estudiantes ***
				1. Listar Estudiantes
				2. Buscar Estudiante
				3. Agregar Estudiante
				4. Modificar Estudiante
				5. Eliminar Estudiante
				6. Salir

				Elige una opción: """);
	}

	// Método que ejecuta las opciones del menú
	private boolean ejecutarOpciones(Scanner teclado) {

		// Leemos la opción seleccionada por el usuario
		var opcion = Integer.parseInt(teclado.nextLine());
		var salir = false;

		// Utilizamos un switch para ejecutar la opción seleccionada
		switch (opcion) {
			case 1: { // Listar estudiantes

				// Imprimimos el título de la lista de estudiantes
				logger.info(nl + "Listado de estudiantes: " + nl);

				// Obtenemos la lista de estudiantes del servicio
				List<Estudiante> estudiantes = estudianteServicio.listarEstudiantes();

				// Imprimimos cada estudiante de la lista
				estudiantes.forEach((estudiante -> logger.info(estudiante.toString() + nl)));

				// Salimos del caso
				break;

			}

			case 2: { // Buscar Estudiante por id

				// Pedimos al usuario que ingrese el id del estudiante a buscar
				logger.info(nl + "Introduce el id del estudiante a buscar: ");
				var idEstudiante = Integer.parseInt(teclado.nextLine());

				// Buscamos el estudiante con el id ingresado
				Estudiante estudiante = estudianteServicio.buscarEstudianteId(idEstudiante);

				// Si se encuentra el estudiante, lo imprimimos
				if (estudiante != null) {
					logger.info("Estudiante encontrado: " + estudiante + nl);
				} else {
					logger.info("Estudiante NO encontrado con id: " + idEstudiante + nl);
				}

				// Salimos del caso
				break;

			}

			case 3: { // Agregar estudiante

				// Imprimimos el título de agregar estudiante
				logger.info("Agregar estudiante: " + nl);

				// Pedimos al usuario que ingrese los datos del estudiante
				logger.info("Nombre: ");
				var nombre = teclado.nextLine();
				logger.info("Apellido: ");
				var apellido = teclado.nextLine();
				logger.info("Telefono: ");
				var telefono = teclado.nextLine();
				logger.info("Email: ");
				var email = teclado.nextLine();

				// Creamos un nuevo objeto estudiante con los datos ingresados
				var estudiante = new Estudiante();
				estudiante.setNombre(nombre);
				estudiante.setApellido(apellido);
				estudiante.setTelefono(telefono);
				estudiante.setEmail(email);

				// Guardamos el estudiante en el servicio
				estudianteServicio.guardarEstudiante(estudiante);

				// Imprimimos el estudiante agregado
				logger.info("Estudiante agregado: " + estudiante + nl);

				// Salimos del caso
				break;

			}

			case 4: { // Modificar estudiante

				// Imprimimos el título de modificar estudiante
				logger.info("Modificar estudiante: " + nl);

				// Pedimos al usuario que ingrese el id del estudiante a modificar
				logger.info("Id estudiante: ");
				var idEstudiante = Integer.parseInt(teclado.nextLine());

				// Buscamos el estudiante con el id ingresado
				Estudiante estudiante = estudianteServicio.buscarEstudianteId(idEstudiante);

				// Si se encuentra el estudiante, lo modificamos
				if (estudiante != null) {

					// Pedimos al usuario que ingrese los nuevos datos del estudiante
					logger.info("Agregar estudiante: " + nl);
					logger.info("Nombre: ");
					var nombre = teclado.nextLine();
					logger.info("Apellido: ");
					var apellido = teclado.nextLine();
					logger.info("Telefono: ");
					var telefono = teclado.nextLine();
					logger.info("Email: ");
					var email = teclado.nextLine();

					// Modificamos los datos del estudiante
					estudiante.setNombre(nombre);
					estudiante.setApellido(apellido);
					estudiante.setTelefono(telefono);
					estudiante.setEmail(email);

					// Guardamos los cambios en el servicio
					estudianteServicio.guardarEstudiante(estudiante);

					// Imprimimos el estudiante modificado
					logger.info("Estudiante modificado: " + estudiante + nl);

				} else {
					logger.info("Estudiante NO encontrado con el id: " + idEstudiante);
				}

				// Salimos del caso
				break;

			}

			// Caso 5: Eliminar estudiante
			case 5: {

				// Imprimimos el título de eliminar estudiante
				logger.info("Eliminar estudiante: " + nl);

				// Pedimos al usuario que ingrese el id del estudiante a eliminar
				logger.info("Id estudiante: ");
				var idEstudiante = Integer.parseInt(teclado.nextLine());

				// Buscamos el estudiante con el id ingresado
				var estudiante = estudianteServicio.buscarEstudianteId(idEstudiante);

				// Si se encuentra el estudiante, lo eliminamos
				if (estudiante != null) {
					// Llamamos al método eliminarEstudiante del servicio
					estudianteServicio.eliminarEstudiante(estudiante);

					// Imprimimos un mensaje de confirmación
					logger.info("Estudiante eliminado: " + estudiante + nl);
				} else {
					// Si no se encuentra el estudiante, imprimimos un mensaje de error
					logger.info("Estudiante NO encontrado con id: " + idEstudiante + nl);
				}

				// Salimos del caso
				break;
			}

			// Caso 6: Salir
			case 6: {

				// Imprimimos un mensaje de despedida
				logger.info("Hasta pronto" + nl + nl);

				// Establecemos la variable salir en true para salir del ciclo
				salir = true;

				// Salimos del caso
				break;
			}

			// Caso default: Opción no reconocida
			default: {
				// Imprimimos un mensaje de error
				logger.info("Opcion NO reconocida: " + opcion + nl);
			}
				break;

			// Fin del switch
		}
		// Retornamos el valor de la variable salir
		return salir;
	}
}
