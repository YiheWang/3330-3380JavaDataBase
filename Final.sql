

DROP TABLE Student;
DROP TABLE StudentHoldBook;
DROP TABLE Librarian;
DROP TABLE BooksInfo;




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

INSERT INTO Student
VALUES ('ywm46','14283603','Wang','Yihe','31415926aaaa', 122,'2018-3-27-10:35PM',4);

INSERT INTO Student
VALUES ('ylmq3', '14281607','31415926aaaa', 'Liu','Yinda', 23, '2018-5-13-4:20PM', 5);

INSERT INTO Student VALUES
('ywm46','14283603','Wang','Yihe','31415926aaaa', 122,'2018-3-27-10:35PM',4),
('ylmq3','14281607','Liu','Yinda','31415926aaaa', 23, '2018-5-13-4:20PM', 5);


SELECT password,pawPrint FROM Student WHERE pawPrint = 'ywm46';

SELECT holdNum FROM Student WHERE pawPrint = 'ywm46';
UPDATE Student SET holdNum = 5 WHERE pawPrint = 'ywm46';







CREATE TABLE TempStudent (
	pawPrint varchar(50) NOT NULL
);

INSERT INTO TempStudent VALUES
('ywm46');

DELETE FROM TempStudent;


CREATE TABLE StudentHoldBook (
	pawPrint varchar(50) NOT NULL,
	holdNum int NOT NULL,
	book1 varchar(50),
	book2 varchar(50),
	book3 varchar(50),
	book4 varchar(50),
	book5 varchar(50),
	book6 varchar(50),
	book7 varchar(50),
	book8 varchar(50),
	book9 varchar(50),
	book10 varchar(50)
);

INSERT INTO StudentHoldBook VALUES
('ywm46', 4, 'Pride and Prejudice','To Kill A Mockingbird','Harry Potter and the Philosopher’s Stone','A Certain Magic Index',NULL,NULL,NULL,NULL,NULL,NULL),
('ylmq3', 5, 'Around the World in Eighty Days','The Old Man and The Sea','University Physics1','A Certain Magic Index','The Hobbit',NULL,NULL,NULL,NULL,NULL);

UPDATE StudentHoldBook SET holdNum = 5 WHERE pawPrint = 'ywm46';
UPDATE StudentHoldBook SET book5 = 'Dragon Raja 3' WHERE pawPrint = 'ywm46';








CREATE TABLE Librarian (
	pawPrint varchar(25) NOT NULL,
	lastName varchar(50) NOT NULL,
	firstName varchar(50) NOT NULL,
	password varchar(50) NOT NULL
);

INSERT INTO Librarian
VALUES ('yz8pd','Zhao', 'Yi','31415926ssss');

INSERT INTO Librarian
VALUES ('xl2mb','Deng','Tianyuan','31415926ssss');

INSERT INTO Librarian VALUES
('yz8pd','Zhao', 'Yi','31415926ssss'),
('xl2mb','Deng','Tianyuan','31415926ssss');




//for sqlite
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





