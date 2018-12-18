package cl.accenture.programatufuturo.ejemplo;

import cl.accenture.programatufuturo.ejemplo.dao.UsuarioDAO;
import cl.accenture.programatufuturo.ejemplo.model.Usuario;

import javax.swing.*;

public class Programa {

    public static void main(String[] args){
        try{
            String nombre = JOptionPane.showInputDialog("Nombre de usuario");
            String password = JOptionPane.showInputDialog("Contraseña");

            Usuario usuario = new Usuario(nombre, password);
            UsuarioDAO dao = new UsuarioDAO();
            boolean isValid = dao.login( usuario );

            if( isValid ){
                JOptionPane.showMessageDialog(null, "Login Correcto");
            }else{
                JOptionPane.showMessageDialog(null, "Login Incorrecto");
            }

        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Ocurrio un error " + ex.getMessage());
        }
    }
}
