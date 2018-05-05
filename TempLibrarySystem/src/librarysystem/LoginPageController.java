/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.*;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Yihe Wang
 */
public class LoginPageController extends Switchable implements Initializable,PawPrintKeepAndDelete {

    private String pawPrint = null;
    private String password = null;
    
    /*
    private Stage stage;
    private Scene loginPageScene;
    private Scene studentSystemPageScene;
    private StudentSystemPageController studentSystemPageController;*/
    
    @FXML
    private Label displayErrorLabel;
    
    @FXML
    private Label pawPrintLabel;
    
    @FXML
    private Label passwordLabel;
    
    @FXML
    private TextField pawPrintField;
    
    @FXML
    private PasswordField passwordField;
    
    @FXML
    private Button studentButton;
    
    /*
    @FXML
    private Button librarianButton;*/
    
    @FXML
    private ImageView tiger;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        studentButton.setOnAction((ActionEvent event) -> {
            pawPrint = pawPrintField.getText();
            password = passwordField.getText();
            if(pawPrint.length() < 1 || password.length() < 1){
                System.out.println("Pawprint or password can not be empty!");
            }
            
            if(checkStudentIdentity(pawPrint,password)){
                System.out.println("Login successfully!");
                //keepPawPrint();
                keepPawPrint();
                goToStudentSystemPage();
                displayErrorLabel.setText("");
                pawPrintField.setText("");
                passwordField.setText("");
            }
            else{
                System.out.println("Pawprint and password do not match!");
                displayErrorLabel.setText("Pawprint and password do not match!");
            }
        });
        
        /*
        librarianButton.setOnAction((ActionEvent event) -> {
            pawPrint = pawPrintField.getText();
            password = passwordField.getText();
            if(pawPrint.length() < 1 || password.length() < 1){
                System.out.println("Pawprint or password can not be empty!");
            }
            
            if(checkLibrarianIdentity(pawPrint,password)){
                System.out.println("Login successfully!");
                goToStudentSystemPage();
            }
            else{
                System.out.println("Pawprint and password do not match!");
                displayErrorLabel.setText("Pawprint and password do not match!");
            }
        });*/
    }
    
    public boolean checkStudentIdentity(String pawPrint, String password){
        String tempPawPrint = null;
        String tempPassword = null;
        
        Connection c = null;
        Statement stmt = null;
        try {
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:Final.db");
        c.setAutoCommit(false);
        System.out.println("Opened database successfully");

        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT password,pawPrint FROM Student WHERE pawPrint = '" + pawPrint + "';" );
        
        //int id = rs.getInt("id");
        tempPawPrint = rs.getString("pawprint");
        tempPassword = rs.getString("password");
        //System.out.println( "ADDRESS = " + address );
        //System.out.println();
      

        rs.close();
        stmt.close();
        c.close();
        } catch ( Exception e ) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
        }
        System.out.println("Table connected successfully");
        
        
        if(pawPrint.equals(tempPawPrint)){
            if(password.equals(tempPassword)){
            return true;
        } 
        }
            
        return false;
    }
    
    /*
    public boolean checkLibrarianIdentity(String pawPrint, String password){
        if(pawPrint.equals("ywm46")){
            if(password.equals("31415926aaaa")){
            return true;
        }
        }
            
        return false;
    }*/
    
    private void goToStudentSystemPage() {
        //System.out.println("Table Student created successfully");
        Switchable.switchTo("StudentSystemPage");
        StudentSystemPageController studentSystemPageController = (StudentSystemPageController) getControllerByName("StudentSystemPage");
        
    }
    
    @Override
    public void keepPawPrint() {
        Connection conn = null;
        Statement stmt = null;
        try {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:Final.db");
        System.out.println("Opened database successfully");
        
        stmt = conn.createStatement();
        //String sql = "INSERT INTO TempStudent VALUES (" + pawPrint + ");";
        String sql = "INSERT INTO KeepPawPrint (pawPrint) VALUES ('" + pawPrint + "');";
        stmt.executeUpdate(sql);
        System.out.println("Table KeepPawPrint insert successfully!");
        
        stmt.close();
        conn.close();
        } catch ( Exception e ) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
        }
    }
    
    @Override
    public void removePawPrint() {
        //do nothing
    }
}
