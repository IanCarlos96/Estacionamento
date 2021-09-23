/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TPBD.Frontier.Interfaces.Repository;

import com.TPBD.Frontier.Entidades.VeiculoEntidade;
import java.util.ArrayList;

/**
 *
 * @author IanCarlosAfonsodaSil
 */
public interface IVeiculoRepository {
    public VeiculoEntidade buscaVeiculo(int id);
    public int cadastraVeiculo(VeiculoEntidade veiculo);
    public int editaVeiculo(int id, VeiculoEntidade novosDados);
    public int deleteVeiculo(int id);
    public ArrayList<VeiculoEntidade> listaVeiculos();
    public ArrayList<VeiculoEntidade> listaVeiculosPorCpf(String cpf);
    public ArrayList<VeiculoEntidade> listaVeiculosPorCnpj(String cnpj);
    public ArrayList<VeiculoEntidade> listaVeiculosNaoEstacionados();
    public int vinculaVeiculoPessoa(String placa, String cpf);
}
