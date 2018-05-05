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
public class Book {
    
    private int id;
    private String name;
    private String author;
    private String category;
    private double price;
    private int sumNumber;
    private int nowNumber;
    private int historyBorrowTimes;
    private boolean ifReadOnly;
    private String lastBorrowTime;
    private String library;
    
    public Book() {
        
    }
    
    public Book(int id, String name, String author, String category,
            double price, int sumNumber, int nowNumber, int historyBorrowTimes,
            boolean ifReadOnly, String lastBorrowTime, String library) {
        
        this.id = id;
	this.name = name;
	this.author = author;
	this.category = category;
	this.price = price;
	this.sumNumber = sumNumber;
	this.nowNumber = nowNumber;
	this.historyBorrowTimes = historyBorrowTimes;
	this.ifReadOnly = ifReadOnly;
	this.lastBorrowTime = lastBorrowTime;
	this.library = library;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getAuthor(){
        return author;
    }
    
    public void setAuthor(String author){
        this.author = author;
    }
    
    public String getCategory(){
        return category;
    }
    
    public void setCategory(String category){
        this.category = category;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public int getSumNumber(){
        return sumNumber;
    }
    
    public void setSumNumber(int sumNumber){
        this.sumNumber = sumNumber;
    }
    
    public int getNowNumber(){
        return nowNumber;
    }
    
    public void setNowNumber(int nowNumber){
        this.nowNumber = nowNumber;
    }
    
    public int getHistoryBorrowTimes(){
        return historyBorrowTimes;
    }
    
    public void setHistoryBorrowTimes(int historyBorrowTimes){
        this.historyBorrowTimes = historyBorrowTimes;
    }
    
    public boolean getIfReadOnly(){
        return ifReadOnly;
    }
    
    public void setIfReadOnly(boolean ifReadOnly){
        this.ifReadOnly = ifReadOnly;
    }
    
    public String getLastBorrowTime(){
        return lastBorrowTime;
    }
    
    public void setLastBorrowTime(String lastBorrowTime){
        this.lastBorrowTime = lastBorrowTime;
    }
    
    public String getLibrary(){
        return library;
    }
    
    public void setLibrary(String library){
        this.library = library;
    }
}
