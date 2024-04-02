package database;

import java.util.List;

public interface CRUD {

    //Crear
    public Object create(Object object);

    //consultar

    public List<Object> readAll();
    public Object readById(int id);

    //modificar

    public boolean update(Object object);

    //eliminar

    public boolean delete(Object object);

    
}