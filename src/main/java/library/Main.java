package library;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

       Library library = new Library();

        int choice;

        do {

            System.out.println("\n========== LIBRARY MANAGEMENT SYSTEM ==========");

            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Register Member");
            System.out.println("4. View Members");
            System.out.println("5. Search Book");
            System.out.println("6. Borrow Book");
            System.out.println("7. Return Book");
            System.out.println("8. Library Statistics");
            System.out.println("9. Exit"); 

            System.out.print("Enter your choice : ");

            choice = sc.nextInt();

            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter ISBN : ");
                    String isbn = sc.nextLine();

                    System.out.print("Enter Title : ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author : ");
                    String author = sc.nextLine();

                    System.out.print("Enter Year : ");
                    int year = sc.nextInt();

                    Book book = new Book(isbn, title, author, year);

                    library.addBook(book);

                    break;

                case 2:

                    library.displayBooks();

                    break;

                case 3:

                    System.out.print("Enter Member ID : ");
                    String id = sc.nextLine();

                    System.out.print("Enter Member Name : ");
                    String name = sc.nextLine();

                    Member member = new Member(id, name);

                    library.registerMember(member);

                    break;

                case 4:

                    library.displayMembers();

                    break;

                case 5:

                    System.out.print("Enter Book Title : ");
                    String searchTitle = sc.nextLine();

                    library.searchBook(searchTitle);

                    break;

                case 6:

                    System.out.print("Enter ISBN : ");
                    String borrowIsbn = sc.nextLine();

                    library.borrowBook(borrowIsbn);

                    break;
                case 7:

                     System.out.print("Enter ISBN : ");
                     String returnIsbn = sc.nextLine();

                     library.returnBook(returnIsbn);

                         break;
                case 8:

                    library.displayStatistics();

                         break;
                case 9:

                    System.out.println("Thank You!");

                    break;

                default:

                    System.out.println("Invalid Choice.");

            }

        } while (choice != 9);

        sc.close();

    }

}
