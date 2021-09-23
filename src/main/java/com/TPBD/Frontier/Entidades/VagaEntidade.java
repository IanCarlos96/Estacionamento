/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TPBD.Frontier.Entidades;

/**
 *
 * @author IanCarlosAfonsodaSil
 */
public class VagaEntidade {
    private int id;
    private String nomeVaga;
    private String tipo;
    private String ocupada;

    public VagaEntidade() {
    }

    public VagaEntidade(int id, String nomeVaga, String tipo, String ocupada) {
        this.id = id;
        this.nomeVaga = nomeVaga;
        this.tipo = tipo;
        this.ocupada = ocupada;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeVaga() {
        return nomeVaga;
    }

    public void setNomeVaga(String nomeVaga) {
        this.nomeVaga = nomeVaga;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOcupada() {
        return ocupada;
    }

    public void setOcupada(String ocupada) {
        this.ocupada = ocupada;
    }

    
    
    
}
