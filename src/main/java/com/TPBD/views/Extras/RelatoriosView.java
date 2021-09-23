/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TPBD.views.Extras;

import com.TPBD.Frontier.Entidades.ClienteEntidade;
import com.TPBD.Frontier.Entidades.Joins.EmpresaClienteJoin;
import com.TPBD.Frontier.Entidades.Joins.EmpresaCountJoin;
import java.util.ArrayList;

/**
 *
 * @author IanCarlosAfonsodaSil
 */
public class RelatoriosView extends javax.swing.JFrame {
    String inputRelatorio;
    /**
     * Creates new form RelatoriosView
     */
    public RelatoriosView(ArrayList dadosProcessados, int tipoRelatorio) {
        this.inputRelatorio = preparaRelatorio(dadosProcessados, tipoRelatorio);
        initComponents();
        this.jTextPane1.setText(inputRelatorio);
    }

    public RelatoriosView(){
        initComponents();
    }
    
    public String preparaRelatorio(ArrayList dados, int tipo){
        String saida = "";
        if(tipo == 1){
            ArrayList<ClienteEntidade> list = dados;
            for(int i=0; i < list.size(); i++) {
                saida = saida.concat("Nome: "+list.get(i).getNome());
                saida = saida.concat("\nCPF: "+list.get(i).getCpf());
                saida = saida.concat("\nTelefone: "+list.get(i).getTelefone());
                saida = saida.concat("\nCidade: "+list.get(i).getCidade());
                saida = saida.concat("\nEndereço: "+list.get(i).getEndereco());
                saida = saida.concat("\nCEP: "+list.get(i).getCep());
                saida = saida.concat("\nEmail: "+list.get(i).getEmail());
                saida = saida.concat("\n\n");
            }
            saida = saida.concat("\n");
        }
        if(tipo == 2){
            ArrayList<EmpresaClienteJoin> list= dados;
            for(int i=0; i < list.size(); i++) {
                saida = saida.concat("Nome: "+list.get(i).getCliente().getNome());
                saida = saida.concat("\nCPF: "+list.get(i).getCliente().getCpf());
                saida = saida.concat("\nTelefone: "+list.get(i).getCliente().getTelefone());
                saida = saida.concat("\nCidade: "+list.get(i).getCliente().getCidade());
                saida = saida.concat("\nEndereço: "+list.get(i).getCliente().getEndereco());
                saida = saida.concat("\nCEP: "+list.get(i).getCliente().getCep());
                saida = saida.concat("\nEmail: "+list.get(i).getCliente().getEmail());
                saida = saida.concat("\nEmpresa: "+list.get(i).getEmpresa().getRazaoSocial());
                saida = saida.concat("\nCNPJ: "+list.get(i).getEmpresa().getCnpj());
                saida = saida.concat("\nTelefone: "+list.get(i).getEmpresa().getTelefone());
                saida = saida.concat("\n\n");
            }
            saida = saida.concat("\n");
        }  
        if(tipo == 3 || tipo == 4) {
            ArrayList<EmpresaCountJoin> list = dados;
            for(int i = 0; i<list.size(); i++) {
                saida = saida.concat("Empresa: "+list.get(i).getEmpresa().getRazaoSocial());
                saida = saida.concat("\nCNPJ: "+list.get(i).getEmpresa().getCnpj());
                saida = saida.concat("\nFuncionários com veículos estacionados: "+list.get(i).getCount());
                saida = saida.concat("\n\n");
            }
        }
        if(tipo == 5){
            ArrayList<String> list = dados;
            for(int i=0; i<list.size(); i++){
                saida = saida.concat(list.get(i)+"\n\n");
            }
        }
        return saida;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RELATÓRIOS");

        jTextPane1.setText(this.inputRelatorio
        );
        jScrollPane1.setViewportView(jTextPane1);

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jButton1)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RelatoriosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatoriosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatoriosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatoriosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatoriosView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
