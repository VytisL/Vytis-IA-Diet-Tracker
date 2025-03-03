package com.benedict.minibank.Controllers;

import com.benedict.minibank.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.Random;
import java.util.ResourceBundle;

public class CreateClientController  implements Initializable {
    public TextField fName_fld;
    public TextField lName_fld;
    public PasswordField password_fld;
    public CheckBox pAddress_box;
    public Label pAddress_lbl;
    public CheckBox ch_acc_chk_box;
    public TextField ch_amount_fld;
    public CheckBox sv_acc_chk_box;
    public TextField sv_amount_fld;
    public Button create_client_btn;
    public Label error_lbl;

    private String payeeAddress;
    private  boolean createCheckingAccountFalg = false;
    private boolean createSavingsAccountFlag = false;


    @Override
    public void initialize( URL url, ResourceBundle resourceBundle) {
        create_client_btn.setOnAction(event -> createClient());
        pAddress_box.selectedProperty().addListener((observable, oldVal, newVal) ->  {
            if(newVal){
               // payeeAddress = createPayyAddress();
                onCreatePayeeAddress();
            }
        });
        ch_acc_chk_box.selectedProperty().addListener((observable, oldVal, newVal) ->  {
            if(newVal){
                createCheckingAccountFalg = true;
            }
        });

        sv_acc_chk_box.selectedProperty().addListener((observable, oldVal, newVal) ->  {
            if(newVal){
                createSavingsAccountFlag = true;
            }
        });
    }

    private void createClient(){
        // Create Checking account
        if(createCheckingAccountFalg){
            createAccount("Checking");
        }

        if(createSavingsAccountFlag){
            createAccount("Savings");
        }

        //Create Client

        String fName = fName_fld.getText();
        String lName = lName_fld.getText();
        String password = password_fld.getText();
       // Model.getInstance().getDatabaseDriver().createClient(fName, lName, payeeAddress, password, LocalDate.now());
        emptyFields();
        error_lbl.setStyle("-fx-text-fill: blue; -fx-font-size: 1.3em; -fx-font-weight: bold");
        error_lbl.setText("Client Created Successfully!");

    }

    private void createCheckingAccount(){
        double balance = Double.parseDouble(ch_amount_fld.getText());
        //Generate Account number
        String firstPart = "3201";
        String secondPart = Integer.toString((new Random()).nextInt(9999) + 1000);
        String accountNumber = firstPart + " " + secondPart;
        //Create the checking account
       // Model.getInstance().getDatabaseDriver().createCheckingAccount(payeeAddress, accountNumber, 10, balance);

    }

    private void createAccount(String accountType){
        double balance = Double.parseDouble(ch_amount_fld.getText());
        //Generate Account number
        String firstPart = "3201";
        String secondPart = Integer.toString((new Random()).nextInt(9999) + 1000);
        String accountNumber = firstPart + " " + secondPart;
        //Create the checking or savings account
        if(accountType.equals("Checking")) {
            //Model.getInstance().getDatabaseDriver().createCheckingAccount(payeeAddress, accountNumber, 10, balance);
        }else {
           // Model.getInstance().getDatabaseDriver().createSavingsAccount(payeeAddress, accountNumber, 2000, balance);
        }
    }

    private void onCreatePayeeAddress(){
        if(fName_fld.getText() != null & lName_fld.getText() != null){
            pAddress_lbl.setText(payeeAddress);
        }
    }

   /* private String createPayyAddress(){
        //int id = Model.getInstance().getDatabaseDriver().getLastClientId() + 1;
        char fChar = Character.toLowerCase(fName_fld.getText().charAt(0));
        //return  "@"+fChar+lName_fld.getText()+id;
    }*/



    private void emptyFields(){
        fName_fld.setText("");
        lName_fld.setText("");
        password_fld.setText("");
        pAddress_box.setSelected(false);
        pAddress_lbl.setText("");
        ch_acc_chk_box.setSelected(false);
        ch_amount_fld.setText("");
        sv_acc_chk_box.setSelected(false);
        sv_amount_fld.setText("");
    }
}
