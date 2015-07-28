/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.logica.seguridad;

import com.suricata.argos.WS.vo.UsuarioVo;
import com.suricata.argos.WS.dao.seguridad.UsuarioDao;
import com.suricata.argos.WS.entidades.Usuario;
import com.suricata.argos.WS.excepciones.DatosDuplicadosException;
import com.suricata.argos.WS.excepciones.DatosNoEncontradosException;
import com.suricata.argos.WS.excepciones.ErrorSQLException;
import com.suricata.argos.WS.excepciones.FaltaParametroException;
import com.suricata.argos.WS.vo.RolVo;
import com.suricata.argos.argos.WS.logica.utiles.ConvertidorUtiles;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Valentina
 */
public class UsuarioManagerImpl implements UsuarioManager {
private UsuarioDao usuarioDao;

private static final Logger LOGGER = Logger.getLogger(UsuarioManagerImpl.class);

    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }


    /**
     * 
     * @param idUsuario
     * @return
     * @throws DatosNoEncontradosException
     * @throws ErrorSQLException
     */
    public UsuarioVo buscarUsuario(Integer idUsuario) throws DatosNoEncontradosException, ErrorSQLException  {
        Usuario usuario = usuarioDao.buscarUsuario(idUsuario);
        if (usuario ==  null) {
            LOGGER.error("Datos no encontrados");
            throw new DatosNoEncontradosException();
        }
          return ConvertidorUtiles.convertEntityToVo(usuario);
    }

    /**
     * 
     * @return
     * @throws ErrorSQLException
     */
    public List<UsuarioVo> listarUsuarios() throws ErrorSQLException  {
      List<Usuario> listaEntity = this.usuarioDao.listarUsuarios();
      Iterator it = listaEntity.iterator();
      List<UsuarioVo> listaVos = new ArrayList<UsuarioVo>();
      while (it.hasNext()) {
          UsuarioVo usuarioVo = ConvertidorUtiles.convertEntityToVo((Usuario)it.next());
          listaVos.add(usuarioVo);
      }
      return listaVos;
    }

    /**
     * 
     * @param usuario
     * @throws FaltaParametroException
     * @throws ErrorSQLException
     */
    public void modificarUsuario(UsuarioVo usuario) throws FaltaParametroException, ErrorSQLException,DatosDuplicadosException  {
       if (validarDatosObligatorios(usuario) && usuario.getId() != 0){
            this.usuarioDao.modificarUsuario(ConvertidorUtiles.converVoToEntity(usuario));
       } else {
            LOGGER.error("FaltaParametroException");
            throw new FaltaParametroException();
       }
    }

    /**
     * 
     * @param usuario
     * @throws FaltaParametroException
     * @throws ErrorSQLException
     * @throws DatosDuplicadosException
     */
    public void crearUsuario(UsuarioVo usuario) throws FaltaParametroException, ErrorSQLException, DatosDuplicadosException  {
        if (validarDatosObligatorios(usuario)){
            this.usuarioDao.crearUsuario(ConvertidorUtiles.converVoToEntity(usuario));
       } else {
            LOGGER.error("FaltaParametroException");
            throw new FaltaParametroException();
       }
    }

       /**
     *
     * @param usuario
     * @return
     */
    private boolean validarDatosObligatorios (UsuarioVo usuario) {
        boolean resultado = false;
        if (usuario != null && usuario.getApellido()!= null && usuario.getNombre() != null &&
                usuario.getCargo() != null && usuario.getEmail() != null && usuario.getNick()  != null) {
            resultado = true;
        }

        return resultado;
    }

    public UsuarioVo buscarUsuario(String nombre, String contraseña) throws ErrorSQLException, DatosNoEncontradosException {
        Usuario usuario = usuarioDao.buscarUsuario(nombre, contraseña);
        if (usuario ==  null) {
            LOGGER.error("Datos no encontrados");
            throw new DatosNoEncontradosException();
        }
          return ConvertidorUtiles.convertEntityToVo(usuario);
    }

    
}
