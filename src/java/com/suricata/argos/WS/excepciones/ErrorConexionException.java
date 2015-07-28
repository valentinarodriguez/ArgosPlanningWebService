package com.suricata.argos.WS.excepciones;

/**
 * Si hay un error en la conexi�n en la base de datos o alg�n problema con el WS
 * lanzar� una excepci�n.
 * @version 1.0
 * @created 06-Jul-2010 01:07:05
 */
public class ErrorConexionException extends Exception {

	public ErrorConexionException(){

	}

	public void finalize() throws Throwable {

	}

    /**
     * @param message the throwable message.
     * @param throwable the parent of this Throwable.
     */
    public ErrorConexionException(String message, Throwable throwable)
    {
        super(message, throwable);
    }

}