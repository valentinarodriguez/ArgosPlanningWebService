/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.dao.seguridad;

import com.suricata.argos.WS.entidades.Estado;
import com.suricata.argos.WS.entidades.Tecnologia;
import com.suricata.argos.WS.entidades.Tipoactividad;
import com.suricata.argos.WS.entidades.Tipoproyecto;
import com.suricata.argos.WS.entidades.Tiposeguimiento;
import com.suricata.argos.WS.excepciones.ErrorSQLException;
import java.util.List;

/**
 *
 * @author Valentina
 */
public interface CodigueraDao {

     List<Tipoproyecto>  listarTipoProyectos() throws ErrorSQLException;

     List<Tecnologia>  listarTecnologias() throws ErrorSQLException;

     List<Estado>  listarEstados() throws ErrorSQLException;

     List<Tipoactividad> listarTipoActividades() throws ErrorSQLException;

     List<Tiposeguimiento> listarTipoSeguimientos() throws ErrorSQLException;

}
