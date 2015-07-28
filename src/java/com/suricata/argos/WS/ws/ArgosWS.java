/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.WS.ws;

import com.suricata.argos.WS.excepciones.DatosDuplicadosException;
import com.suricata.argos.WS.excepciones.DatosNoEncontradosException;
import com.suricata.argos.WS.excepciones.DocumentoException;
import com.suricata.argos.WS.excepciones.ErrorSQLException;
import com.suricata.argos.WS.excepciones.FaltaParametroException;
import com.suricata.argos.WS.excepciones.TipoDatosException;
import com.suricata.argos.WS.logica.seguridad.ActividadManager;
import com.suricata.argos.WS.logica.seguridad.CodigueraManager;
import com.suricata.argos.WS.logica.seguridad.ContactoManager;
import com.suricata.argos.WS.logica.seguridad.EmpresaManager;
import com.suricata.argos.WS.logica.seguridad.OportunidadManager;
import com.suricata.argos.WS.logica.seguridad.RolManager;
import com.suricata.argos.WS.logica.seguridad.SeguimientoManager;
import com.suricata.argos.WS.logica.seguridad.UsuarioManager;
import com.suricata.argos.WS.vo.ActividadVo;
import com.suricata.argos.WS.vo.ContactoVo;
import com.suricata.argos.WS.vo.DocumentoVo;
import com.suricata.argos.WS.vo.EmpresaVo;
import com.suricata.argos.WS.vo.EstadoVo;
import com.suricata.argos.WS.vo.OportunidadVo;
import com.suricata.argos.WS.vo.RolVo;
import com.suricata.argos.WS.vo.SeguimientoVo;
import com.suricata.argos.WS.vo.TecnologiaVo;
import com.suricata.argos.WS.vo.TipoActividadVo;
import com.suricata.argos.WS.vo.TipoProyectoVo;
import com.suricata.argos.WS.vo.TipoSeguimientoVo;
import com.suricata.argos.WS.vo.UsuarioVo;
import java.lang.String;
import java.util.Date;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Valentina
 */
@WebService()
public class ArgosWS {
 String[] paths = {"applicationContext.xml"};
private ClassPathXmlApplicationContext ctx =new ClassPathXmlApplicationContext(paths);
private UsuarioManager usuarioManager = (UsuarioManager) ctx.getBean("usuarioManager");
private EmpresaManager empresaManager = (EmpresaManager) ctx.getBean("empresaManager");
private ContactoManager contactoManager = (ContactoManager) ctx.getBean("contactoManager");
private OportunidadManager oportunidadManager = (OportunidadManager) ctx.getBean("oportunidadManager");
private CodigueraManager codigueraManager = (CodigueraManager) ctx.getBean("codigueraManager");
private SeguimientoManager seguimientoManager = (SeguimientoManager) ctx.getBean("seguimientoManager");
private ActividadManager actividadManager = (ActividadManager) ctx.getBean("actividadManager");
private RolManager rolManager = (RolManager) ctx.getBean("rolManager");
/**

    /**
    * Se modifican los datos del usuario puede modificarse el estado. No se puede
    * modificar el nombre del usuario y as� tampoco no el tipo de usuario. Antes de
    * grabar debo verificar que no exista un mismo usuario con el mismo username en
    * un estado !=Cancelado.
    *
    * @param usuarioVO
    */
    @WebMethod
    public void modificarUsuario(UsuarioVo usuario) throws FaltaParametroException, ErrorSQLException, DatosDuplicadosException {
    this.usuarioManager.modificarUsuario(usuario);
    }

    /**
    * Se modifican los datos del usuario puede modificarse el estado. No se puede
    * modificar el nombre del usuario y as� tampoco no el tipo de usuario. Antes de
    * grabar debo verificar que no exista un mismo usuario con el mismo username en
    * un estado !=Cancelado.
    *
    * @param usuarioVO
    */
    @WebMethod
    public UsuarioVo buscarUsuario(Integer id) throws DatosNoEncontradosException, ErrorSQLException {
        UsuarioVo usuarioVo = null;
        usuarioVo = this.usuarioManager.buscarUsuario(id);
    return usuarioVo;
    }


    /**
    * Crea un nuevo usuario en el sistema. Antes debo verificar que no exista un
    * mismo usuario con el mismo username en un estado !=Cancelado.
    *
    * @param usuarioVO
    */
    @WebMethod
    public void crearUsuario(UsuarioVo usuario) throws FaltaParametroException, ErrorSQLException, DatosDuplicadosException {
        this.usuarioManager.crearUsuario(usuario);
    }

