/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TPBD.Frontier.Interfaces.Repository;

import com.TPBD.Frontier.Entidades.ReciboEntidade;
import java.util.ArrayList;

/**
 *
 * @author IanCarlosAfonsodaSil
 */
public interface IReciboRepository {
    public int insereRecibo(ReciboEntidade recibo);
    public int editaRecibo(int id, ReciboEntidade novosDados);
    public int excluiRecibo(int id);
    public ReciboEntidade buscaRecibo(int id);
    public ArrayList<ReciboEntidade> buscaRecibosPorVeiculo(int idVeiculo);
    public ArrayList<ReciboEntidade> buscaRecibosPorCliente(int idCliente);
    public ArrayList<ReciboEntidade> buscaRecibosPorEmpresa(int idEmpresa);
    public ArrayList<ReciboEntidade> buscaRecibosPorVeiculoAberto(int idVeiculo);
    public ArrayList<ReciboEntidade> buscaRecibosPorClienteAberto(int idCliente);
    public ArrayList<ReciboEntidade> buscaRecibosPorEmpresaAberto(int nomeEmpresa);
    public ArrayList<ReciboEntidade> buscaRecibosPorNomeEmpresaAberto(String nomeEmpresa);
    public ArrayList<ReciboEntidade> buscaRecibosNaoPagos();
    public ReciboEntidade buscaReciboAbertoPorPlaca(String placa);
}
