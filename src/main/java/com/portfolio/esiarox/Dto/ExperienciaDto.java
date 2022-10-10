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
public class ExperienciaDto {
    @NotBlank
    private String nombreExp;
    @NotBlank
    private String descripcion;
    @NotBlank
    private int duracion;

    public ExperienciaDto() {
    }

    public ExperienciaDto(String nombreExp, String descripcion, int duracion) {
        this.nombreExp = nombreExp;
        this.descripcion = descripcion;
        this.duracion = duracion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getNombreExp() {
        return nombreExp;
    }

    public void setNombreExp(String nombreExp) {
        this.nombreExp = nombreExp;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
