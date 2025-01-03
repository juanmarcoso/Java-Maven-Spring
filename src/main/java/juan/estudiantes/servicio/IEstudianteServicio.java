package juan.estudiantes.servicio;

import java.util.List;

import juan.estudiantes.modelo.Estudiante;

public interface IEstudianteServicio {

    public List<Estudiante> listarEstudiantes();

    public Estudiante buscarEstudianteId(Integer idEstudiante);

    public void guardarEstudiante(Estudiante estudiante);

    public void eliminarEstudiante(Estudiante estudiante);
    
}