//for mysql
CREATE TABLE BooksInfo (
	id int NOT NULL auto_increment primary key,
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

SELECT nowNumber FROM BooksInfo WHERE name = 'Dragon Raja 3';
UPDATE BooksInfo SET nowNumber = 4



INSERT INTO BooksInfo (name,author, category,price, sumNumber, nowNumber, historyBorrowTimes, ifReadOnly, lastBorrowTime, library)
VALUES ('A Certain Magic Index', 'Kazuma Kamachi', 'Light Novel', 15.99, 10, 5, 200, 0, '2018-4-17-11:20AM', 'Ellise Library'); 

INSERT INTO BooksInfo (name,author, category,price, sumNumber, nowNumber, historyBorrowTimes, ifReadOnly, lastBorrowTime, library)
VALUES ('Around the World in Eighty Days', 'Jules Gabriel Verne', 'Adventure Novel', 20, 2, 0, 21, 0, '2018-4-6-3:48PM', 'Ellise Library');

INSERT INTO BooksInfo (name,author, category,price, sumNumber, nowNumber, historyBorrowTimes, ifReadOnly, lastBorrowTime, library)
VALUES ('To Kill A Mockingbird', 'Harper Lee', 'Bildungsroman', 10, 10, 7, 189, 0, '2018-3-12-09:45AM', 'Ellise Library');

INSERT INTO BooksInfo (name,author, category,price, sumNumber, nowNumber, historyBorrowTimes, ifReadOnly, lastBorrowTime, library)
VALUES ('The Hobbit', 'J.R.R.Tolkien', 'Novel', 17, 13, 5, 234, 0, '2018-2-11-12:57PM', 'Ellis-Library');

INSERT INTO BooksInfo (name,author, category,price, sumNumber, nowNumber, historyBorrowTimes, ifReadOnly, lastBorrowTime, library)
VALUES ('Pride-and-Prejudice', 'Jane-Austen', 'Bildungsroman', 15, 20, 11, 323, 0, '2018-4-1-11:04AM', 'Ellis Library');

INSERT INTO BooksInfo (name,author, category,price, sumNumber, nowNumber, historyBorrowTimes, ifReadOnly, lastBorrowTime, library)
VALUES ('Harry Potter and the Philosopher’s Stone', 'J.K. Rowling', 'Magic Novel', 30, 32, 25, 451, 0, '2018-4-15-9:44AM', 'Ellise-Library');

INSERT INTO BooksInfo (name,author, category, price, sumNumber, nowNumber, historyBorrowTimes, ifReadOnly, lastBorrowTime, library)
VALUES ('Dragon Raja 1', 'Jiang Nan', 'Novel', 18, 20, 13, 123, 0, '2018-3-16-10:30PM', 'Ellise-Library');

INSERT INTO BooksInfo (name,author, category, price, sumNumber, nowNumber, historyBorrowTimes, ifReadOnly, lastBorrowTime, library)
VALUES ('Dragon Raja 2', 'Jiang Nan', 'Novel', 19, 20, 18, 110, 0, '2018-2-19-11:12PM', 'Ellise-Library');

INSERT INTO BooksInfo (name,author, category, price, sumNumber, nowNumber, historyBorrowTimes, ifReadOnly, lastBorrowTime, library)
VALUES ('Dragon Raja 3', 'Jiang Nan', 'Novel', 23, 20, 10, 181, 0, '2018-4-20-9:42PM', 'Ellise Library');

INSERT INTO BooksInfo (name,author, category, price, sumNumber, nowNumber, historyBorrowTimes, ifReadOnly, lastBorrowTime, library)
VALUES ('1984', 'George Orwell', 'War', 18, 34, 28, 178, 0, '2017-12-24-11:32AM', 'Ellise Library');

INSERT INTO BooksInfo (name,author, category, price, sumNumber, nowNumber, historyBorrowTimes, ifReadOnly, lastBorrowTime, library)
VALUES ('The-Adventure-of-Sherlock-Holmes', 'Arthur-Conan-Doyle', 'Adventure', 15, 10, 5, 120, 0, '2018-3-13-8:11AM', 'Ellise Library');

INSERT INTO BooksInfo (name,author, category, price, sumNumber, nowNumber, historyBorrowTimes, ifReadOnly, lastBorrowTime, library)
VALUES ('The-Old-Man-and-The-Sea', 'Ernest-Miller-Hemingway', 'Novel', 10, 20, 13, 123, 0, '2018-1-23-15:21PM', 'Ellise Library');

INSERT INTO BooksInfo (name,author, category,price, sumNumber, nowNumber, historyBorrowTimes, ifReadOnly, lastBorrowTime, library)
VALUES ('Beneath a Scarlet Sky: A Novel', 'Mark T. Sullivan', 'Literary', 15.99, 2, 1, 4, 0, '2018-3-27-2:15PM', 'Ellise Library'); 

INSERT INTO BooksInfo (name,author, category,price, sumNumber, nowNumber, historyBorrowTimes, ifReadOnly, lastBorrowTime, library)
VALUES ('Macbeth', 'Jo Nesbo', 'Literary', 17.70, 1, 1, 3, 0, '2018-4-16-3:40PM', 'Ellise Library'); 

INSERT INTO BooksInfo (name,author, category,price, sumNumber, nowNumber, historyBorrowTimes, ifReadOnly, lastBorrowTime, library)
VALUES ('To Kill a Mockingbird', 'Harper Lee', 'Thrillers', 20.57, 3, 0, 8, 0, '2018-4-17-10:30AM', 'Ellise Library'); 

INSERT INTO BooksInfo (name,author, category,price, sumNumber, nowNumber, historyBorrowTimes, ifReadOnly, lastBorrowTime, library)
VALUES ('The Immortalists', 'Chloe Benjamin', 'Literary', 18.20, 4, 2, 6, 0, '2018-4-16-11:15AM', 'Ellise Library'); 

INSERT INTO BooksInfo (name,author, category,price, sumNumber, nowNumber, historyBorrowTimes, ifReadOnly, lastBorrowTime, library)
VALUES ('In the Absence of the Sun', 'Emily Curtis', 'Poetry', 6.99, 1, 0, 3, 0, '2018-4-15-5:00PM', 'Ellise Library'); 

INSERT INTO BooksInfo (name,author, category,price, sumNumber, nowNumber, historyBorrowTimes, ifReadOnly, lastBorrowTime, library)
VALUES ('The Punishment She Deserves: A Lynley Novel', 'Elizabeth George', 'Mystery', 16.69, 3, 0, 10, 0, '2018-4-16-6:20PM', 'Ellise Library'); 

INSERT INTO BooksInfo (name,author, category,price, sumNumber, nowNumber, historyBorrowTimes, ifReadOnly, lastBorrowTime, library)
VALUES ('Red Rising', 'Pierce Brown', 'Science', 17.79, 2, 0, 9, 0, '2018-4-10-1:30PM', 'Ellise Library');

INSERT INTO BooksInfo (name,author, category,price, sumNumber, nowNumber, historyBorrowTimes, ifReadOnly, lastBorrowTime, library)
VALUES ('Night', 'Elie Wiesel', 'History', 12.23, 5, 3, 60, 0, '2018-4-5-10:00PM', 'Ellise Library');

INSERT INTO BooksInfo (name,author, category,price, sumNumber, nowNumber, historyBorrowTimes, ifReadOnly, lastBorrowTime, library)
VALUES ('Grant', 'Ron Chernow', 'History', 22.96, 5, 4, 54, 0, '2018-4-7-11:30PM', 'Ellise Library');

INSERT INTO BooksInfo (name,author, category,price, sumNumber, nowNumber, historyBorrowTimes, ifReadOnly, lastBorrowTime, library)
VALUES ('Me Talk Pretty One Day', 'David Sedaris', 'Correspondence', 15.39, 3, 1, 63, 0, '2018-4-13-9:45AM', 'Ellise Library');

INSERT INTO BooksInfo (name,author, category,price, sumNumber, nowNumber, historyBorrowTimes, ifReadOnly, lastBorrowTime, library)
VALUES ('Introduction To C++', 'Dong Xu', 'Programming', 40, 2, 1, 15, 0, '2018-4-12-10:30AM', 'Engineering Library');

INSERT INTO BooksInfo (name,author, category,price, sumNumber, nowNumber, historyBorrowTimes, ifReadOnly, lastBorrowTime, library)
VALUES ('University Physics1', 'Yihe Wang', 'Physics', 50, 3, 0, 0, 1, ' 2018-1-2-10:32AM', 'Engineering Library');







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


























