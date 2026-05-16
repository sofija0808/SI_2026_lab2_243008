Sofija Stojanovska 243008


2.

3. 
addBook(Book book): Predicate Nodes = 0; Cyclomatic complexity = 0 + 1 = 1

searchBookByTitle(String title): Predicate Nodes = 5 (if; for; if-&&-1; if-&&-2; if); Cyclomatic complexity = 5 + 1 = 6

borrowBook(String title, String author): Predicate Nodes = 6 (if-||-1; if-||-2; for; if-&&-1; if-&&-2; if); Cyclomatic complexity = 6 + 1 = 7

returnBook(String title): Predicate Nodes = 4 (if; for; if; if); Cyclomatic complexity = 4 + 1 = 5

printBooksByGenre(String genre): Predicate Nodes = 2 (for; if); Cyclomatic complexity = 2 + 1 = 3

countBooksByGenre(String genre): Predicate Nodes = 2 (for; if); Cyclomatic complexity = 2 + 1 = 3

countAvailableBooks(): Predicate Nodes = 2 (for; if); Cyclomatic complexity = 2 + 1 = 3

printBorrowedBooks(): Predicate Nodes = 2 (for; if); Cyclomatic complexity = 2 + 1 = 3



5.
Every Statement критериум за searchBookByTitle тука минималниот број на тест случаеви е 3

Тест случај 1  
library.searchBookByTitle("");
Тестираме со празна линија за да се прикаже IllegalArgumentException

Тест случај 2
library.searchBookByTitle("The Brothers Karamazov");
Сега тестираме со книга која не постои во листата и листата ќе остане празна и функцијата ќе врати null

Тест случај 3
library.searchBookByTitle("Crime and Punishment");
За крај книгата постои и не е позајмена, се додава во листата и функцијата ја враќа на крај листата


8.Every Branch критериум за borrowBook тука минималниот број на тест случаи е 4

Тест случај 1 — Invalid input
library.borrowBook("", "");
Branch title.isEmpty() || author.isEmpty() = true и поради ова функцијата фрла IllegalArgumentException

Тест случај 2 — Successful borrow
library.borrowBook("The Idiot", "Fyodor Dostoevsky");
Branch во овој случај имаме валиден input, книгата е пронајдена и книгата не е позајмена

Тест случај 3 — Already borrowed
library.borrowBook("The Idiot", "Fyodor Dostoevsky");
Branch тука имаме книга која е веќе позајмена и фрла RuntimeException

Тест случај 4 — Book not found
library.borrowBook("Demons", "Fyodor Dostoevsky");
Branch имаме книга која не постои и фрла RuntimeException("Book not found")

Тест случај 5 — author.isEmpty() е true
library.borrowBook("The Idiot", "");
Branch во овој случај имаме валидно има на книга но го немаме авторот и фрла IllegalArgumentException



10. Multiple Condition критериум имаме комбинации на условот if (title.isEmpty() || author.isEmpty()) и добиваме дека минималниот број на тест случаи е 4 во borrowBook
A = title.isEmpty()
B = author.isEmpty()

Tест случај 1
A=true, B=true
Добиваме IllegalArgumentException

Tест случај 2
A=true, B=false
Добиваме IllegalArgumentException

Tест случај 3
A=false, B=true
Добиваме IllegalArgumentException

Tест случај 4
A=false, B=false 
Добиваме дека Книгата успешно се позајмува


TT
TF
FT
FF

Усов пак во searchBookByTitle е if (book.getTitle().equalsIgnoreCase(title) && !book.isBorrowed()) и тука најмалку ни се потребни 4 тест случаи 

A = book.getTitle().equalsIgnoreCase(title)
B = !book.isBorrowed()

Тест случај 1
A=true, B=true
На излез имаме листа со 1 елемент

Тест случај 2
A=true, B=false
Добиваме null односно книгата нема да се додаде бидејќи B=false

Тест случај 3
A=false, B=true
Добиваме null односно книгата нема да се додаде бидејќи A=false

Тест случај 4
A=false, B=false
книгата нема да се додаде



