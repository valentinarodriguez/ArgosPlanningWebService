/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.dao.seguridad;

import com.suricata.argos.WS.entidades.Contacto;
import com.suricata.argos.WS.excepciones.DatosDuplicadosException;
import com.suricata.argos.WS.excepciones.ErrorSQLException;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/**
 *
 * @author Valentina
 */
public class ContactoDaoImpl extends HibernateDaoSupport implements
ContactoDao {

private static final Logger LOGGER = Logger.getLogger(ContactoDaoImpl.class);

        /**
         * 
         * @param Contacto
         * @throws ErrorSQLException
         * @throws DatosDuplicadosException
         */
	public void crearContacto(Contacto Contacto) throws ErrorSQLException  {
            try {
                HibernateTemplate template = getHibernateTemplate();
                template.save(Contacto);
            } catch (Exception e){
                LOGGER.error(e.getMessage(), e);
                throw  new  ErrorSQLException(e.getMessage(), e);
          }
	}

        /**
         * 
         * @param Contacto
         * @throws ErrorSQLException
         */
	public void borrarContacto(Contacto Contacto) throws ErrorSQLException {
            try {
                HibernateTemplate template = getHibernateTemplate();
                if (Contacto != null){
                    template.delete(Contacto);
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
	public List<Contacto> listarContactos() throws ErrorSQLException  {
            try {
              HibernateTemplate template = getHibernateTemplate();
              return getHibernateTemplate().find("from Contacto order by nombre, apellido");
           } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw  new  ErrorSQLException(e.getMessage(), e);
          }
	}

        /**
         * 
         * @param Contacto
         * @throws ErrorSQLException
         */
	public void modificarContacto(Contacto Contacto) throws ErrorSQLException  {
          try {
            HibernateTemplate template = getHibernateTemplate();
            template.update(Contacto);
          } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw  new  ErrorSQLException(e.getMessage(), e);
          }
	}

        /**
         *
         * @param id
         * @return Contacto
         * @throws ErrorSQLException
         */
        public Contacto buscarContacto(Integer id) throws ErrorSQLException {
          Contacto Contacto = null;
          try {
              Contacto = (Contacto) getHibernateTemplate().get(Contacto.class,id);
          } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw  new  ErrorSQLException(e.getMessage(), e);
          }
          return Contacto;
	}

}
