package pruebasExamen.repository.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Alumno {
    private int alumno_id;
    private String nombre;
    private String apellido;
    private Date fecha_nacimiento;
    private String curso;
}
