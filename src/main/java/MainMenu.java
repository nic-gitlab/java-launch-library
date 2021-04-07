import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
  public static final String ADD_BOOK_TEXT = "Contribute a book";
  public static final String CHECKOUT_TEXT = "Check out a book";
  public static final String RETURN_BOOK_TEXT = "Return a book";
  public static final String QUIT_TEXT = "Quit";

  public enum MenuOption {
    a(ADD_BOOK_TEXT),
    c(CHECKOUT_TEXT),
    r(RETURN_BOOK_TEXT),
    q(QUIT_TEXT);

    private String optionText;

    MenuOption(String optionText){
      this.optionText = optionText;

    }

    public String toString() {
      return this.name() + ") " + this.optionText + "\n";
    }
  }

  public String toString() {
    String output = "MAIN MENU\n\n";
    for(MenuOption option : MenuOption.values()) {
      output += option.toString();
    }
    return output;
  }

  public static List<Book> getInitialBooksFromLibrary() {
    List<Book> books;
    books = new ArrayList<>();
    books.add(new Book("R for Data Science"));
    books.add(new Book("Data Science for Business"));
    return books;
  }

  public static void promptUntilQuit() {
//    welcome the user to the library
    System.out.println("Welcome to the library!");
//    list out their menu options
    MainMenu menu = new MainMenu();

    List<Book> booksInLibrary = MainMenu.getInitialBooksFromLibrary();
/*
        prompt the user to make a selection
        check for bad input -
        if they don't make a valid selection prompt them to make another selection
    */
    MenuOption selectedOption = null;
    do {
      System.out.println(menu.toString());
      System.out.println("Choose an option: ");
      Scanner scanner = new Scanner(System.in);
      try{
      selectedOption = MenuOption.valueOf(scanner.next());
      }
      catch(IllegalArgumentException exception){
        System.out.println("\nNot a valid menu option, please try again: \n");
      }
      if(selectedOption == MenuOption.c) {
        CheckoutMenu checkoutMenu = new CheckoutMenu(booksInLibrary);
        checkoutMenu.promptUntilDone();
      }
      if(selectedOption == MenuOption.a) {
        AddBook addBook;
        addBook = new AddBook(booksInLibrary);
        addBook.addANewBook();
      }
    } while (selectedOption != MenuOption.q);

    System.out.println("Thanks for stopping by!");
  }
}