    /**
    * Se listan los usuarios del sistema mediante criterios de b�squeda.
    *
    * @param criterioBusqueda
    */
    @WebMethod
    public List<UsuarioVo> listarUsuarios() throws ErrorSQLException {
        return this.usuarioManager.listarUsuarios();
    }


    @WebMethod
    public void crearContacto(ContactoVo contacto) throws ErrorSQLException, FaltaParametroException {
        this.contactoManager.crearContacto(contacto);
    }

    @WebMethod
    public void borrarContacto(ContactoVo contacto) throws ErrorSQLException {
        this.contactoManager.borrarContacto(contacto);
    }

    @WebMethod
    public List<ContactoVo> listarContactos() throws ErrorSQLException {
        return this.contactoManager.listarContactos();
    }


    @WebMethod
    public ContactoVo buscarContacto(Integer id) throws ErrorSQLException, DatosNoEncontradosException {
        return this.contactoManager.buscarContacto(id);
    }

    @WebMethod
    public void modificarContacto(ContactoVo contacto) throws ErrorSQLException, FaltaParametroException {
        this.contactoManager.modificarContacto(contacto);
    }

    @WebMethod
    public void crearEmpresa(EmpresaVo empresa) throws ErrorSQLException, DatosDuplicadosException, FaltaParametroException {
        this.empresaManager.crearEmpresa(empresa);
    }

    @WebMethod
    public void borrarEmpresa(EmpresaVo empresa) throws ErrorSQLException {
        this.empresaManager.borrarEmpresa(empresa);
    }

    @WebMethod
    public List<EmpresaVo>  listarEmpresas() throws ErrorSQLException {
        return this.empresaManager.listarEmpresas();
    }

    @WebMethod
    public EmpresaVo buscarEmpresa(Integer id) throws ErrorSQLException, DatosNoEncontradosException {
        return this.empresaManager.buscarEmpresa(id);
    }

    @WebMethod
    public void modificarEmpresa(EmpresaVo empresa) throws ErrorSQLException, DatosDuplicadosException, FaltaParametroException {
        this.empresaManager.modificarEmpresa(empresa);
    }

    @WebMethod
    public void crearOportunidad(OportunidadVo oportunidad) throws ErrorSQLException, DatosDuplicadosException, FaltaParametroException, DocumentoException, TipoDatosException {
        this.oportunidadManager.crearOportunidad(oportunidad);
    }

    @WebMethod
    public void borrarOportunidad(OportunidadVo oportunidad) throws ErrorSQLException {
        this.oportunidadManager.borrarOportunidad(oportunidad);
    }

    @WebMethod
    public List<OportunidadVo>  listarOportunidades(String estado, Date fechaDesde, Date fechaHasta) throws ErrorSQLException, TipoDatosException {
        return this.oportunidadManager.listarOportunidades( estado,  fechaDesde,  fechaHasta);
    }

    @WebMethod
    public OportunidadVo buscarOportunidad(Integer id) throws ErrorSQLException, DatosNoEncontradosException, DocumentoException, TipoDatosException {
        return this.oportunidadManager.buscarOportunidad(id);
    }

    @WebMethod
    public void modificarOportunidad(OportunidadVo oportunidad) throws ErrorSQLException, DatosDuplicadosException, FaltaParametroException, TipoDatosException {
        this.oportunidadManager.modificarOportunidad(oportunidad);
    }

    @WebMethod
    public  List<TipoProyectoVo>  listarTipoProyectos() throws ErrorSQLException {
        return this.codigueraManager.listarTipoProyectos();
    }

    @WebMethod
    public List<TecnologiaVo>  listarTecnologias() throws ErrorSQLException {
        return this.codigueraManager.listarTecnologias();
    }

    @WebMethod
    public List<EstadoVo>  listarEstados() throws ErrorSQLException {
        return this.codigueraManager.listarEstados();
    }


    @WebMethod
    public  void crearSeguimiento(SeguimientoVo seguimiento) throws ErrorSQLException,FaltaParametroException, TipoDatosException {
        this.seguimientoManager.crearSeguimiento(seguimiento);
    }


    @WebMethod
    public  List<SeguimientoVo>  listarSeguimientos(String enviado, Date fechaDesde, Date fechaHasta) throws ErrorSQLException, TipoDatosException {
        return this.seguimientoManager.listarSeguimientos( enviado,  fechaDesde,  fechaHasta);
    }

