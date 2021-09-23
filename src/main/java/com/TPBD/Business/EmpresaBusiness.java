/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TPBD.Business;

import com.TPBD.Frontier.Entidades.EmpresaEntidade;
import com.TPBD.Frontier.Entidades.Joins.EmpresaCountJoin;
import com.TPBD.Frontier.Interfaces.IEmpresaBusiness;
import com.TPBD.Repository.EmpresaRepository;
import java.util.ArrayList;

/**
 *
 * @author IanCarlosAfonsodaSil
 */
public class EmpresaBusiness implements IEmpresaBusiness {
    
    EmpresaRepository empresaRepository;
    
    public EmpresaBusiness(){
        empresaRepository = new EmpresaRepository();
    }
    @Override
    public int insereEmpresa(EmpresaEntidade empresa) {
        return empresaRepository.cadastraEmpresa(empresa);
    }

    @Override
    public int excluiEmpresa(int id) {
        return empresaRepository.deleteEmpresa(id);
    }

    @Override
    public int editaEmpresa(int id, EmpresaEntidade novosDados) {
        return empresaRepository.editaEmpresa(id, novosDados);
    }

    @Override
    public EmpresaEntidade buscaEmpresa(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<EmpresaEntidade> listaEmpresas() {
        return empresaRepository.lista_empresas();
    }

    @Override
    public ArrayList<EmpresaCountJoin> contaClientesPorEmpresa() {
        return empresaRepository.contaClientesPorEmpresa();
    }

    @Override
    public ArrayList<EmpresaCountJoin> limitaClientesEstacionados() {
        return empresaRepository.limitaClientesEstacionados();
    }
    
}
