package com.benedict.minibank.Models;

import javafx.beans.property.*;

public class FoodType {
    private IntegerProperty id;

    private StringProperty name;
    private DoubleProperty calories;
    private DoubleProperty protein;
    private DoubleProperty carbs;
    private DoubleProperty fats;

    public FoodType(String name, double calories, double protein, double carbs, double fats) {
        this.name = new SimpleStringProperty(name);
        this.calories = new SimpleDoubleProperty(calories);
        this.protein = new SimpleDoubleProperty(protein);
        this.carbs = new SimpleDoubleProperty(carbs);
        this.fats = new SimpleDoubleProperty(fats);
    }
    public FoodType(int id, String name, double calories, double protein, double carbs, double fats) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.calories = new SimpleDoubleProperty(calories);
        this.protein = new SimpleDoubleProperty(protein);
        this.carbs = new SimpleDoubleProperty(carbs);
        this.fats = new SimpleDoubleProperty(fats);
    }



    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public double getCalories() {
        return calories.get();
    }

    public DoubleProperty caloriesProperty() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories.set(calories);
    }

    public double getProtein() {
        return protein.get();
    }

    public DoubleProperty proteinProperty() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein.set(protein);
    }

    public double getCarbs() {
        return carbs.get();
    }

    public DoubleProperty carbsProperty() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs.set(carbs);
    }

    public double getFats() {
        return fats.get();
    }

    public DoubleProperty fatsProperty() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats.set(fats);
    }

}
