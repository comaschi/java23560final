package com.codoacodo.modelo;

import java.util.Date;

public class Orador {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String tema;
    private Date fechaCreacion;
    private String imagen;

    public Orador() {
    }
    
    public Orador( long id, String nombre, String apellido, String email, String tema,  String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.tema = tema;
        this.imagen = imagen;
    }
    public Orador( String nombre, String apellido, String email, String tema,  String imagen) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.tema = tema;
        this.imagen = imagen;
    }

    public Orador(Long id, String nombre, String apellido, String email, String tema, Date fechaCreacion, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.tema = tema;
        this.fechaCreacion = fechaCreacion;
        this.imagen = imagen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Orador{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", tema=" + tema + ", fechaCreacion=" + fechaCreacion + ", imagen=" + imagen + '}';
    }
    
    

}
