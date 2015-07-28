/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */ 

package com.suricata.argos.WS.logica.seguridad;

import com.suricata.argos.WS.entidades.Contacto;
import com.suricata.argos.WS.excepciones.DatosNoEncontradosException;
import com.suricata.argos.WS.excepciones.ErrorSQLException;
import com.suricata.argos.WS.excepciones.FaltaParametroException;
import com.suricata.argos.WS.vo.ContactoVo;
import java.util.List;

/**
 *
 * @author Valentina
 */
public interface ContactoManager {

    void crearContacto(ContactoVo contacto) throws ErrorSQLException, FaltaParametroException;

    void borrarContacto(ContactoVo Contacto) throws ErrorSQLException;

    List<ContactoVo> listarContactos() throws ErrorSQLException;

    ContactoVo buscarContacto(Integer id) throws ErrorSQLException, DatosNoEncontradosException;

    void modificarContacto(ContactoVo contacto) throws ErrorSQLException, FaltaParametroException;

}
