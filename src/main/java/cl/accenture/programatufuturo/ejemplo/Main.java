package cl.accenture.programatufuturo.ejemplo;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Main {

    public static void main( String[] args ){

        try{

            //Incluir codigo nuevo
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection =
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/people",
                            "root",
                            "my-secret-pw");

            String nombre = JOptionPane.showInputDialog("Ingrese el nombre de usuario");
            String password = JOptionPane.showInputDialog("Ingrese password de usuario");


            PreparedStatement ps = connection.prepareStatement("select * from usuarios where " +
                    "nombre=? and password=?");
            ps.setString(1, nombre);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next() ){
                JOptionPane.showMessageDialog(null, "Login Correcto");
            }else{
                JOptionPane.showMessageDialog(null, "Login Incorrecto");
            }



        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }



    }


    public static void loginInseguro( String nombre, String password, Connection connection) throws Exception{
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select * from usuarios where " +
                "nombre='"+nombre+"' and password='"+password+"'");

        if(rs.next() ){
            JOptionPane.showMessageDialog(null, "Login Correcto");
        }else{
            JOptionPane.showMessageDialog(null, "Login Incorrecto");
        }

    }



}
