/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TPBD.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import com.TPBD.DataBase.ConnectionDatabase;
/**
 *
 * @author IanCarlosAfonsodaSil
 */
public class BaseRepository {
    //
    public Connection conn;
    
    public BaseRepository() {
        
        try{
            Class.forName(ConnectionDatabase.driverName);
            conn = DriverManager.getConnection(ConnectionDatabase.connectionString, ConnectionDatabase.user, ConnectionDatabase.pass);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
           Logger.getLogger(BaseRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
