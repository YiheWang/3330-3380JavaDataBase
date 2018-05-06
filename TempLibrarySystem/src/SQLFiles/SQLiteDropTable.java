/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLFiles;

import librarysystem.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Yihe Wang
 */
//this file used to drop the whole tables when we find something wrong of our table
//do not use run this file in comman case
public class SQLiteDropTable {
    public static void main( String args[] ){
    Connection c = null;
    Statement stmt = null;
    try {
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:Final.db");
        c.setAutoCommit(false);
        System.out.println("Opened database successfully");

        stmt = c.createStatement();
        String sql1 = "DROP TABLE Student;" ;
        stmt.executeUpdate(sql1);
        
        String sql2 = "DROP TABLE StudentHoldBook;";
        stmt.executeUpdate(sql2);
        
        String sql3 = "DROP TABLE Librarian;" ;
        stmt.executeUpdate(sql3);
        
        String sql4 = "DROP TABLE BooksInfo;" ;
        stmt.executeUpdate(sql4);
        
        String sql5 = "DROP TABLE KeepPawPrint;" ;
        stmt.executeUpdate(sql5);

        stmt.close();
        c.commit();
        c.close();
        } catch ( Exception e ) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
        }
        System.out.println("Table droped successfully");
  }
}
