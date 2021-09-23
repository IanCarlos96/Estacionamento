/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TPBD.Frontier.Entidades.Joins;

import com.TPBD.Frontier.Entidades.EmpresaEntidade;

/**
 *
 * @author IanCarlosAfonsodaSil
 */
public class EmpresaCountJoin {
    private EmpresaEntidade empresa;
    private int count;

    public EmpresaCountJoin(EmpresaEntidade empresa, int count) {
        this.empresa = empresa;
        this.count = count;
    }
    
    public EmpresaEntidade getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaEntidade empresa) {
        this.empresa = empresa;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    
}
