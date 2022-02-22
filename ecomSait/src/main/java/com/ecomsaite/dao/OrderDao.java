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
import java.util.List;

import com.ecomsait.model.Order;
import com.ecomsait.model.Product;

public class OrderDao {
    private Connection con;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public OrderDao(Connection con) {
        this.con = con;
    }

    public boolean insertOrder(Order model) {
        boolean result = false;

        try {
            this.query = "insert into orders (p_id, u_id, o_quantity, o_date) values(?,?,?,?)";
            this.pst = this.con.prepareStatement(this.query);
            this.pst.setInt(1, model.getId());
            this.pst.setInt(2, model.getUid());
            this.pst.setInt(3, model.getQunatity());
            this.pst.setString(4, model.getDate());
            this.pst.executeUpdate();
            result = true;
        } catch (SQLException var4) {
            System.out.println(var4.getMessage());
        }

        return result;
    }

    public List<Order> userOrders(int id) {
        ArrayList list = new ArrayList();

        try {
            this.query = "select * from orders where u_id=? order by orders.o_id desc";
            this.pst = this.con.prepareStatement(this.query);
            this.pst.setInt(1, id);
            this.rs = this.pst.executeQuery();

            while(this.rs.next()) {
                Order order = new Order();
                ProductDao productDao = new ProductDao(this.con);
                int pId = this.rs.getInt("p_id");
                Product product = productDao.getSingleProduct(pId);
                order.setOrderId(this.rs.getInt("o_id"));
                order.setId(pId);
                order.setName(product.getName());
                order.setCategory(product.getCategory());
                order.setPrice(product.getPrice() * (double)this.rs.getInt("o_quantity"));
                order.setQunatity(this.rs.getInt("o_quantity"));
                order.setDate(this.rs.getString("o_date"));
                list.add(order);
            }
        } catch (Exception var7) {
            var7.printStackTrace();
            System.out.println(var7.getMessage());
        }

        return list;
    }

    public void cancelOrder(int id) {
        try {
            this.query = "delete from orders where o_id=?";
            this.pst = this.con.prepareStatement(this.query);
            this.pst.setInt(1, id);
            this.pst.execute();
        } catch (SQLException var3) {
            var3.printStackTrace();
            System.out.print(var3.getMessage());
        }

    }
}
