/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TPBD.Frontier.Interfaces.Repository;

import com.TPBD.Frontier.Entidades.VagaEntidade;
import java.util.ArrayList;

/**
 *
 * @author IanCarlosAfonsodaSil
 */
public interface IVagasRepository {
    public ArrayList<VagaEntidade> buscaListaVagas();
    public ArrayList<VagaEntidade> buscaListaVagasLivres();
    public int insereVaga(VagaEntidade vaga);
    public int editaVaga(int id, VagaEntidade novosDados);
    public int deleteVaga(int id);
    
}
