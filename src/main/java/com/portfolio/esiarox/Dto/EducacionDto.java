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
public class EducacionDto {
    @NotBlank
    private int anio;
    @NotBlank
    private String titulo;
    @NotBlank
    private String institucion;

    public EducacionDto() {
    }

    public EducacionDto(int anio, String titulo, String institucion) {
        this.anio = anio;
        this.titulo = titulo;
        this.institucion = institucion;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }
    
}
