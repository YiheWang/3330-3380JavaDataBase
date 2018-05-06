/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class StudentHoldBook {
    private String pawPrint;
    private int holdNum;
    ArrayList<String> borrowBookList;
    
    public StudentHoldBook() {
        
    }
    
    public StudentHoldBook(String pawPrint,int holdNum,String book1,String book2,
            String book3,String book4,String book5,
            String book6,String book7,String book8,String book9,String book10) {
        
        borrowBookList = new ArrayList<>();
        this.pawPrint = pawPrint;
        this.holdNum = holdNum;
        borrowBookList.add(book1);
        borrowBookList.add(book2);
        borrowBookList.add(book3);
        borrowBookList.add(book4);
        borrowBookList.add(book5);
        borrowBookList.add(book6);
        borrowBookList.add(book7);
        borrowBookList.add(book8);
        borrowBookList.add(book9);
        borrowBookList.add(book10);
        
    }
    
    public void deleteBookInList(String bookName){
        for(int i = 0 ; i < (int)borrowBookList.size(); ++i){  
            if(borrowBookList.get(i).equals(bookName)){  
                System.out.println(borrowBookList.get(i));
                borrowBookList.remove(i);
                //borrowBookList.add(null);
                return;
            }  
        } 
    }
    
    public String getPawPrint(){
        return pawPrint;
    }
    
    public int getHoldNum(){
        return holdNum;
    }
    
    public int getSize(){
        return borrowBookList.size();
    }
    
    public String getBook(int index){
        return borrowBookList.get(index - 1);
    }
    
}