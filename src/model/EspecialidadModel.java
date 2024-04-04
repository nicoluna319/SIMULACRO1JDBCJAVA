package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

            String sql = "INSERT INTO especialidad(nombre, descripcion) VALUES(?,?);";

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

        Especialidad especialidad = (Especialidad) object;

        Connection objConnection = ConfigDB.openConnection();

        try {
           
            String sql = "DELETE FROM especialidad WHERE id_especialidad =?";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

                objPrepare.setInt(1, especialidad.getId_especialidad());

            int filasAfectadas = objPrepare.executeUpdate();

            objPrepare.close();

            if (filasAfectadas > 0) {

                System.out.println("Registro eliminado correctamente");
                return true;
            } else {
                
                System.out.println("No se encontro ningun ID");
                return false;
            }




        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
            return false;
        } finally{
            ConfigDB.closeConnection();
        }
    }
    //obtener todas las especialidades

    @Override
    public List<Object> readAll() {

        List<Especialidad> especialidades = new ArrayList<>();

        Connection objConnection = ConfigDB.openConnection();

        try {
            

            
        } catch (Exception e) {
            // TODO: handle exception
        }



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
