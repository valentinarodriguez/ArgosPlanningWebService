/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.dao.seguridad;


import com.suricata.argos.WS.entidades.Actividad;
import com.suricata.argos.WS.excepciones.DatosDuplicadosException;
import com.suricata.argos.WS.excepciones.ErrorSQLException;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/**
 *
 * @author Valentina
 */
public class ActividadDaoImpl extends HibernateDaoSupport implements
ActividadDao {

private static final Logger LOGGER = Logger.getLogger(ActividadDaoImpl.class);

        /**
         * 
         * @param Actividad
         * @throws ErrorSQLException
         * @throws DatosDuplicadosException
         */
	public void crearActividad(Actividad actividad) throws ErrorSQLException  {
            try {
                HibernateTemplate template = getHibernateTemplate();
                if (actividad.getDocumento() != null) {
                   template.save(actividad.getDocumento());
                }
                template.save(actividad);
            } catch (Exception e){
                LOGGER.error(e.getMessage(), e);
                throw  new  ErrorSQLException(e.getMessage(), e);
          }
	}

        /**
         * 
         * @param Actividad
         * @throws ErrorSQLException
         */
	public void borrarActividad(Actividad actividad) throws ErrorSQLException {
            try {
                HibernateTemplate template = getHibernateTemplate();
                if (actividad != null){
                    template.delete(actividad);
                }
            } catch (Exception e){
                LOGGER.error(e.getMessage(), e);
                throw  new  ErrorSQLException(e.getMessage(), e);
          }
	}

        /**
         * 
         * @return List<Actividad>
         * @throws ErrorSQLException
         */
	public List<Actividad> listarActividades(String estado, Date fechaDesde, Date fechaHasta) throws ErrorSQLException  {
            try {
              HibernateTemplate template = getHibernateTemplate();
              if (fechaDesde != null && fechaHasta != null){
                    fechaHasta.setHours(23);
                    fechaHasta.setMinutes(59);
                    Object [] array = new Object[3];
                    array[0] = estado;
                    array[1] = fechaDesde;
                    array[2] = fechaHasta;
                    return getHibernateTemplate().find("from Actividad where estado.nombre=? and fechaCreacion between ? and ? order by titulo", array);
              } else {
                return getHibernateTemplate().find("from Actividad where estado.nombre=? order by titulo", estado);
              }


           } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw  new  ErrorSQLException(e.getMessage(), e);
          }
	}

        /**
         * 
         * @param Actividad
         * @throws ErrorSQLException
         */
	public void modificarActividad(Actividad actividad) throws ErrorSQLException  {
          try {
            HibernateTemplate template = getHibernateTemplate();
            template.update(actividad);
          } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw  new  ErrorSQLException(e.getMessage(), e);
          }
	}

        /**
         *
         * @param id
         * @return Actividad
         * @throws ErrorSQLException
         */
        public Actividad buscarActividad(Integer id) throws ErrorSQLException {
          Actividad actividad = null;
          try {
              actividad = (Actividad) getHibernateTemplate().get(Actividad.class,id);
          } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw  new  ErrorSQLException(e.getMessage(), e);
          }
          return actividad;
	}

    public List<Actividad> listarUltimasActividades(Long idUsuario) throws ErrorSQLException {
      List<Actividad> listActividades = null;
      try {
           listActividades = getHibernateTemplate().find("from Actividad where estado.nombre='Abierta' and usuarioByUsuario.id=? order by id desc limit 3", Integer.parseInt(idUsuario.toString()));
      } catch (Exception e){
        LOGGER.error(e.getMessage(), e);
        throw  new  ErrorSQLException(e.getMessage(), e);
      }
      return listActividades;
    }

      public List<Actividad> listarUltimasActividades() throws ErrorSQLException {
      List<Actividad> listActividades = null;
      try {
           listActividades = getHibernateTemplate().find("from Actividad where estado.nombre='Abierta' order by id desc limit 3");
      } catch (Exception e){
        LOGGER.error(e.getMessage(), e);
        throw  new  ErrorSQLException(e.getMessage(), e);
      }
      return listActividades;
    }

     
}
