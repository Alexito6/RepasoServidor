package pruebasExamen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pruebasExamen.repository.AlumnoRepository;
import pruebasExamen.repository.model.Alumno;

import java.sql.SQLException;
import java.util.List;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;
    public List<Alumno> getAlumnos() throws SQLException{
        return alumnoRepository.getAlumnos();
    }
}
