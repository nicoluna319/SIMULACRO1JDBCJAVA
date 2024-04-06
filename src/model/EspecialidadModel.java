package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.CRUD;
import database.ConfigDB;
import entity.Especialidad;

public class EspecialidadModel implements CRUD {

    @Override
    public Especialidad create(Object object) {

       
        
        Connection objConnection = ConfigDB.openConnection();

        Especialidad especialidad = (Especialidad) object;

        try {

            String sql = "INSERT INTO Especialidad(nombre, descripcion) VALUES(?,?);";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1,especialidad.getNombre());

            objPrepare.setString(2,especialidad.getDescripcion());

            objPrepare.execute();


            ResultSet objResult = objPrepare.getGeneratedKeys();

                while(objResult.next()){

                    especialidad.setId_especialidad(objResult.getInt(1));
                }

                JOptionPane.showMessageDialog(null, "La especialidad fue agregada correctamente");

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

       List<Object> ListEspecialidades = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM especialidad;";
        PreparedStatement objprepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objprepare.executeQuery();

            while(objResult.next()){
                Especialidad objEspecialidad = new Especialidad();

                objEspecialidad.setId_especialidad(objResult.getInt("id_especialidad"));
                objEspecialidad.setNombre(objResult.getString("nombre"));
                objEspecialidad.setDescripcion(objResult.getString("descripcion"));

                ListEspecialidades.add(objEspecialidad);
            }


        } catch (SQLException e) {
            System.out.println("ERROR > " + e.getMessage());
        }

        ConfigDB.closeConnection();


        return ListEspecialidades;
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
