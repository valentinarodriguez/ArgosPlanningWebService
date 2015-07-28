package com.suricata.argos.WS.excepciones;

/**
 * Para los errores de tipo sql, por gram�tica, etc.
 * @version 1.0
 * @created 06-Jul-2010 01:07:05
 */
public class ErrorSQLException extends Exception {

	public ErrorSQLException(){

	}

	public void finalize() throws Throwable {

	}

     /**
     * @param message the throwable message.
     * @param throwable the parent of this Throwable.
     */
    public ErrorSQLException(String message, Throwable throwable)
    {
        super(message, throwable);
    }


}