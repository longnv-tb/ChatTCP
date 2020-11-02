/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.User;

/**
 *
 * @author Long Coi
 */
public class UserDAO extends DAO{
    public UserDAO(){
        super();
    }
    
    public User checkLogin(User u){
        //boolean check = false;
        User user = null;
        String sql = "select name from user where username = ? and password = ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.getUserName());
            ps.setString(2, u.getPassword());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                u.setName(rs.getString("name"));
                //check = true;
                user = u;
            }       
        }catch(SQLException e){
        }
        return user;
    }
    
    public void addUser(User user){
        String sql = "insert into user (name, username, password) values(?, ?, ?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getPassword());
            ps.executeUpdate();
        }catch(SQLException e){
        }
    }
    
    public boolean checkUser(User u){
        String query = "SELECT username FROM user "+ "WHERE username = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, u.getUserName());
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
