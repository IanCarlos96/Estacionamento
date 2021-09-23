/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TPBD.core;

import com.TPBD.views.Start;
import javax.swing.JFrame;

/**
 *
 * @author IanCarlosAfonsodaSil
 */
public class main {
    
    public static void main(String[] args) {
    
        Start startView = new Start();
        startView.setTitle("TP BD1 - Controle de estacionamento");
        startView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startView.setVisible(true);
        
    }
}
