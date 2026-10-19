
import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    boolean issued;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    void display() {
        System.out.println(id + " || " + title + " || "
                + author + " | "
                + (issued ? "Issued" : "Available"));
    }
}

public class LibrarySystem {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Library Management ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewBooks();
                case 3 -> issueBook();
                case 4 -> returnBook();
                case 5 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void addBook() {
        System.out.print("Enter book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Book b : books) {
            if (b.id == id) {
                System.out.println("ID already exists!");
                return;
            }
        }

        System.out.print("Enter title: ");
        String title = sc.nextLine();

        System.out.print("Enter author: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("Book added successfully!");
    }

    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book b : books) {
            b.display();
        }
    }

    static void issueBook() {
        Book b = findBook();

        if (b != null && !b.issued) {
            b.issued = true;
            System.out.println("Book issued successfully!");
        } else if (b != null) {
            System.out.println("Book is already issued.");
        }
    }

    static void returnBook() {
        Book b = findBook();

        if (b != null && b.issued) {
            b.issued = false;
            System.out.println("Book returned successfully!");
        } else if (b != null) {
            System.out.println("Book was not issued.");
        }
    }

    static Book findBook() {
        System.out.print("Enter book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Book b : books) {
            if (b.id == id) {
                return b;
            }
        }

        System.out.println("Book not found.");
        return null;
    }
}
