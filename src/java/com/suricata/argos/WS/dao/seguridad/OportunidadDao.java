/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.dao.seguridad;

import com.suricata.argos.WS.entidades.Oportunidad;
import com.suricata.argos.WS.excepciones.DatosDuplicadosException;
import com.suricata.argos.WS.excepciones.ErrorSQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Valentina
 */
public interface OportunidadDao {

    void crearOportunidad(Oportunidad Oportunidad) throws ErrorSQLException, DatosDuplicadosException;

    void borrarOportunidad(Oportunidad Oportunidad) throws ErrorSQLException;

    List<Oportunidad>  listarOportunidades(String estado, Date fechaDesde, Date fechaHasta) throws ErrorSQLException;

    Oportunidad buscarOportunidad(Integer id) throws ErrorSQLException;

    void modificarOportunidad(Oportunidad Oportunidad) throws ErrorSQLException, DatosDuplicadosException;

    List<Oportunidad> listarUltimasOportunidades(Long idUsuario) throws ErrorSQLException;

    List<Oportunidad> listarUltimasOportunidades() throws ErrorSQLException;

}
