/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TPBD.Frontier.Interfaces.Repository;

import com.TPBD.Frontier.Entidades.EmpresaEntidade;
import com.TPBD.Frontier.Entidades.Joins.EmpresaCountJoin;
import java.util.ArrayList;

/**
 *
 * @author IanCarlosAfonsodaSil
 */
public interface IEmpresaRepository {
    public int cadastraEmpresa(EmpresaEntidade empresa);
    public int editaEmpresa(int id, EmpresaEntidade novosDados);
    public int deleteEmpresa(int id);
    public ArrayList<EmpresaEntidade> lista_empresas();
    public EmpresaEntidade busca_empresa_por_nome(String nome);
    public ArrayList<EmpresaCountJoin> contaClientesPorEmpresa();
    public ArrayList<EmpresaCountJoin> limitaClientesEstacionados();
}
