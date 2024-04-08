package model;

import database.CRUD;
import database.ConfigDB;
import entity.Especialidad;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
   



    //obtener todas las especialidades

    @Override
    public List<Object> readAll() {

       List<Object> ListEspecialidades = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM Especialidad;";
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
    public boolean delete(Object object) {

        Connection objConnection = ConfigDB.openConnection();

        Especialidad objEspecialidad = (Especialidad) object;

        boolean isDeleted = false;

        try {
            String sql = "DELETE FROM Especialidad WHERE id_especialidad = ?;";
            PreparedStatement objprepare = objConnection.prepareStatement(sql);

            objprepare.setInt(1,objEspecialidad.getId_especialidad());

            int totalAfectadas = objprepare.executeUpdate();

            if (totalAfectadas > 0){
                isDeleted = true;
                JOptionPane.showMessageDialog(null,"Registro eliminado correctamente");
            }
        }catch (SQLException e) {

            System.out.println("ERROR > " + e.getMessage());
        }

        ConfigDB.closeConnection();

        return isDeleted;
    }


    @Override
    public boolean update(Object object) {

        Connection objConnection = ConfigDB.openConnection();
        Especialidad especialidad = (Especialidad) object;

        boolean isUpdated = false;

        try {
            String sql = "UPDATE Especialidad SET nombre = ?, descripcion = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1,especialidad.getNombre());

            objPrepare.setString(2,especialidad.getDescripcion());

            int totalAfectadas = objPrepare.executeUpdate();
            if (totalAfectadas > 0){
                isUpdated = true;
                JOptionPane.showMessageDialog(null,"El registro fue actualizado correctamente");

            }



        }catch (SQLException e){
            System.out.println("ERROR" + e.getMessage());
        }
        ConfigDB.closeConnection();
        return isUpdated;
    }

    @Override
    public Object readById(int id) {

        return null;
    }
    

    
}
