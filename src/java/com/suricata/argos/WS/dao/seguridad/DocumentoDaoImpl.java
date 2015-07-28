/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.dao.seguridad;

import com.suricata.argos.WS.entidades.Documento;
import com.suricata.argos.WS.excepciones.ErrorSQLException;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Valentina
 */
public class DocumentoDaoImpl extends HibernateDaoSupport implements
DocumentoDao {

private static final Logger LOGGER = Logger.getLogger(DocumentoDaoImpl.class);

      public Documento obtenerDocumento(String nombre) throws ErrorSQLException {
          Documento documento = null;
          try {
               List<Documento> docs = getHibernateTemplate().find("from Documento where nombre =? ", nombre);
               if (docs != null && docs.size()!= 0)
                  documento = (Documento) docs.get(0);
          } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw  new  ErrorSQLException(e.getMessage(), e);
          }
          return documento;
	}

}
