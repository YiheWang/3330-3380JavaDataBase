# 3330-3380JavaDataBase
Final Project for CS3330&CS3380 in University of Missouri
A student library system


Description of library manage system
This application create a library manage system.
Students can search books from the database to check if there are enough copies in the library. 
Then students can borrow books and return them. The system can record the number of books borrowed by a student. If a book is borrowed
the database will refresh and record. The system can show how many books this student borrowed and the books' names.
And the student’s status will refresh after Borrow and Return.
In this project, we need to meet the requirement following: 
Classes, subclasses, try exception, abstract class, at least one interface, multiple sceene, model view controller, and load file or database.


Group Member
================
Yihe Wang  14283603 ywm46   

Tianyuan Deng 14252517 td337

Boao Huang 14279968 bhgc9

Yinda Liu 14281607 ylmq3

Yi Zhao 14304750 yz8pd

Xiaowei Liu 14222423 xl2mb


Technology Stack
================

Language: JavaFXML
database: SQLite

SystemOperation
================
log in account: ywm46, 31415926aaaa

ylmq3, 31415926aaaa
		
you can check the file SQLiteInsertData.java   to check the insert information


Table
================
Student 
----------------
CREATE TABLE Student (
  pawPrint varchar(25) NOT NULL,
  studentID int(15) NOT NULL,
  lastName varchar(50) NOT NULL,
  firstName varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  historyBorrowNumber int NOT NULL,
  lastBorrowTime varchar(50) NOT NULL,
  holdNum int NOT NULL
);

INSERT INTO Student VALUES
('ywm46','14283603','Wang','Yihe','31415926aaaa', 122,'2018-3-27-10:35PM',4),
('ylmq3','14281607','Liu','Yinda','31415926aaaa', 23, '2018-5-13-4:20PM', 5);

KeepPawPrint
---------------------
CREATE TABLE KeepPawprint (
	pawPrint varchar(50) NOT NULL
);

INSERT INTO KeepPawPrint VALUES
('ywm46');

DELETE FROM TempStudent;


Librarian
-----------------------
CREATE TABLE Librarian (
	pawPrint varchar(25) NOT NULL,
	lastName varchar(50) NOT NULL,
	firstName varchar(50) NOT NULL,
	password varchar(50) NOT NULL
);

INSERT INTO Librarian VALUES
('yz8pd','Zhao', 'Yi','31415926ssss'),
('xl2mb','Deng','Tianyuan','31415926ssss');


BooksInfo
-------------------------

CREATE TABLE BooksInfo (
	id INTEGER PRIMARY KEY NOT NULL,
	name varchar(50) NOT NULL,
	author varchar(50) NOT NULL,
	category varchar(50) NOT NULL,
	price double,
	sumNumber int NOT NULL,
	nowNumber int NOT NULL,
	historyBorrowTimes int NOT NULL,
	ifReadOnly tinyint(1) NOT NULL,
	lastBorrowTime varchar(50) NOT NULL,
	library varchar(50) NOT NULL
);

INSERT INTO BooksInfo (name,author, category,price, sumNumber, nowNumber, historyBorrowTimes, ifReadOnly, lastBorrowTime, library) VALUES 

('A Certain Magic Index', 'Kazuma Kamachi', 'Light Novel', 15.99, 10, 5, 200, 0, '2018-4-17-11:20AM', 'Ellise Library'),

('Around the World in Eighty Days', 'Jules Gabriel Verne', 'Adventure Novel', 20, 2, 0, 21, 0, '2018-4-6-3:48PM', 'Ellise Library'),

('To Kill A Mockingbird', 'Harper Lee', 'Bildungsroman', 10, 10, 7, 189, 0, '2018-3-12-09:45AM', 'Ellise Library'),

('The Hobbit', 'J.R.R.Tolkien', 'Novel', 17, 13, 5, 234, 0, '2018-2-11-12:57PM', 'Ellis-Library'),

('Pride and Prejudice', 'Jane Austen', 'Bildungsroman', 15, 20, 11, 323, 0, '2018-4-1-11:04AM', 'Ellis Library'),

