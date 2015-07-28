/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.logica.seguridad;

import com.suricata.argos.WS.excepciones.DatosDuplicadosException;
import com.suricata.argos.WS.excepciones.DatosNoEncontradosException;
import com.suricata.argos.WS.excepciones.DocumentoException;
import com.suricata.argos.WS.excepciones.ErrorSQLException;
import com.suricata.argos.WS.excepciones.FaltaParametroException;
import com.suricata.argos.WS.excepciones.TipoDatosException;
import com.suricata.argos.WS.vo.OportunidadVo;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Valentina
 */
public interface OportunidadManager {

    void crearOportunidad(OportunidadVo oportunidad) throws ErrorSQLException, DatosDuplicadosException, FaltaParametroException, DocumentoException,TipoDatosException;

    void borrarOportunidad(OportunidadVo oportunidad) throws ErrorSQLException;

    List<OportunidadVo>  listarOportunidades(String estado, Date fechaDesde, Date fechaHasta) throws ErrorSQLException, TipoDatosException;

    OportunidadVo buscarOportunidad(Integer id) throws ErrorSQLException, DatosNoEncontradosException, DocumentoException, TipoDatosException;

    void modificarOportunidad(OportunidadVo oportunidad) throws ErrorSQLException, DatosDuplicadosException, FaltaParametroException, TipoDatosException;

    List<OportunidadVo> listarUltimasOportunidades(Long idUsuario) throws ErrorSQLException, TipoDatosException;

    List<OportunidadVo> listarUltimasOportunidades() throws ErrorSQLException, TipoDatosException;
}
