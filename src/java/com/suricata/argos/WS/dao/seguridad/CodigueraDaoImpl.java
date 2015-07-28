/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.dao.seguridad;
import com.suricata.argos.WS.entidades.Estado;
import com.suricata.argos.WS.entidades.Tecnologia;
import com.suricata.argos.WS.entidades.Tipoactividad;
import com.suricata.argos.WS.entidades.Tipoproyecto;
import com.suricata.argos.WS.entidades.Tiposeguimiento;
import com.suricata.argos.WS.excepciones.ErrorSQLException;
import com.suricata.argos.WS.vo.TipoSeguimientoVo;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Valentina
 */
public class CodigueraDaoImpl extends HibernateDaoSupport implements CodigueraDao {

    private static final Logger LOGGER = Logger.getLogger(ContactoDaoImpl.class);


    public List<Tipoproyecto> listarTipoProyectos() throws ErrorSQLException {
       try {
              HibernateTemplate template = getHibernateTemplate();
               return getHibernateTemplate().find("from Tipoproyecto order by nombre");
           } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw  new  ErrorSQLException(e.getMessage(), e);
          }
    }

    public List<Tecnologia> listarTecnologias() throws ErrorSQLException {
        try {
            HibernateTemplate template = getHibernateTemplate();
            return getHibernateTemplate().find("from Tecnologia order by nombre");
       } catch (Exception e){
        LOGGER.error(e.getMessage(), e);
        throw  new  ErrorSQLException(e.getMessage(), e);
      }
    }

    public List<Estado> listarEstados() throws ErrorSQLException {
       try {
            HibernateTemplate template = getHibernateTemplate();
            return getHibernateTemplate().find("from Estado order by nombre");
       } catch (Exception e){
        LOGGER.error(e.getMessage(), e);
        throw  new  ErrorSQLException(e.getMessage(), e);
      }
    }

    public List<Tipoactividad> listarTipoActividades() throws ErrorSQLException {
       try {
            HibernateTemplate template = getHibernateTemplate();
             return getHibernateTemplate().find("from Tipoactividad order by nombre");
       } catch (Exception e){
        LOGGER.error(e.getMessage(), e);
        throw  new  ErrorSQLException(e.getMessage(), e);
      }
    }

    public List<Tiposeguimiento> listarTipoSeguimientos() throws ErrorSQLException {
       try {
            HibernateTemplate template = getHibernateTemplate();
            return getHibernateTemplate().find("from Tiposeguimiento order by nombre");
       } catch (Exception e){
        LOGGER.error(e.getMessage(), e);
        throw  new  ErrorSQLException(e.getMessage(), e);
      }
    }
}
