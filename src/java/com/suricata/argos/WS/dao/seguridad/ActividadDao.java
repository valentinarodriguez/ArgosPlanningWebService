/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.dao.seguridad;

import com.suricata.argos.WS.entidades.Actividad;
import com.suricata.argos.WS.excepciones.ErrorSQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Valentina
 */
public interface ActividadDao {

    void crearActividad(Actividad actividad) throws ErrorSQLException;

    void borrarActividad(Actividad actividad) throws ErrorSQLException;

    List<Actividad> listarActividades(String estado, Date fechaDesde, Date fechaHasta) throws ErrorSQLException;

    Actividad buscarActividad(Integer id) throws ErrorSQLException;

    void modificarActividad(Actividad actividad) throws ErrorSQLException;

    List<Actividad> listarUltimasActividades(Long idUsuario) throws ErrorSQLException;

    List<Actividad> listarUltimasActividades() throws ErrorSQLException;

    
}
