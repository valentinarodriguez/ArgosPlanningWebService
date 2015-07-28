/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.dao.seguridad;

import com.suricata.argos.WS.entidades.Empresa;
import com.suricata.argos.WS.excepciones.DatosDuplicadosException;
import com.suricata.argos.WS.excepciones.ErrorSQLException;
import java.util.List;

/**
 *
 * @author Valentina
 */
public interface EmpresaDao {

    void crearEmpresa(Empresa Empresa) throws ErrorSQLException, DatosDuplicadosException;

    void borrarEmpresa(Empresa Empresa) throws ErrorSQLException;

    List<Empresa>  listarEmpresas() throws ErrorSQLException;

    Empresa buscarEmpresa(Integer id) throws ErrorSQLException;

    void modificarEmpresa(Empresa Empresa) throws ErrorSQLException, DatosDuplicadosException;

}
