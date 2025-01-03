package juan.estudiantes;

import java.util.List;
import java.util.Scanner;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import juan.estudiantes.modelo.Estudiante;
import juan.estudiantes.servicio.EstudianteServicio;

@SpringBootApplication
public class EstudiantesApplication implements CommandLineRunner {

	@Autowired
	private EstudianteServicio estudianteServicio;

	private static final Logger logger = LoggerFactory.getLogger(EstudiantesApplication.class);

	// Nos va a mandar a imprimir un salto de linea deṕendiendo del sistema
	// operativo
	String nl = System.lineSeparator();

	public static void main(String[] args) {
		logger.info("Iniciando la aplicacion...");

		// Con esta linea levantamos la fabrica de Spring
		SpringApplication.run(EstudiantesApplication.class, args);

		// Despues vamos a imprimir un mensaje de fin
		logger.info("Aplicacion finalizada...");
	}

	@Override
	// Metodo de instancia de esta clase
	public void run(String... args) throws Exception {

		// Vamos a ver en que momento arranca el metodo run
		logger.info(nl + "Ejecutando el metodo run!" + nl);

		var salir = false;
		var teclado = new Scanner(System.in);

		while (!salir) {
			mostrarMenu();
			salir = ejecutarOpciones(teclado);
			logger.info(nl);
		} // Fin ciclo while

	}

	private void mostrarMenu() {
		logger.info(nl);
		logger.info("""
				*** Sistema de estudiantes ***
				1. Listar Estudiantes
				2. Buscar Estudiante
				3. Agregar Estudiante
				4. Modificar Estudiante
				5. Eliminar Estudiante
				6. Salir

				Elige una opcion: """);
	}

	// Creamos un metodo que no sea estatico para poder trabajar con los atributos
	// de la clase "private EstudianteServicio estudianteServicio"
	private boolean ejecutarOpciones(Scanner teclado) {

		var opcion = Integer.parseInt(teclado.nextLine());
		var salir = false;

		switch (opcion) {
			case 1: { // Listar estudiantes

				logger.info(nl + "Listado de estudiantes: " + nl);
				List<Estudiante> estudiantes = estudianteServicio.listarEstudiantes();
				estudiantes.forEach((estudiante -> logger.info(estudiante.toString() + nl)));

				break;

			}

			case 2: { // Buscar Estudiante por id

				logger.info(nl + "Introduce el id del estudiante a buscar: ");
				var idEstudiante = Integer.parseInt(teclado.nextLine());
				Estudiante estudiante = estudianteServicio.buscarEstudianteId(idEstudiante);

				if (estudiante != null) {
					logger.info("Estudiante encontrado: " + estudiante + nl);
				} else {
					logger.info("Estudiante NO encontrado con id: " + idEstudiante + nl);
				}

				break;

			}

			case 3: { // Agregar estudiante

				logger.info("Agregar estudiante: " + nl);
				logger.info("Nombre: ");
				var nombre = teclado.nextLine();
				logger.info("Apellido: ");
				var apellido = teclado.nextLine();
				logger.info("Telefono: ");
				var telefono = teclado.nextLine();
				logger.info("Email: ");
				var email = teclado.nextLine();

				// Creamos el objeto estudiante sin el id
				var estudiante = new Estudiante();
				estudiante.setNombre(nombre);
				estudiante.setApellido(apellido);
				estudiante.setTelefono(telefono);
				estudiante.setEmail(email);

				estudianteServicio.guardarEstudiante(estudiante);
				logger.info("Estudiante agregado: " + estudiante + nl);

				break;

			}

			case 4: {

				logger.info("Modificar estudiante: " + nl);
				logger.info("Id estudiante: ");
				var idEstudiante = Integer.parseInt(teclado.nextLine());

				// Buscamos estudiante a modificar
				Estudiante estudiante = estudianteServicio.buscarEstudianteId(idEstudiante);

				if (estudiante != null) {

					logger.info("Agregar estudiante: " + nl);
					logger.info("Nombre: ");
					var nombre = teclado.nextLine();
					logger.info("Apellido: ");
					var apellido = teclado.nextLine();
					logger.info("Telefono: ");
					var telefono = teclado.nextLine();
					logger.info("Email: ");
					var email = teclado.nextLine();

					estudiante.setNombre(nombre);
					estudiante.setApellido(apellido);
					estudiante.setTelefono(telefono);
					estudiante.setEmail(email);

					estudianteServicio.guardarEstudiante(estudiante);
					logger.info("Estudiante modificado: " + estudiante + nl);

				} else {
					logger.info("Estudiante NO encontrado con el id: " + idEstudiante);
				}

				break;

			}

			case 5: { // Eliminar estudiante

				logger.info("Eliminar estudiante: " + nl);
				logger.info("Id estudiante: ");
				var idEstudiante = Integer.parseInt(teclado.nextLine());

				// Buscamos el id a buscar
				var estudiante = estudianteServicio.buscarEstudianteId(idEstudiante);

				if(estudiante != null){
					estudianteServicio.eliminarEstudiante(estudiante);
					logger.info("Estudiante eliminado: " + estudiante + nl);					
				} else {
					logger.info("Estudiante NO encontrado con id: " + idEstudiante + nl);
				}

				break;

			}

			case 6: { //Salir

				logger.info("Hasta pronto" + nl + nl);
				salir = true;

			}

			default: {
				logger.info("Opcion NO reconocida: " + opcion + nl);				
			}
				break;
		} // Fin switch

		return salir;
	}

}
