/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.dao.seguridad;

import com.suricata.argos.WS.entidades.Rol;
import com.suricata.argos.WS.entidades.Usuariorol;
import com.suricata.argos.WS.excepciones.DatosNoEncontradosException;
import com.suricata.argos.WS.excepciones.ErrorSQLException;
import com.suricata.argos.WS.excepciones.FaltaParametroException;
import java.util.List;

/**
 *
 * @author Valentina
 */
public interface RolDao {

    void crearRol(Rol rol) throws ErrorSQLException, FaltaParametroException;

    List<Rol>  listarRoles() throws ErrorSQLException;

    Rol buscarRol(Integer id) throws ErrorSQLException, DatosNoEncontradosException;

    void modificarRol(Rol rol) throws ErrorSQLException, FaltaParametroException;

    List<Rol> listarRoles(Integer idUsuario) throws ErrorSQLException;
}
