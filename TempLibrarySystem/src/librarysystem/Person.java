/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

/**
 *
 * @author Yihe Wang
 */
public abstract class Person {
    protected int ID;
    protected String firstName;
    protected String lastName;
    protected String pawPrint;
    protected String password;
    
    Person(){
        
    }
    
    Person(String pawPrint,int ID,String lastName,String firstName,String password){
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.pawPrint = pawPrint;
    }
    
    public int getID(){
        return ID;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getPawPrint(){
        return pawPrint;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String name){
        this.password = password;
    }
    
    //public abstract void loadDatabase();
    
}
