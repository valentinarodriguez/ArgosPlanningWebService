/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.suricata.argos.argos.WS.logica.utiles;

import com.suricata.argos.WS.entidades.Actividad;
import com.suricata.argos.WS.entidades.Contacto;
import com.suricata.argos.WS.entidades.Documento;
import com.suricata.argos.WS.entidades.Empresa;
import com.suricata.argos.WS.entidades.Estado;
import com.suricata.argos.WS.entidades.Oportunidad;
import com.suricata.argos.WS.entidades.Rol;
import com.suricata.argos.WS.entidades.Seguimiento;
import com.suricata.argos.WS.entidades.Seguimientotiposeguimiento;
import com.suricata.argos.WS.entidades.Tecnologia;
import com.suricata.argos.WS.entidades.Tipoactividad;
import com.suricata.argos.WS.entidades.Tipoproyecto;
import com.suricata.argos.WS.entidades.Tiposeguimiento;
import com.suricata.argos.WS.entidades.Usuario;
import com.suricata.argos.WS.vo.ActividadVo;
import com.suricata.argos.WS.vo.ContactoVo;
import com.suricata.argos.WS.vo.DocumentoVo;
import com.suricata.argos.WS.vo.EmpresaVo;
import com.suricata.argos.WS.vo.EstadoVo;
import com.suricata.argos.WS.vo.OportunidadVo;
import com.suricata.argos.WS.vo.RolVo;
import com.suricata.argos.WS.vo.SeguimientoTipoSeguimientoVo;
import com.suricata.argos.WS.vo.SeguimientoVo;
import com.suricata.argos.WS.vo.TecnologiaVo;
import com.suricata.argos.WS.vo.TipoActividadVo;
import com.suricata.argos.WS.vo.TipoProyectoVo;
import com.suricata.argos.WS.vo.TipoSeguimientoVo;
import com.suricata.argos.WS.vo.UsuarioVo;
import java.util.Iterator;
import javax.xml.datatype.DatatypeConfigurationException;

/**
 *
 * @author Valentina
 */
public class ConvertidorUtiles {


     /**
     *
     * @param usuario
     * @return
     */
    public static UsuarioVo convertEntityToVo(Usuario usuario){
        UsuarioVo usuarioVo = new UsuarioVo();
        if (usuario != null) {
            usuarioVo.setApellido(usuario.getApellido());
            usuarioVo.setCargo(usuario.getCargo());
            usuarioVo.setEmail(usuario.getEmail());
            usuarioVo.setCelular(usuario.getCelular());
            usuarioVo.setId(usuario.getId());
            usuarioVo.setNick(usuario.getNick());
            usuarioVo.setNombre(usuario.getNombre());
            usuarioVo.setTelefono(usuario.getTelefono());
            usuarioVo.setContrasena(usuario.getContrasena());
        }
         return usuarioVo;
    }

     public static RolVo convertEntityToVo(Rol rol){
        RolVo rolVo = new RolVo();
        if (rol != null) {
           rolVo.setId(rol.getId());
           if (rol.getNombre() != null)
            rolVo.setNombre(rol.getNombre());
        }
         return rolVo;
    }

     public static DocumentoVo convertEntityToVo(Documento documento){
        DocumentoVo documentoVo = new DocumentoVo();
        if (documento != null) {
            documentoVo.setId(documento.getId());
            documentoVo.setNombre(documento.getNombre());
            documentoVo.setTipo(documento.getTipo());
            documentoVo.setRuta(documento.getRuta());
            documentoVo.setTamano(documento.getTamano());
        }
         return documentoVo;
    }



