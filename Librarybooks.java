import java.util.Scanner;

public class Librarybooks {
    static final int MAX_BOOKS = 100;
    Book[] books;
    int numBooks;

    public class Book {
        String title;
        String authorname;
        boolean available;

        void initializeBook(String title, String authorname) {
            this.title = title;
            this.authorname = authorname;
            this.available = true;
        }
    }

    Librarybooks() {
        books = new Book[MAX_BOOKS];
        numBooks = 0;
    }

    void displayBooks() {
        System.out.println("Library Books:");
        for (Book book : books) {
            if (book != null) {
                System.out.println(book.title + " by " + book.authorname);
            }
        }
    }

    void borrowBook(String title) {
        for (Book book : books) {
            if (book != null && book.title.equalsIgnoreCase(title) && book.available) {
                book.available = false;
                System.out.println("You have borrowed: " + book.title);
                return;
            }
        }
        System.out.println("not available!!");
    }

    void returnBook(String title) {
        for (Book book : books) {
            if (book != null && book.title.equalsIgnoreCase(title) && !book.available) {
                book.available = true;
                System.out.println("You have returned: " + book.title);
                return;
            }
        }
        System.out.println("Error!!");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Librarybooks librarybooks = new Librarybooks();

        char choice;
        do {
            System.out.println("\nLibrary Menu");
            System.out.println("1. Display all books");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int menuChoice = scanner.nextInt();
            scanner.nextLine(); 

            switch (menuChoice) {
                case 1:
                    librarybooks.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter the title of the book you want to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    librarybooks.borrowBook(borrowTitle);
                    break;
                case 3:
                    System.out.print("Enter the title of the book you want to return: ");
                    String returnTitle = scanner.nextLine();
                    librarybooks.returnBook(returnTitle);
                    break;
                case 4:
                    System.out.println("Thank you for using the Library.");
                    break;
                }

            System.out.print("Do you want to borrow another book? Enter Y/N: ");
            choice = scanner.next().charAt(0);

        } while (Character.toUpperCase(choice) == 'Y');


        scanner.close();
    }
}

