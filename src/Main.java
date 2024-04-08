import javax.swing.JOptionPane;

import controller.EspecialidadController;
import controller.MedicoController;
import database.ConfigDB;

public class Main {

    public static void main(String[] args) {

        ConfigDB.openConnection();

        int option =0, option2 =0;

        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("""
                    1.Administrar especialidades
                    2.Administrar medicos
                    3.Administrar Pacientes
                    4.Administrar citas
                    5.Salir

                    Ingrese una opcion:
                    """));
            switch(option){
                case 1:
                do {
                    option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                    1.Listar especialidades
                    2.crear una especialidad
                    3.Eliminar una especialidadj
                    4.Actualizar una especialidad
                    5.Salir

                    Ingrese una opcion:
                    """));

                    switch(option2){

                        case 1:
                            EspecialidadController.getAll();
                            break;
                        case 2:
                        EspecialidadController.create();
                        break;
                        case 3:
                            EspecialidadController.delete();
                            break;
                        case 4:
                            EspecialidadController.update();
                            break;
                    }

                    
                } while (option2 !=5);
                break;

                case 2:do {
                    option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                        1.Listar Medicos
                        2.Crear Medicos
                        3.Borrar medico
                        4.Actualizar Medico
                        5.Salir
    
                        Ingrese una opcion:
                        """));
                    switch (option2){
                        case 1:
                            MedicoController.getAll();
                            break;
                        case 2:
                            MedicoController.create();
                            break;

                        case 3:
                            MedicoController.delete();
                            break;

                        case 4:
                            MedicoController.update();
                            break;
                    }


                }while (option !=5);
                    break;
            }
        } while (option !=5);

    }
}