    @WebMethod
    public SeguimientoVo buscarSeguimiento(Integer id) throws ErrorSQLException, DatosNoEncontradosException, TipoDatosException {
        return this.seguimientoManager.buscarSeguimiento(id);
    }

    @WebMethod
    public void modificarSeguimiento(SeguimientoVo seguimiento) throws ErrorSQLException, FaltaParametroException, TipoDatosException {
        this.seguimientoManager.modificarSeguimiento(seguimiento);
    }

    @WebMethod
    public void crearActividad(ActividadVo actividad) throws ErrorSQLException, FaltaParametroException, TipoDatosException, DocumentoException {
        this.actividadManager.crearActividad(actividad);
    }

    @WebMethod
    public List<ActividadVo>  listarActividades(String estado, Date fechaDesde, Date fechaHasta) throws ErrorSQLException, TipoDatosException {
        return this.actividadManager.listarActividades( estado,  fechaDesde,  fechaHasta);
    }

    @WebMethod
    public ActividadVo buscarActividad(Integer id) throws ErrorSQLException, DatosNoEncontradosException, TipoDatosException {
        return this.actividadManager.buscarActividad(id);
    }

    @WebMethod
    public void modificarActividad(ActividadVo actividad) throws ErrorSQLException, FaltaParametroException, TipoDatosException {
        this.actividadManager.modificarActividad(actividad);
    }

        @WebMethod
    public List<TipoActividadVo> listarTipoActividades() throws ErrorSQLException {
        return this.codigueraManager.listarTipoActividades();
    }

       @WebMethod
    public List<TipoSeguimientoVo> listarTipoSeguimientos() throws ErrorSQLException {
         return this.codigueraManager.listarTipoSeguimientos();
    }

        @WebMethod
    public  List<ActividadVo> listarUltimasActividadesPorUsuario(Long idUsuario) throws ErrorSQLException, TipoDatosException {
         return this.actividadManager.listarUltimasActividades(idUsuario);
    }

        @WebMethod
    public List<OportunidadVo> listarUltimasOportunidadesPorUsuario(Long idUsuario) throws ErrorSQLException, TipoDatosException {
         return this.oportunidadManager.listarUltimasOportunidades(idUsuario);
    }

        @WebMethod
    public List<SeguimientoVo> listarUltimosSeguimientosPorUsuario(Long idUsuario) throws ErrorSQLException, TipoDatosException {
         return this.seguimientoManager.listarUltimosSeguimientos(idUsuario);
    }

       @WebMethod
    public  List<ActividadVo> listarUltimasActividades() throws ErrorSQLException, TipoDatosException {
         return this.actividadManager.listarUltimasActividades();
    }

        @WebMethod
    public List<OportunidadVo> listarUltimasOportunidades() throws ErrorSQLException, TipoDatosException {
         return this.oportunidadManager.listarUltimasOportunidades();
    }

        @WebMethod
    public List<SeguimientoVo> listarUltimosSeguimientos() throws ErrorSQLException, TipoDatosException {
         return this.seguimientoManager.listarUltimosSeguimientos();
    }

        @WebMethod
    public void crearRol(RolVo rol) throws ErrorSQLException, FaltaParametroException{
        this.rolManager.crearRol(rol);
    }

        @WebMethod
    public List<RolVo>  listarRoles() throws ErrorSQLException {
        return this.rolManager.listarRoles();
    }

        @WebMethod
    public RolVo buscarRol(Integer id) throws ErrorSQLException, DatosNoEncontradosException {
        return this.rolManager.buscarRol(id);
    }

        @WebMethod
    public void modificarRol(RolVo rol) throws ErrorSQLException, FaltaParametroException {
        this.rolManager.modificarRol(rol);
    }

        @WebMethod
    public List<RolVo> listarRolesPorUsuario(Integer idUsuario) throws ErrorSQLException, FaltaParametroException {
        return this.rolManager.listarRoles(idUsuario);
    }

     @WebMethod
    public byte[] descargarPlantilla(String ruta) throws ErrorSQLException, FaltaParametroException, DocumentoException {
        return this.actividadManager.descargarPlantilla(ruta);
    }

       @WebMethod
    public DocumentoVo buscarDocumento(String nombrePlantilla) throws ErrorSQLException, FaltaParametroException {
        return this.actividadManager.buscarDocumento(nombrePlantilla);
    }
       @WebMethod
    public  UsuarioVo validarUsuario(String nombre, String contraseña) throws ErrorSQLException, DatosNoEncontradosException{
       return this.usuarioManager.buscarUsuario(nombre, contraseña);
    }
}