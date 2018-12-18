package cl.accenture.programatufuturo.ejemplo.dao;

import cl.accenture.programatufuturo.ejemplo.exception.SinConexionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String DRIVER =  "com.mysql.jdbc.Driver";
    private static final int PORT = 3306;
    private static final String HOST = "locahost";
    private static final String DATABASE = "people";
    private static final String USER = "root";
    private static final String PASSWORD = "my-secret-pw";


    public Connection obtenerConnection() throws SinConexionException{
        try{
            Class.forName(DRIVER);
            Connection connection =
                    DriverManager.getConnection(
                            "jdbc:mysql://"+HOST+":"+PORT+"/" + DATABASE,
                            USER,
                            PASSWORD);
            return connection;

        }catch (ClassNotFoundException e){
            throw new SinConexionException("El driver no se ha cargado correctamente", e);

        }catch (SQLException e){
            throw new SinConexionException("Ocurrio un error al establecer la conexion : " + e.getMessage(), e);
        }
    }
}
