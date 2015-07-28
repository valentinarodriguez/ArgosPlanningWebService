/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.logica.seguridad;

import com.suricata.argos.WS.dao.seguridad.RolDao;
import com.suricata.argos.WS.dao.seguridad.UsuarioDao;
import com.suricata.argos.WS.entidades.Rol;
import com.suricata.argos.WS.entidades.Usuario;
import com.suricata.argos.WS.entidades.Usuariorol;
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
public class RolManagerImpl implements RolManager {
    private RolDao rolDao;
    private UsuarioDao usuarioDao;

    private static final Logger LOGGER = Logger.getLogger(RolManagerImpl.class);

    public RolDao getRolDao() {
        return rolDao;
    }

    public void setRolDao(RolDao rolDao) {
        this.rolDao = rolDao;
    }

    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }


    public void crearRol(RolVo rol) throws ErrorSQLException, FaltaParametroException {
        if (validarDatosObligatorios(rol)){
            this.rolDao.crearRol(ConvertidorUtiles.converVoToEntity(rol));
       } else {
            LOGGER.error("FaltaParametroException");
            throw new FaltaParametroException();
       }
    }

    public List<RolVo> listarRoles() throws ErrorSQLException {
      List<Rol> listaEntity = this.rolDao.listarRoles();
      Iterator it = listaEntity.iterator();
      List<RolVo> listaVos = new ArrayList<RolVo>();
      while (it.hasNext()) {
          RolVo rolVo;
          rolVo = ConvertidorUtiles.convertEntityToVo((Rol) it.next());
          listaVos.add(rolVo);
      }
      return listaVos;
    }

    public RolVo buscarRol(Integer id) throws ErrorSQLException, DatosNoEncontradosException {
        RolVo rolVo = null;
        Rol rol = rolDao.buscarRol(id);
        if (rol == null) {
            LOGGER.error("Datos no encontrados");
            throw new DatosNoEncontradosException();
        }
        rolVo = ConvertidorUtiles.convertEntityToVo(rol);

        return rolVo;
    }

    public void modificarRol(RolVo rol) throws ErrorSQLException, FaltaParametroException {
      if (validarDatosObligatorios(rol) && rol.getId() != 0){
            this.rolDao.modificarRol(ConvertidorUtiles.converVoToEntity(rol));
       } else {
            LOGGER.error("FaltaParametroException");
            throw new FaltaParametroException();
       }
    }

    public List<RolVo> listarRoles(Integer idUsuario) throws ErrorSQLException, FaltaParametroException {
       List<Rol> listaEntity = null;
       List<RolVo> listaVos = new ArrayList<RolVo>();
       if (idUsuario != null){
          listaEntity = this.rolDao.listarRoles(idUsuario);
          Iterator it = listaEntity.iterator();
          while (it.hasNext()) {
              RolVo rolVo;
              Rol rol = (Rol) it.next();
              rolVo = ConvertidorUtiles.convertEntityToVo(rol);
              listaVos.add(rolVo);
          }

      } else {
            LOGGER.error("FaltaParametroException");
            throw new FaltaParametroException();
      }
     
     return listaVos;
    }

     private boolean validarDatosObligatorios (RolVo rol) {
        boolean resultado = false;
        if (rol != null && rol.getNombre() != null) {
            resultado = true;
        }
        return resultado;
    }
}
