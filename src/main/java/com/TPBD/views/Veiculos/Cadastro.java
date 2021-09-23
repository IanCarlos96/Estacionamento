/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TPBD.views.Veiculos;

import com.TPBD.Business.VeiculoBusiness;
import com.TPBD.Frontier.Entidades.ClienteEntidade;
import com.TPBD.Frontier.Entidades.VeiculoEntidade;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author IanCarlosAfonsodaSil
 */
public class Cadastro extends javax.swing.JFrame {
    private VeiculoBusiness veiculoBusiness;
    private String[] defaultListModel;
    private ArrayList<ClienteEntidade> clienteList;
    
    /**
     * Creates new form Cadastro
     */
    public Cadastro() {
        this.veiculoBusiness = new VeiculoBusiness();
        this.clienteList = new ArrayList();
        this.defaultListModel = this.geraListaModelCliente();
        initComponents();
    }
    
    public Cadastro(ArrayList<ClienteEntidade> clienteList) {
        this.veiculoBusiness = new VeiculoBusiness();
        this.clienteList = clienteList;
        this.defaultListModel = this.geraListaModelCliente();
        initComponents();
    }
    
    private String[] geraListaModelCliente() {
        ArrayList<String> aux = new ArrayList();
        if(!clienteList.isEmpty()) {
            for(int i=0; i < clienteList.size(); i++){
                aux.add(clienteList.get(i).getNome());
            }
        } else {
            aux.add("Lista Vazia!");
            
        }
        String[] teste = new String[aux.size()];
        teste = aux.toArray(teste);
        
        return teste;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JLVeiculoPlaca = new javax.swing.JLabel();
        JVeiculoPlaca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JVeiculoMarca = new javax.swing.JTextField();
        SaveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        JVeiculoModelo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        JClienteList = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cadastro de Veículos");

        JLVeiculoPlaca.setText("Placa");

        JVeiculoPlaca.setToolTipText("Placa");
        JVeiculoPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JVeiculoPlacaActionPerformed(evt);
            }
        });

        jLabel3.setText("Marca");

        JVeiculoMarca.setToolTipText("Marca");
        JVeiculoMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JVeiculoMarcaActionPerformed(evt);
            }
        });

        SaveButton.setText("Salvar");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Modelo");

        JVeiculoModelo.setToolTipText("Modelo");
        JVeiculoModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JVeiculoModeloActionPerformed(evt);
            }
        });

        jLabel5.setText("Proprietário");

        JClienteList.setModel(new DefaultComboBoxModel(this.geraListaModelCliente())

        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLVeiculoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(JVeiculoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JVeiculoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JVeiculoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(137, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(SaveButton)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton)
                        .addGap(79, 79, 79))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JClienteList, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(JLVeiculoPlaca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JVeiculoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JVeiculoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JVeiculoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JClienteList, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton)
                    .addComponent(cancelButton))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JVeiculoPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JVeiculoPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JVeiculoPlacaActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        // TODO add your handling code here:
        VeiculoEntidade veiculo = new VeiculoEntidade();
        veiculo.setMarca(this.JVeiculoMarca.getText());
        veiculo.setModelo(this.JVeiculoModelo.getText());
        veiculo.setPlaca(this.JVeiculoPlaca.getText());
        
        int idSelected = this.JClienteList.getSelectedIndex();
        veiculo.setIdCliente(this.clienteList.get(idSelected).getId());
        
        int status = veiculoBusiness.cadastraVeiculo(veiculo);
        if(status == 0) {
            this.JVeiculoMarca.setText("");
            this.JVeiculoModelo.setText("");
            this.JVeiculoPlaca.setText("");
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void JVeiculoMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JVeiculoMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JVeiculoMarcaActionPerformed

    private void JVeiculoModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JVeiculoModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JVeiculoModeloActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JClienteList;
    private javax.swing.JLabel JLVeiculoPlaca;
    private javax.swing.JTextField JVeiculoMarca;
    private javax.swing.JTextField JVeiculoModelo;
    private javax.swing.JTextField JVeiculoPlaca;
    private javax.swing.JButton SaveButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
