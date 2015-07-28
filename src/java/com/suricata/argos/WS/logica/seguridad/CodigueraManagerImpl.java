/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.logica.seguridad;

import com.suricata.argos.WS.dao.seguridad.CodigueraDao;
import com.suricata.argos.WS.entidades.Estado;
import com.suricata.argos.WS.entidades.Tecnologia;
import com.suricata.argos.WS.entidades.Tipoactividad;
import com.suricata.argos.WS.entidades.Tipoproyecto;
import com.suricata.argos.WS.entidades.Tiposeguimiento;
import com.suricata.argos.WS.excepciones.ErrorSQLException;
import com.suricata.argos.WS.vo.EstadoVo;
import com.suricata.argos.WS.vo.TecnologiaVo;
import com.suricata.argos.WS.vo.TipoActividadVo;
import com.suricata.argos.WS.vo.TipoProyectoVo;
import com.suricata.argos.WS.vo.TipoSeguimientoVo;
import com.suricata.argos.argos.WS.logica.utiles.ConvertidorUtiles;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Valentina
 */
public class CodigueraManagerImpl implements CodigueraManager {
    private static final Logger LOGGER = Logger.getLogger(CodigueraManagerImpl.class);
    private CodigueraDao codigueraDao;

    public CodigueraDao getCodigueraDao() {
        return codigueraDao;
    }

    public void setCodigueraDao(CodigueraDao codigueraDao) {
        this.codigueraDao = codigueraDao;
    }

   

    public List<TipoProyectoVo> listarTipoProyectos() throws ErrorSQLException {
      List<Tipoproyecto> listaEntity = this.codigueraDao.listarTipoProyectos();
      Iterator it = listaEntity.iterator();
      List<TipoProyectoVo> listaVos = new ArrayList<TipoProyectoVo>();
      while (it.hasNext()) {
          TipoProyectoVo codigueraVo = ConvertidorUtiles.convertEntityToVo((Tipoproyecto)it.next());
          listaVos.add(codigueraVo);
      }
      return listaVos;
    }

    public List<TecnologiaVo> listarTecnologias() throws ErrorSQLException {
      List<Tecnologia> listaEntity = this.codigueraDao.listarTecnologias();
      Iterator it = listaEntity.iterator();
      List<TecnologiaVo> listaVos = new ArrayList<TecnologiaVo>();
      while (it.hasNext()) {
          TecnologiaVo codigueraVo = ConvertidorUtiles.convertEntityToVo((Tecnologia)it.next());
          listaVos.add(codigueraVo);
      }
      return listaVos;
    }

    public List<EstadoVo> listarEstados() throws ErrorSQLException {
      List<Estado> listaEntity = this.codigueraDao.listarEstados();
      Iterator it = listaEntity.iterator();
      List<EstadoVo> listaVos = new ArrayList<EstadoVo>();
      while (it.hasNext()) {
          EstadoVo codigueraVo = ConvertidorUtiles.convertEntityToVo((Estado)it.next());
          listaVos.add(codigueraVo);
      }
      return listaVos;
    }

    public List<TipoActividadVo> listarTipoActividades() throws ErrorSQLException {
      List<Tipoactividad> listaEntity = this.codigueraDao.listarTipoActividades();
      Iterator it = listaEntity.iterator();
      List<TipoActividadVo> listaVos = new ArrayList<TipoActividadVo>();
      while (it.hasNext()) {
          TipoActividadVo codigueraVo = ConvertidorUtiles.convertEntityToVo((Tipoactividad)it.next());
          listaVos.add(codigueraVo);
      }
      return listaVos;
    }

    public List<TipoSeguimientoVo> listarTipoSeguimientos() throws ErrorSQLException {
      List<Tiposeguimiento> listaEntity = this.codigueraDao.listarTipoSeguimientos();
      Iterator it = listaEntity.iterator();
      List<TipoSeguimientoVo> listaVos = new ArrayList<TipoSeguimientoVo>();
      while (it.hasNext()) {
          TipoSeguimientoVo codigueraVo = ConvertidorUtiles.convertEntityToVo((Tiposeguimiento)it.next());
          listaVos.add(codigueraVo);
      }
      return listaVos;
    }

}
