package pruebasExamen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pruebasExamen.service.AlumnoService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/prueba")
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;
    @GetMapping("/alumnos")
    public ResponseEntity<?> getAlumnos(){
        try {
            return new ResponseEntity<>(alumnoService.getAlumnos(), HttpStatus.OK);
        } catch (SQLException e) {
            Map<String, Object> response=new HashMap<>();
            response.put("code",e.getErrorCode());
            response.put(("message"),e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/alumnos/{alumno_id}")
    public ResponseEntity<?> getAlumno(@PathVariable int alumno_id){
        try {
            return new ResponseEntity<>(alumnoService.getAlumno(alumno_id),HttpStatus.OK);
        }catch (SQLException e){
            Map<String, Object> response=new HashMap<>();
            response.put("code",e.getErrorCode());
            response.put(("message"),e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
