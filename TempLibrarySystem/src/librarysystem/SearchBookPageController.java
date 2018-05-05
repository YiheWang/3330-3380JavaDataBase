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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Yihe Wang
 */
public class SearchBookPageController extends Switchable implements Initializable {


    @FXML
    private TableView<NestedBook> tableView;
    
    private final ObservableList<NestedBook> data = FXCollections.observableArrayList();
    
    @FXML
    TableColumn id;
    
    @FXML
    TableColumn name;
    
    @FXML
    TableColumn author;
    
    @FXML
    TableColumn category;
    
    @FXML
    TableColumn price;
    
    @FXML
    TableColumn sumNumber;
    
    @FXML
    TableColumn nowNumber;
    
    @FXML
    TableColumn historyBorrowTimes;
    
    @FXML
    TableColumn ifReadOnly;
    
    @FXML
    TableColumn lastBorrowTime;
    
    @FXML
    TableColumn library;
    
    @FXML
    private Menu searchChoicesMenu;
    
    @FXML
    private MenuItem searchById;
    
    @FXML
    private MenuItem searchByName;
    
    @FXML
    private MenuItem searchByAuthor;
    
    @FXML
    private MenuItem searchByCategory;
    
    @FXML
    private Button searchButton;
    
    @FXML
    private TextField searchText;
    
    @FXML
    private Button borrowButton;
    
    @FXML
    private TextField borrowText;
    
    @FXML
    private Label emptyNotice;
    
    private ArrayList<MenuItem> menuItems;  
    
    private String tempPawPrint = null;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        menuItems = new ArrayList<>();
        menuItems.add(searchById);
        menuItems.add(searchByName);
        menuItems.add(searchByAuthor);
        menuItems.add(searchByCategory);
        // TODO
        for (MenuItem menuItem : menuItems) {
            menuItem.setUserData(menuItem);
            menuItem.setOnAction((ActionEvent event) -> {
                selectMenuItem(event);                          
                //searchBook(searchButton.getText());
            });
            searchButton.setOnAction((ActionEvent event) ->{
                searchBook(searchButton.getText());
            });
        }
        
