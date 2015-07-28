/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.excepciones;

/**
 *
 * @author Valentina
 */
public class TipoDatosException extends Exception {

    public TipoDatosException(){

    }

    public void finalize() throws Throwable {

    }

     /**
     * @param message the throwable message.
     * @param throwable the parent of this Throwable.
     */
    public TipoDatosException(String message, Throwable throwable)
    {
        super(message, throwable);
    }

}