('Harry Potter and the Philosopher’s Stone', 'J.K. Rowling', 'Magic Novel', 30, 32, 25, 451, 0, '2018-4-15-9:44AM', 'Ellise-Library'),

('Dragon Raja 1', 'Jiang Nan', 'Novel', 18, 20, 13, 123, 0, '2018-3-16-10:30PM', 'Ellise-Library'),

('Dragon Raja 2', 'Jiang Nan', 'Novel', 19, 20, 18, 110, 0, '2018-2-19-11:12PM', 'Ellise-Library'),

('Dragon Raja 3', 'Jiang Nan', 'Novel', 23, 20, 10, 181, 0, '2018-4-20-9:42PM', 'Ellise Library'),

('1984', 'George Orwell', 'War', 18, 34, 28, 178, 0, '2017-12-24-11:32AM', 'Ellise Library'),

('The Adventure of Sherlock Holmes', 'Arthur Conan Doyle', 'Detective Novel', 15, 10, 5, 120, 0, '2018-3-13-8:11AM', 'Ellise Library'),

('The Old Man and The Sea', 'Ernest Miller Hemingway', 'Novel', 10, 20, 13, 123, 0, '2018-1-23-15:21PM', 'Ellise Library'),

('Beneath a Scarlet Sky: A Novel', 'Mark T. Sullivan', 'Literary', 15.99, 2, 1, 4, 0, '2018-3-27-2:15PM', 'Ellise Library'), 

('Macbeth', 'Jo Nesbo', 'Literary', 17.70, 1, 1, 3, 0, '2018-4-16-3:40PM', 'Ellise Library'), 

('To Kill a Mockingbird', 'Harper Lee', 'Thrillers', 20.57, 3, 0, 8, 0, '2018-4-17-10:30AM', 'Ellise Library'),

('The Immortalists', 'Chloe Benjamin', 'Literary', 18.20, 4, 2, 6, 0, '2018-4-16-11:15AM', 'Ellise Library'), 

('In the Absence of the Sun', 'Emily Curtis', 'Poetry', 6.99, 1, 0, 3, 0, '2018-4-15-5:00PM', 'Ellise Library'),

('The Punishment She Deserves: A Lynley Novel', 'Elizabeth George', 'Mystery', 16.69, 3, 0, 10, 0, '2018-4-16-6:20PM', 'Ellise Library'), 

('Red Rising', 'Pierce Brown', 'Science', 17.79, 2, 0, 9, 0, '2018-4-10-1:30PM', 'Ellise Library'),

('Night', 'Elie Wiesel', 'History', 12.23, 5, 3, 60, 0, '2018-4-5-10:00PM', 'Ellise Library'),

('Grant', 'Ron Chernow', 'History', 22.96, 5, 4, 54, 0, '2018-4-7-11:30PM', 'Ellise Library'),

('Me Talk Pretty One Day', 'David Sedaris', 'Correspondence', 15.39, 3, 1, 63, 0, '2018-4-13-9:45AM', 'Ellise Library'),

('Introduction To C++', 'Dong Xu', 'Programming', 40, 2, 1, 15, 0, '2018-4-12-10:30AM', 'Engineering Library'),

('University Physics1', 'Yihe Wang', 'Physics', 50, 3, 0, 0, 1, ' 2018-1-2-10:32AM', 'Engineering Library');


CRUD
=====================

Create :
	create table student() //create a student’s information into the database 
	create able StudentHoldBook() // record books that a student held 
        They are all in SQLiteCreateTable file so You only need to run the file one time
Read :
	selectAndSetInfo()// get the students’ information.

Update :
	deleteBookList()
	students’ information will be updated after they borrow or return books. The number of 			the books they held will increase or decrease.

Delete :
	removePawPrint() // when a student log out, the system delete the table of this student.
       
       
       

Logic Diagram of this library system
====================================
https://github.com/YiheWang/3330-3380JavaDataBase/blob/Modified/WeChat%20Image_20180505011319.jpg


Youtube url:
https://youtu.be/FE10S9CBgeY

