/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TPBD.Business;

import com.TPBD.Frontier.Entidades.VagaEntidade;
import com.TPBD.Frontier.Interfaces.IVagaBusiness;
import com.TPBD.Frontier.Interfaces.Repository.IVagasRepository;
import com.TPBD.Repository.VagasRepository;
import java.util.ArrayList;

/**
 *
 * @author IanCarlosAfonsodaSil
 */
public class VagaBusiness implements IVagaBusiness {
    VagasRepository vagasRepository;
    
    public VagaBusiness() {
        vagasRepository = new VagasRepository() {};
    }

    @Override
    public int deleteVaga(int id) {
        return vagasRepository.deleteVaga(id);
    }

    @Override
    public VagaEntidade buscaVaga(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<VagaEntidade> buscaListaVagas() {
        ArrayList<VagaEntidade> listaVagas = vagasRepository.buscaListaVagas(); 
        //ArrayList<VagaEntidade> listaVagas = new ArrayList<VagaEntidade>();
        return listaVagas;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verificaStatusVaga(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alteraStatusVaga(int id, boolean novoStatus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int alteraDadosVaga(int id, VagaEntidade novosDados) {
        int status = vagasRepository.editaVaga(id, novosDados);
        return status;
    }

    @Override
    public int insereVaga(VagaEntidade vaga) {
        int status = vagasRepository.insereVaga(vaga);
        return status;
    }

    @Override
    public int quantidadeVagas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int quantidadeVagasDisponiveis() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<VagaEntidade> buscaListaVagasLivres() {
        return vagasRepository.buscaListaVagasLivres();
    }
    
    
}
