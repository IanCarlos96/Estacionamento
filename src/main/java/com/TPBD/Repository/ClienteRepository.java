/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TPBD.Repository;

import com.TPBD.Frontier.Entidades.ClienteEntidade;
import com.TPBD.Frontier.Entidades.EmpresaEntidade;
import com.TPBD.Frontier.Entidades.Joins.EmpresaClienteJoin;
import com.TPBD.Frontier.Interfaces.Repository.IClienteRepository;
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
public class ClienteRepository extends BaseRepository implements IClienteRepository {

    @Override
    public int cadastraCliente(ClienteEntidade cliente) {
        try{
            String query = "Insert into cliente (nome, cpf, email, telefone, cidade, endereco, cep, id_empresa) "
                            + "values (?,?,?,?,?,?,?,?)";
            
            //int id, String nome, String cpf, String email, String telefone, String cidade, String endereco, String cep, int idEmpresa
            PreparedStatement dapper = conn.prepareStatement(query);
            dapper.setString(1, cliente.getNome());
            dapper.setString(2, cliente.getCpf());
            dapper.setString(3, cliente.getEmail());
            dapper.setString(4, cliente.getTelefone());
            dapper.setString(5, cliente.getCidade());
            dapper.setString(6, cliente.getEndereco());
            dapper.setString(7, cliente.getCep());
            dapper.setInt(8, cliente.getIdEmpresa());
            dapper.execute();
            return 0;
        } catch(SQLException ex){
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public int editaCliente(int id, ClienteEntidade novosDados) {
        try{
            String query = "UPDATE cliente SET "
                    + " nome = ?,"
                    + " cpf = ?,"
                    + " email = ?,"
                    + " telefone = ?,"
                    + " cidade = ?,"
                    + " endereco = ?,"
                    + " cep = ?,"
                    + " id_empresa = ?"
                    + " WHERE id = ?";
            PreparedStatement dapper = conn.prepareStatement(query);
            dapper.setString(1, novosDados.getNome());
            dapper.setString(2, novosDados.getCpf());
            dapper.setString(3, novosDados.getEmail());
            dapper.setString(4, novosDados.getTelefone());
            dapper.setString(5, novosDados.getCidade());
            dapper.setString(6, novosDados.getEndereco());
            dapper.setString(7, novosDados.getCep());
            dapper.setInt(8, novosDados.getIdEmpresa());
            dapper.setInt(9, id);
            dapper.execute();
            return 0;
        }catch(Exception ex){
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public int deleteCliente(int id) {
        try{
            String query = "DELETE FROM cliente WHERE id = ?";
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
    public ArrayList<ClienteEntidade> listaClientes() {
        ArrayList<ClienteEntidade> listaClientes = new ArrayList();
        try {    
            Statement statement = this.conn.createStatement();
            ResultSet result = statement.executeQuery("select * from cliente");
            while(result.next()){
                int id = result.getInt("id");
                String nome = result.getString("nome");
                String cpf = result.getString("cpf");
                String email = result.getString("email");
                String telefone = result.getString("telefone");
                String cidade = result.getString("cidade");
                String endereco = result.getString("endereco");
                String cep = result.getString("cep");
                int idEmpresa = result.getInt("id_empresa");
                
                
                ClienteEntidade clienteEntidade = new ClienteEntidade(id, nome, cpf, email, telefone, cidade, endereco, cep, idEmpresa);
                //int id, String nome, String cpf, String email, String telefone, String cidade, String endereco, String cep, int idEmpresa
                listaClientes.add(clienteEntidade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaClientes;
    }

    @Override
    public ArrayList<ClienteEntidade> listaClientesDaEmpresa(String cnpj) {
        ArrayList<ClienteEntidade> listaClientes = new ArrayList();
        try{
            Statement statement = this.conn.createStatement();
            ResultSet result = statement.executeQuery("select " +
                " cliente.id, " +
                " cliente.nome, " +
                " cliente.cpf, " +
                " cliente.email, " +
                " cliente.telefone as telefone_cliente," +
                " cliente.cidade," +
                " cliente.endereco," +
                " cliente.id_empresa," +
                " cliente.cep" +
                " from cliente " +
                " inner join empresa on cliente.id_empresa = empresa.id" +
                " where empresa.cnpj = "+cnpj+" ");
            while(result.next()){
                int id = result.getInt("id");
                String nome = result.getString("nome");
                String cpf = result.getString("cpf");
                String email = result.getString("email");
                String telefone = result.getString("telefone_cliente");
                String cidade = result.getString("cidade");
                String endereco = result.getString("endereco");
                String cep = result.getString("cep");
                int idEmpresa = result.getInt("id_empresa");
                
                ClienteEntidade clienteEntidade = new ClienteEntidade(id, nome, cpf, email, telefone, cidade, endereco, cep, idEmpresa);
                //int id, String nome, String cpf, String email, String telefone, String cidade, String endereco, String cep, int idEmpresa
                listaClientes.add(clienteEntidade);
            }
        } catch(Exception ex) {
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaClientes;
    }

    
    
    @Override
    public int vinculaClienteNaEmpresa(String cpf, String cnpj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<EmpresaClienteJoin> listaClientesEEmpresa() {
         ArrayList<EmpresaClienteJoin> lista = new ArrayList();
        try{
            Statement statement = this.conn.createStatement();
            ResultSet result = statement.executeQuery(
                "select " +
                " cliente.id, " +
                " cliente.nome, " +
                " cliente.cpf, " +
                " cliente.email, " +
                " cliente.telefone as telefone_cliente," +
                " cliente.cidade," +
                " cliente.endereco," +
                " cliente.id_empresa," +
                " cliente.cep," +
                " empresa.cnpj," +
                " empresa.razao_social," +
                " empresa.telefone as telefone_empresa, " +
                " empresa.desconto " +
                " from cliente " +
                " left outer join empresa on cliente.id_empresa = empresa.id"
            );
            while(result.next()){
                int id = result.getInt("id");
                String nome = result.getString("nome");
                String cpf = result.getString("cpf");
                String email = result.getString("email");
                String telefone = result.getString("telefone_cliente");
                String cidade = result.getString("cidade");
                String endereco = result.getString("endereco");
                String cep = result.getString("cep");
                int idEmpresa = result.getInt("id_empresa");
                
                String cnpj = result.getString("cnpj");
                String razao = result.getString("razao_social");
                String telefoneEmpresa = result.getString("telefone_empresa");
                Double desconto = result.getDouble("desconto");
                
                EmpresaEntidade empresa = new EmpresaEntidade(0, cnpj, razao, telefoneEmpresa, desconto);
                //int id, String cnpj, String razaoSocial, String telefone, double desconto
                ClienteEntidade clienteEntidade = new ClienteEntidade(id, nome, cpf, email, telefone, cidade, endereco, cep, idEmpresa);
                //int id, String nome, String cpf, String email, String telefone, String cidade, String endereco, String cep, int idEmpresa
                EmpresaClienteJoin joinResult = new EmpresaClienteJoin(empresa, clienteEntidade);
                lista.add(joinResult);
            }
        } catch(Exception ex) {
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;    
    }
    
}
