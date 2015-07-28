/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.logica.seguridad;

import com.suricata.argos.WS.excepciones.DatosNoEncontradosException;
import com.suricata.argos.WS.excepciones.EmailException;
import com.suricata.argos.WS.excepciones.ErrorSQLException;
import com.suricata.argos.WS.excepciones.FaltaParametroException;
import com.suricata.argos.WS.excepciones.TipoDatosException;
import com.suricata.argos.WS.vo.SeguimientoVo;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Valentina
 */
public interface SeguimientoManager {

    void crearSeguimiento(SeguimientoVo seguimiento) throws ErrorSQLException, FaltaParametroException,TipoDatosException;

    void borrarSeguimiento(SeguimientoVo seguimiento) throws ErrorSQLException;

    List<SeguimientoVo>  listarSeguimientos(String enviado, Date fechaDesde, Date fechaHasta) throws ErrorSQLException,TipoDatosException;

    SeguimientoVo buscarSeguimiento(Integer id) throws ErrorSQLException, DatosNoEncontradosException,TipoDatosException;

    void modificarSeguimiento(SeguimientoVo seguimiento) throws ErrorSQLException, FaltaParametroException,TipoDatosException;
    
    void sincronizarSeguimientos() throws ErrorSQLException, FaltaParametroException, EmailException;

    List<SeguimientoVo> listarUltimosSeguimientos(Long idUsuario) throws ErrorSQLException,TipoDatosException;

    List<SeguimientoVo> listarUltimosSeguimientos() throws ErrorSQLException,TipoDatosException;
    
}
