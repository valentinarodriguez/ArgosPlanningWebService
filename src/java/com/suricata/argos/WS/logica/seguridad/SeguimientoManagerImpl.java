/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.logica.seguridad;

import com.suricata.argos.WS.dao.seguridad.SeguimientoDao;
import com.suricata.argos.WS.entidades.Actividad;
import com.suricata.argos.WS.entidades.Seguimiento;
import com.suricata.argos.WS.entidades.Seguimientotiposeguimiento;
import com.suricata.argos.WS.excepciones.DatosNoEncontradosException;
import com.suricata.argos.WS.excepciones.EmailException;
import com.suricata.argos.WS.excepciones.ErrorSQLException;
import com.suricata.argos.WS.excepciones.FaltaParametroException;
import com.suricata.argos.WS.excepciones.TipoDatosException;
import com.suricata.argos.WS.vo.SeguimientoVo;
import com.suricata.argos.argos.WS.logica.utiles.Constantes;
import com.suricata.argos.argos.WS.logica.utiles.ConvertidorUtiles;
import com.suricata.argos.argos.WS.logica.utiles.EmailUtiles;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.mail.MessagingException;
import javax.xml.datatype.DatatypeConfigurationException;
import org.apache.log4j.Logger;

/**
 *
 * @author Valentina
 */
public class SeguimientoManagerImpl implements SeguimientoManager {
    private SeguimientoDao seguimientoDao;

    private static final Logger LOGGER = Logger.getLogger(SeguimientoManagerImpl.class);

    public SeguimientoDao getSeguimientoDao() {
        return seguimientoDao;
    }

    public void setSeguimientoDao(SeguimientoDao seguimientoDao) {
        this.seguimientoDao = seguimientoDao;
    }


    public void crearSeguimiento(SeguimientoVo seguimiento) throws ErrorSQLException, FaltaParametroException,TipoDatosException {
       if (validarDatosObligatorios(seguimiento)){
            try {
                this.seguimientoDao.crearSeguimiento(ConvertidorUtiles.converVoToEntity(seguimiento));
            } catch (DatatypeConfigurationException ex) {
                 LOGGER.error(ex.getMessage(), ex);
                 throw new TipoDatosException();
            }
       } else {
            LOGGER.error("FaltaParametroException");
            throw new FaltaParametroException();
       }
    }

    public void borrarSeguimiento(SeguimientoVo Seguimiento) throws ErrorSQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<SeguimientoVo> listarSeguimientos(String enviado, Date fechaDesde, Date fechaHasta) throws ErrorSQLException,TipoDatosException {
      List<Seguimiento> listaEntity = this.seguimientoDao.listarSeguimientos( enviado, fechaDesde, fechaHasta);
      Iterator it = listaEntity.iterator();
      List<SeguimientoVo> listaVos = new ArrayList<SeguimientoVo>();
      try {
          while (it.hasNext()) {
              SeguimientoVo seguimientoVo;
              seguimientoVo = ConvertidorUtiles.convertEntityToVo((Seguimiento) it.next());
              listaVos.add(seguimientoVo);
          }
      } catch (DatatypeConfigurationException ex) {
        LOGGER.error(ex.getMessage(), ex);
        throw new TipoDatosException();
      }
      return listaVos;
    }

    public SeguimientoVo buscarSeguimiento(Integer id) throws ErrorSQLException, DatosNoEncontradosException,TipoDatosException {
       SeguimientoVo seguimientoVo = null;
        try {
            Seguimiento seguimiento = seguimientoDao.buscarSeguimiento(id);
            if (seguimiento == null) {
                LOGGER.error("Datos no encontrados");
                throw new DatosNoEncontradosException();
            }
            seguimientoVo = ConvertidorUtiles.convertEntityToVo(seguimiento);
        } catch (DatatypeConfigurationException ex) {
           LOGGER.error(ex.getMessage(), ex);
           throw new TipoDatosException();
        }
        return seguimientoVo;
    }

