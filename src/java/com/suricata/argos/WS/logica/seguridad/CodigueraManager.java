/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.logica.seguridad;

import com.suricata.argos.WS.excepciones.ErrorSQLException;
import com.suricata.argos.WS.vo.EstadoVo;
import com.suricata.argos.WS.vo.TecnologiaVo;
import com.suricata.argos.WS.vo.TipoActividadVo;
import com.suricata.argos.WS.vo.TipoProyectoVo;
import com.suricata.argos.WS.vo.TipoSeguimientoVo;
import java.util.List;

/**
 *
 * @author Valentina
 */
public interface CodigueraManager {

      List<TipoProyectoVo>  listarTipoProyectos() throws ErrorSQLException;

      List<TecnologiaVo>  listarTecnologias() throws ErrorSQLException;

      List<EstadoVo>  listarEstados() throws ErrorSQLException;

      List<TipoActividadVo> listarTipoActividades() throws ErrorSQLException;

      List<TipoSeguimientoVo> listarTipoSeguimientos() throws ErrorSQLException;

}
