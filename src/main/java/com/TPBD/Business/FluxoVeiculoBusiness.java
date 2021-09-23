/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TPBD.Business;

import com.TPBD.Frontier.Entidades.FluxoVeiculoEntidade;
import com.TPBD.Frontier.Entidades.VagaEntidade;
import com.TPBD.Frontier.Entidades.VeiculoEntidade;
import com.TPBD.Frontier.Interfaces.IFluxoVeiculoBusiness;
import com.TPBD.Repository.FluxoVeiculoRepository;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author IanCarlosAfonsodaSil
 */
public class FluxoVeiculoBusiness implements IFluxoVeiculoBusiness {

    private FluxoVeiculoRepository fluxoVeiculoRepository;
    public VeiculoBusiness veiculoBusiness;
    public VagaBusiness vagaBusiness;
    
    
    
    public FluxoVeiculoEntidade fluxo;
    
    public FluxoVeiculoBusiness() {
        fluxoVeiculoRepository = new FluxoVeiculoRepository();
        veiculoBusiness = new VeiculoBusiness();
        vagaBusiness = new VagaBusiness();
    }
    
    @Override
    public int cadastraFluxo(FluxoVeiculoEntidade novoFluxo) {
        return fluxoVeiculoRepository.cadastraFluxo(novoFluxo);
    }

    @Override
    public int editaFluxo(int id, FluxoVeiculoEntidade novosDados) {
        return fluxoVeiculoRepository.editaFluxo(id, novosDados);
    }

    @Override
    public int finalizaFluxoAberto(int id) {
        return fluxoVeiculoRepository.finalizaFluxoAberto(id);
    }

    @Override
    public ArrayList<FluxoVeiculoEntidade> listaFluxos() {
        return fluxoVeiculoRepository.listaFluxos();
    }

    @Override
    public ArrayList<FluxoVeiculoEntidade> listaFluxosAbertos() {
        return fluxoVeiculoRepository.listaFluxosAbertos();
    }
    
}
