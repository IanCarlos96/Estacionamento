/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TPBD.Repository;

import com.TPBD.Frontier.Entidades.EmpresaEntidade;
import com.TPBD.Frontier.Entidades.Joins.EmpresaCountJoin;
import com.TPBD.Frontier.Interfaces.Repository.IEmpresaRepository;
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
public class EmpresaRepository extends BaseRepository implements IEmpresaRepository {

    @Override
    public int cadastraEmpresa(EmpresaEntidade empresa) {
        try{
            String query = "Insert into empresa (cnpj, razao_social, telefone, desconto) "
                            + "values (?,?,?,?)";
            PreparedStatement dapper = conn.prepareStatement(query);
            dapper.setString(1, empresa.getCnpj());
            dapper.setString(2, empresa.getRazaoSocial());
            dapper.setString(3, empresa.getTelefone());
            dapper.setDouble(4, empresa.getDesconto());
            
            dapper.execute();
            return 0;
        } catch(SQLException ex){
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public int editaEmpresa(int id, EmpresaEntidade novosDados) {
        try{
            String query = "UPDATE empresa SET "
                    + " cnpj = ?,"
                    + " razao_social = ?,"
                    + " telefone = ?,"
                    + " desconto = ?"
                    + " WHERE id = ?";
            PreparedStatement dapper = conn.prepareStatement(query);
            dapper.setString(1, novosDados.getCnpj());
            dapper.setString(2, novosDados.getRazaoSocial());
            dapper.setString(3, novosDados.getTelefone());
            dapper.setDouble(4, novosDados.getDesconto());
            dapper.setInt(4, id);
            dapper.execute();
            return 0;
        }catch(Exception ex){
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public int deleteEmpresa(int id) {
        try{
            String query = "DELETE FROM empresa WHERE id = ?";
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
    public ArrayList<EmpresaEntidade> lista_empresas() {
        ArrayList<EmpresaEntidade> listaEmpresas = new ArrayList();
        try {    
            Statement statement = this.conn.createStatement();
            ResultSet result = statement.executeQuery("select * from empresa");
            while(result.next()){
                int id = result.getInt("id");
                String cnpj = result.getString("cnpj");
                String razaoSocial = result.getString("razao_social");
                String telefone = result.getString("telefone");
                Double desconto = result.getDouble("desconto");
                
                EmpresaEntidade empresaEntidade = new EmpresaEntidade(id, cnpj, razaoSocial, telefone, desconto);
                //int id, String cnpj, String razaoSocial, String telefone, double desconto
                listaEmpresas.add(empresaEntidade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaEmpresas;
    }

    @Override
    public EmpresaEntidade busca_empresa_por_nome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<EmpresaCountJoin> contaClientesPorEmpresa() {
        ArrayList<EmpresaCountJoin> lista = new ArrayList();
        try {    
            Statement statement = this.conn.createStatement();
            ResultSet result = statement.executeQuery(
                    "select e.razao_social, e.cnpj, e.telefone, count(c.id) as total_cliente from cliente c" +
                    " inner join veiculo v on c.id = v.id_cliente " +
                    " left outer join recibo r on r.id_veiculo = v.id" +
                    " left outer join empresa e on e.id = c.id_empresa" +
                    " where r.pago is NULL " +
                    " GROUP BY c.id_empresa;"
            );
            while(result.next()){
                String cnpj = result.getString("cnpj");
                String razaoSocial = result.getString("razao_social");
                String telefone = result.getString("telefone");
                int count = result.getInt("total_cliente");
                
                EmpresaEntidade empresaEntidade = new EmpresaEntidade(0, cnpj, razaoSocial, telefone, 0);
                //int id, String cnpj, String razaoSocial, String telefone, double desconto
                EmpresaCountJoin dados = new EmpresaCountJoin(empresaEntidade, count);
                lista.add(dados);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public ArrayList<EmpresaCountJoin> limitaClientesEstacionados() {
        ArrayList<EmpresaCountJoin> lista = new ArrayList();
        try {    
            Statement statement = this.conn.createStatement();
            ResultSet result = statement.executeQuery(
                    "select e.razao_social, e.cnpj, e.telefone, count(c.id) as total_cliente from cliente c" +
                    " inner join veiculo v on c.id = v.id_cliente " +
                    " left outer join recibo r on r.id_veiculo = v.id" +
                    " left outer join empresa e on e.id = c.id_empresa" +
                    " where r.pago is NULL" +
                    " GROUP BY c.id_empresa" +
                    " HAVING total_cliente >= 2"
            );
            while(result.next()){
                String cnpj = result.getString("cnpj");
                String razaoSocial = result.getString("razao_social");
                String telefone = result.getString("telefone");
                int count = result.getInt("total_cliente");
                
                EmpresaEntidade empresaEntidade = new EmpresaEntidade(0, cnpj, razaoSocial, telefone, 0);
                //int id, String cnpj, String razaoSocial, String telefone, double desconto
                EmpresaCountJoin dados = new EmpresaCountJoin(empresaEntidade, count);
                lista.add(dados);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VagasRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
}
