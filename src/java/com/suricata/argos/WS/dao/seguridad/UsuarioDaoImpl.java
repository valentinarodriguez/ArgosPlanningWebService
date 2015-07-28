/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.dao.seguridad;

import com.suricata.argos.WS.entidades.Usuario;
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
public class UsuarioDaoImpl extends HibernateDaoSupport implements
UsuarioDao {

private static final Logger LOGGER = Logger.getLogger(UsuarioDaoImpl.class);

        /**
         * 
         * @param usuario
         * @throws ErrorSQLException
         * @throws DatosDuplicadosException
         */
	public void crearUsuario(Usuario usuario) throws ErrorSQLException,DatosDuplicadosException  {
            try {
                HibernateTemplate template = getHibernateTemplate();
                List list = getHibernateTemplate().find("from Usuario where nick = ?", usuario.getNick());
                if (list != null && list.size() > 0) {
                    LOGGER.error("El atributo nombre ya existe.");
                    throw  new  DatosDuplicadosException("El atributo nombre ya existe.");
             }  else {
                    template.save(usuario);
               }
            } catch (Exception e){
                LOGGER.error(e.getMessage(), e);
                throw  new  ErrorSQLException(e.getMessage(), e);
          }
	}

        /**
         * 
         * @param usuario
         * @throws ErrorSQLException
         */
	public void borrarUsuario(Usuario usuario) throws ErrorSQLException {
            try {
                HibernateTemplate template = getHibernateTemplate();
                if (usuario != null){
                    template.delete(usuario);
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
	public List<Usuario> listarUsuarios() throws ErrorSQLException  {
            try {
              HibernateTemplate template = getHibernateTemplate();
               return getHibernateTemplate().find("from Usuario order by nombre, apellido");
           } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw  new  ErrorSQLException(e.getMessage(), e);
          }
	}

        /**
         * 
         * @param usuario
         * @throws ErrorSQLException
         */
	public void modificarUsuario(Usuario usuario) throws ErrorSQLException, DatosDuplicadosException  {
          try {
            HibernateTemplate template = getHibernateTemplate();
            Object [] array = new Object[2];
            array[0] = usuario.getNick();
            array[1] = usuario.getId();
            List list = getHibernateTemplate().find("from Usuario where nick =? and id!=?", array);
            if (list != null && list.size() > 0) {
                    LOGGER.error("El atributo nombre ya existe.");
                    throw  new  DatosDuplicadosException("El atributo nombre ya existe.");
             }  else {
                    template.update(usuario);
               }
          } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw  new  ErrorSQLException(e.getMessage(), e);
          }
	}

        /**
         *
         * @param id
         * @return Usuario
         * @throws ErrorSQLException
         */
        public Usuario buscarUsuario(Integer id) throws ErrorSQLException {
          Usuario usuario = null;
          try {
              usuario = (Usuario) getHibernateTemplate().get(Usuario.class,id);
          } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw  new  ErrorSQLException(e.getMessage(), e);
          }
          return usuario;
	}

    public Usuario buscarUsuario(String nombre, String contraseña) throws ErrorSQLException {
         Usuario usuario = null;
          try {
               Object [] array = new Object[2];
               array[0] = nombre;
               array[1] = contraseña;
              List users = getHibernateTemplate().find("from Usuario where nick = ? and contrasena=?", array);
              if (users != null && users.size()!= 0)
                  usuario = (Usuario) users.get(0);
          } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw  new  ErrorSQLException(e.getMessage(), e);
          }
          return usuario;
    }

}
