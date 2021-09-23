/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TPBD.Frontier.Interfaces.Repository;

import com.TPBD.Frontier.Entidades.ClienteEntidade;
import com.TPBD.Frontier.Entidades.Joins.EmpresaClienteJoin;
import java.util.ArrayList;

/**
 *
 * @author IanCarlosAfonsodaSil
 */
public interface IClienteRepository {
    public int cadastraCliente(ClienteEntidade cliente);
    public int editaCliente(int id, ClienteEntidade novosDados);
    public int deleteCliente(int id);
    public ArrayList<ClienteEntidade> listaClientes();
    public ArrayList<ClienteEntidade> listaClientesDaEmpresa(String cnpj);
    public int vinculaClienteNaEmpresa(String cpf, String cnpj);
    public ArrayList<EmpresaClienteJoin>listaClientesEEmpresa();
    
}
