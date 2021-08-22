/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.player;

/**
 *
 * @author hoandk
 */
public class playerDAO extends DBContext {

    public ArrayList<player> getTop15() {
        ArrayList<player> list = new ArrayList<>();
        try {
            String sql = "SELECT `player`.`name`,\n"
                    + "    `player`.`coin`,\n"
                    + "    `player`.`cmt`\n"
                    + "FROM `sql5430309`.`player`\n"
                    + "order by coin desc\n"
                    + "limit 15";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                player p = new player();
                p.setName(rs.getString("name"));
                p.setCoin(rs.getInt("coin"));
                p.setComment(rs.getString("cmt"));
                list.add(p);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(playerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insert(String name, int coin) {
        try {
            String sql = "INSERT INTO `sql5430309`.`player`\n"
                    + "(`name`,\n"
                    + "`coin`)\n"
                    + "VALUES\n"
                    + "(?,\n"
                    + "?);";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, name);
            stm.setInt(2, coin);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(playerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateCoin(String name, int coin) {
        try {
            String sql = "UPDATE `sql5430309`.`player`\n"
                    + "SET\n"
                    + "`coin` = ?\n"
                    + "WHERE `name` = ?;";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, coin);
            stm.setString(2, name);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(playerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public player getPlayerByName(String name) {
        try {
            String sql = "SELECT `player`.`name`,\n"
                    + "    `player`.`coin`,\n"
                    + "    `player`.`cmt`\n"
                    + "FROM `sql5430309`.`player` \n"
                    + "Where name = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, name);
            ResultSet rs = stm.executeQuery();
            player p = new player();
            if (rs.next()) {
                p.setName(rs.getString("name"));
                p.setCoin(rs.getInt("coin"));
                p.setComment(rs.getString("cmt"));
            }
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(playerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

//    public static void main(String[] args) {
//        playerDAO pDAO = new playerDAO();
//        ArrayList<player> list = pDAO.getTop15();
//        pDAO.updateCoin("av", 60);
//        System.out.println(list.size());
//    }
}
