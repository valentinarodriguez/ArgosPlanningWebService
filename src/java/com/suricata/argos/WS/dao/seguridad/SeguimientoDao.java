/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.dao.seguridad;

import com.suricata.argos.WS.entidades.Seguimiento;
import com.suricata.argos.WS.excepciones.ErrorSQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Valentina
 */
public interface SeguimientoDao {

    void crearSeguimiento(Seguimiento seguimiento) throws ErrorSQLException;

    void borrarSeguimiento(Seguimiento seguimiento) throws ErrorSQLException;

    List<Seguimiento>  listarSeguimientos(String enviado, Date fechaDesde, Date fechaHasta) throws ErrorSQLException;

    Seguimiento buscarSeguimiento(Integer id) throws ErrorSQLException;

    void modificarSeguimiento(Seguimiento seguimiento) throws ErrorSQLException;

    List<Seguimiento> obtenerSeguimientos(Date fechaActual) throws ErrorSQLException;

    List<Seguimiento> listarUltimosSeguimientos(Long idUsuario) throws ErrorSQLException;

     List<Seguimiento> listarUltimosSeguimientos() throws ErrorSQLException;

}
