/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Long Coi
 */
public class DAO {
    public static Connection con;
    public DAO(){
        if(con == null){
            String dbUrl = "jdbc:mysql://localhost:3306/NetworkProgramming?autoReconnect=true&useSSL=false";
            String dbClass = "com.mysql.jdbc.Driver";
            
            try{
                Class.forName(dbClass);
                con = DriverManager.getConnection(dbUrl, "root", "08091999");
            }catch(ClassNotFoundException | SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        new DAO();
        //System.out.println(con);
    }
}
