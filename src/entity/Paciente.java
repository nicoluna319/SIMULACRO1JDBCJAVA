package entity;

import java.sql.Date;

public class Paciente {
    
    private int id_paciente;
    private String nombre;
    private String apellidos;
    private Date fecha_nacimiento;
    private String documento_identidad;
    
    public Paciente(int id_paciente, String nombre, String apellidos, Date fecha_nacimiento,
            String documento_identidad) {
        this.id_paciente = id_paciente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.documento_identidad = documento_identidad;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDocumento_identidad() {
        return documento_identidad;
    }

    public void setDocumento_identidad(String documento_identidad) {
        this.documento_identidad = documento_identidad;
    }

    @Override
    public String toString() {
        return "Paciente [id_paciente=" + id_paciente + ", nombre=" + nombre + ", apellidos=" + apellidos
                + ", fecha_nacimiento=" + fecha_nacimiento + ", documento_identidad=" + documento_identidad + "]";
    }

    
    
    
    
}
