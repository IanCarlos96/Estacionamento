/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TPBD.Frontier.Entidades.Joins;

import com.TPBD.Frontier.Entidades.ClienteEntidade;
import com.TPBD.Frontier.Entidades.EmpresaEntidade;

/**
 *
 * @author IanCarlosAfonsodaSil
 */
public class EmpresaClienteJoin {
    private EmpresaEntidade empresa;
    private ClienteEntidade cliente;

    public EmpresaClienteJoin(EmpresaEntidade empresa, ClienteEntidade cliente) {
        this.empresa = empresa;
        this.cliente = cliente;
    }

    public EmpresaClienteJoin() {
        this.empresa = new EmpresaEntidade();
        this.cliente = new ClienteEntidade();
    }

    public EmpresaEntidade getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaEntidade empresa) {
        this.empresa = empresa;
    }

    public ClienteEntidade getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntidade cliente) {
        this.cliente = cliente;
    }
    
    
    
}
