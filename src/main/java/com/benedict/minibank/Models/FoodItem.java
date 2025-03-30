package com.benedict.minibank.Models;

import javafx.beans.property.*;

public class FoodItem extends Food{
    private SimpleObjectProperty<FoodType> foodType;
    private SimpleIntegerProperty foodTypeId;
    private double portion;

    public FoodItem(int id, SimpleObjectProperty<FoodType> foodType, double portion){
        this.id = new SimpleIntegerProperty(id);
        this.foodTypeId = new SimpleIntegerProperty(foodType.get().getId());
        this.foodType = foodType;
        this.portion = portion;

        this.name = new SimpleStringProperty(foodType.getName() + ", " + portion + "g");
        this.calories = new SimpleDoubleProperty(foodType.get().getCalories()*(portion/100));
        this.protein = new SimpleDoubleProperty(foodType.get().getProtein()*(portion/100));
        this.carbs = new SimpleDoubleProperty(foodType.get().getCarbs()*(portion/100));
        this.fats = new SimpleDoubleProperty(foodType.get().getFats()*(portion/100));
    }
    public FoodItem(int id, double portion, int foodTypeId, String name, double calories, double protein, double carbs, double fats) {
        this.id = new SimpleIntegerProperty(id);
        this.portion = portion;
        this.foodTypeId = new SimpleIntegerProperty(foodTypeId);
        this.name = new SimpleStringProperty(name);
        this.calories = new SimpleDoubleProperty(calories);
        this.protein = new SimpleDoubleProperty(protein);
        this.carbs = new SimpleDoubleProperty(carbs);
        this.fats = new SimpleDoubleProperty(fats);
    }
}
