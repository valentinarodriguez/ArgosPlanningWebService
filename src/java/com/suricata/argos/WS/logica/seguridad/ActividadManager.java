/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.logica.seguridad;

import com.suricata.argos.WS.excepciones.DatosNoEncontradosException;
import com.suricata.argos.WS.excepciones.DocumentoException;
import com.suricata.argos.WS.excepciones.ErrorSQLException;
import com.suricata.argos.WS.excepciones.FaltaParametroException;
import com.suricata.argos.WS.excepciones.TipoDatosException;
import com.suricata.argos.WS.vo.ActividadVo;
import com.suricata.argos.WS.vo.DocumentoVo;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Valentina
 */
public interface ActividadManager {

    void crearActividad(ActividadVo actividad) throws ErrorSQLException, FaltaParametroException,TipoDatosException, DocumentoException;

    List<ActividadVo>  listarActividades(String estado, Date fechaDesde, Date fechaHasta) throws ErrorSQLException,TipoDatosException;

    ActividadVo buscarActividad(Integer id) throws ErrorSQLException, DatosNoEncontradosException,TipoDatosException;

    void modificarActividad(ActividadVo actividad) throws ErrorSQLException, FaltaParametroException,TipoDatosException;

    List<ActividadVo> listarUltimasActividades(Long idUsuario) throws ErrorSQLException,TipoDatosException;

    List<ActividadVo> listarUltimasActividades() throws ErrorSQLException,TipoDatosException;

    byte[] descargarPlantilla(String ruta) throws ErrorSQLException, FaltaParametroException, DocumentoException;

    DocumentoVo buscarDocumento(String nombrePlantilla) throws ErrorSQLException, FaltaParametroException;


}
