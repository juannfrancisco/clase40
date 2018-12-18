package cl.accenture.programatufuturo.ejemplo.exception;

public class SinConexionException extends Exception{

    /**
     *
     * @param message
     * @param e
     */
    public SinConexionException(String message, Throwable e){
        super(message, e);
    }
}
