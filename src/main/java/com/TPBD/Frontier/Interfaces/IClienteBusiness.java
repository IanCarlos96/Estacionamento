/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TPBD.Frontier.Interfaces;

import com.TPBD.Frontier.Entidades.ClienteEntidade;
import com.TPBD.Frontier.Entidades.Joins.EmpresaClienteJoin;
import java.util.ArrayList;

/**
 *
 * @author IanCarlosAfonsodaSil
 */
public interface IClienteBusiness {
    public int insereCliente(ClienteEntidade cliente);
    public int excluiCliente(int id);
    public int editaCliente(int id, ClienteEntidade novosDados);
    public ClienteEntidade buscaCliente(int id);
    public ArrayList<ClienteEntidade> buscaListaCliente();
    public ArrayList<ClienteEntidade> buscaListaClientesEmpresa(String cnpj);
    public ArrayList<EmpresaClienteJoin> buscaListaClientesEEmpresas();
}
