/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.logica.seguridad;

import com.suricata.argos.WS.dao.seguridad.ActividadDao;
import com.suricata.argos.WS.dao.seguridad.DocumentoDao;
import com.suricata.argos.WS.entidades.Actividad;
import com.suricata.argos.WS.excepciones.DatosNoEncontradosException;
import com.suricata.argos.WS.excepciones.DocumentoException;
import com.suricata.argos.WS.excepciones.ErrorSQLException;
import com.suricata.argos.WS.excepciones.FaltaParametroException;
import com.suricata.argos.WS.excepciones.TipoDatosException;
import com.suricata.argos.WS.vo.ActividadVo;
import com.suricata.argos.WS.vo.DocumentoVo;
import com.suricata.argos.argos.WS.logica.utiles.ConvertidorUtiles;
import com.suricata.argos.argos.WS.logica.utiles.DocumentosUtiles;
import java.io.File;
import java.io.IOException;
import java.lang.String;
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
public class ActividadManagerImpl implements ActividadManager {
  private ActividadDao actividadDao;
  private DocumentoDao documentoDao;
  private static final Logger LOGGER = Logger.getLogger(ActividadManagerImpl.class);

    public ActividadDao getActividadDao() {
        return actividadDao;
    }

    public void setActividadDao(ActividadDao actividadDao) {
        this.actividadDao = actividadDao;
    }

    public DocumentoDao getDocumentoDao() {
        return documentoDao;
    }

    public void setDocumentoDao(DocumentoDao documentoDao) {
        this.documentoDao = documentoDao;
    }


    public void crearActividad(ActividadVo actividad) throws ErrorSQLException, FaltaParametroException, TipoDatosException,DocumentoException {
        if (validarDatosObligatorios(actividad)){
            try {
                Actividad act = ConvertidorUtiles.converVoToEntity(actividad);
                if (act.getDocumento() != null) {
                    DocumentosUtiles.guardarArchivo(act.getDocumento());
                }
                this.actividadDao.crearActividad(act);
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
            throw new FaltaParametroException();
       }
    }

    public void borrarActividad(ActividadVo actividad) throws ErrorSQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<ActividadVo> listarActividades(String estado, Date fechaDesde, Date fechaHasta) throws ErrorSQLException,TipoDatosException {
      List<Actividad> listaEntity = this.actividadDao.listarActividades( estado,  fechaDesde,  fechaHasta);
      Iterator it = listaEntity.iterator();
      List<ActividadVo> listaVos = new ArrayList<ActividadVo>();
      try {
          while (it.hasNext()) {
              ActividadVo actividadVo;
              actividadVo = ConvertidorUtiles.convertEntityToVo((Actividad) it.next());
              listaVos.add(actividadVo);
          }
      } catch (DatatypeConfigurationException ex) {
           LOGGER.error(ex.getMessage(), ex);
           throw new TipoDatosException();
      }
      return listaVos;
    }

    public ActividadVo buscarActividad(Integer id) throws ErrorSQLException, DatosNoEncontradosException,TipoDatosException {
        ActividadVo actividadVo = null;
        try {
            Actividad actividad = actividadDao.buscarActividad(id);
            if (actividad == null) {
                LOGGER.error("Datos no encontrados");
                throw new DatosNoEncontradosException();
            }
            actividadVo = ConvertidorUtiles.convertEntityToVo(actividad);
        } catch (DatatypeConfigurationException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new TipoDatosException();
        }
        return actividadVo;
    }

    public void modificarActividad(ActividadVo actividad) throws ErrorSQLException, FaltaParametroException,TipoDatosException{
        if (validarDatosObligatorios(actividad) && actividad.getId() != 0){
            try {
                this.actividadDao.modificarActividad(ConvertidorUtiles.converVoToEntity(actividad));
            } catch (DatatypeConfigurationException ex) {
                LOGGER.error(ex.getMessage(), ex);
                throw new TipoDatosException();
            }
       } else {
            throw new FaltaParametroException();
       }
    }

     private boolean validarDatosObligatorios (ActividadVo actividad) {
        boolean resultado = true;
        if (actividad != null && actividad.getEstado() != null
                && actividad.getOportunidad() != null && actividad.getTipoactividad() != null
                && actividad.getTitulo() != null && actividad.getUsuario() != null) {
            resultado = true;
        }
        return resultado;
    }

    public List<ActividadVo> listarUltimasActividades(Long idUsuario) throws ErrorSQLException,TipoDatosException {
      List<Actividad> listaEntity = this.actividadDao.listarUltimasActividades(idUsuario);
      Iterator it = listaEntity.iterator();
      List<ActividadVo> listaVos = new ArrayList<ActividadVo>();
      try {
          while (it.hasNext()) {
              ActividadVo actividadVo;
              actividadVo = ConvertidorUtiles.convertEntityToVo((Actividad) it.next());
              listaVos.add(actividadVo);
          }
      } catch (DatatypeConfigurationException ex) {
           LOGGER.error(ex.getMessage(), ex);
           throw new TipoDatosException();
      }
      return listaVos;
    }


     public List<ActividadVo> listarUltimasActividades() throws ErrorSQLException,TipoDatosException {
      List<Actividad> listaEntity = this.actividadDao.listarUltimasActividades();
      Iterator it = listaEntity.iterator();
      List<ActividadVo> listaVos = new ArrayList<ActividadVo>();
      try {
          while (it.hasNext()) {
              ActividadVo actividadVo;
              actividadVo = ConvertidorUtiles.convertEntityToVo((Actividad) it.next());
              listaVos.add(actividadVo);
          }
      } catch (DatatypeConfigurationException ex) {
           LOGGER.error(ex.getMessage(), ex);
           throw new TipoDatosException();
      }
      return listaVos;
    }

      public byte[] descargarPlantilla(String ruta) throws ErrorSQLException, FaltaParametroException, DocumentoException {
        byte[] archivo = null;
        try {
            if (ruta == null || ruta.equalsIgnoreCase("")) {
                throw new FaltaParametroException();
            }
            File file = new File(ruta);
            archivo = DocumentosUtiles.getBytesFromFile(file);
        } catch (IOException ex) {
             LOGGER.error(ex.getMessage(), ex);
             throw new DocumentoException();
        }
          return archivo;
      }

       public DocumentoVo buscarDocumento(String nombrePlantilla) throws ErrorSQLException, FaltaParametroException {
           if (nombrePlantilla == null || nombrePlantilla.equalsIgnoreCase("")) {
                throw new FaltaParametroException();
            }
             return ConvertidorUtiles.convertEntityToVo(this.documentoDao.obtenerDocumento(nombrePlantilla));
       }

}
