/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.dao.seguridad;

import com.suricata.argos.WS.entidades.Seguimiento;
import com.suricata.argos.WS.entidades.Seguimientotiposeguimiento;
import com.suricata.argos.WS.excepciones.DatosDuplicadosException;
import com.suricata.argos.WS.excepciones.ErrorSQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/**
 *
 * @author Valentina
 */
public class SeguimientoDaoImpl extends HibernateDaoSupport implements
SeguimientoDao {

private static final Logger LOGGER = Logger.getLogger(SeguimientoDaoImpl.class);

        /**
         * 
         * @param Seguimiento
         * @throws ErrorSQLException
         * @throws DatosDuplicadosException
         */
	public void crearSeguimiento(Seguimiento seguimiento) throws ErrorSQLException  {
            try {
                HibernateTemplate template = getHibernateTemplate();
                seguimiento.setEnviado(0);
                template.save(seguimiento);
                Iterator<Seguimientotiposeguimiento>  it = seguimiento.getSeguimientotiposeguimientos().iterator();
                while (it.hasNext()){
                    Seguimientotiposeguimiento seguimientoTipoSeguimiento = it.next();
                    seguimientoTipoSeguimiento.setSeguimiento(seguimiento);
                    template.save(seguimientoTipoSeguimiento);
                }
            } catch (Exception e){
                LOGGER.error(e.getMessage(), e);
                throw  new  ErrorSQLException(e.getMessage(), e);
          }
	}

        /**
         * 
         * @param Seguimiento
         * @throws ErrorSQLException
         */
	public void borrarSeguimiento(Seguimiento seguimiento) throws ErrorSQLException {
            try {
                HibernateTemplate template = getHibernateTemplate();
                if (seguimiento != null){
                    template.delete(seguimiento);
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
	public List<Seguimiento> listarSeguimientos(String enviado, Date fechaDesde, Date fechaHasta) throws ErrorSQLException  {
            try {
               HibernateTemplate template = getHibernateTemplate();
               Integer enviadoCod = 0;
               if(enviado.equalsIgnoreCase("true")){
                   enviadoCod = 1;
               } 
                if (fechaDesde != null && fechaHasta != null){     
                    fechaHasta.setHours(23);
                    fechaHasta.setMinutes(59);
                    Object [] array = new Object[3];
                    array[0] = enviadoCod;
                    array[1] = fechaDesde;
                    array[2] = fechaHasta;
                    return getHibernateTemplate().find("from Seguimiento where enviado=? and fechaAnuncio between ? and ? order by id desc", array);
              } else {
                    return getHibernateTemplate().find("from Seguimiento where enviado=? order by id desc",enviadoCod);
              }
               
           } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw  new  ErrorSQLException(e.getMessage(), e);
          }
	}

        /**
         * 
         * @param Seguimiento
         * @throws ErrorSQLException
         */
	public void modificarSeguimiento(Seguimiento seguimiento) throws ErrorSQLException  {
          try {
            HibernateTemplate template = getHibernateTemplate();
            template.update(seguimiento);
          } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw  new  ErrorSQLException(e.getMessage(), e);
          }
	}

        /**
         *
         * @param id
         * @return Seguimiento
         * @throws ErrorSQLException
         */
        public Seguimiento buscarSeguimiento(Integer id) throws ErrorSQLException {
          Seguimiento seguimiento = null;
          try {
              seguimiento = (Seguimiento) getHibernateTemplate().get(Seguimiento.class,id);
          } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw  new  ErrorSQLException(e.getMessage(), e);
          }
          return seguimiento;
	}

       public List<Seguimiento> obtenerSeguimientos(Date fechaActual) throws ErrorSQLException {
           List<Seguimiento> listSeguimientos = null;
          try {
               Object [] array = new Object[2];
               array[0] = fechaActual;
               array[1] = fechaActual;
               listSeguimientos = getHibernateTemplate().find("from Seguimiento where fechaAnuncio <= ? and fechaVencimiento >= ? and enviado=0",array);
          } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw  new  ErrorSQLException(e.getMessage(), e);
          }
          return listSeguimientos;
	}

        public List<Seguimiento> listarUltimosSeguimientos(Long idUsuario) throws ErrorSQLException {
           List<Seguimiento> listSeguimientos = null;
           Date fechaActual = new Date();
           Object [] array = new Object[2];
           array[0] = fechaActual;
           array[1] = Integer.parseInt(idUsuario.toString());
          try {
               listSeguimientos = getHibernateTemplate().find("from Seguimiento where fechaVencimiento >=? and usuario.id =? order by id desc limit 3", array);
          } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw  new  ErrorSQLException(e.getMessage(), e);
          }
          return listSeguimientos;
	}

         public List<Seguimiento> listarUltimosSeguimientos() throws ErrorSQLException {
           List<Seguimiento> listSeguimientos = null;
           Date fechaActual = new Date();
          try {
               listSeguimientos = getHibernateTemplate().find("from Seguimiento where fechaVencimiento >=? order by id desc limit 3", fechaActual);
          } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw  new  ErrorSQLException(e.getMessage(), e);
          }
          return listSeguimientos;
	}

    
}
