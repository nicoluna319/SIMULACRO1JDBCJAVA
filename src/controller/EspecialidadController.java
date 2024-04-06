package controller;

import javax.swing.JOptionPane;

import entity.Especialidad;
import model.EspecialidadModel;

import java.awt.*;
import java.util.List;

public class EspecialidadController {

    public static void create() {
        String nombre = JOptionPane.showInputDialog("Ingresa el nombre de la especialidad");
        String descripcion = JOptionPane.showInputDialog("Ingresa la descripcion de la especialidad");

        instanceModel().create(new Especialidad(nombre,descripcion));
    }



    public static void getAll(){
        String list = getAll(instanceModel().readAll());

        JOptionPane.showMessageDialog(null,list);
    }

    public static String getAll(List<Object> list){

        String ListaString = "Lista de Registros: \n" ;
                 for (Object temp: list){
                Especialidad objEspecialidad = (Especialidad)temp;
                ListaString += objEspecialidad.toString() + "\n";

                 }
                 return ListaString;
    }
    public static EspecialidadModel instanceModel(){
        return new EspecialidadModel();
    }
}
