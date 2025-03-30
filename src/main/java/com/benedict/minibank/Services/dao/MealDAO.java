package com.benedict.minibank.Services.dao;

import com.benedict.minibank.Models.FoodType;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MealDAO {

    private Connection conn;

    public MealDAO(Connection conn) {
        this.conn = conn;
    }

    public void create(String name, ObservableList<FoodType> foodTypes, ObservableList<Double> portions) {
        String insertMealsSQL = "INSERT INTO Meals (name, calories, protein, carbs, fats) VALUES (?, ?, ?, ?, ?)";
        String getIdSQL = "SELECT last_insert_rowid()";
        String insertMealItemsSQL = "INSERT INTO MealItems (meal_id, foodType_id, portion) VALUES (?, ?, ?)";


        double totalCalories = 0;
        double totalProtein = 0;
        double totalCarbs = 0;
        double totalFats = 0;
        double fraction;

        //Loop to add all nutrients
        for(int i = 0; i< foodTypes.size(); i++){
            fraction = portions.get(i)/100;
            totalCalories += foodTypes.get(i).getCalories()*fraction;
            totalProtein += foodTypes.get(i).getProtein()*fraction;
            totalCarbs += foodTypes.get(i).getCarbs()*fraction;
            totalFats += foodTypes.get(i).getFats()*fraction;
        }

        try(PreparedStatement mealStmt = conn.prepareStatement(insertMealsSQL);
            PreparedStatement getIdStmt = conn.prepareStatement(getIdSQL);
            PreparedStatement mealItemStmt = conn.prepareStatement(insertMealItemsSQL)) {

            //This works, meal is created with the right amount of all nutrients and saved to DB
            mealStmt.setString(1, name);
            mealStmt.setDouble(2, totalCalories);
            mealStmt.setDouble(3, totalProtein);
            mealStmt.setDouble(4, totalCarbs);
            mealStmt.setDouble(5, totalFats);
            mealStmt.executeUpdate();
            System.out.println("Meal created successfully");

            //This part does not work.
            //I'm not sure how it could work
            //It does not break though
            ResultSet rs = getIdStmt.executeQuery();
            int mealId = -1;
            if (rs.next()) {
                mealId = rs.getInt(1);
            }

            for(int k = 0; k < foodTypes.size(); k++){
                mealItemStmt.setInt(1, mealId);
                mealItemStmt.setInt(2, foodTypes.get(k).getId());
                mealItemStmt.setDouble(3, portions.get(k));
            }

        } catch (SQLException e) {
            System.out.println("ERROR CREATING MEAL" + e.getMessage());
            e.printStackTrace();
        }



    }
}
