/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.esiarox.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Esiarox
 */
public class PersonaDto {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    private String imagen;
    @NotBlank
    private String titulo;
    private String acercaDe;
    private String imagenBanner;

    public PersonaDto() {
    }

    public PersonaDto(String nombre, String apellido, String imagen, String titulo, String acercaDe, String imagenBanner) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.imagen = imagen;
        this.titulo = titulo;
        this.acercaDe = acercaDe;
        this.imagenBanner = imagenBanner;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAcercaDe() {
        return acercaDe;
    }

    public void setAcercaDe(String acercaDe) {
        this.acercaDe = acercaDe;
    }

    public String getImagenBanner() {
        return imagenBanner;
    }

    public void setImagenBanner(String imagenBanner) {
        this.imagenBanner = imagenBanner;
    } 

}
