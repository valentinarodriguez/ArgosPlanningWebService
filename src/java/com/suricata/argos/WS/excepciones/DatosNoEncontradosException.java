package com.suricata.argos.WS.excepciones;

/**
 * Devuleve una excepci�n en caso de no encontrarse datos.
 * @version 1.0
 * @created 06-Jul-2010 01:07:05
 */
public class DatosNoEncontradosException extends  Exception {

	public DatosNoEncontradosException(){

	}

	public void finalize() throws Throwable {

	}

     /**
     * @param message the throwable message.
     * @param throwable the parent of this Throwable.
     */
    public DatosNoEncontradosException(String message, Throwable throwable)
    {
        super(message, throwable);
    }
}