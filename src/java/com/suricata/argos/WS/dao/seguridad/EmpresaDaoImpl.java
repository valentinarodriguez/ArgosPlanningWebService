/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.dao.seguridad;

import com.suricata.argos.WS.entidades.Empresa;
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
public class EmpresaDaoImpl extends HibernateDaoSupport implements
EmpresaDao {

private static final Logger LOGGER = Logger.getLogger(EmpresaDaoImpl.class);

        /**
         * 
         * @param Empresa
         * @throws ErrorSQLException
         * @throws DatosDuplicadosException
         */
	public void crearEmpresa(Empresa Empresa) throws ErrorSQLException,DatosDuplicadosException  {
            try {
                HibernateTemplate template = getHibernateTemplate();
                List list = getHibernateTemplate().find("from Empresa where nombre = ?", Empresa.getNombre());
                if (list != null && list.size() > 0) {
                    LOGGER.error("El atributo nombre ya existe.");
                    throw  new  DatosDuplicadosException("El atributo nombre ya existe.");
             }  else {
                    template.save(Empresa);
               }
            } catch (Exception e){
                LOGGER.error(e.getMessage(), e);
                throw  new  ErrorSQLException(e.getMessage(), e);
          }
	}

        /**
         * 
         * @param Empresa
         * @throws ErrorSQLException
         */
	public void borrarEmpresa(Empresa Empresa) throws ErrorSQLException {
            try {
                HibernateTemplate template = getHibernateTemplate();
                if (Empresa != null){
                    template.delete(Empresa);
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
	public List<Empresa> listarEmpresas() throws ErrorSQLException  {
            try {
              HibernateTemplate template = getHibernateTemplate();
              return getHibernateTemplate().find("from Empresa order by nombre");
           } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw  new  ErrorSQLException(e.getMessage(), e);
          }
	}

        /**
         * 
         * @param Empresa
         * @throws ErrorSQLException
         */
	public void modificarEmpresa(Empresa Empresa) throws ErrorSQLException, DatosDuplicadosException  {
          try {
            HibernateTemplate template = getHibernateTemplate();
            Object [] array = new Object[2];
            array[0] = Empresa.getNombre();
            array[1] = Empresa.getId();
            List list = getHibernateTemplate().find("from Empresa where nombre =? and id!=?", array);
            if (list != null && list.size() > 0) {
                    LOGGER.error("El atributo nombre ya existe.");
                    throw  new  DatosDuplicadosException("El atributo nombre ya existe.");
             }  else {
                    template.update(Empresa);
               }
          } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw  new  ErrorSQLException(e.getMessage(), e);
          }
	}

        /**
         *
         * @param id
         * @return Empresa
         * @throws ErrorSQLException
         */
        public Empresa buscarEmpresa(Integer id) throws ErrorSQLException {
          Empresa Empresa = null;
          try {
              Empresa = (Empresa) getHibernateTemplate().get(Empresa.class,id);
          } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw  new  ErrorSQLException(e.getMessage(), e);
          }
          return Empresa;
	}

}
