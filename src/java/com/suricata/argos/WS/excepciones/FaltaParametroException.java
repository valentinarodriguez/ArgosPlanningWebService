package com.suricata.argos.WS.excepciones;

/**
 * En caso de faltar un par�metro requerido por el procedimiento, �ste retornar�
 * un error.
 * @version 1.0
 * @created 06-Jul-2010 01:07:05
 */
public class FaltaParametroException extends Exception {

	public FaltaParametroException(){

	}

	public void finalize() throws Throwable {

	}

     /**
     * @param message the throwable message.
     * @param throwable the parent of this Throwable.
     */
    public FaltaParametroException(String message, Throwable throwable)
    {
        super(message, throwable);
    }


}