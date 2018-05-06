/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLFiles;

import librarysystem.*;
import java.sql.*;
/**
 *
 * @author Yihe Wang
 */

//This class will run just one time by running file
//to create the SQLite database embedded into the project file
public class SQLiteCreateTable {
    public static void main( String args[] ){
    Connection conn = null;
    Statement stmt = null;
    
    try {
      Class.forName("org.sqlite.JDBC");
      conn = DriverManager.getConnection("jdbc:sqlite:Final.db");
      System.out.println("Opened database successfully");

      stmt = conn.createStatement();
      String sql = "CREATE TABLE KeepPawPrint (" +
                   " pawPrint varchar(25) NOT NULL );";
      stmt.executeUpdate(sql);
      stmt.close();
      conn.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Table KeepPawPrint created successfully");
    
    try {
      Class.forName("org.sqlite.JDBC");
      conn = DriverManager.getConnection("jdbc:sqlite:Final.db");
      System.out.println("Opened database successfully");

      stmt = conn.createStatement();
      String sql = "CREATE TABLE Librarian (" +
                   " pawPrint varchar(25) NOT NULL," +
                   " lastName varchar(50) NOT NULL, " + 
                   " firstName varchar(50) NOT NULL, " + 
                   " password varchar(50) NOT NULL );";
      stmt.executeUpdate(sql);
      stmt.close();
      conn.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Table Librarian created successfully");
    
    try {
      Class.forName("org.sqlite.JDBC");
      conn = DriverManager.getConnection("jdbc:sqlite:Final.db");
      System.out.println("Opened database successfully");

      stmt = conn.createStatement();
      String sql = "CREATE TABLE Student (" +
                   " pawPrint varchar(25) NOT NULL," +
                   " studentID int(15) NOT NULL, " + 
                   " lastName varchar(50) NOT NULL, " + 
                   " firstName varchar(50) NOT NULL, " + 
                   " password varchar(50) NOT NULL, " + 
                   " historyBorrowNumber int NOT NULL, " + 
                   " lastBorrowTime varchar(50) NOT NULL, " + 
                   " holdNum int NOT NULL );"; 
      stmt.executeUpdate(sql);
      stmt.close();
      conn.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Table Student created successfully");
    
    try {
      Class.forName("org.sqlite.JDBC");
      conn = DriverManager.getConnection("jdbc:sqlite:Final.db");
      System.out.println("Opened database successfully");

      stmt = conn.createStatement();
      String sql = "CREATE TABLE StudentHoldBook (" +
                   " pawPrint varchar(25) NOT NULL," +
                   " holdNum int NOT NULL, " + 
                   " book1 varchar(50), " + 
                   " book2 varchar(50), " + 
                   " book3 varchar(50), " + 
                   " book4 varchar(50), " + 
                   " book5 varchar(50), " + 
                   " book6 varchar(50), " +
                   " book7 varchar(50), " +
                   " book8 varchar(50), " +
                   " book9 varchar(50), " +
                   " book10 varchar(50) );";
      stmt.executeUpdate(sql);
      stmt.close();
      conn.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Table StudentHoldBook created successfully");
    
    
    try {
      Class.forName("org.sqlite.JDBC");
      conn = DriverManager.getConnection("jdbc:sqlite:Final.db");
      System.out.println("Opened database successfully");

      stmt = conn.createStatement();
      String sql = "CREATE TABLE BooksInfo (" +
                   " id INTEGER PRIMARY KEY NOT NULL," +
                   " name varchar(50) NOT NULL, " + 
                   " author varchar(50) NOT NULL, " + 
                   " category varchar(50) NOT NULL, " + 
                   " price double, " + 
                   " sumNumber int NOT NULL, " + 
                   " nowNumber int NOT NULL, " +
                   " historyBorrowTimes int NOT NULL, " +
                   " ifReadOnly tinyint(1) NOT NULL, " +
                   " lastBorrowTime varchar(50) NOT NULL, " +
                   " library varchar(50) NOT NULL );";
      stmt.executeUpdate(sql);
      stmt.close();
      conn.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Table BooksInfo created successfully");
    
    /*
    try {
      Class.forName("org.sqlite.JDBC");
      conn = DriverManager.getConnection("jdbc:sqlite:Final.db");
      System.out.println("Opened database successfully");

      stmt = conn.createStatement();
      String sql = "CREATE TABLE KeepPawPrint (" +
                   " pawPrint varchar(25) NOT NULL );";
      stmt.executeUpdate(sql);
      stmt.close();
      conn.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Table KeepPawPrint created successfully");*/
       
  }
}