      /**
       *
       * @param contactoVo
       * @return
       */
      public static  ContactoVo convertEntityToVo(Contacto contacto){
        ContactoVo contactoVo = new ContactoVo();
        if (contactoVo != null) {
            contactoVo.setApellido(contacto.getApellido());
            contactoVo.setCargo(contacto.getCargo());
            contactoVo.setEmail(contacto.getEmail());
            contactoVo.setCelular(contacto.getCelular());
            contactoVo.setId(contacto.getId());
            contactoVo.setNombre(contacto.getNombre());
            contactoVo.setTelefono(contacto.getTelefono());
            contactoVo.setChat(contacto.getChat());
            contactoVo.setComentarios(contacto.getComentarios());
            contactoVo.setEmpresaVo(convertEntityToVo(contacto.getEmpresa()));
        }
         return contactoVo;
    }

    
      /**
       *
       * @param oportunidadVo
       * @return
       */
      public static OportunidadVo convertEntityToVo(Oportunidad oportunidad) throws DatatypeConfigurationException{
        OportunidadVo oportunidadVo = new OportunidadVo();
        if (oportunidadVo != null) {
            oportunidadVo.setCodigoInterno(oportunidad.getCodigoInterno());
            oportunidadVo.setContacto(convertEntityToVo(oportunidad.getContacto()));
            oportunidadVo.setDescripcionCierre(oportunidad.getDescripcionCierre());
            oportunidadVo.setEmpresa(convertEntityToVo(oportunidad.getEmpresa()));
            oportunidadVo.setEstado(convertEntityToVo(oportunidad.getEstado()));
            oportunidadVo.setFecha(oportunidad.getFecha());
            oportunidadVo.setId(oportunidad.getId());
            oportunidadVo.setTecnologia(convertEntityToVo(oportunidad.getTecnologia()));
            oportunidadVo.setTipoproyecto(convertEntityToVo(oportunidad.getTipoproyecto()));
            oportunidadVo.setTitulo(oportunidad.getTitulo());
            oportunidadVo.setUsuario(convertEntityToVo(oportunidad.getUsuario()));
            oportunidadVo.setFechaCierre(oportunidad.getFechaCierre());
            if (oportunidad.getDocumento() != null) {
                DocumentoVo documentoVo = new DocumentoVo();
                documentoVo.setId(oportunidad.getDocumento().getId());
                documentoVo.setNombre(oportunidad.getDocumento().getNombre());
                documentoVo.setTipo(oportunidad.getDocumento().getTipo());
               // documentoVo.setOportunidad(oportunidadVo);
                documentoVo.setRuta(oportunidad.getDocumento().getRuta());
                documentoVo.setTamano(oportunidad.getDocumento().getTamano());
                oportunidadVo.setDocumento(documentoVo);
            }
        
        }
        return oportunidadVo;
    }

        public static  EmpresaVo convertEntityToVo(Empresa empresa){
        EmpresaVo empresaVo = new EmpresaVo();
        if (empresaVo != null) {
         //   empresa.setContactos(converVoToEntity(empresaVo.get));
            //faltan contactos y oportunidades
            empresaVo.setDescripcion(empresa.getDescripcion());
            empresaVo.setDireccion(empresa.getDireccion());
            empresaVo.setRubro(empresa.getRubro());
            empresaVo.setId(empresa.getId());
            empresaVo.setNombre(empresa.getNombre());
            empresaVo.setTelefono(empresa.getTelefono());
            empresaVo.setRut(empresa.getRut());
        }
         return empresaVo;
    }

      public static  TipoProyectoVo convertEntityToVo(Tipoproyecto tipoproyecto){
        TipoProyectoVo tipoproyectoVo = new TipoProyectoVo();
        if (tipoproyectoVo != null) {
            tipoproyectoVo.setId(tipoproyecto.getId());
            tipoproyectoVo.setDescripcion(tipoproyecto.getDescripcion());
            tipoproyectoVo.setNombre(tipoproyecto.getNombre());
        }
        return tipoproyectoVo;
    }


     public static  TecnologiaVo convertEntityToVo(Tecnologia tecnologia){
        TecnologiaVo tecnologiaVo = new TecnologiaVo();
        if (tecnologiaVo != null) {
            tecnologiaVo.setId(tecnologia.getId());
            tecnologiaVo.setDescripcion(tecnologia.getDescripcion());
            tecnologiaVo.setNombre(tecnologia.getNombre());
        }
        return tecnologiaVo;
    }

    public static  EstadoVo convertEntityToVo(Estado estado){
        EstadoVo estadoVo = new EstadoVo();
        if (estado != null) {
            estadoVo.setId(estado.getId());
            estadoVo.setDescripcion(estado.getDescripcion());
            estadoVo.setNombre(estado.getNombre());
        }
        return estadoVo;
    }

      public static TipoActividadVo convertEntityToVo(Tipoactividad tipoActividad){
        TipoActividadVo tipoActividadVo = new TipoActividadVo();
        if (tipoActividadVo != null) {
            tipoActividadVo.setId(tipoActividad.getId());
            tipoActividadVo.setDescripcion(tipoActividad.getDescripcion());
            tipoActividadVo.setNombre(tipoActividad.getNombre());
        }
        return tipoActividadVo;
    }



     public static  TipoSeguimientoVo convertEntityToVo(Tiposeguimiento tiposeguimiento){
        TipoSeguimientoVo tipoSeguimientoVo = new TipoSeguimientoVo();
        if (tipoSeguimientoVo != null) {
            tipoSeguimientoVo.setId(tiposeguimiento.getId());
            tipoSeguimientoVo.setDescripcion(tiposeguimiento.getDescripcion());
            tipoSeguimientoVo.setNombre(tiposeguimiento.getNombre());
        }
        return tipoSeguimientoVo;
    }

