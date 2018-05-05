/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Yihe Wang
 */
public class StudentSystemPageController extends Switchable implements Initializable,PawPrintKeepAndDelete {

    //@FXML
    //private Label infoLabel;
    @FXML
    private Button searchForBook;
    
    @FXML
    private Button myStatus;
    
    @FXML
    private ImageView logOutView;
    
    @FXML
    private ImageView myZou;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    public void goToSearchBookPage() {
        Switchable.switchTo("SearchBookPage");
        SearchBookPageController searchBookPageController = (SearchBookPageController) getControllerByName("SearchBookPage");
    }
    
    @FXML
    private void logOut(ActionEvent event) {
        removePawPrint();
        Switchable.switchTo("LoginPage");
        LoginPageController loginPageController = (LoginPageController) getControllerByName("LoginPage");
    }
    
    @FXML
    private void goToMyStatusPage() {
        //removePawPrint();
        Switchable.switchTo("MyStatusPage");
        MyStatusPageController myStatusPageController = (MyStatusPageController) getControllerByName("MyStatusPage");
    }
    
    
    @Override
    public void removePawPrint() {     
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:Final.db");
            conn.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = conn.createStatement();
            String sql = "DELETE FROM KeepPawPrint;";
            stmt.executeUpdate(sql);
            conn.commit();
            stmt.close();
            conn.close();
        } catch ( Exception e ) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
    
    @Override
    public void keepPawPrint() {
        //do nothing
    }
}
