/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.logica.seguridad;

import com.suricata.argos.WS.dao.seguridad.OportunidadDao;
import com.suricata.argos.WS.entidades.Oportunidad;
import com.suricata.argos.WS.excepciones.DatosDuplicadosException;
import com.suricata.argos.WS.excepciones.DatosNoEncontradosException;
import com.suricata.argos.WS.excepciones.DocumentoException;
import com.suricata.argos.WS.excepciones.ErrorSQLException;
import com.suricata.argos.WS.excepciones.FaltaParametroException;
import com.suricata.argos.WS.excepciones.TipoDatosException;
import com.suricata.argos.WS.vo.OportunidadVo;
import com.suricata.argos.argos.WS.logica.utiles.ConvertidorUtiles;
import com.suricata.argos.argos.WS.logica.utiles.DocumentosUtiles;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import org.apache.log4j.Logger;

/**
 *
 * @author Valentina
 */
public class OportunidadManagerImpl implements OportunidadManager {
    private OportunidadDao oportunidadDao;

    private static final Logger LOGGER = Logger.getLogger(OportunidadManagerImpl.class);

    public OportunidadDao getOportunidadDao() {
        return oportunidadDao;
    }

    public void setOportunidadDao(OportunidadDao oportunidadDao) {
        this.oportunidadDao = oportunidadDao;
    }

    

    public void crearOportunidad(OportunidadVo oportunidad) throws ErrorSQLException, DatosDuplicadosException, FaltaParametroException, DocumentoException,TipoDatosException {
         if (validarDatosObligatorios(oportunidad)){
            try {
                Oportunidad opo = ConvertidorUtiles.converVoToEntity(oportunidad);
                if (opo.getDocumento() != null) {
                    DocumentosUtiles.guardarArchivo(opo.getDocumento());
                }
                this.oportunidadDao.crearOportunidad(opo);

            } catch (DatatypeConfigurationException ex) {
                 LOGGER.error(ex.getMessage(), ex);
                 throw new TipoDatosException();
              } catch (IOException ex) {
                 LOGGER.error(ex.getMessage(), ex);
                 throw new DocumentoException();
            } catch (Exception ex){
                 LOGGER.error(ex.getMessage(), ex);
                 throw new ErrorSQLException();
            }
         } else {
            LOGGER.error("FaltaParametroException");
            throw new FaltaParametroException();
       }
    }

    public void borrarOportunidad(OportunidadVo oportunidad) throws ErrorSQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<OportunidadVo> listarOportunidades(String estado, Date fechaDesde, Date fechaHasta) throws ErrorSQLException, TipoDatosException {
      List<Oportunidad> listaEntity = this.oportunidadDao.listarOportunidades( estado,  fechaDesde,  fechaHasta);
      Iterator it = listaEntity.iterator();
      List<OportunidadVo> listaVos = new ArrayList<OportunidadVo>();
      try {
          while (it.hasNext()) {
              OportunidadVo oportunidadVo;
              oportunidadVo = ConvertidorUtiles.convertEntityToVo((Oportunidad) it.next());
              listaVos.add(oportunidadVo);
          }
      } catch (DatatypeConfigurationException ex) {
          LOGGER.error(ex.getMessage(), ex);
          throw new TipoDatosException();
       }
      return listaVos;
    }

    public OportunidadVo buscarOportunidad(Integer id) throws ErrorSQLException, DatosNoEncontradosException, DocumentoException, TipoDatosException {
       OportunidadVo oportunidadVo = null;
        try {
            Oportunidad oportunidad = oportunidadDao.buscarOportunidad(id);
            if (oportunidad == null) {
                LOGGER.error("Datos no encontrados");
                throw new DatosNoEncontradosException();
            }
            oportunidadVo = ConvertidorUtiles.convertEntityToVo(oportunidad);
        } catch (DatatypeConfigurationException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new TipoDatosException();
        }
        return oportunidadVo;
    }

    public void modificarOportunidad(OportunidadVo oportunidad) throws ErrorSQLException, DatosDuplicadosException, FaltaParametroException, TipoDatosException  {
         if (validarDatosObligatorios(oportunidad) && oportunidad.getId() != 0){
            try {
                this.oportunidadDao.modificarOportunidad(ConvertidorUtiles.converVoToEntity(oportunidad));
            } catch (DatatypeConfigurationException ex) {
               LOGGER.error(ex.getMessage(), ex);
               throw new TipoDatosException();
            }
       } else {
            LOGGER.error("FaltaParametroException");
            throw new FaltaParametroException();
       }
    }

 

    /**
     *
     * @param oportunidad
     * @return
     */
    private boolean validarDatosObligatorios (OportunidadVo oportunidad) {
        boolean resultado = false;
        if (oportunidad != null && oportunidad.getContacto() != null && oportunidad.getEmpresa() != null
                && oportunidad.getEstado() != null && oportunidad.getTecnologia()  != null &&
                oportunidad.getTipoproyecto() != null && oportunidad.getTitulo() != null && oportunidad.getUsuario() != null) {
            resultado = true;
        }
        return resultado;
    }

    public List<OportunidadVo> listarUltimasOportunidades(Long idUsuario) throws ErrorSQLException, TipoDatosException {
      List<Oportunidad> listaEntity = this.oportunidadDao.listarUltimasOportunidades(idUsuario);
      Iterator it = listaEntity.iterator();
      List<OportunidadVo> listaVos = new ArrayList<OportunidadVo>();
      try {
          while (it.hasNext()) {
              OportunidadVo oportunidadVo;
              oportunidadVo = ConvertidorUtiles.convertEntityToVo((Oportunidad) it.next());
              listaVos.add(oportunidadVo);
          }
      } catch (DatatypeConfigurationException ex) {
          LOGGER.error(ex.getMessage(), ex);
          throw new TipoDatosException();
      }
      return listaVos;
    }

     public List<OportunidadVo> listarUltimasOportunidades() throws ErrorSQLException, TipoDatosException {
      List<Oportunidad> listaEntity = this.oportunidadDao.listarUltimasOportunidades();
      Iterator it = listaEntity.iterator();
      List<OportunidadVo> listaVos = new ArrayList<OportunidadVo>();
      try {
          while (it.hasNext()) {
              OportunidadVo oportunidadVo;
              oportunidadVo = ConvertidorUtiles.convertEntityToVo((Oportunidad) it.next());
              listaVos.add(oportunidadVo);
          }
      } catch (DatatypeConfigurationException ex) {
          LOGGER.error(ex.getMessage(), ex);
          throw new TipoDatosException();
       }
      return listaVos;
    }
}
