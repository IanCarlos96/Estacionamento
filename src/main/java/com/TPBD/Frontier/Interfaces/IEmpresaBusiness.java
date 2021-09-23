/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TPBD.Frontier.Interfaces;

import com.TPBD.Frontier.Entidades.EmpresaEntidade;
import com.TPBD.Frontier.Entidades.Joins.EmpresaCountJoin;
import java.util.ArrayList;

/**
 *
 * @author IanCarlosAfonsodaSil
 */
public interface IEmpresaBusiness {
    
    public int insereEmpresa(EmpresaEntidade empresa);
    public int excluiEmpresa(int id);
    public int editaEmpresa(int id, EmpresaEntidade novosDados);
    public EmpresaEntidade buscaEmpresa(int id);
    public ArrayList<EmpresaEntidade> listaEmpresas();
    public ArrayList<EmpresaCountJoin> contaClientesPorEmpresa();
    public ArrayList<EmpresaCountJoin> limitaClientesEstacionados();
    
}
