/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TPBD.Frontier.Interfaces;

import com.TPBD.Frontier.Entidades.VagaEntidade;
import java.util.ArrayList;

/**
 *
 * @author IanCarlosAfonsodaSil
 */
public interface IVagaBusiness {
    
    public int deleteVaga(int id);
    public VagaEntidade buscaVaga(int id);
    public ArrayList<VagaEntidade> buscaListaVagas();
    public ArrayList<VagaEntidade> buscaListaVagasLivres();
    public boolean verificaStatusVaga(int id);
    public void alteraStatusVaga(int id, boolean novoStatus);
    public int alteraDadosVaga(int id, VagaEntidade novosDados);
    public int insereVaga(VagaEntidade vaga);
    public int quantidadeVagas();
    public int quantidadeVagasDisponiveis();
    
    
}
