package pruebasExamen.repository;

import org.springframework.stereotype.Repository;
import pruebasExamen.repository.model.Alumno;
import pruebasExamen.repository.model.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AlumnoRepository {
    public List<Alumno> getAlumnos() throws SQLException {
        List<Alumno> alumnos=new ArrayList<>();
        String query="SELECT * FROM ALUMNO";
        try (Connection connection= DataSource.getMyDataSource().getConnection();
             Statement statement=connection.createStatement();
             ResultSet rs=statement.executeQuery(query)){
            while (rs.next()){
                alumnos.add(Alumno.builder().alumno_id(rs.getInt(1))
                        .nombre(rs.getString(2))
                        .apellido(rs.getString(3))
                        .fecha_nacimiento(rs.getDate(4))
                        .curso(rs.getString(5))
                        .build()
                );
            }
        }
        return alumnos;
    }
    public Alumno getAlumno(int alumno_id)throws SQLException{
        Alumno alumno=null;
        String query="SELECT * FROM ALUMNO WHERE alumno_id=?";
        try (Connection connection=DataSource.getMyDataSource().getConnection();
             PreparedStatement ps=connection.prepareStatement(query)){
            ps.setInt(1,alumno_id);
            ResultSet rs= ps.executeQuery();
            if (rs.next()){
                alumno=Alumno.builder().alumno_id(rs.getInt(1))
                        .nombre(rs.getString(2))
                        .apellido(rs.getString(3))
                        .fecha_nacimiento(rs.getDate(4))
                        .curso(rs.getString(5))
                        .build();
            }
        }
        return alumno;
    }
}
