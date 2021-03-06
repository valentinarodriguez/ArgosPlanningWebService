package com.suricata.argos.WS.entidades;
// Generated 25/08/2010 08:00:38 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private String nick;
     private String apellido;
     private String telefono;
     private String email;
     private Long celular;
     private String cargo;
     private String contrasena;
     private Set oportunidads = new HashSet(0);
     private Set actividadsForResponsableUsuario = new HashSet(0);
     private Set actividadsForUsuario = new HashSet(0);
     private Set usuariorols = new HashSet(0);
     private Set seguimientos = new HashSet(0);
     private Set seguimientousuarios = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(String nombre, String nick, String apellido, String email, String cargo, String contrasena) {
        this.nombre = nombre;
        this.nick = nick;
        this.apellido = apellido;
        this.email = email;
        this.cargo = cargo;
        this.contrasena = contrasena;
    }
    public Usuario(String nombre, String nick, String apellido, String telefono, String email, Long celular, String cargo, String contrasena, Set oportunidads, Set actividadsForResponsableUsuario, Set actividadsForUsuario, Set usuariorols, Set seguimientos, Set seguimientousuarios) {
       this.nombre = nombre;
       this.nick = nick;
       this.apellido = apellido;
       this.telefono = telefono;
       this.email = email;
       this.celular = celular;
       this.cargo = cargo;
       this.contrasena = contrasena;
       this.oportunidads = oportunidads;
       this.actividadsForResponsableUsuario = actividadsForResponsableUsuario;
       this.actividadsForUsuario = actividadsForUsuario;
       this.usuariorols = usuariorols;
       this.seguimientos = seguimientos;
       this.seguimientousuarios = seguimientousuarios;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNick() {
        return this.nick;
    }
    
    public void setNick(String nick) {
        this.nick = nick;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Long getCelular() {
        return this.celular;
    }
    
    public void setCelular(Long celular) {
        this.celular = celular;
    }
    public String getCargo() {
        return this.cargo;
    }
    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getContrasena() {
        return this.contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public Set getOportunidads() {
        return this.oportunidads;
    }
    
    public void setOportunidads(Set oportunidads) {
        this.oportunidads = oportunidads;
    }
    public Set getActividadsForResponsableUsuario() {
        return this.actividadsForResponsableUsuario;
    }
    
    public void setActividadsForResponsableUsuario(Set actividadsForResponsableUsuario) {
        this.actividadsForResponsableUsuario = actividadsForResponsableUsuario;
    }
    public Set getActividadsForUsuario() {
        return this.actividadsForUsuario;
    }
    
    public void setActividadsForUsuario(Set actividadsForUsuario) {
        this.actividadsForUsuario = actividadsForUsuario;
    }
    public Set getUsuariorols() {
        return this.usuariorols;
    }
    
    public void setUsuariorols(Set usuariorols) {
        this.usuariorols = usuariorols;
    }
    public Set getSeguimientos() {
        return this.seguimientos;
    }
    
    public void setSeguimientos(Set seguimientos) {
        this.seguimientos = seguimientos;
    }
    public Set getSeguimientousuarios() {
        return this.seguimientousuarios;
    }
    
    public void setSeguimientousuarios(Set seguimientousuarios) {
        this.seguimientousuarios = seguimientousuarios;
    }




}


