import javax.swing.JOptionPane;

import controller.EspecialidadController;

public class Main {

    public static void main(String[] args) {
        int option =0, option2 =0;

        do {
            option = Integer.parseInt(JOptionPane.showMessageDialog("""
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
                    option2 = Integer.parseInt(JOptionPane.showMessageDialog("""
                    1.Listar especialidades
                    2.crear una especialidad
                    3.Eliminar una especialidad
                    4.Actualizar una especialidad
                    5.Salir

                    Ingrese una opcion:
                    """));

                    switch(option2){
                        EspecialidadController.create();
                        break;
                    }
                    
                } while (option2 !=5);
                break;
            }
        } while (condition);
    }
}
