//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ecomsaite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ecomsait.model.Cart;
import com.ecomsait.model.Product;

public class ProductDao {
    private Connection con;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public ProductDao(Connection con) {
        this.con = con;
    }

    public List<Product> getAllProducts() {
        ArrayList book = new ArrayList();

        try {
            this.query = "select * from products";
            this.pst = this.con.prepareStatement(this.query);
            this.rs = this.pst.executeQuery();

            while(this.rs.next()) {
                Product row = new Product();
                row.setId(this.rs.getInt("id"));
                row.setName(this.rs.getString("name"));
                row.setCategory(this.rs.getString("category"));
                row.setPrice(this.rs.getDouble("price"));
                row.setImage(this.rs.getString("image"));
                book.add(row);
            }
        } catch (SQLException var3) {
            var3.printStackTrace();
            System.out.println(var3.getMessage());
        }

        return book;
    }

    public Product getSingleProduct(int id) {
        Product row = null;

        try {
            this.query = "select * from products where id=? ";
            this.pst = this.con.prepareStatement(this.query);
            this.pst.setInt(1, id);
            ResultSet rs = this.pst.executeQuery();

            while(rs.next()) {
                row = new Product();
                row.setId(rs.getInt("id"));
                row.setName(rs.getString("name"));
                row.setCategory(rs.getString("category"));
                row.setPrice(rs.getDouble("price"));
                row.setImage(rs.getString("image"));
            }
        } catch (Exception var4) {
            var4.printStackTrace();
            System.out.println(var4.getMessage());
        }

        return row;
    }

    public double getTotalCartPrice(ArrayList<Cart> cartList) {
        double sum = 0.0D;

        try {
            if (cartList.size() > 0) {
                Iterator var5 = cartList.iterator();

                while(var5.hasNext()) {
                    Cart item = (Cart)var5.next();
                    this.query = "select price from products where id=?";
                    this.pst = this.con.prepareStatement(this.query);
                    this.pst.setInt(1, item.getId());

                    for(this.rs = this.pst.executeQuery(); this.rs.next(); sum += this.rs.getDouble("price") * (double)item.getQuantity()) {
                    }
                }
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
            System.out.println(var6.getMessage());
        }

        return sum;
    }

    public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
        ArrayList book = new ArrayList();

        try {
            if (cartList.size() > 0) {
                Iterator var4 = cartList.iterator();

                while(var4.hasNext()) {
                    Cart item = (Cart)var4.next();
                    this.query = "select * from products where id=?";
                    this.pst = this.con.prepareStatement(this.query);
                    this.pst.setInt(1, item.getId());
                    this.rs = this.pst.executeQuery();

                    while(this.rs.next()) {
                        Cart row = new Cart();
                        row.setId(this.rs.getInt("id"));
                        row.setName(this.rs.getString("name"));
                        row.setCategory(this.rs.getString("category"));
                        row.setPrice(this.rs.getDouble("price") * (double)item.getQuantity());
                        row.setQuantity(item.getQuantity());
                        book.add(row);
                    }
                }
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
            System.out.println(var6.getMessage());
        }

        return book;
    }
}
