/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.dao.seguridad;

import com.suricata.argos.WS.entidades.Usuario;
import com.suricata.argos.WS.excepciones.DatosDuplicadosException;
import com.suricata.argos.WS.excepciones.ErrorSQLException;
import java.util.List;

/**
 *
 * @author Valentina
 */
public interface UsuarioDao {

    void crearUsuario(Usuario usuario) throws ErrorSQLException, DatosDuplicadosException;

    void borrarUsuario(Usuario usuario) throws ErrorSQLException;

    List<Usuario>  listarUsuarios() throws ErrorSQLException;

    Usuario buscarUsuario(Integer id) throws ErrorSQLException;

    void modificarUsuario(Usuario usuario) throws ErrorSQLException, DatosDuplicadosException;

    Usuario buscarUsuario(String nombre, String contraseña) throws ErrorSQLException;

}
