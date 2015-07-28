/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.logica.seguridad;

import com.suricata.argos.WS.excepciones.DatosNoEncontradosException;
import com.suricata.argos.WS.excepciones.ErrorSQLException;
import com.suricata.argos.WS.excepciones.FaltaParametroException;
import com.suricata.argos.WS.vo.RolVo;
import java.util.List;

/**
 *
 * @author Valentina
 */
public interface RolManager {

    void crearRol(RolVo rol) throws ErrorSQLException, FaltaParametroException;

    List<RolVo>  listarRoles() throws ErrorSQLException;

    RolVo buscarRol(Integer id) throws ErrorSQLException, DatosNoEncontradosException;

    void modificarRol(RolVo rol) throws ErrorSQLException, FaltaParametroException;

    List<RolVo> listarRoles(Integer idUsuario) throws ErrorSQLException, FaltaParametroException;
}
