/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.dao.seguridad;

import com.suricata.argos.WS.entidades.Rol;
import com.suricata.argos.WS.entidades.Usuariorol;
import com.suricata.argos.WS.excepciones.ErrorSQLException;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Valentina
 */
public class RolDaoImpl  extends HibernateDaoSupport implements RolDao{

private static final Logger LOGGER = Logger.getLogger(RolDaoImpl.class);

    public void crearRol(Rol rol)throws ErrorSQLException  {
       try {
            HibernateTemplate template = getHibernateTemplate();
            template.save(rol);
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw  new  ErrorSQLException(e.getMessage(), e);
      }
    }

    public List<Rol> listarRoles() throws ErrorSQLException {
       try {
             HibernateTemplate template = getHibernateTemplate();
              return getHibernateTemplate().find("from Rol order by nombre");
           } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw  new  ErrorSQLException(e.getMessage(), e);
          }
    }

    public Rol buscarRol(Integer id) throws ErrorSQLException  {
         Rol rol = null;
          try {
              rol = (Rol) getHibernateTemplate().get(Rol.class,id);
          } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw  new  ErrorSQLException(e.getMessage(), e);
          }
          return rol;
    }

    public void modificarRol(Rol rol) throws ErrorSQLException  {
       try {
            HibernateTemplate template = getHibernateTemplate();
            template.update(rol);
      } catch (Exception e){
        LOGGER.error(e.getMessage(), e);
        throw  new  ErrorSQLException(e.getMessage(), e);
      }
    }

    public List<Rol> listarRoles(Integer idUsuario) throws ErrorSQLException {
      List<Usuariorol> listUsuarioRoles = null;
      List<Rol> listRoles = null;
      try {
           listRoles = getHibernateTemplate().find("select rol from Usuariorol u where u.usuario.id =?" , idUsuario);
      } catch (Exception e){
        LOGGER.error(e.getMessage(), e);
        throw  new  ErrorSQLException(e.getMessage(), e);
      }
      return listRoles;
    }

}