       public static SeguimientoVo convertEntityToVo(Seguimiento seguimiento) throws DatatypeConfigurationException{
        SeguimientoVo seguimientoVo = new SeguimientoVo();
        if (seguimientoVo != null) {
            seguimientoVo.setId(seguimiento.getId());
            seguimientoVo.setActividad(convertEntityToVo(seguimiento.getActividad()));
            seguimientoVo.setFechaAnuncio(seguimiento.getFechaAnuncio());
            seguimientoVo.setFechaVencimiento(seguimiento.getFechaVencimiento());
            if (seguimiento.getSeguimientotiposeguimientos() != null) {
                Iterator<Seguimientotiposeguimiento>  it = seguimiento.getSeguimientotiposeguimientos().iterator();
                while (it.hasNext()){
                    Seguimientotiposeguimiento seguimientoTipoSeguimiento = it.next();
                    SeguimientoTipoSeguimientoVo seguimientoTipoSeguimientoVo = new SeguimientoTipoSeguimientoVo();
                    seguimientoTipoSeguimientoVo.setId(seguimientoTipoSeguimiento.getId());
                    TipoSeguimientoVo tipoSeguimientoVo = convertEntityToVo(seguimientoTipoSeguimiento.getTiposeguimiento());
                    seguimientoTipoSeguimientoVo.setTiposeguimiento(tipoSeguimientoVo);
                    seguimientoVo.getSeguimientotiposeguimientos().add(seguimientoTipoSeguimientoVo);
                }
            }
            seguimientoVo.setUsuario(convertEntityToVo(seguimiento.getUsuario()));
            seguimientoVo.setEnviado(seguimiento.getEnviado());
        }
        return seguimientoVo;
    }

     public static ActividadVo convertEntityToVo(Actividad actividad) throws DatatypeConfigurationException{
        ActividadVo actividadVo = new ActividadVo();
        if (actividadVo != null) {
            actividadVo.setDescripcion(actividad.getDescripcion());
            actividadVo.setDescripcionCierre(actividad.getDescripcionCierre());
            actividadVo.setEstado(convertEntityToVo(actividad.getEstado()));
            actividadVo.setFechaCreacion(actividad.getFechaCreacion());
            actividadVo.setFechaVencimiento(actividad.getFechaVencimiento());
            actividadVo.setId(actividad.getId());
            actividadVo.setOportunidad(convertEntityToVo(actividad.getOportunidad()));
            actividadVo.setResponsableCliente(convertEntityToVo(actividad.getContacto()));
            actividadVo.setTipoactividad(convertEntityToVo(actividad.getTipoactividad()));
            actividadVo.setTitulo(actividad.getTitulo());
            actividadVo.setUsuario(convertEntityToVo(actividad.getUsuarioByUsuario()));
            actividadVo.setResponsableUsuario(convertEntityToVo(actividad.getUsuarioByResponsableUsuario()));
              if (actividad.getDocumento() != null) {
                DocumentoVo documentoVo = new DocumentoVo();
                documentoVo.setId(actividad.getDocumento().getId());
                documentoVo.setNombre(actividad.getDocumento().getNombre());
                documentoVo.setTipo(actividad.getDocumento().getTipo());
               // documentoVo.setOportunidad(oportunidadVo);
                documentoVo.setRuta(actividad.getDocumento().getRuta());
                documentoVo.setTamano(actividad.getDocumento().getTamano());
                actividadVo.setDocumento(documentoVo);
            }
        }
        return actividadVo;
    }

     /**
       *
       * @param contactoVo
       * @return
       */
      public static  Contacto converVoToEntity(ContactoVo contactoVo){
        Contacto contacto = new Contacto();
        if (contacto != null) {
            contacto.setApellido(contactoVo.getApellido());
            contacto.setCargo(contactoVo.getCargo());
            contacto.setEmail(contactoVo.getEmail());
            contacto.setCelular(contactoVo.getCelular());
            contacto.setId(contactoVo.getId());
            contacto.setNombre(contactoVo.getNombre());
            contacto.setTelefono(contactoVo.getTelefono());
            contacto.setChat(contactoVo.getChat());
            contacto.setComentarios(contactoVo.getComentarios());
            contacto.setEmpresa(converVoToEntity(contactoVo.getEmpresaVo()));
        }
         return contacto;
    }

