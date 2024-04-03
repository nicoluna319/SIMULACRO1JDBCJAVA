package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import database.CRUD;
import database.ConfigDB;
import entity.Especialidad;

public class EspecialidadModel implements CRUD {

    @Override
    public Especialidad create(Object object) {

        Especialidad especialidad = (Especialidad) object;


        Connection objConnection = ConfigDB.openConnection();

        try {

            String sql = "INSERT INTO especialidad(nombre, descripcion) VALUES(?,?);";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1,especialidad.getNombre());

            objPrepare.setString(2,especialidad.getDescripcion());

            objPrepare.execute();


            ResultSet objResult = objPrepare.getGeneratedKeys();

                while(objResult.next()){

                    especialidad.setId_especialidad(objResult.getInt(1));
                }

                objPrepare.close();

            }catch(Exception e){
                System.out.println("Error al insertar especialidad" + e.getMessage());
            }

            ConfigDB.closeConnection();
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
