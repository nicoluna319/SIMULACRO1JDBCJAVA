package controller;

import javax.swing.JOptionPane;

import entity.Especialidad;
import model.EspecialidadModel;

public class EspecialidadController {

    public static void create() {
        String nombre = JOptionPane.showInputDialog("Ingresa el nombre de la especialidad");
        String descripcion = JOptionPane.showInputDialog("Ingresa la descripcion de la especialidad");

        instanceModel().create(new Especialidad(nombre,descripcion));
    }

    public static EspecialidadModel instanceModel(){
        return new EspecialidadModel();
    }
}