        borrowButton.setOnAction((ActionEvent event) -> {
            clickBorrowButton();
        });

    }
    
    
    private void clickBorrowButton() {
        emptyNotice.setText("");
        String bookName;
        bookName = borrowText.getText();
        if(bookName.length() < 1){
            emptyNotice.setText("Please enter something!");
            return;
        }
        
        Connection c = null;
        Statement stmt = null;
        try {
            String tempSearchChoice = null;
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Final.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM KeepPawPrint;");
            tempPawPrint = rs.getString("pawPrint");
            System.out.println(tempPawPrint);
            
            rs = stmt.executeQuery( "SELECT * FROM BooksInfo WHERE name = '" + bookName + "';");
            if(rs == null){
                System.out.println("This book not exist!");
                emptyNotice.setText("This book not exist!");
                return;
            }
            //System.out.println(rs.getInt("id"));
            //check if the book exist or not
            rs = stmt.executeQuery("SELECT nowNumber FROM BooksInfo WHERE name = '" + bookName + "';");
            int nowNumber = rs.getInt("nowNumber");
            if(nowNumber == 0){
                System.out.println("All of this book were borrowed, you can connect librarian for more information");
                emptyNotice.setText("All of this book were borrowed, you can connect librarian for more information");
                return;
            }
            String sql = "UPDATE BooksInfo SET nowNumber = " + (nowNumber - 1) +" WHERE name = '" + bookName + "';";
            stmt.executeUpdate(sql);//update holdNumber
            
            rs = stmt.executeQuery("SELECT historyBorrowTimes FROM BooksInfo WHERE name = '" + bookName + "';");
            int historyBorrowTimes1 = rs.getInt("historyBorrowTimes");
            sql = "UPDATE BooksInfo SET historyBorrowTimes = " + (historyBorrowTimes1 + 1) +" WHERE name = '" + bookName + "';";
            stmt.executeUpdate(sql);//update historyBorrowTimes
            
            String time = getLocalTime();
            sql = "UPDATE BooksInfo SET lastBorrowTime = '" + time +"' WHERE name = '" + bookName + "';";
            stmt.executeUpdate(sql);//update new time 
            //update the book information
            
            
            //update student information
            rs = stmt.executeQuery( "SELECT holdNum FROM Student WHERE pawPrint = '"+ tempPawPrint +"'; " );
            int holdNum = rs.getInt("holdNum");
            sql = "UPDATE Student SET holdNum = " + (holdNum + 1)+" WHERE pawPrint = '"+ tempPawPrint +"'; ";
            stmt.executeUpdate(sql);
            
            sql = "UPDATE StudentHoldBook SET holdNum = " + (holdNum + 1) +" WHERE pawPrint = '"+ tempPawPrint +"'; ";
            stmt.executeUpdate(sql);
            sql = "UPDATE StudentHoldBook SET book" +(holdNum + 1) + " = '" + bookName +"' WHERE pawPrint = '"+ tempPawPrint +"'; ";
            stmt.executeUpdate(sql);
            
            
            rs = stmt.executeQuery("SELECT historyBorrowNumber FROM Student WHERE pawPrint = '"+ tempPawPrint +"'; ");
            int historyBorrowNumber = rs.getInt("historyBorrowNumber");
            sql = "UPDATE Student SET historyBorrowNumber = " + (historyBorrowNumber + 1) +" WHERE pawPrint = '"+ tempPawPrint +"'; ";
            stmt.executeUpdate(sql);//update historyBorrowTimes
            
            rs = stmt.executeQuery( "SELECT book5 FROM StudentHoldBook WHERE pawPrint = '"+ tempPawPrint +"'; " );
            System.out.println(rs.getString("book5"));
            
            time = getLocalTime();
            sql = "UPDATE Student SET lastBorrowTime = '" + time +"'  WHERE pawPrint = '"+ tempPawPrint +"'; ";
            stmt.executeUpdate(sql);//update new time 
            
            //write sql here
            
            rs.close();
            stmt.close();
            c.commit();
            c.close();
            } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
            }
            System.out.println("Table connected successfully");
            emptyNotice.setText("Borrow successfully!");
            borrowText.setText("");
    }
    
    private void selectMenuItem(ActionEvent event) {
        MenuItem menuItem = (MenuItem)event.getSource();
        searchButton.setText(menuItem.getText());
        searchText.setText("Search by id/name/author/category,enter here");
    }
      
    public void searchBook(String searchChoice){
        
    Connection c = null;
    Statement stmt = null;
    try {
        String tempSearchChoice = null;
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:Final.db");
        c.setAutoCommit(false);
        System.out.println("Opened database successfully");

        stmt = c.createStatement();
        ResultSet rs = null;
        if(searchChoice.equals("searchById")){
            tempSearchChoice = "id";
            rs = stmt.executeQuery( "SELECT * FROM BooksInfo WHERE " + tempSearchChoice + " = " + searchText.getText());
        }
        else if(searchChoice.equals("searchByName")){
            tempSearchChoice = "name";
            rs = stmt.executeQuery( "SELECT * FROM BooksInfo WHERE " + tempSearchChoice + " LIKE '%" + searchText.getText() + "%'");
        }
        else if(searchChoice.equals("searchByAuthor")){
            tempSearchChoice = "author";
            rs = stmt.executeQuery( "SELECT * FROM BooksInfo WHERE " + tempSearchChoice + " LIKE '%" + searchText.getText() + "%'");
        }
        else if(searchChoice.equals("searchByCategory")){
            tempSearchChoice = "category";
            rs = stmt.executeQuery( "SELECT * FROM BooksInfo WHERE " + tempSearchChoice + " LIKE '%" + searchText.getText() + "%'");
        }
        
        while (rs.next()){
                    data.add(new NestedBook(rs.getInt("id"), rs.getString("name"), rs.getString("author"),
                            rs.getString("category"), rs.getDouble("price"), rs.getInt("sumNumber"),
                    rs.getInt("nowNumber"),rs.getInt("historyBorrowTimes"),rs.getBoolean("ifReadOnly"),
                    rs.getString("lastBorrowTime"),rs.getString("library")));
                }
      
        rs.close();
        stmt.close();
        c.close();
        } catch ( Exception e ) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
        }
        System.out.println("Table connected successfully");
        
        id.setCellValueFactory(new PropertyValueFactory<Person,Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Person,String>("name"));
        author.setCellValueFactory(new PropertyValueFactory<Person,String>("author"));
        category.setCellValueFactory(new PropertyValueFactory<Person,String>("category"));
        price.setCellValueFactory(new PropertyValueFactory<Person,Double>("price"));
        sumNumber.setCellValueFactory(new PropertyValueFactory<Person,Integer>("sumNumber"));
        nowNumber.setCellValueFactory(new PropertyValueFactory<Person,Integer>("nowNumber"));
        historyBorrowTimes.setCellValueFactory(new PropertyValueFactory<Person,Integer>("historyBorrowTimes"));
        ifReadOnly.setCellValueFactory(new PropertyValueFactory<Person,Boolean>("ifReadOnly"));
        lastBorrowTime.setCellValueFactory(new PropertyValueFactory<Person,String>("lastBorrowTime"));
        library.setCellValueFactory(new PropertyValueFactory<Person,String>("library"));
        
        
        tableView.setItems(data);
    }
    
    @FXML
    public void backToFormerPage(ActionEvent event) {
        Switchable.switchTo("StudentSystemPage");       
        StudentSystemPageController studentSystemPageController = (StudentSystemPageController) getControllerByName("StudentSystemPage");
    }
    
    private static String getLocalTime(){
        Calendar cal = Calendar.getInstance();
        String time= new SimpleDateFormat("yyyy-MM-dd-hh:mmaa",Locale.ENGLISH).format(cal.getTime());
        System.out.println(time);
        return time;
    }
    
    public static class NestedBook {      
        private final SimpleIntegerProperty id;
        private final SimpleStringProperty name;
        private final SimpleStringProperty author;
        private final SimpleStringProperty category;
        private final SimpleDoubleProperty price;
        private final SimpleIntegerProperty sumNumber;
        private final SimpleIntegerProperty nowNumber;
        private final SimpleIntegerProperty historyBorrowTimes;
        private final SimpleBooleanProperty ifReadOnly;
        private final SimpleStringProperty lastBorrowTime;
        private final SimpleStringProperty library;

        private NestedBook(int id, String name, String author, String category,
            double price, int sumNumber, int nowNumber, int historyBorrowTimes,
            boolean ifReadOnly, String lastBorrowTime, String library) {
            
            this.id = new SimpleIntegerProperty(id);
            this.name = new SimpleStringProperty(name);
            this.author = new SimpleStringProperty(author);
            this.category = new SimpleStringProperty(category);
            this.price = new SimpleDoubleProperty(price);
            this.sumNumber = new SimpleIntegerProperty(sumNumber);
            this.nowNumber = new SimpleIntegerProperty(nowNumber);
            this.historyBorrowTimes = new SimpleIntegerProperty(historyBorrowTimes);
            this.ifReadOnly = new SimpleBooleanProperty(ifReadOnly);
            this.lastBorrowTime = new SimpleStringProperty(lastBorrowTime);
            this.library = new SimpleStringProperty(library);
        }

        public int getId(){
            return id.get();
        }
    
        public void setId(int id){
            this.id.set(id);
        }
    
        public String getName(){
            return name.get();
        }
    
        public void setName(String name){
            this.name.set(name);
        }
    
        public String getAuthor(){
            return author.get();
        }
    
        public void setAuthor(String author){
            this.author.set(author);
        }
    
        public String getCategory(){
            return category.get();
        }
    
        public void setCategory(String category){
            this.category.set(category);
        }
    
        public double getPrice(){
            return price.get();
        }
    
        public void setPrice(double price){
            this.price.set(price);
        }
    
        public int getSumNumber(){
            return sumNumber.get();
        }
    
        public void setSumNumber(int sumNumber){
            this.sumNumber.set(sumNumber);
        }
    
        public int getNowNumber(){
            return nowNumber.get();
        }
    
        public void setNowNumber(int nowNumber){
            this.nowNumber.set(nowNumber);
        }
    
        public int getHistoryBorrowTimes(){
            return historyBorrowTimes.get();
        }
    
        public void setHistoryBorrowTimes(int historyBorrowTimes){
            this.historyBorrowTimes.set(historyBorrowTimes);
        }
    
        public boolean getIfReadOnly(){
            return ifReadOnly.get();
        }
    
        public void setIfReadOnly(boolean ifReadOnly){
            this.ifReadOnly.set(ifReadOnly);
        }
    
        public String getLastBorrowTime(){
            return lastBorrowTime.get();
        }
    
        public void setLastBorrowTime(String lastBorrowTime){
            this.lastBorrowTime.set(lastBorrowTime);
        }
    
        public String getLibrary(){
            return library.get();
        }
    
        public void setLibrary(String library){
            this.library.set(library);
        }
       
    }
   
}
    
