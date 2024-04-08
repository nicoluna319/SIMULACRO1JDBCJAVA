package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.CRUD;
import database.ConfigDB;
import entity.Especialidad;
import entity.Medico;

import javax.swing.*;

public class MedicoModel implements CRUD {

    @Override
    public Object create(Object object) {

        Connection objConnection = ConfigDB.openConnection();

        Medico objMedico = (Medico) object;

        try {

            String sql = "INSERT INTO Medico(nombre, apellidos, id_especialidad) VALUES(?,?,?);";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1,objMedico.getNombre());

            objPrepare.setString(2,objMedico.getApellidos());

            objPrepare.setInt(3,objMedico.getId_especialidad());

            objPrepare.execute();


            ResultSet objResult = objPrepare.getGeneratedKeys();

            while(objResult.next()){

                objMedico.setId_medico(objResult.getInt(1));
            }



            JOptionPane.showMessageDialog(null, "El medico fue agregado correctamente");

        }catch(Exception e){
            System.out.println("Error al insertar Medico" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return objMedico;

    }

    @Override
    public boolean delete(Object object) {

        Connection objConnection = ConfigDB.openConnection();
        Medico objMedico = (Medico) object;
        boolean isDeleted = false;
        try {
            String sql = "DELETE FROM Medico WHERE id_medico = ?;";
            PreparedStatement objprepare = objConnection.prepareStatement(sql);

            objprepare.setInt(1,objMedico.getId_medico());

            int totalAfectadas = objprepare.executeUpdate();

            if (totalAfectadas > 0){

                isDeleted = true;

                JOptionPane.showMessageDialog(null,"Registro actualizado correctamente");
            }

        }catch (SQLException e) {
            System.out.println("ERROR" + e.getMessage());
        }

        ConfigDB.closeConnection();

        return isDeleted;
    }

    @Override
    public List<Object> readAll() {

        List<Object> listMedicos = new ArrayList<>();

        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM medico \n" +
                    "INNER JOIN Especialidad ON Especialidad.id = Medico.id_especialidad;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while(objResult.next()){
            Medico objMedico = new Medico();
            Especialidad objEspecialidad = new Especialidad();

            objMedico.setId_medico(objResult.getInt("Medico.id"));
            objMedico.setNombre(objResult.getString("Medico.nombre"));
            objMedico.setApellidos(objResult.getString("Medico.apellidos"));
            objMedico.setId_especialidad(objResult.getInt("Medico.id_especialidad"));

                objEspecialidad.setId_especialidad(objResult.getInt("Especialidad.id_especialidad"));
                objEspecialidad.setNombre(objResult.getString("Especialidad.nombre"));
                objEspecialidad.setDescripcion(objResult.getString("Especialidad.descripcion"));

                objMedico.setobjEspecialidad(objEspecialidad);
                listMedicos.add (objMedico);


            }

        }catch (SQLException e){
            System.out.println("ERROR" + e.getMessage());
        }



        return null;
    }

    @Override
    public Object readById(int id) {

        return null;
    }

    @Override
    public boolean update(Object object) {
        Connection objConnection = ConfigDB.openConnection();
        Medico objMedico = (Medico) object;
        boolean isUpdated = false;

        try {
            String sql = "UPDATE FROM Medico SET nombre=?, apellidos=?, id_especialidad=?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1,objMedico.getNombre());
            objPrepare.setString(2,objMedico.getApellidos());
            objPrepare.setInt(3,objMedico.getId_especialidad());

            int totalAfectadas = objprepare.executeUpdate();

            if (totalAfectadas > 0){

                isUpdated = true;

                JOptionPane.showMessageDialog(null,"Registro actualizado correctamente");
            }

        }catch (SQLException e){
            System.out.println("ERROR" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return isUpdated;
    }
     
    


}
