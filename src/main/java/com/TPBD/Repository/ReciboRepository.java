/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TPBD.Repository;

import com.TPBD.Frontier.Entidades.ReciboEntidade;
import com.TPBD.Frontier.Interfaces.Repository.IReciboRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IanCarlosAfonsodaSil
 */
public class ReciboRepository extends BaseRepository implements IReciboRepository {

    @Override
    public int insereRecibo(ReciboEntidade recibo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int editaRecibo(int id, ReciboEntidade novosDados) {
        try{
            String query = "UPDATE recibo SET "
                    + " pago = ?"
                    + " WHERE id = ?";
            PreparedStatement dapper = conn.prepareStatement(query);
            dapper.setString(1, novosDados.getPago());
            dapper.setInt(2, novosDados.getId());
            dapper.execute();
            return 0;
        }catch(Exception ex){
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public int excluiRecibo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReciboEntidade buscaRecibo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ReciboEntidade> buscaRecibosPorVeiculo(int idVeiculoRecebido) {
        ArrayList<ReciboEntidade> reciboList = new ArrayList();
        try {    
            Statement statement = this.conn.createStatement();
            ResultSet result = statement.executeQuery("select * from recibo where id_veiculo = "+idVeiculoRecebido);
            while(result.next()){
                int id = result.getInt("id");
                int idVeiculo = result.getInt("id_veiculo");
                LocalDateTime entrada = result.getObject("entrada", LocalDateTime.class);
                LocalDateTime saida = result.getObject("saida", LocalDateTime.class);
                Double valor = result.getDouble("valor");
                String pago = result.getString("pago");
                
                ReciboEntidade reciboEntidade = new ReciboEntidade(id, idVeiculo, entrada, saida, valor, pago);
                //int id, int idFluxo, int idVeiculo, LocalDate horarioEntrada, LocalDate horarioSaida, double valor, String pago
                reciboList.add(reciboEntidade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return reciboList;
    }

    @Override
    public ArrayList<ReciboEntidade> buscaRecibosPorCliente(int idCliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ReciboEntidade> buscaRecibosPorEmpresa(int idEmpresa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ReciboEntidade> buscaRecibosPorVeiculoAberto(int idVeiculoRecebido) {
        ArrayList<ReciboEntidade> reciboList = new ArrayList();
        try {    
            Statement statement = this.conn.createStatement();
            ResultSet result = statement.executeQuery("select * from recibo where id_veiculo = "+idVeiculoRecebido+" AND pago = '0'");
            while(result.next()){
                int id = result.getInt("id");
                int idVeiculo = result.getInt("id_veiculo");
                LocalDateTime entrada = result.getObject("entrada", LocalDateTime.class);
                LocalDateTime saida = result.getObject("saida", LocalDateTime.class);
                Double valor = result.getDouble("valor");
                String pago = result.getString("pago");
                
                ReciboEntidade reciboEntidade = new ReciboEntidade(id, idVeiculo, entrada, saida, valor, pago);
                //int id, int idFluxo, int idVeiculo, LocalDate horarioEntrada, LocalDate horarioSaida, double valor, String pago
                reciboList.add(reciboEntidade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return reciboList;
    
    }

    @Override
    public ArrayList<ReciboEntidade> buscaRecibosPorClienteAberto(int idCliente) {
        ArrayList<ReciboEntidade> reciboList = new ArrayList();
        try {    
            Statement statement = this.conn.createStatement();
            ResultSet result = statement.executeQuery("select r.* from recibo r inner join veiculo v on r.id_veiculo = v.id where r.pago = 0 and v.id_cliente = "+idCliente);
            
            while(result.next()){
                int id = result.getInt("id");
                int idVeiculo = result.getInt("id_veiculo");
                LocalDateTime entrada = result.getObject("entrada", LocalDateTime.class);
                LocalDateTime saida = result.getObject("saida", LocalDateTime.class);
                Double valor = result.getDouble("valor");
                String pago = result.getString("pago");
                
                ReciboEntidade reciboEntidade = new ReciboEntidade(id, idVeiculo, entrada, saida, valor, pago);
                //int id, int idFluxo, int idVeiculo, LocalDate horarioEntrada, LocalDate horarioSaida, double valor, String pago
                reciboList.add(reciboEntidade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return reciboList;
    }

    @Override
    public ArrayList<ReciboEntidade> buscaRecibosPorEmpresaAberto(int idEmpresa) {
        ArrayList<ReciboEntidade> reciboList = new ArrayList();
        try {    
            Statement statement = this.conn.createStatement();
            ResultSet result = statement.executeQuery(
                    "select r.* from recibo r" +
                    " inner join veiculo v on r.id_veiculo = v.id" +
                    " where r.pago = 0 AND (select id_empresa from cliente where id = v.id_cliente) = "+idEmpresa);
            while(result.next()){
                int id = result.getInt("id");
                int idVeiculo = result.getInt("id_veiculo");
                LocalDateTime entrada = result.getObject("entrada", LocalDateTime.class);
                LocalDateTime saida = result.getObject("saida", LocalDateTime.class);
                Double valor = result.getDouble("valor");
                String pago = result.getString("pago");
                
                ReciboEntidade reciboEntidade = new ReciboEntidade(id, idVeiculo, entrada, saida, valor, pago);
                //int id, int idFluxo, int idVeiculo, LocalDate horarioEntrada, LocalDate horarioSaida, double valor, String pago
                reciboList.add(reciboEntidade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return reciboList;
    }

    @Override
    public ArrayList<ReciboEntidade> buscaRecibosNaoPagos() {
        ArrayList<ReciboEntidade> reciboList = new ArrayList();
        try {    
            Statement statement = this.conn.createStatement();
            ResultSet result = statement.executeQuery("select * from recibo where pago = 0");
            while(result.next()){
                int id = result.getInt("id");
                int idVeiculo = result.getInt("id_veiculo");
                LocalDateTime entrada = result.getObject("entrada", LocalDateTime.class);
                LocalDateTime saida = result.getObject("saida", LocalDateTime.class);
                Double valor = result.getDouble("valor");
                String pago = result.getString("pago");
                
                ReciboEntidade reciboEntidade = new ReciboEntidade(id, idVeiculo, entrada, saida, valor, pago);
                //int id, int idFluxo, int idVeiculo, LocalDate horarioEntrada, LocalDate horarioSaida, double valor, String pago
                reciboList.add(reciboEntidade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return reciboList;
    }

    @Override
    public ReciboEntidade buscaReciboAbertoPorPlaca(String placa) {
        ReciboEntidade reciboEntidade = new ReciboEntidade();
        try {    
            
            Statement statement = this.conn.createStatement();
            ResultSet result = statement.executeQuery("select * from recibo r inner join veiculo v ON r.id_veiculo = v.id where r.pago = 0 and v.placa = '"+placa+"'");
            while(result.next()){
                int id = result.getInt("id");
                int idVeiculo = result.getInt("id_veiculo");
                LocalDateTime entrada = result.getObject("entrada", LocalDateTime.class);
                LocalDateTime saida = result.getObject("saida", LocalDateTime.class);
                Double valor = result.getDouble("valor");
                String pago = result.getString("pago");
                
                reciboEntidade = new ReciboEntidade(id, idVeiculo, entrada, saida, valor, pago);
                //int id, int idFluxo, int idVeiculo, LocalDate horarioEntrada, LocalDate horarioSaida, double valor, String pago
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reciboEntidade;
    }

    @Override
    public ArrayList<ReciboEntidade> buscaRecibosPorNomeEmpresaAberto(String nomeEmpresa) {
        ArrayList<ReciboEntidade> reciboList = new ArrayList();
        try {    
            Statement statement = this.conn.createStatement();
            ResultSet result = statement.executeQuery("select r.* from recibo r inner join veiculo v on r.id_veiculo = v.id where (select id_empresa from cliente where id = v.id_cliente) = (select id from empresa where razao_social='"+nomeEmpresa+"') and r.pago=0");
                   
            while(result.next()){
                int id = result.getInt("id");
                int idVeiculo = result.getInt("id_veiculo");
                LocalDateTime entrada = result.getObject("entrada", LocalDateTime.class);
                LocalDateTime saida = result.getObject("saida", LocalDateTime.class);
                Double valor = result.getDouble("valor");
                String pago = result.getString("pago");
                
                ReciboEntidade reciboEntidade = new ReciboEntidade(id, idVeiculo, entrada, saida, valor, pago);
                //int id, int idFluxo, int idVeiculo, LocalDate horarioEntrada, LocalDate horarioSaida, double valor, String pago
                reciboList.add(reciboEntidade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return reciboList;
    }
    
}
