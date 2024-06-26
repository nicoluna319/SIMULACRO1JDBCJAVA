package entity;

public class Medico {

    private int id_medico;
    private String nombre;
    private String apellidos;
    private int id_especialidad;

    private Especialidad especialidad;


    public Medico() {

    }

    public Medico(int id_medico, String nombre, String apellidos, int id_especialidad, Especialidad especialidad) {
        this.id_medico = id_medico;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.id_especialidad = id_especialidad;
        this.especialidad = especialidad;
    }

    public Medico(String nombre, String apellidos, int idEspecialidad, Especialidad objEspecialidad) {

    }


    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
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

    public int getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(int id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Medico [id_medico=" + id_medico + ", nombre=" + nombre + ", apellidos=" + apellidos
                + ", id_especialidad=" + id_especialidad + "Especialidad" + this.especialidad.getNombre() + "]";
    }
    
    


}
