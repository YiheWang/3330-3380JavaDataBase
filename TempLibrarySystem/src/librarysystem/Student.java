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
public class Student extends Person {

    private int historyBorrowNumber;
    private String lastBorrowTime;
    private int holdNum;
    
    Student(String pawPrint,int ID, String lastName,String firstName, String password, 
    int historyBorrowNumber, String lastBorrowTime, int holdNum){
        super(pawPrint,ID,lastName,firstName,password);
        this.historyBorrowNumber = historyBorrowNumber;
        this.lastBorrowTime = lastBorrowTime;
        this.holdNum = holdNum;
    }
    
    public int getHistoryBorrowNumber(){
        return historyBorrowNumber;
    }
    
    public void setHistoryBorrowNumber(int historyBorrowNumber){
        this.historyBorrowNumber = historyBorrowNumber;
    }
    
    public String getLastBorrowTime(){
        return lastBorrowTime;
    }
    
    public void setLastBorrowTime(String lastBorrowTime){
        this.lastBorrowTime = lastBorrowTime;
    }
    
    public int getHoldNumber(){
        return holdNum;
    }
    
    public void setHoldNumber(int holdNumber){
        this.holdNum = holdNum;
    }
    
}
