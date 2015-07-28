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
import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/**
 *
 * @author Valentina
 */
public class OportunidadDaoImpl extends HibernateDaoSupport implements
OportunidadDao {

private static final Logger LOGGER = Logger.getLogger(OportunidadDaoImpl.class);

        /**
         * 
         * @param Oportunidad
         * @throws ErrorSQLException
         * @throws DatosDuplicadosException
         */
	public void crearOportunidad(Oportunidad oportunidad) throws ErrorSQLException,DatosDuplicadosException  {
            try {
                HibernateTemplate template = getHibernateTemplate();
               if (oportunidad.getDocumento() != null) {
                   template.save(oportunidad.getDocumento());
                }
                 template.save(oportunidad);
            } catch (Exception e){
                LOGGER.error(e.getMessage(), e);
                throw  new  ErrorSQLException(e.getMessage(), e);
          }
	}

        /**
         * 
         * @param Oportunidad
         * @throws ErrorSQLException
         */
	public void borrarOportunidad(Oportunidad Oportunidad) throws ErrorSQLException {
            try {
                HibernateTemplate template = getHibernateTemplate();
                if (Oportunidad != null){
                    template.delete(Oportunidad);
                }
            } catch (Exception e){
                LOGGER.error(e.getMessage(), e);
                throw  new  ErrorSQLException(e.getMessage(), e);
          }
	}

        /**
         * 
         * @return
         * @throws ErrorSQLException
         */
	public List<Oportunidad> listarOportunidades(String estado, Date fechaDesde, Date fechaHasta) throws ErrorSQLException  {
            try {
              HibernateTemplate template = getHibernateTemplate();
              if (fechaDesde != null && fechaHasta != null){
                    fechaHasta.setHours(23);
                    fechaHasta.setMinutes(59);
                    Object [] array = new Object[3];
                    array[0] = estado;
                    array[1] = fechaDesde;
                    array[2] = fechaHasta;
                    return getHibernateTemplate().find("from Oportunidad where estado.nombre=? and fecha between ? and ? order by titulo", array);
              } else {
                return getHibernateTemplate().find("from Oportunidad where estado.nombre=? order by titulo", estado);
              }
           } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw  new  ErrorSQLException(e.getMessage(), e);
          }
	}

        /**
         * 
         * @param Oportunidad
         * @throws ErrorSQLException
         */
	public void modificarOportunidad(Oportunidad oportunidad) throws ErrorSQLException, DatosDuplicadosException  {
          try {
            HibernateTemplate template = getHibernateTemplate();
            template.update(oportunidad);
          } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw  new  ErrorSQLException(e.getMessage(), e);
          }
	}

        /**
         *
         * @param id
         * @return Oportunidad
         * @throws ErrorSQLException
         */
        public Oportunidad buscarOportunidad(Integer id) throws ErrorSQLException {
          Oportunidad Oportunidad = null;
          try {
              Oportunidad = (Oportunidad) getHibernateTemplate().get(Oportunidad.class,id);
          } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw  new  ErrorSQLException(e.getMessage(), e);
          }
          return Oportunidad;
	}

    public List<Oportunidad> listarUltimasOportunidades(Long idUsuario) throws ErrorSQLException {
        List<Oportunidad> listOportunidades = null;
          try {
               listOportunidades = getHibernateTemplate().find("from Oportunidad where estado.nombre='Abierta' and usuario.id=? order by id desc limit 3", Integer.parseInt(idUsuario.toString()));
          } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw  new  ErrorSQLException(e.getMessage(), e);
          }
          return listOportunidades;
    }

       public List<Oportunidad> listarUltimasOportunidades() throws ErrorSQLException {
        List<Oportunidad> listOportunidades = null;
          try {
               listOportunidades = getHibernateTemplate().find("from Oportunidad where estado.nombre='Abierta' order by id desc limit 3");
          } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw  new  ErrorSQLException(e.getMessage(), e);
          }
          return listOportunidades;
    }

}
