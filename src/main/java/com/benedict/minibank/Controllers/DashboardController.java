package com.benedict.minibank.Controllers;

import com.benedict.minibank.Models.FoodType;
import com.benedict.minibank.Models.Model;
import com.benedict.minibank.Utilities.DialogUtility;
import com.benedict.minibank.Views.MenuOptions;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    public Button add_food_type_btn;
    public Button add_food_into_day_one_btn;
    public Button add_food_into_day_two_btn;
    public Button create_meal_btn;
    public Button add_meal_into_day_one_btn;
    public Button add_meal_into_day_two_btn;
    public Button view_progress_btn;

    public TableView<FoodType> food_types_table;
    public TableColumn<FoodType, String> types_col_name;
    public TableColumn<FoodType, String> types_col_calories;
    public TableColumn<FoodType, String> types_col_protein;
    public TableColumn<FoodType, String> types_col_carbs;
    public TableColumn<FoodType, String> types_col_fats;
    //add other tables too

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        add_food_type_btn.setOnAction(event -> onAddFoodType());
        add_food_into_day_one_btn.setOnAction(event -> onAddFoodIntoDay());
        add_food_into_day_two_btn.setOnAction(event -> onAddFoodIntoDay());
        create_meal_btn.setOnAction(event -> onCreateMeal());
        add_meal_into_day_one_btn.setOnAction(event -> onAddMealIntoDay());
        add_meal_into_day_two_btn.setOnAction(event -> onAddMealIntoDay());
        view_progress_btn.setOnAction(event -> onViewProgress());
        initTypesTableColumns();
        setRowFactoryForFoodTypesTable();
        loadFoodTypeData();
    }


    private void onAddFoodType() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(MenuOptions.ADD_FOOD_TYPE);
    }
    private void onAddFoodIntoDay() {
      Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(MenuOptions.ADD_FOOD_ITEM_INTO_DAY);
    }
    private void onCreateMeal() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(MenuOptions.CREATE_MEAL);
    }
    private void onAddMealIntoDay() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(MenuOptions.ADD_MEAL_INTO_DAY);
    }
    private void onViewProgress() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(MenuOptions.PROGRESS_VIEWER);
    }



    //FoodTypes table

    private void editFoodType(FoodType foodType) {
        Optional<FoodType> result = DialogUtility.showEditFoodTypeDialog(foodType);
        result.ifPresent(updateFoodType -> {
            Model.getInstance().updateFoodType(foodType);
            System.out.println("Update result");
        });
    }

    private void initTypesTableColumns() {
        types_col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        types_col_calories.setCellValueFactory(new PropertyValueFactory<>("calories"));
        types_col_protein.setCellValueFactory(new PropertyValueFactory<>("protein"));
        types_col_carbs.setCellValueFactory(new PropertyValueFactory<>("carbs"));
        types_col_fats.setCellValueFactory(new PropertyValueFactory<>("fats"));
    }

    private void setRowFactoryForFoodTypesTable() {
        food_types_table.setRowFactory(tv -> {
           TableRow<FoodType> row = new TableRow<>();
           row.setOnMouseClicked(event ->{
               if(event.getClickCount() == 2 && (!row.isEmpty())){
                   FoodType selectedFoodType = row.getItem();
                   editFoodType(selectedFoodType);
               }
           });
           return row;
        });
    }

    private void loadFoodTypeData() {
        ObservableList<FoodType> foodTypes = Model.getInstance().getFoodTypes();
        food_types_table.setItems(foodTypes);
    }

}
