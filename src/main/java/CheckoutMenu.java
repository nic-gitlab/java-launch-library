import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CheckoutMenu {
 private List<Book> books;

// this is the constructor
 CheckoutMenu(List<Book> books) {
   this.books = books;
 }

 public Book promptUntilDone(){
   System.out.println("Check out a new book...\n");

   System.out.println(this.toString());
   Book selectedBook = null;
   do{
     System.out.println("What book would you like to check out?");
     Scanner scanner = new Scanner(System.in);
     try{
     selectedBook = this.books.get(scanner.nextInt());
     this.books.remove(selectedBook);
     }
     catch(IndexOutOfBoundsException exception) {
       System.out.println("Please select a valid book number:");
     }
     catch(InputMismatchException exception) {
       System.out.println("Please enter a number: ");
     }
   } while(selectedBook == null);
   System.out.println("You checked out " + selectedBook.toString());
   System.out.println("Books remaining in Library: ");
   System.out.println(this.toString());
   return selectedBook;
 }
 public String toString() {
   String bookOutput = "";
   for(int i = 0 ; i < this.books.size(); i++) {
     bookOutput += i + ". " + this.books.get(i).toString() + "\n";
   }
  return bookOutput;
 }
}