      public static Seguimiento converVoToEntity(SeguimientoVo seguimientoVo) throws DatatypeConfigurationException{
        Seguimiento seguimiento = new Seguimiento();
        if (seguimiento != null) {
         Actividad actividad = new Actividad();
         actividad.setId(seguimientoVo.getActividad().getId());
         seguimiento.setActividad(actividad);
         seguimiento.setFechaAnuncio(seguimientoVo.getFechaAnuncio());
         seguimiento.setFechaVencimiento(seguimientoVo.getFechaVencimiento());
         seguimiento.setId(seguimientoVo.getId());
         seguimiento.setUsuario(converVoToEntity(seguimientoVo.getUsuario()));
         Iterator<SeguimientoTipoSeguimientoVo>  it = seguimientoVo.getSeguimientotiposeguimientos().iterator();
            while (it.hasNext()){
                SeguimientoTipoSeguimientoVo seguimientoTipoSeguimientoVo = it.next();
                Seguimientotiposeguimiento seguimientoTipoSeguimiento = new Seguimientotiposeguimiento();
                seguimientoTipoSeguimiento.setId(seguimientoTipoSeguimientoVo.getId());
                Tiposeguimiento tipoSeguimiento = converVoToEntity(seguimientoTipoSeguimientoVo.getTiposeguimiento());
                seguimientoTipoSeguimiento.setTiposeguimiento(tipoSeguimiento);
                seguimiento.getSeguimientotiposeguimientos().add(seguimientoTipoSeguimiento);
            }
         seguimiento.setEnviado(seguimientoVo.getEnviado());
        }
         return seguimiento;
       }

       public static Tiposeguimiento converVoToEntity(TipoSeguimientoVo tipoSeguimientoVo){
        Tiposeguimiento tiposeguimiento = new Tiposeguimiento();
        if (tipoSeguimientoVo != null) {
            tiposeguimiento.setId(tipoSeguimientoVo.getId());
            tiposeguimiento.setDescripcion(tipoSeguimientoVo.getDescripcion());
            tiposeguimiento.setNombre(tipoSeguimientoVo.getNombre());
        }
        return tiposeguimiento;
    }

       public static Actividad converVoToEntity(ActividadVo actividadVo) throws DatatypeConfigurationException{
        Actividad actividad = new Actividad();
        if (actividad != null) {
            actividad.setDescripcion(actividadVo.getDescripcion());
            actividad.setDescripcionCierre(actividadVo.getDescripcionCierre());
            actividad.setEstado(converVoToEntity(actividadVo.getEstado()));
            actividad.setFechaCreacion(actividadVo.getFechaCreacion());
            actividad.setFechaVencimiento(actividadVo.getFechaVencimiento());
            actividad.setId(actividadVo.getId());
            Oportunidad oportunidad = new Oportunidad();
            oportunidad.setId(actividadVo.getOportunidad().getId());
            actividad.setOportunidad(oportunidad);
            Contacto contacto = new Contacto();
            contacto.setId(actividadVo.getResponsableCliente().getId());
            actividad.setContacto(contacto);
            Usuario responsableUsuario = new Usuario();
            responsableUsuario.setId(actividadVo.getResponsableUsuario().getId());
            actividad.setUsuarioByResponsableUsuario(responsableUsuario);
            Tipoactividad tipoactividad = new Tipoactividad();
            tipoactividad.setId(actividadVo.getTipoactividad().getId());
            actividad.setTipoactividad(tipoactividad);
            actividad.setTitulo(actividadVo.getTitulo());
            actividad.setUsuarioByUsuario(converVoToEntity(actividadVo.getUsuario()));
              if (actividadVo.getDocumento() != null) {
                Documento documento = new Documento();
               // documento.setId(actividad.getDocumento().getId());
                documento.setNombre(actividadVo.getDocumento().getNombre());
               // documento.setOportunidad(oportunidad);
                documento.setRuta(actividadVo.getDocumento().getRuta());
                documento.setTipo(actividadVo.getDocumento().getTipo());
                documento.setTamano(actividadVo.getDocumento().getTamano());
                actividad.setDocumento(documento);
            }
        }
         return actividad;
    }

      /**
       *
       * @param usuarioVo
       * @return
       */
      public static Usuario converVoToEntity(UsuarioVo usuarioVo){
        Usuario usuario = new Usuario();
        if (usuario != null) {
            usuario.setApellido(usuarioVo.getApellido());
            usuario.setCargo(usuarioVo.getCargo());
            usuario.setEmail(usuarioVo.getEmail());
            usuario.setCelular(usuarioVo.getCelular());
            usuario.setId(usuarioVo.getId());
            usuario.setNick(usuarioVo.getNick());
            usuario.setNombre(usuarioVo.getNombre());
            usuario.setTelefono(usuarioVo.getTelefono());
            usuario.setContrasena(usuarioVo.getContrasena());
        }
         return usuario;
    }


