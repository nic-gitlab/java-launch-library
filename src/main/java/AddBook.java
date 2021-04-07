import java.util.List;
import java.util.Scanner;

public class AddBook {

  private final List<Book> books;

  // this is the constructor
  AddBook(List<Book> books) {
    this.books = books;
  }

 public void addANewBook() {
   Scanner scanner;
   Book newBook = null;
   do {
     System.out.println("Thanks for choosing to donate a book!\n" +
         "Please enter the title of the book you're donating");
     scanner = new Scanner(System.in);
     try {
       newBook = new Book(scanner.nextLine());
       this.books.add(newBook);
     } catch (Exception e) {
       e.printStackTrace();
     }
     if(scanner.nextLine().equals("")){
       this.addANewBook();
     }
   } while(newBook == null);
   System.out.println("Thanks! You donated: " + newBook.toString());
   System.out.println("Available books now include" + books.toString()+"\n");
 }
}