    public void modificarSeguimiento(SeguimientoVo Seguimiento) throws ErrorSQLException, FaltaParametroException,TipoDatosException {
         if (validarDatosObligatorios(Seguimiento) && Seguimiento.getId() != 0){
            try {
                this.seguimientoDao.modificarSeguimiento(ConvertidorUtiles.converVoToEntity(Seguimiento));
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
     * @param Seguimiento
     * @return
     */
    private boolean validarDatosObligatorios (SeguimientoVo seguimiento) {
        boolean resultado = false;
        if (seguimiento != null && seguimiento.getActividad() != null && seguimiento.getFechaAnuncio() != null
                && seguimiento.getFechaVencimiento() != null  &&
                seguimiento.getSeguimientotiposeguimientos() != null && seguimiento.getUsuario() != null) {
            resultado = true;
        }
        return resultado;
    }

      public void sincronizarSeguimientos() throws ErrorSQLException, FaltaParametroException,EmailException {
        Date hoy = new Date();
        List<Seguimiento> listSeguimientos =  this.seguimientoDao.obtenerSeguimientos(hoy);
        if (listSeguimientos != null && listSeguimientos.size() > 0){
            Iterator<Seguimiento> it = listSeguimientos.iterator();
            String mensajeaEnviar = "";
            while (it.hasNext()){
                Seguimiento seguimiento = it.next();
                Actividad actividad = seguimiento.getActividad();
                if (seguimiento.getFechaVencimiento() == hoy){
                    mensajeaEnviar = Constantes.PLANTILLA_MENSAJE_VENCE + actividad.getTitulo() + Constantes.PLANTILLA_MENSAJE_CLIENTE + seguimiento.getActividad().getOportunidad().getEmpresa().getNombre();
                } else {
                    mensajeaEnviar = actividad.getTitulo() + Constantes.PLANTILLA_MENSAJE_CLIENTE + seguimiento.getActividad().getOportunidad().getEmpresa().getNombre();
                }
                Iterator<Seguimientotiposeguimiento> itTipos = seguimiento.getSeguimientotiposeguimientos().iterator();
                while (itTipos.hasNext()){
                    Seguimientotiposeguimiento tipoSeguimiento = itTipos.next();
                     if (tipoSeguimiento.getTiposeguimiento().getNombre().equalsIgnoreCase(Constantes.NOMBRE_EMAIL)){
                         try {
                            EmailUtiles.envioMail(Constantes.ENVIO_TITULO_VENCIMIENTO, mensajeaEnviar, seguimiento.getUsuario().getEmail());
                            seguimiento.setEnviado(1);
                            seguimientoDao.modificarSeguimiento(seguimiento);
                        } catch (MessagingException ex) {
                            LOGGER.error(ex.getMessage(), ex);
                             throw new EmailException();
                        }
                    } else {
                       try {
                            String celular = seguimiento.getUsuario().getCelular().toString();
                            EmailUtiles.envioMail(Constantes.ENVIO_TITULO_VENCIMIENTO, mensajeaEnviar, celular + Constantes.EMAIL_MOVISTAR);
                             seguimiento.setEnviado(1);
                             seguimientoDao.modificarSeguimiento(seguimiento);
                        } catch (MessagingException ex) {
                            LOGGER.error(ex.getMessage(), ex);
                            throw new EmailException();

                        }
                    }

                }

               
            }
        }
    }

    public List<SeguimientoVo> listarUltimosSeguimientos(Long idUsuario) throws ErrorSQLException,TipoDatosException {
      List<Seguimiento> listaEntity = this.seguimientoDao.listarUltimosSeguimientos(idUsuario);
      Iterator it = listaEntity.iterator();
      List<SeguimientoVo> listaVos = new ArrayList<SeguimientoVo>();
      try {
          while (it.hasNext()) {
              SeguimientoVo seguimientoVo;
              seguimientoVo = ConvertidorUtiles.convertEntityToVo((Seguimiento) it.next());
              listaVos.add(seguimientoVo);
          }
      } catch (DatatypeConfigurationException ex) {
        LOGGER.error(ex.getMessage(), ex);
        throw new TipoDatosException();
      }
      return listaVos;
    }

      public List<SeguimientoVo> listarUltimosSeguimientos() throws ErrorSQLException, TipoDatosException {
          List<Seguimiento> listaEntity = this.seguimientoDao.listarUltimosSeguimientos();
          Iterator it = listaEntity.iterator();
          List<SeguimientoVo> listaVos = new ArrayList<SeguimientoVo>();
          try {
              while (it.hasNext()) {
                  SeguimientoVo seguimientoVo;
                  seguimientoVo = ConvertidorUtiles.convertEntityToVo((Seguimiento) it.next());
                  listaVos.add(seguimientoVo);
              }
          } catch (DatatypeConfigurationException ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new TipoDatosException();
          }
      return listaVos;
    }
}