      /**
       *
       * @param oportunidadVo
       * @return
       */
      public static  Oportunidad converVoToEntity(OportunidadVo oportunidadVo) throws DatatypeConfigurationException{
        Oportunidad oportunidad = new Oportunidad();
        if (oportunidad != null) {
            oportunidad.setCodigoInterno(oportunidadVo.getCodigoInterno());
            oportunidad.setContacto(converVoToEntity(oportunidadVo.getContacto()));
            oportunidad.setDescripcionCierre(oportunidadVo.getDescripcionCierre());
            oportunidad.setEmpresa(converVoToEntity(oportunidadVo.getEmpresa()));
            oportunidad.setEstado(converVoToEntity(oportunidadVo.getEstado()));
            oportunidad.setFecha(oportunidadVo.getFecha());
            oportunidad.setId(oportunidadVo.getId());
            oportunidad.setTecnologia(converVoToEntity(oportunidadVo.getTecnologia()));
            oportunidad.setTipoproyecto(converVoToEntity(oportunidadVo.getTipoproyecto()));
            oportunidad.setTitulo(oportunidadVo.getTitulo());
            oportunidad.setUsuario(converVoToEntity(oportunidadVo.getUsuario()));
            oportunidad.setFechaCierre(oportunidadVo.getFechaCierre());
            if (oportunidadVo.getDocumento() != null) {
                Documento documento = new Documento();
                documento.setId(oportunidadVo.getDocumento().getId());
                documento.setNombre(oportunidadVo.getDocumento().getNombre());
               // documento.setOportunidad(oportunidad);
                documento.setRuta(oportunidadVo.getDocumento().getRuta());
                documento.setTipo(oportunidadVo.getDocumento().getTipo());
                documento.setTamano(oportunidadVo.getDocumento().getTamano());
                oportunidad.setDocumento(documento);
            }
         }

        return oportunidad;
    }

        public static  Empresa converVoToEntity(EmpresaVo empresaVo){
        Empresa empresa = new Empresa();
        if (empresaVo != null) {
         //   empresa.setContactos(converVoToEntity(empresaVo.get));
            //faltan contactos y oportunidades
            empresa.setDescripcion(empresaVo.getDescripcion());
            empresa.setDireccion(empresaVo.getDireccion());
            empresa.setRubro(empresaVo.getRubro());
            empresa.setId(empresaVo.getId());
            empresa.setNombre(empresaVo.getNombre());
            empresa.setTelefono(empresaVo.getTelefono());
            empresa.setRut(empresaVo.getRut());
        }
         return empresa;
    }

      public static  Tipoproyecto converVoToEntity(TipoProyectoVo tipoproyectoVo){
        Tipoproyecto tipoproyecto = new Tipoproyecto();
        if (tipoproyectoVo != null) {
            tipoproyecto.setId(tipoproyectoVo.getId());
            tipoproyecto.setDescripcion(tipoproyectoVo.getDescripcion());
            tipoproyecto.setNombre(tipoproyectoVo.getNombre());
        }
        return tipoproyecto;
    }


     public static  Tecnologia converVoToEntity(TecnologiaVo tecnologiaVo){
        Tecnologia tecnologia = new Tecnologia();
        if (tecnologia != null) {
            tecnologia.setId(tecnologiaVo.getId());
            tecnologia.setDescripcion(tecnologiaVo.getDescripcion());
            tecnologia.setNombre(tecnologiaVo.getNombre());
        }
        return tecnologia;
    }

    public static  Estado converVoToEntity(EstadoVo estadoVo){
        Estado estado = new Estado();
        if (estado != null) {
            estado.setId(estadoVo.getId());
            estado.setDescripcion(estadoVo.getDescripcion());
            estado.setNombre(estadoVo.getNombre());
        }
        return estado;
    }

     public static Tipoactividad converVoToEntity(TipoActividadVo tipoActividadVo){
        Tipoactividad tipoActividad = new Tipoactividad();
        if (tipoActividad != null) {
            tipoActividad.setId(tipoActividadVo.getId());
            tipoActividad.setDescripcion(tipoActividadVo.getDescripcion());
            tipoActividad.setNombre(tipoActividadVo.getNombre());
        }
        return tipoActividad;
    }

      public static Rol converVoToEntity(RolVo rolVo){
        Rol rol = new Rol();
        if (rolVo != null) {
           rol.setId(rolVo.getId());
           rol.setNombre(rolVo.getNombre());
        }
        return rol;
    }

}
