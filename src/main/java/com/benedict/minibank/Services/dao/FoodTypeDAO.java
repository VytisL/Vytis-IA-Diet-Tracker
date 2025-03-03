package com.benedict.minibank.Services.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FoodTypeDAO {

    private Connection conn;

    public FoodTypeDAO(Connection conn) {
        this.conn = conn;
    }

    public void create(String name, double calories, double protein, double carbs, double fats) {
        String sql = "INSERT INTO FoodTypes (name, calories, protein, carbs, fats) VALUES (?, ?, ?, ?, ?)";
        try(PreparedStatement stmt = this.conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setDouble(2, calories);
            stmt.setDouble(3, protein);
            stmt.setDouble(4, carbs);
            stmt.setDouble(5, fats);
            stmt.executeUpdate();
            System.out.println("FoodType created successfully");
        } catch (SQLException e) {
            System.out.println("ERROR CREATING FOODTYPE" + e.getMessage());
            e.printStackTrace();
        }
    }
}
