/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.logica.seguridad;

import com.suricata.argos.WS.dao.seguridad.ContactoDao;
import com.suricata.argos.WS.entidades.Contacto;
import com.suricata.argos.WS.excepciones.DatosNoEncontradosException;
import com.suricata.argos.WS.excepciones.ErrorSQLException;
import com.suricata.argos.WS.excepciones.FaltaParametroException;
import com.suricata.argos.WS.vo.ContactoVo;
import com.suricata.argos.argos.WS.logica.utiles.ConvertidorUtiles;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Valentina
 */
public class ContactoManagerImpl implements ContactoManager {
    private ContactoDao contactoDao;
    private static final Logger LOGGER = Logger.getLogger(ContactoManagerImpl.class);

    public ContactoDao getContactoDao() {
        return contactoDao;
    }

    public void setContactoDao(ContactoDao contactoDao) {
        this.contactoDao = contactoDao;
    }



    public void crearContacto(ContactoVo contacto) throws ErrorSQLException, FaltaParametroException {
           if (validarDatosObligatorios(contacto)){
            this.contactoDao.crearContacto(ConvertidorUtiles.converVoToEntity(contacto));
       } else {
            LOGGER.error("FaltaParametroException");
            throw new FaltaParametroException();
       }
    }

    public void borrarContacto(ContactoVo Contacto) throws ErrorSQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<ContactoVo> listarContactos() throws ErrorSQLException {
      List<Contacto> listaEntity = this.contactoDao.listarContactos();
      Iterator it = listaEntity.iterator();
      List<ContactoVo> listaVos = new ArrayList<ContactoVo>();
      while (it.hasNext()) {
          ContactoVo contactoVo = ConvertidorUtiles.convertEntityToVo((Contacto)it.next());
          listaVos.add(contactoVo);
      }
      return listaVos;
    }

    public ContactoVo buscarContacto(Integer id) throws ErrorSQLException, DatosNoEncontradosException {
        Contacto contacto = contactoDao.buscarContacto(id);
        if (contacto ==  null) {
            LOGGER.error("Datos no encontrados");
            throw new DatosNoEncontradosException();
        }
        return ConvertidorUtiles.convertEntityToVo(contacto);
    }

    public void modificarContacto(ContactoVo contacto) throws ErrorSQLException, FaltaParametroException {
         if (validarDatosObligatorios(contacto) && contacto.getId() != 0){
            this.contactoDao.modificarContacto(ConvertidorUtiles.converVoToEntity(contacto));
       } else {
            throw new FaltaParametroException();
       }
    }

     

    /**
     *
     * @param contacto
     * @return
     */
    private boolean validarDatosObligatorios (ContactoVo contacto) {
        boolean resultado = false;
        if (contacto != null && contacto.getApellido()!= null && contacto.getNombre() != null &&
                contacto.getEmpresaVo() != null) {
            resultado = true;
        }
        return resultado;
    }

}
