import java.util.Scanner;

interface LibraryOperations {
    void libOp();
}

class SectionA implements LibraryOperations {
    static final int MaxBooks = 100;
    LibrarySystem.Book[] books;
    int numBooks;

    SectionA() {
        books = new LibrarySystem.Book[MaxBooks];
        numBooks = 0;
    }

    @Override
    public void libOp() {
        displayBooksfromA();
    }

    void displayBooksfromA() {
        System.out.println("Library Books:");
        for (LibrarySystem.Book book : books) {
            if (book != null) {
                System.out.println(book.title + " by " + book.author);
            }
        }
    }

    void borrowBookfromA(String title) {
        for (LibrarySystem.Book book : books) {
                if (book != null && book.title.equalsIgnoreCase(title)) {
                    System.out.println("Borrowed " + book.title);
                    return;
                }
            }
        try {
            boolean isStaff = checkStaffStatus();
            if (!isStaff) {
                throw new Exception("Only library staff can approve book borrowing requests.");
            }

            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void returnBooktoA(String title) {
        for (LibrarySystem.Book book : books) {
            if (book != null && book.title.equalsIgnoreCase(title)) {
                System.out.println("You have returned: " + book.title);
                return;
            }
        }
    }

    void addBooktoA(LibrarySystem.Book book) {
        if (numBooks < MaxBooks) {
            books[numBooks++] = book;
            System.out.println("Added.");
        } else {
            System.out.println("Library is full.");
        }
    }

    boolean checkStaffStatus() {
        return false;
    }
}

class SectionB implements LibraryOperations {
    static final int MaxBooks = 100;
    LibrarySystem.Book[] books;
    int numBooks;

    SectionB() {
        books = new LibrarySystem.Book[MaxBooks];
        numBooks = 0;
    }

    @Override
    public void libOp() {
        displayBooksfromB();
    }

    void displayBooksfromB() {
        System.out.println("Library Books:");
        for (LibrarySystem.Book book : books) {
            if (book != null) {
                System.out.println(book.title + " by " + book.author);
            }
        }
    }

    void borrowBookfromB(String title) {
        for (LibrarySystem.Book book : books) {
                if (book != null && book.title.equalsIgnoreCase(title)) {
                    System.out.println("Borrowed " + book.title);
                    return;
                }
            }
        try {
            boolean isStaff = checkStaffStatus();
            if (!isStaff) {
                throw new Exception("Only library staff can approve book borrowing requests.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void returnBooktoB(String title) {
        for (LibrarySystem.Book book : books) {
            if (book != null && book.title.equalsIgnoreCase(title)) {
                System.out.println("You have returned: " + book.title);
                return;
            }
        }
    }

    void addBooktoB(LibrarySystem.Book book) {
        if (numBooks < MaxBooks) {
            books[numBooks++] = book;
            System.out.println("Added.");
        } else {
            System.out.println("Library is full.");
        }
    }

    boolean checkStaffStatus() {
        return false;
    }
}

class LibrarySystem {
    static class Book {
        String title;
        String author;

        void initializeBook(String title, String author) {
            this.title = title;
            this.author = author;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SectionA sectionA = new SectionA();
        SectionB sectionB = new SectionB();

        sectionA.addBooktoA(new LibrarySystem.Book());
        sectionA.books[0].initializeBook("Book1", "Author1");
        sectionA.numBooks++;

        sectionB.addBooktoB(new LibrarySystem.Book());
        sectionB.books[0].initializeBook("Book2", "Author2");
        sectionB.numBooks++;

        char choice;
        do {
            System.out.println("\nLibrary Menu");
            System.out.println("1. Display  A ,2. Display B,3. Borrow  A,4. Borrow B,5. Return  A,6. Return  B");
            int menuChoice = scanner.nextInt();
            scanner.nextLine(); 

            switch (menuChoice) {
                case 1:
                    sectionA.libOp();
                    break;

                case 2:
                    sectionB.libOp();
                    break;

                case 3:
                    System.out.print("A T: ");
                    String borrowTitleA = scanner.nextLine();
                    sectionA.borrowBookfromA(borrowTitleA);
                    break;

                case 4:
                    System.out.print("B T: ");
                    String borrowTitleB = scanner.nextLine();
                    sectionB.borrowBookfromB(borrowTitleB);
                    break;

                case 5:
                    System.out.print("A T: ");
                    String returnTitleA = scanner.nextLine();
                    sectionA.returnBooktoA(returnTitleA);
                    break;

                case 6:
                    System.out.print("B T: ");
                    String returnTitleB = scanner.nextLine();
                    sectionB.returnBooktoB(returnTitleB);
                    break;

               
                default:
                    System.out.println("Invalid choice.");
                    break;
            }

            System.out.print("Do you want to perform another action? Enter Y/N: ");
            choice = scanner.next().charAt(0);

        } while (Character.toUpperCase(choice) == 'Y');

        scanner.close();
    }
}

