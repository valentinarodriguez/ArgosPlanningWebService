/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.logica.seguridad;

import com.suricata.argos.WS.dao.seguridad.EmpresaDao;
import com.suricata.argos.WS.entidades.Empresa;
import com.suricata.argos.WS.excepciones.DatosDuplicadosException;
import com.suricata.argos.WS.excepciones.DatosNoEncontradosException;
import com.suricata.argos.WS.excepciones.ErrorSQLException;
import com.suricata.argos.WS.excepciones.FaltaParametroException;
import com.suricata.argos.WS.vo.EmpresaVo;
import com.suricata.argos.argos.WS.logica.utiles.ConvertidorUtiles;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Valentina
 */
public class EmpresaManagerImpl implements EmpresaManager {
    private EmpresaDao empresaDao;
    private static final Logger LOGGER = Logger.getLogger(EmpresaManagerImpl.class);

    public EmpresaDao getEmpresaDao() {
        return empresaDao;
    }

    public void setEmpresaDao(EmpresaDao empresaDao) {
        this.empresaDao = empresaDao;
    }


    public void crearEmpresa(EmpresaVo empresa) throws ErrorSQLException, DatosDuplicadosException, FaltaParametroException {
        if (validarDatosObligatorios(empresa)){
            this.empresaDao.crearEmpresa(ConvertidorUtiles.converVoToEntity(empresa));
       } else {
            LOGGER.error("Falta Parametro");
            throw new FaltaParametroException();
       }
    }

    public void borrarEmpresa(EmpresaVo empresa) throws ErrorSQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<EmpresaVo> listarEmpresas() throws ErrorSQLException {
      List<Empresa> listaEntity = this.empresaDao.listarEmpresas();
      Iterator it = listaEntity.iterator();
      List<EmpresaVo> listaVos = new ArrayList<EmpresaVo>();
      while (it.hasNext()) {
          EmpresaVo empresaVo = ConvertidorUtiles.convertEntityToVo((Empresa)it.next());
          listaVos.add(empresaVo);
      }
      return listaVos;
    }

    public EmpresaVo buscarEmpresa(Integer id) throws ErrorSQLException, DatosNoEncontradosException {
        Empresa empresa = empresaDao.buscarEmpresa(id);
        if (empresa ==  null) {
            LOGGER.error("Datos no encontrados");
            throw new DatosNoEncontradosException();
        }
          return ConvertidorUtiles.convertEntityToVo(empresa);
    }

    public void modificarEmpresa(EmpresaVo empresa) throws ErrorSQLException, DatosDuplicadosException, FaltaParametroException {
        if (validarDatosObligatorios(empresa) && empresa.getId() != 0){
            this.empresaDao.modificarEmpresa(ConvertidorUtiles.converVoToEntity(empresa));
       } else {
            LOGGER.error("FaltaParametroException");
            throw new FaltaParametroException();
       }
    }

   

    /**
     *
     * @param empresa
     * @return
     */
    private boolean validarDatosObligatorios (EmpresaVo empresa) {
        boolean resultado = false;
        if (empresa != null && empresa.getNombre() != null) {
            resultado = true;
        }
        return resultado;
    }
}
