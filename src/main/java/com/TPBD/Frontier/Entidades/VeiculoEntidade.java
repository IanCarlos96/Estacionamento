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
public class VeiculoEntidade{
    private int id;
    private int idCliente;
    private String placa;
    private String modelo;
    private String marca;

    public VeiculoEntidade(int id, int idCliente, String placa, String modelo, String marca) {
        this.id = id;
        this.idCliente = idCliente;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
    }

    public VeiculoEntidade() {
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    
    
}
