package controller;

import entity.Especialidad;
import entity.Medico;
import model.MedicoModel;
import utils.Utils;

import javax.swing.*;

import java.util.List;

import static controller.EspecialidadController.instanceModel;
import static javax.swing.JOptionPane.showInputDialog;

public class MedicoController {

    public static void getAll(){
        String list = getAll(instanceModel().readAll());

        JOptionPane.showMessageDialog(null,list);
    }


    public static String getAll(List<Object> list){
        String ListaString = "Lista de Registros: \n" ;
        for (Object temp: list){
            Medico objMedico = (Medico)temp;
            ListaString += objMedico.toString() + "\n";

        }
        return ListaString;

    }

    public static void delete(){
        Object[] options = Utils.listToArray(instanceModel().readAll());
        Medico objMedico = (Medico) JOptionPane.showInputDialog(null,
                "Seleccione el medico a eliminar: ",
                "",JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        instanceModel().delete(objMedico);

    }

    public static void update(){
        Object[] options = Utils.listToArray(instanceModel().readAll());

        Medico objMedico = (Medico) JOptionPane.showInputDialog(null,
                "Seleccione el medico a eliminar: ",
                "",JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        String nombre = showInputDialog(null, "Ingresa el nombre del medico: ", objMedico.getNombre());
        String apellidos = showInputDialog(null,"Ingrese los apellidos: ",objMedico.getApellidos());

        Object[] optionsEspecialidad = Utils.listToArray(EspecialidadController.instanceModel().readAll());

        Especialidad objEspecialidad = (Especialidad) JOptionPane.showInputDialog(null,
                "Seleccione una especialidad: ",
                "",JOptionPane.QUESTION_MESSAGE,
                null,
                optionsEspecialidad,
                optionsEspecialidad[0]);

        instanceModel().update(new Medico(name,apellidos,objEspecialidad.getId_especialidad(),objEspecialidad))

    }




    public static void create() {
        String nombre = showInputDialog("Ingresa el nombre del medico: ");
        String apellidos = showInputDialog("Ingrese los apellidos: ");

        Object[] optionsEspecialidad = Utils.listToArray(EspecialidadController.instanceModel().readAll());

        Especialidad objEspecialidad = (Especialidad) JOptionPane.showInputDialog(null,
                "Seleccione una especialidad: ",
                "",JOptionPane.QUESTION_MESSAGE,
                null,
                optionsEspecialidad,
                optionsEspecialidad[0]);

        instanceModel().create(new Medico(nombre,apellidos, objEspecialidad.getId_especialidad(), objEspecialidad));

    }

    public static MedicoModel instanceModel(){

        return new MedicoModel();
    }
}
