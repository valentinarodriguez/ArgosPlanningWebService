/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.logica.seguridad;

import com.suricata.argos.WS.excepciones.DatosDuplicadosException;
import com.suricata.argos.WS.excepciones.DatosNoEncontradosException;
import com.suricata.argos.WS.excepciones.ErrorSQLException;
import com.suricata.argos.WS.excepciones.FaltaParametroException;
import com.suricata.argos.WS.vo.EmpresaVo;
import java.util.List;

/**
 *
 * @author Valentina
 */
public interface EmpresaManager {

    void crearEmpresa(EmpresaVo empresa) throws ErrorSQLException, DatosDuplicadosException, FaltaParametroException;

    void borrarEmpresa(EmpresaVo empresa) throws ErrorSQLException;

    List<EmpresaVo>  listarEmpresas() throws ErrorSQLException;

    EmpresaVo buscarEmpresa(Integer id) throws ErrorSQLException, DatosNoEncontradosException;

    void modificarEmpresa(EmpresaVo empresa) throws ErrorSQLException, DatosDuplicadosException, FaltaParametroException;
}
