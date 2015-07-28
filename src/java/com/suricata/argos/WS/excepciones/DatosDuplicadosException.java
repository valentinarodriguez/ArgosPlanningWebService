/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.excepciones;

/**
 *
 * @author Valentina
 */
public class DatosDuplicadosException extends Exception {

	public DatosDuplicadosException(){

	}

	public void finalize() throws Throwable {

	}

     /**
     * @param message the throwable message.
     * @param throwable the parent of this Throwable.
     */
    public DatosDuplicadosException(String message, Throwable throwable)
    {
        super(message, throwable);
    }

       /**
     * @param message the throwable message.
     */
    public DatosDuplicadosException(String message)
    {
        super(message);
    }
}
