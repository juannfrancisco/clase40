package cl.accenture.programatufuturo.ejemplo.dao;

import cl.accenture.programatufuturo.ejemplo.exception.SinConexionException;
import cl.accenture.programatufuturo.ejemplo.model.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    private Conexion conexion;

    public UsuarioDAO(){
        this.conexion = new Conexion();
    }


    public boolean login(Usuario usuario)throws SinConexionException {

        try{
            final String SQL = "select * from usuarios where " +
                    "nombre=? and password=?";

            PreparedStatement ps = conexion.obtenerConnection().prepareStatement(SQL);
            ps.setString(1, usuario.getNombre() );
            ps.setString(2, usuario.getPassword() );

            ResultSet rs = ps.executeQuery();
            return rs.next();

        }catch (SQLException e){
            return false;
        }
    }
}
