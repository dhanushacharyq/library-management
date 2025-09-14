package libraryapp;

import java.util.List;
import java.util.Scanner;

public class LibrarySystem {
    private static final Library library = new Library();

    public static void main(String[] args) {
        // Sample books (optional)
        library.addBook(new Book("Effective Java", "Joshua Bloch", "9780134685991"));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "9780132350884"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add book");
            System.out.println("2. Issue book");
            System.out.println("3. Return book");
            System.out.println("4. List all books");
            System.out.println("5. List available books");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            String choice = scanner.nextLine().trim();
            try {
                switch (choice) {
                    case "1":
                        System.out.print("Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Author: ");
                        String author = scanner.nextLine();
                        System.out.print("ISBN: ");
                        String isbn = scanner.nextLine();
                        library.addBook(new Book(title, author, isbn));
                        System.out.println("Book added.");
                        break;
                    case "2":
                        System.out.print("ISBN to issue: ");
                        isbn = scanner.nextLine();
                        boolean issued = library.issueBook(isbn);
                        System.out.println(issued ? "Book issued." : "Book could not be issued (already issued).");
                        break;
                    case "3":
                        System.out.print("ISBN to return: ");
                        isbn = scanner.nextLine();
                        boolean returned = library.returnBook(isbn);
                        System.out.println(returned ? "Book returned." : "Book was not issued.");
                        break;
                    case "4":
                        List<Book> all = library.listAll();
                        if (all.isEmpty()) System.out.println("No books.");
                        else all.forEach(System.out::println);
                        break;
                    case "5":
                        List<Book> avail = library.listAvailable();
                        if (avail.isEmpty()) System.out.println("No available books.");
                        else avail.forEach(System.out::println);
                        break;
                    case "0":
                        System.out.println("Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
