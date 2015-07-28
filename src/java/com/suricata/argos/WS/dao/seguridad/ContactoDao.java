/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.dao.seguridad;

import com.suricata.argos.WS.entidades.Contacto;
import com.suricata.argos.WS.excepciones.DatosDuplicadosException;
import com.suricata.argos.WS.excepciones.ErrorSQLException;
import java.util.List;

/**
 *
 * @author Valentina
 */
public interface ContactoDao {

    void crearContacto(Contacto Contacto) throws ErrorSQLException;

    void borrarContacto(Contacto Contacto) throws ErrorSQLException;

    List<Contacto>  listarContactos() throws ErrorSQLException;

    Contacto buscarContacto(Integer id) throws ErrorSQLException;

    void modificarContacto(Contacto Contacto) throws ErrorSQLException;

}
