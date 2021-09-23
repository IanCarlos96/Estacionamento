/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TPBD.Business;

import com.TPBD.Frontier.Entidades.ReciboEntidade;
import com.TPBD.Frontier.Interfaces.IReciboBusiness;
import com.TPBD.Repository.ReciboRepository;
import java.util.ArrayList;

/**
 *
 * @author IanCarlosAfonsodaSil
 */
public class ReciboBusiness implements IReciboBusiness {

    private ReciboRepository reciboRepository;
    
    public ReciboBusiness() {
        reciboRepository = new ReciboRepository();
    }

    @Override
    public int editaRecibo(int id, ReciboEntidade novosDados) {
        return reciboRepository.editaRecibo(id, novosDados);
    }

    @Override
    public ReciboEntidade buscaRecibo(int id) {
        return reciboRepository.buscaRecibo(id);
    }

    @Override
    public ArrayList<ReciboEntidade> buscaRecibosPorVeiculo(int idVeiculo) {
        return reciboRepository.buscaRecibosPorVeiculo(idVeiculo);
    }

    @Override
    public ArrayList<ReciboEntidade> buscaRecibosPorCliente(int idCliente) {
        return reciboRepository.buscaRecibosPorCliente(idCliente);
    }

    @Override
    public ArrayList<ReciboEntidade> buscaRecibosPorEmpresa(int idEmpresa) {
        return reciboRepository.buscaRecibosPorEmpresa(idEmpresa);
    }

    @Override
    public ArrayList<ReciboEntidade> buscaRecibosPorVeiculoAberto(int idVeiculo) {
        return reciboRepository.buscaRecibosPorVeiculoAberto(idVeiculo);
    }

    @Override
    public ArrayList<ReciboEntidade> buscaRecibosPorClienteAberto(int idCliente) {
        return reciboRepository.buscaRecibosPorClienteAberto(idCliente);
    }

    @Override
    public ArrayList<ReciboEntidade> buscaRecibosPorEmpresaAberto(int idEmpresa) {
        return reciboRepository.buscaRecibosPorEmpresaAberto(idEmpresa);
    }

    @Override
    public ArrayList<ReciboEntidade> buscaRecibosNaoPagos() {
        return reciboRepository.buscaRecibosNaoPagos();
    }

    @Override
    public ReciboEntidade buscaReciboAbertoPorPlaca(String placa) {
        return reciboRepository.buscaReciboAbertoPorPlaca(placa);
    }

    @Override
    public ArrayList<ReciboEntidade> buscaRecibosPorNomeEmpresaAberto(String nomeEmpresa) {
        return reciboRepository.buscaRecibosPorNomeEmpresaAberto(nomeEmpresa);
    }
    
    
    
}
