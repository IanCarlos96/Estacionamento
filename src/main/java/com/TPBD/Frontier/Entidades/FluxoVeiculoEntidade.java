/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TPBD.Frontier.Entidades;

import java.time.LocalDateTime;

/**
 *
 * @author IanCarlosAfonsodaSil
 */
public class FluxoVeiculoEntidade {
    private int id;
    private int idVeiculo;
    private int idVaga;
    private LocalDateTime horarioEntrada;
    private LocalDateTime horarioSaida;
    private String gerarRecibo;

    public FluxoVeiculoEntidade() {
    }

    public FluxoVeiculoEntidade(int idVeiculo, int idVaga, String gerarRecibo){
        this.idVeiculo = idVeiculo;
        this.idVaga = idVaga;
        this.gerarRecibo = gerarRecibo;
    }
    
    public FluxoVeiculoEntidade(int idVeiculo, int idVaga, LocalDateTime horarioEntrada) {
        this.idVeiculo = idVeiculo;
        this.idVaga = idVaga;
        this.horarioEntrada = horarioEntrada;
    }

    public FluxoVeiculoEntidade(int id, int idVeiculo, int idVaga, LocalDateTime horarioEntrada, LocalDateTime horarioSaida, String gerarRecibo) {
        this.id = id;
        this.idVeiculo = idVeiculo;
        this.idVaga = idVaga;
        this.horarioEntrada = horarioEntrada;
        this.horarioSaida = horarioSaida;
        this.gerarRecibo = gerarRecibo;
    }

    public String getGerarRecibo() {
        return gerarRecibo;
    }

    public void setGerarRecibo(String gerarRecibo) {
        this.gerarRecibo = gerarRecibo;
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

    public int getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(int idVaga) {
        this.idVaga = idVaga;
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
    
    
}
