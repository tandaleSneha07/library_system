package library;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<Member> members;
    private FileHandler fileHandler;

    public Library() {

    fileHandler = new FileHandler();

    books = fileHandler.loadBooks();

    members = new ArrayList<>();
}
    public void addBook(Book book) {
        books.add(book);
        fileHandler.saveBooks(books);
        System.out.println("Book added successfully.");
    }

     public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
            System.out.println("----------------------");
        }
    }
     public void registerMember(Member member) {
        members.add(member);
        System.out.println("Member registered successfully.");
    }
     public void displayMembers() {
        if (members.isEmpty()) {
            System.out.println("No members found.");
            return;
        }

        for (Member member : members) {
            System.out.println(member);
            System.out.println("----------------------");
        }
    }
    // Search Book by Title
public void searchBook(String title) {

    boolean found = false;

    for (Book book : books) {

        if (book.gettitle().equalsIgnoreCase(title)) {

            System.out.println("\nBook Found");
            System.out.println(book);

            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Book Not Found.");
    }
}
public void borrowBook(String isbn) {

    boolean found = false;

    for (Book book : books) {

        if (book.getIsbn().equals(isbn)) {

            found = true;

            if (book.isAvailable()) {

                book.setAvailable(false);
                fileHandler.saveBooks(books);

                System.out.println("Book Borrowed Successfully.");

            } else {

                System.out.println("Book is already borrowed.");

            }

            break;
        }
    }

    if (!found) {
        System.out.println("Book Not Found.");
    }
    
}
// Return Book
public void returnBook(String isbn) {

    boolean found = false;

    for (Book book : books) {

        if (book.getIsbn().equals(isbn)) {

            found = true;

            if (!book.isAvailable()) {

                book.setAvailable(true);
                fileHandler.saveBooks(books);

                System.out.println("Book Returned Successfully.");

            } else {

                System.out.println("Book is already available.");

            }

            break;
        }
    }

    if (!found) {
        System.out.println("Book Not Found.");
    }
}
public void displayStatistics() {

    int totalBooks = books.size();
    int availableBooks = 0;
    int borrowedBooks = 0;

    for (Book book : books) {
        if (book.isAvailable()) {
            availableBooks++;
        } else {
            borrowedBooks++;
        }
    }

    System.out.println("\n========== LIBRARY STATISTICS ==========");
    System.out.println("Total Books      : " + totalBooks);
    System.out.println("Available Books  : " + availableBooks);
    System.out.println("Borrowed Books   : " + borrowedBooks);
    System.out.println("Total Members    : " + members.size());
}

}
