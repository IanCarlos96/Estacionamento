/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TPBD.Frontier.Entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author IanCarlosAfonsodaSil
 */
public class ReciboEntidade {
    private int id;
    private int idVeiculo;
    private LocalDateTime horarioEntrada;
    private LocalDateTime horarioSaida;
    private Double valor;
    private String pago;

    public ReciboEntidade() {
    }

    public ReciboEntidade(int id, int idVeiculo, LocalDateTime horarioEntrada, LocalDateTime horarioSaida, double valor, String pago) {
        this.id = id;
        this.idVeiculo = idVeiculo;
        this.horarioEntrada = horarioEntrada;
        this.horarioSaida = horarioSaida;
        this.valor = valor;
        this.pago = pago;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public LocalDateTime getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(LocalDateTime horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public LocalDateTime getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(LocalDateTime horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    
}
