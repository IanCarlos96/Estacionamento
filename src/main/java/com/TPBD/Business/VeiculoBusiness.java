/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TPBD.Business;

import com.TPBD.Frontier.Entidades.VeiculoEntidade;
import com.TPBD.Frontier.Interfaces.IVeiculoBusiness;
import com.TPBD.Repository.VeiculoRepository;
import java.util.ArrayList;

/**
 *
 * @author IanCarlosAfonsodaSil
 */
public class VeiculoBusiness implements IVeiculoBusiness {
    
    public VeiculoRepository veiculoRepository;
    public ClienteBusiness clienteBusiness;
    
    public VeiculoBusiness(){
        veiculoRepository = new VeiculoRepository();
        clienteBusiness = new ClienteBusiness();
    }
    
    @Override
    public int deleteVeiculo(int id) {
        return veiculoRepository.deleteVeiculo(id);
    }

    @Override
    public int cadastraVeiculo(VeiculoEntidade veiculo) {
        return veiculoRepository.cadastraVeiculo(veiculo);
    }

    @Override
    public int editaVeiculo(int id, VeiculoEntidade novosDados) {
        return veiculoRepository.editaVeiculo(id, novosDados);
    }

    @Override
    public ArrayList<VeiculoEntidade> listaVeiculos() {
        return veiculoRepository.listaVeiculos();
    }

    @Override
    public ArrayList<VeiculoEntidade> listaVeiculosPorCpf(String cpf) {
        return veiculoRepository.listaVeiculosPorCpf(cpf);
    }

    @Override
    public ArrayList<VeiculoEntidade> listaVeiculosPorCnpj(String cnpj) {
        return veiculoRepository.listaVeiculosPorCnpj(cnpj);
    }

    @Override
    public int vinculaVeiculoPessoa(String placa, String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<VeiculoEntidade> listaVeiculosNaoEstacionados() {
        return veiculoRepository.listaVeiculosNaoEstacionados();
    }

    @Override
    public VeiculoEntidade buscaVeiculo(int id) {
        return veiculoRepository.buscaVeiculo(id);
    }
    
    
    
}
