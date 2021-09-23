/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TPBD.Frontier.Interfaces;

import com.TPBD.Frontier.Entidades.FluxoVeiculoEntidade;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author IanCarlosAfonsodaSil
 */
public interface IFluxoVeiculoBusiness {
    public int cadastraFluxo(FluxoVeiculoEntidade novoFluxo);
    public int editaFluxo(int id, FluxoVeiculoEntidade novosDados);
    public int finalizaFluxoAberto(int id);
    public ArrayList<FluxoVeiculoEntidade> listaFluxos();
    public ArrayList<FluxoVeiculoEntidade> listaFluxosAbertos();
}
