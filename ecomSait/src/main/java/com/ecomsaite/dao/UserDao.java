//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ecomsaite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecomsait.model.User;

public class UserDao {
    private Connection con;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public UserDao(Connection con) {
        this.con = con;
    }

    public User userLogin(String email, String password) {
        User user = null;

        try {
            this.query = "select * from users where email=? and password=?";
            this.pst = this.con.prepareStatement(this.query);
            this.pst.setString(1, email);
            this.pst.setString(2, password);
            this.rs = this.pst.executeQuery();
            if (this.rs.next()) {
                user = new User();
                user.setId(this.rs.getInt("id"));
                user.setName(this.rs.getString("name"));
                user.setEmail(this.rs.getString("email"));
            }
        } catch (SQLException var5) {
            System.out.print(var5.getMessage());
        }

        return user;
    }
}
