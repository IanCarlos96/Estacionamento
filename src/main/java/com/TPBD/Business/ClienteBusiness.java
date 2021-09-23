/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TPBD.Business;

import com.TPBD.Frontier.Entidades.ClienteEntidade;
import com.TPBD.Frontier.Entidades.Joins.EmpresaClienteJoin;
import com.TPBD.Frontier.Interfaces.IClienteBusiness;
import com.TPBD.Repository.ClienteRepository;
import com.TPBD.Repository.EmpresaRepository;
import java.util.ArrayList;

/**
 *
 * @author IanCarlosAfonsodaSil
 */
public class ClienteBusiness implements IClienteBusiness {

    public ClienteRepository clienteRepository;
    public EmpresaBusiness empresaBusiness;
    
    public ClienteBusiness(){
        clienteRepository = new ClienteRepository();
        empresaBusiness = new EmpresaBusiness();
    }
    
    @Override
    public int insereCliente(ClienteEntidade cliente) {
        return clienteRepository.cadastraCliente(cliente);
    }

    @Override
    public int excluiCliente(int id) {
        return clienteRepository.deleteCliente(id);
    }

    @Override
    public int editaCliente(int id, ClienteEntidade novosDados) {
        return clienteRepository.editaCliente(id, novosDados);
    }

    @Override
    public ClienteEntidade buscaCliente(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ClienteEntidade> buscaListaCliente() {
        return clienteRepository.listaClientes();
    }
    
    @Override
    public ArrayList<ClienteEntidade> buscaListaClientesEmpresa(String cnpj){
        return clienteRepository.listaClientesDaEmpresa(cnpj);
    }
    
    @Override
    public ArrayList<EmpresaClienteJoin> buscaListaClientesEEmpresas(){
        return clienteRepository.listaClientesEEmpresa();
    }
    
}
