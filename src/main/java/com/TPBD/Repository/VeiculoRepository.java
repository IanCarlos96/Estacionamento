/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TPBD.Repository;

import com.TPBD.Frontier.Entidades.VeiculoEntidade;
import com.TPBD.Frontier.Interfaces.Repository.IVeiculoRepository;
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
public class VeiculoRepository extends BaseRepository implements IVeiculoRepository {

    public VeiculoRepository() {}
    
    @Override
    public int cadastraVeiculo(VeiculoEntidade veiculo) {
        try{
            String query = "INSERT INTO veiculo (id_cliente, placa, marca, modelo) VALUES (?,?,?,?)";
            PreparedStatement dapper = conn.prepareStatement(query);
            dapper.setInt(1, veiculo.getIdCliente());
            dapper.setString(2, veiculo.getPlaca());
            dapper.setString(3, veiculo.getMarca());
            dapper.setString(4, veiculo.getModelo());
            dapper.execute();
            return 0;
        }catch(Exception ex){
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public int editaVeiculo(int id, VeiculoEntidade novosDados) {
        try{
            String query = "UPDATE veiculo SET "
                    + " id_cliente = ?,"
                    + " placa = ?,"
                    + " marca = ?,"
                    + " modelo = ?"
                    + " WHERE id = ?";
            PreparedStatement dapper = conn.prepareStatement(query);
            dapper.setInt(1, novosDados.getIdCliente());
            dapper.setString(2, novosDados.getPlaca());
            dapper.setString(3, novosDados.getMarca());
            dapper.setString(4, novosDados.getModelo());
            dapper.setInt(5, id);
            dapper.execute();
            return 0;
        }catch(Exception ex){
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public int deleteVeiculo(int id) {
        try{
            String query = "DELETE FROM veiculo WHERE id = ?";
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
    public ArrayList<VeiculoEntidade> listaVeiculos() {
        ArrayList<VeiculoEntidade> listaVeiculos = new ArrayList();
        try {    
            Statement statement = this.conn.createStatement();
            ResultSet result = statement.executeQuery("select * from veiculo");
            while(result.next()){
                int id = result.getInt("id");
                int idCliente = result.getInt("id_cliente");
                String placa = result.getString("placa");
                String marca = result.getString("marca");
                String modelo = result.getString("modelo");                
   
                VeiculoEntidade veiculoEntidade = new VeiculoEntidade(id, idCliente, placa, marca, modelo);
                //int id, int idCliente, String placa, String modelo, String marca
                listaVeiculos.add(veiculoEntidade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVeiculos;
    }

    @Override
    public ArrayList<VeiculoEntidade> listaVeiculosPorCpf(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<VeiculoEntidade> listaVeiculosPorCnpj(String cnpj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int vinculaVeiculoPessoa(String placa, String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<VeiculoEntidade> listaVeiculosNaoEstacionados() {
        ArrayList<VeiculoEntidade> listaVeiculos = new ArrayList();
        try {
            Statement statement = this.conn.createStatement();
            ResultSet result = statement.executeQuery(
                    "select * from veiculo where id not in" +
                            "(select id_veiculo from fluxo_de_veiculos where gerar_recibo = 'N')");
        while(result.next()){
                int id = result.getInt("id");
                int idCliente = result.getInt("id_cliente");
                String placa = result.getString("placa");
                String marca = result.getString("marca");
                String modelo = result.getString("modelo");                
   
                VeiculoEntidade veiculoEntidade = new VeiculoEntidade(id, idCliente, placa, marca, modelo);
                //int id, int idCliente, String placa, String modelo, String marca
                listaVeiculos.add(veiculoEntidade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVeiculos;
    }

    @Override
    public VeiculoEntidade buscaVeiculo(int idBusca) {
        ArrayList<VeiculoEntidade> listaVeiculos = new ArrayList();
        try {
            Statement statement = this.conn.createStatement();
            String query = "select * from veiculo where id = " + idBusca;
            ResultSet result = statement.executeQuery(query);
        while(result.next()){
                int id = result.getInt("id");
                int idCliente = result.getInt("id_cliente");
                String placa = result.getString("placa");
                String marca = result.getString("marca");
                String modelo = result.getString("modelo");                
   
                VeiculoEntidade veiculoEntidade = new VeiculoEntidade(id, idCliente, placa, marca, modelo);
                //int id, int idCliente, String placa, String modelo, String marca
                listaVeiculos.add(veiculoEntidade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVeiculos.get(0);
    }
}
