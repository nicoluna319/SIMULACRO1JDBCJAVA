package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {

    static Connection objConnection = null;

    public static Connection openConnection(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/hospital";
            String user = "root";
            String password = "";

            objConnection = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Me conecté perfectamente");

        }catch(ClassNotFoundException e){
            System.out.println("Error Driver no instalado");
        }catch(SQLException e){
            System.out.println("Error No se pudo establecer la conexion con la DB" + e.getMessage()); 
        }

        return objConnection;
    }

    public static void closeConnection(){
        try {
            if (objConnection != null) objConnection.close();
            
        } catch (SQLException e) {
           System.out.println(e.getMessage());
        }
    }
}
