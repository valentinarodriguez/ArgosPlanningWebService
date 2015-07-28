/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.dao.seguridad;

import com.suricata.argos.WS.entidades.Documento;
import com.suricata.argos.WS.excepciones.ErrorSQLException;

/**
 *
 * @author Valentina
 */
public interface DocumentoDao {

    Documento obtenerDocumento(String nombre) throws ErrorSQLException;

}
