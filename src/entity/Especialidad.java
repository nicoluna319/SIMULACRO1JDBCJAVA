package entity;

public class Especialidad {
    
    private int id_especialidad;
    private String nombre;
    private String descripcion;


    public Especialidad(int id_especialidad, String nombre, String descripcion) {
      
        this.nombre = nombre;
        this.descripcion = descripcion;
    }


    public int getId_especialidad() {
        return id_especialidad;
    }


    public void setId_especialidad(int id_especialidad) {
        this.id_especialidad = id_especialidad;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    @Override
    public String toString() {
        return "Especialidad [id_especialidad=" + id_especialidad + ", nombre=" + nombre + ", descripcion="
                + descripcion + "]";
    }

    


    
   
    

    
}
