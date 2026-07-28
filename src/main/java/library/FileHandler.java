package library;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    // Save books to file
    public void saveBooks(ArrayList<Book> books) {
System.out.println("Saving " + books.size() + " book(s)...");
        try {

           BufferedWriter writer = new BufferedWriter(
        new FileWriter("src/main/java/library/data/books.txt"));

            for (Book book : books) {

                writer.write(
                        book.getIsbn() + "," +
                        book.gettitle() + "," +
                        book.getAuthor() + "," +
                        book.getYear() + "," +
                        book.isAvailable()
                );

                writer.newLine();
            }

            writer.close();
            System.out.println("Books saved successfully.");

        } catch (IOException e) {

            System.out.println("Error saving books.");

        }
    }

    // Load books from file
    public ArrayList<Book> loadBooks() {

        ArrayList<Book> books = new ArrayList<>();

        try {

           File file = new File("src/main/java/library/data/books.txt");

            if (!file.exists()) {
                return books;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                Book book = new Book(
                        data[0],
                        data[1],
                        data[2],
                        Integer.parseInt(data[3])
                );

                book.setAvailable(Boolean.parseBoolean(data[4]));

                books.add(book);
            }

            reader.close();

        } catch (Exception e) {

            System.out.println("Error loading books.");

        }

        return books;
    }
}