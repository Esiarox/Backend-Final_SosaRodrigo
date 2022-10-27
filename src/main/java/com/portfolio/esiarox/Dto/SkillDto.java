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
public class SkillDto {
    @NotBlank
    private String titulo;
    @NotBlank
    private int nivel;

    public SkillDto() {
    }

    public SkillDto(String titulo, int nivel) {
        this.titulo = titulo;
        this.nivel = nivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
}
