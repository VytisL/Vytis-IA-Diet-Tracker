package com.benedict.minibank.Views;

import com.benedict.minibank.Controllers.RouteController;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ViewFactory {
    private final ObjectProperty<MenuOptions> adminSelectedMenuItem;
    private AnchorPane authorsView;
    private AnchorPane createAuthorView;
    private Pane addFoodTypeView;
    private Pane addFoodItemIntoDayView;
    private Pane addMealIntoDayView;
    private Pane CreateMealView;
    private AnchorPane dashboard;


    public Pane getAddFoodTypeView() {
        if(addFoodTypeView == null){
            try {
                addFoodTypeView = new FXMLLoader(getClass().getResource("/Fxml/AddFoodTypeWindow.fxml")).load();
            }catch (Exception e){
                System.out.println(e);
            }
        }
        return addFoodTypeView;
    }

    public Pane getAddFoodItemIntoDayView() {
        if(addFoodItemIntoDayView == null){
            try {
                addFoodItemIntoDayView = new FXMLLoader(getClass().getResource("/Fxml/AddFoodItemIntoDayWindow.fxml")).load();
            }catch (Exception e){
                System.out.println(e);
            }
        }
        return addFoodItemIntoDayView;
    }

    public Pane getAddMealIntoDayView() {
        if(addMealIntoDayView == null){
            try {
                addMealIntoDayView = new FXMLLoader(getClass().getResource("/Fxml/AddMealIntoDayWindow.fxml")).load();
            }catch (Exception e){
                System.out.println(e);
            }
        }
        return addMealIntoDayView;
    }

    public Pane getCreateMealView() {
        if(CreateMealView == null){
            try {
                CreateMealView = new FXMLLoader(getClass().getResource("/Fxml/CreateMealWindow.fxml")).load();
            }catch (Exception e){
                System.out.println(e);
            }
        }
        return CreateMealView;
    }


    public Pane returnToMainWindow() {
        if(dashboard == null){
            try {
                dashboard = new FXMLLoader(getClass().getResource("/Fxml/Dashboard.fxml")).load();
            }catch (Exception e){
                System.out.println(e);
            }
        }
        return dashboard;
    }


    public ViewFactory(){
        this.adminSelectedMenuItem = new SimpleObjectProperty<>();
    }

  //Auth

    /*
    * User login
     */

    public void showLoginWindow (){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        createStage(loader);
    }

    /*
     * User register
     */

    public void showRegisterWindow (){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Register.fxml"));
        createStage(loader);
    }

    public ObjectProperty<MenuOptions> getAdminSelectedMenuItem(){
        return adminSelectedMenuItem;
    }

    public AnchorPane getAuthorsView() {
        if(authorsView == null){
            try {
                authorsView = new FXMLLoader(getClass().getResource("/Fxml/Authors.fxml")).load();
            }catch (Exception e){
                System.out.println(e);
            }
        }
        return authorsView;
    }

    public AnchorPane getCreateAuthorView() {
        if(createAuthorView == null){
            try {
                createAuthorView = new FXMLLoader(getClass().getResource("/Fxml/CreateAuthor.fxml")).load();
            }catch (Exception e){
                System.out.println(e);
            }
        }
        return createAuthorView;
    }


    public void showAdminWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Main.fxml"));
        RouteController controller = new RouteController();
        loader.setController(controller);
        createStage(loader);
    }

    public void createStage(FXMLLoader loader){
        Scene scene = null;
        try{
            scene = new Scene(loader.load());
        }catch(Exception e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/icon.png"))));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("Benedikto knygynas");
        stage.show();
    }

    public void closeStage(Stage stage){
        Platform.runLater(stage::close);
    }


}
