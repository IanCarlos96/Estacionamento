/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TPBD.Repository;

import com.TPBD.Frontier.Entidades.VagaEntidade;
import com.TPBD.Frontier.Interfaces.Repository.IVagasRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IanCarlosAfonsodaSil
 */
public class VagasRepository extends BaseRepository implements IVagasRepository{
    
    
    public VagasRepository() {
        super();
    }
    
    @Override
    public ArrayList<VagaEntidade> buscaListaVagas() {
        ArrayList<VagaEntidade> listaVagas = new ArrayList();
        try {    
            Statement statement = this.conn.createStatement();
            ResultSet result = statement.executeQuery("select * from vagas");
            while(result.next()){
                int id = result.getInt("id");
                String identificacao = result.getString("identificacao");
                String ocupado = result.getString("ocupado");
                String tipoVaga = result.getString("tipo");
                
                VagaEntidade vagaEntidade = new VagaEntidade(id, identificacao, tipoVaga, ocupado);
                listaVagas.add(vagaEntidade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVagas;
    }

    @Override
    public int insereVaga(VagaEntidade vaga) {
        try{
            
            Statement statement = this.conn.createStatement();
            String query = "Insert into vagas (identificacao, ocupado, tipo) "
                            + "values (?,?,?)";
            PreparedStatement dapper = conn.prepareStatement(query);
            dapper.setString(1, vaga.getNomeVaga());
            dapper.setString(2, "N");
            dapper.setString(3, vaga.getTipo());
            
            dapper.execute();
            return 0;
        } catch(SQLException ex){
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }    

    public int editaVaga(int id, VagaEntidade novosDados) {
        try{
            Statement statement = this.conn.createStatement();
            String query = "UPDATE vagas SET "
                    + " identificacao = ?,"
                    + " tipo = ?,"
                    + " ocupado = ?"
                    + " WHERE id = ?";
            PreparedStatement dapper = conn.prepareStatement(query);
            dapper.setString(1, novosDados.getNomeVaga());
            dapper.setString(2, novosDados.getTipo());
            dapper.setString(3, novosDados.getOcupada());
            dapper.setInt(4, id);
            dapper.execute();
            return 0;
        }catch(Exception ex){
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public int deleteVaga(int id) {
        try{
            Statement statement = this.conn.createStatement();
            String query = "DELETE FROM vagas WHERE id = ?";
            PreparedStatement dapper = conn.prepareStatement(query);
            dapper.setInt(1, id);
            dapper.execute();
            return 0;
        } catch(Exception ex){
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public ArrayList<VagaEntidade> buscaListaVagasLivres() {
        ArrayList<VagaEntidade> listaVagas = new ArrayList();
        try {    
            Statement statement = this.conn.createStatement();
            ResultSet result = statement.executeQuery("select * from vagas where ocupado = '0'");
            while(result.next()){
                int id = result.getInt("id");
                String identificacao = result.getString("identificacao");
                String ocupado = result.getString("ocupado");
                String tipoVaga = result.getString("tipo");
                
                VagaEntidade vagaEntidade = new VagaEntidade(id, identificacao, tipoVaga, ocupado);
                listaVagas.add(vagaEntidade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVagas;
    }
}
