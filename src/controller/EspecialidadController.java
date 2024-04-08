package controller;

import javax.swing.JOptionPane;

import entity.Especialidad;
import model.EspecialidadModel;
import utils.Utils;

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

    public static void delete(){
        Object[] options = Utils.listToArray(instanceModel().readAll());
        Especialidad objSelected = (Especialidad) JOptionPane.showInputDialog(
                null,
                "Selecciona una especialidad",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        instanceModel().delete(objSelected);
    }

    public static void  update(){
        Object[] options = Utils.listToArray(instanceModel().readAll());

        Especialidad objSelected = (Especialidad) JOptionPane.showInputDialog(
                null,
                "Selecciona una especialidad para actualizar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        objSelected.setNombre(JOptionPane.showInputDialog(null,"Ingresa el nuevo nombre:",objSelected.getNombre()));
        objSelected.setDescripcion(JOptionPane.showInputDialog(null,"Ingresa el nuevo nombre:",objSelected.getDescripcion()));

        instanceModel().update(objSelected);

    }
}

