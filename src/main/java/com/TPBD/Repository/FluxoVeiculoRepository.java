/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TPBD.Repository;

import com.TPBD.Frontier.Entidades.FluxoVeiculoEntidade;
import com.TPBD.Frontier.Interfaces.Repository.IFluxoVeiculoRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IanCarlosAfonsodaSil
 */
public class FluxoVeiculoRepository extends BaseRepository implements IFluxoVeiculoRepository {

    public FluxoVeiculoRepository(){}
    
    @Override
    public int cadastraFluxo(FluxoVeiculoEntidade novoFluxo) {
     try{
            String query = "Insert into fluxo_de_veiculos (id_veiculo, id_vaga, id_estacionamento, gerar_recibo) "
                            + "values (?,?,?,?)";
            
            //int id, String nome, String cpf, String email, String telefone, String cidade, String endereco, String cep, int idEmpresa
            PreparedStatement dapper = conn.prepareStatement(query);
            dapper.setInt(1, novoFluxo.getIdVeiculo());
            dapper.setInt(2, novoFluxo.getIdVaga());
            dapper.setInt(3, 1);
            dapper.setString(4, novoFluxo.getGerarRecibo());
            dapper.execute();
            return 0;
        } catch(SQLException ex){
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public int editaFluxo(int id, FluxoVeiculoEntidade novosDados) {
        try{
            String query = "UPDATE fluxo_de_veiculos SET "
                    + " id_vaga = ?,"
                    + " saida = ?,"
                    + " gerar_recibo = ?"
                    + " WHERE id = ?";
            PreparedStatement dapper = conn.prepareStatement(query);
            dapper.setInt(1, novosDados.getIdVaga());
            dapper.setObject(2, novosDados.getHorarioSaida());
            dapper.setString(3, novosDados.getGerarRecibo());
            dapper.setInt(4, id);
            
            dapper.execute();
            return 0;
        }catch(Exception ex){
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public int finalizaFluxoAberto(int id) {
        try{
            String query = "UPDATE fluxo_de_veiculos SET "
                    + " gerar_recibo = '1'"
                    + " WHERE id = ?";
            PreparedStatement dapper = conn.prepareStatement(query);
            dapper.setInt(1, id);
            dapper.execute();
            return 0;
        }catch(Exception ex){
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public ArrayList<FluxoVeiculoEntidade> listaFluxos() {
        ArrayList<FluxoVeiculoEntidade> listaFluxos = new ArrayList();
        try {    
            Statement statement = this.conn.createStatement();
            ResultSet result = statement.executeQuery("select * from fluxo_de_veiculos");
            while(result.next()){
                int id = result.getInt("id");
                int idVeiculo = result.getInt("id_veiculo");
                int idVaga = result.getInt("id_vaga");
                int idEstacionamento = result.getInt("id_estacionamento");
                LocalDateTime horarioEntrada = result.getObject("entrada", LocalDateTime.class);
                LocalDateTime horarioSaida = result.getObject("saida", LocalDateTime.class);
                String geraRecibo = result.getString("gerar_recibo");
   
                FluxoVeiculoEntidade fluxoVeiculoEntidade = new FluxoVeiculoEntidade(id,idVeiculo, idVaga, horarioEntrada, horarioSaida, geraRecibo);
                //int id, int idVeiculo, int idVaga, LocalDate horarioEntrada, LocalDate horarioSaida, String gerarRecibo
                listaFluxos.add(fluxoVeiculoEntidade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaFluxos;
    }

    @Override
    public ArrayList<FluxoVeiculoEntidade> listaFluxosAbertos() {
        ArrayList<FluxoVeiculoEntidade> listaFluxos = new ArrayList();
        try {    
            Statement statement = this.conn.createStatement();
            ResultSet result = statement.executeQuery("select * from fluxo_de_veiculos where gerar_recibo = '0'");
            while(result.next()){
                int id = result.getInt("id");
                int idVeiculo = result.getInt("id_veiculo");
                int idVaga = result.getInt("id_vaga");
                int idEstacionamento = result.getInt("id_estacionamento");
                LocalDateTime horarioEntrada = result.getObject("entrada", LocalDateTime.class);
                LocalDateTime horarioSaida = result.getObject("saida", LocalDateTime.class);
                String geraRecibo = result.getString("gerar_recibo");
   
                FluxoVeiculoEntidade fluxoVeiculoEntidade = new FluxoVeiculoEntidade(id,idVeiculo, idVaga, horarioEntrada, horarioSaida, geraRecibo);
                //int id, int idVeiculo, int idVaga, LocalDate horarioEntrada, LocalDate horarioSaida, String gerarRecibo
                listaFluxos.add(fluxoVeiculoEntidade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaFluxos;
    }
    
}
