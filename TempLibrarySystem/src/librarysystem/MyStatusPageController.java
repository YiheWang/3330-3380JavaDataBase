/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Yihe Wang
 */
public class MyStatusPageController extends Switchable implements Initializable {

    @FXML
    private TextField firstName;
    
    @FXML
    private TextField lastName;
    
    @FXML
    private TextField pawPrint;
    
    @FXML
    private TextField studentID;
    
    @FXML
    private TextField historyBorrowNumber;
    
    @FXML
    private TextField lastBorrowTime;
    
    @FXML
    private TextField holdNumber;
    
    @FXML
    private TextField book1;
    @FXML
    private TextField book2;
    @FXML
    private TextField book3;
    @FXML
    private TextField book4;
    @FXML
    private TextField book5;
    @FXML
    private TextField book6;
    @FXML
    private TextField book7;
    @FXML
    private TextField book8;
    @FXML
    private TextField book9;
    @FXML
    private TextField book10;
    
    @FXML
    private TextField returnBookName;
    
    @FXML
    private Button returnBookButton;
    
    @FXML
    private Label successNotice;
    
    String tempPawPrint = null;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        selectAndSetInfo();
    }    
    
    @FXML
    public void refresh() {
        selectAndSetInfo();
    }
    /*
    public void selectAndSetInfo() {
        Connection c = null;
        Statement stmt = null;
        try {
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:Final.db");
        c.setAutoCommit(false);
        System.out.println("Opened database successfully");

        stmt = c.createStatement();
        
        ResultSet rs = null;
        rs = stmt.executeQuery( "SELECT * FROM KeepPawPrint;");
        tempPawPrint = rs.getString("pawPrint");
        System.out.println(tempPawPrint);
        rs = stmt.executeQuery( "SELECT * FROM Student WHERE pawPrint = '"+ tempPawPrint +"';" );
      
        pawPrint.setText(rs.getString("pawPrint"));
        studentID.setText(rs.getString("studentID"));
        lastName.setText(rs.getString("lastName"));
        firstName.setText(rs.getString("firstName"));
        rs.getString("password");
        historyBorrowNumber.setText("" + rs.getInt("historyBorrowNumber"));
        lastBorrowTime.setText(rs.getString("lastBorrowTime"));
        holdNumber.setText("" + rs.getInt("holdNum"));
        
        rs = stmt.executeQuery( "SELECT * FROM StudentHoldBook WHERE pawPrint = '"+ tempPawPrint +"';" );
        
        rs.getString("pawPrint");
        rs.getInt("holdNum");
        book1.setText(rs.getString("book1"));
        book2.setText(rs.getString("book2"));
        book3.setText(rs.getString("book3"));
        book4.setText(rs.getString("book4"));
        book5.setText(rs.getString("book5"));
        System.out.println(rs.getString("book5"));
        book6.setText(rs.getString("book6"));
        book7.setText(rs.getString("book7"));
        book8.setText(rs.getString("book8"));
        book9.setText(rs.getString("book9"));
        book10.setText(rs.getString("book10"));
        
        
        rs.close();
        stmt.close();
        c.close();
        } catch ( Exception e ) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
        }
        System.out.println("Table connected successfully");
    }*/
    
    
    public void selectAndSetInfo() {
        Connection c = null;
        Statement stmt = null;
        try {
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:Final.db");
        c.setAutoCommit(false);
        System.out.println("Opened database successfully");
        
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM KeepPawPrint;");
        tempPawPrint = rs.getString("pawPrint");
        System.out.println(tempPawPrint);

        rs = stmt.executeQuery( "SELECT * FROM Student WHERE pawPrint = '"+ tempPawPrint +"'; " );
        System.out.println("Success");
        
        Student student = new Student(
                rs.getString("pawPrint"),
                rs.getInt("studentID"),
                rs.getString("lastName"),
                rs.getString("firstName"),
                rs.getString("password"),
                rs.getInt("historyBorrowNumber"),
                rs.getString("lastBorrowTime"),
                rs.getInt("holdNum"));
        System.out.println("Success");
        
        pawPrint.setText(student.getPawPrint());
        studentID.setText("" + student.getID());
        lastName.setText(student.getLastName());
        firstName.setText(student.getFirstName());
        System.out.println(student.getFirstName());
        historyBorrowNumber.setText("" + student.getHistoryBorrowNumber());
        lastBorrowTime.setText(student.getLastBorrowTime());
        holdNumber.setText("" + student.getHoldNumber());
        System.out.println("Success");
        
        
        rs = stmt.executeQuery("SELECT * FROM StudentHoldBook WHERE pawPrint = '" + tempPawPrint + "';");
        StudentHoldBook studentHoldBook = new StudentHoldBook(
                rs.getString("pawPrint"),
                rs.getInt("holdNum"),
                rs.getString("book1"),
                rs.getString("book2"),
                rs.getString("book3"),
                rs.getString("book4"),
                rs.getString("book5"),
                rs.getString("book6"),
                rs.getString("book7"),
                rs.getString("book8"),
                rs.getString("book9"),
                rs.getString("book10"));//put all data into collection class
        System.out.println("Success");
        
        rs = stmt.executeQuery( "SELECT * FROM StudentHoldBook WHERE pawPrint = '"+ tempPawPrint +"';" );
        book1.setText(studentHoldBook.getBook(1));
        book2.setText(studentHoldBook.getBook(2));
        book3.setText(studentHoldBook.getBook(3));
        book4.setText(studentHoldBook.getBook(4));
        book5.setText(studentHoldBook.getBook(5));
        book6.setText(studentHoldBook.getBook(6));
        book7.setText(studentHoldBook.getBook(7));
        book8.setText(studentHoldBook.getBook(8));
        book9.setText(studentHoldBook.getBook(9));
        book10.setText(studentHoldBook.getBook(10));
        System.out.println("Success");
        
        rs.close();
        stmt.close();
        c.close();
        } catch ( Exception e ) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
        }
        System.out.println("Table connected successfully");
    }
    
    @FXML
    private void returnBooks() {
        successNotice.setText("");
        String bookName;
        bookName = returnBookName.getText();
        if(bookName.length() < 1){
            successNotice.setText("Please enter something!");
            return;
        }
        
        Connection c = null;
        Statement stmt = null;
        try {
            //String tempSearchChoice = null;
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Final.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = null;
            rs = stmt.executeQuery( "SELECT * FROM KeepPawPrint;");
            tempPawPrint = rs.getString("pawPrint");
            System.out.println(tempPawPrint);
                      
            //check if the book exist or not
            rs = stmt.executeQuery("SELECT nowNumber FROM BooksInfo WHERE name = '" + bookName + "';");
            int nowNumber = rs.getInt("nowNumber");
            System.out.println(nowNumber);
            String sql = "UPDATE BooksInfo SET nowNumber = " + (nowNumber - 1) +" WHERE name = '" + bookName + "';";
            stmt.executeUpdate(sql);
            //update the book information
            
            rs = stmt.executeQuery("SELECT nowNumber FROM BooksInfo WHERE name = '" + bookName + "';");
            System.out.println(rs.getInt("nowNumber"));
            //check if update or not
            
            
            //update student information
            rs = stmt.executeQuery( "SELECT holdNum FROM Student WHERE pawPrint = '"+ tempPawPrint +"';" );
            int holdNum = rs.getInt("holdNum");
            System.out.println(holdNum);
            sql = "UPDATE Student SET holdNum = " + (holdNum - 1)+"  WHERE pawPrint = '"+ tempPawPrint +"';";
            stmt.executeUpdate(sql);
            
            
            String tempBookName = null;
            rs = stmt.executeQuery("SELECT name FROM BooksInfo WHERE name = '" + bookName + "';");
            tempBookName = rs.getString("name");
            System.out.println(tempBookName);
            
            
            rs = stmt.executeQuery("SELECT * FROM StudentHoldBook WHERE pawPrint = '" + tempPawPrint + "';");
            StudentHoldBook studentHoldBook = new StudentHoldBook(rs.getString("pawPrint"),
            rs.getInt("holdNum"),
            rs.getString("book1"),
            rs.getString("book2"),
            rs.getString("book3"),
            rs.getString("book4"),
            rs.getString("book5"),
            rs.getString("book6"),
            rs.getString("book7"),
            rs.getString("book8"),
            rs.getString("book9"),
            rs.getString("book10"));//put all data into collection class
            
            System.out.println("Success");
            
            studentHoldBook.deleteBookInList(tempBookName);//delete the book we return
            
            System.out.println("Success");
            
            sql = "UPDATE StudentHoldBook SET holdNum = " + (holdNum - 1) +"  WHERE pawPrint = '"+ tempPawPrint +"';";
            stmt.executeUpdate(sql);
            for(int i = 1; i < 11; ++i){
                sql = "UPDATE StudentHoldBook SET book" + i +" = NULL WHERE pawPrint = '"+ tempPawPrint +"'; ";
                stmt.executeUpdate(sql);
            }
            
            int tempSize = studentHoldBook.getSize();
            System.out.println(tempSize);
            for(int i = 1; i < tempSize; ++i){
                sql = "UPDATE StudentHoldBook SET book" + i +" = '"+ studentHoldBook.getBook(i) + "'  WHERE pawPrint = '"+ tempPawPrint +"'; ";
                stmt.executeUpdate(sql);      
            }
            
            rs.close();
            stmt.close();
            c.commit();
            c.close();
            } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
            }
            System.out.println("Table connected successfully");
            successNotice.setText("Return successfully!");
            returnBookName.setText("Enter Book Name You Want Return");
            selectAndSetInfo();
    }
    
    @FXML
    public void backToFormerPage() {
        Switchable.switchTo("StudentSystemPage");
        StudentSystemPageController studentSystemPageController = (StudentSystemPageController) getControllerByName("StudentSystemPage");
    }
    
}
