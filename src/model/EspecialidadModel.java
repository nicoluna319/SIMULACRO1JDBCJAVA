package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import database.CRUD;
import database.ConfigDB;
import entity.Especialidad;

public class EspecialidadModel implements CRUD {

    @Override
    public Especialidad create(Especialidad especialidad) {

        Connection objConnection = ConfigDB.openConnection();

        try {

            String sql = "INSERT INTO especialidad(nombre, descripcion) VALUES(?,?);";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);





                                            //aqui quedé




            
        } catch (Exception e) {
            //
        }

        return especialidad;
    }

    @Override
    public boolean delete(Object object) {

        return false;
    }
    //obtener todas las especialidades

    @Override
    public List<Object> readAll() {

        return null;
    }

    @Override
    public Object readById(int id) {

        return null;
    }

    @Override
    public boolean update(Object object) {

        return false;
    }
    

    
}
