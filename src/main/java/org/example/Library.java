package org.example;

import java.util.*;

public class Library {

    static Scanner scanner = new Scanner(System.in);

    // List of books that is in the tiny library
    static ArrayList<Book> addedBooks = new ArrayList<>();

    // List of books that the user has borrowed from the tiny library
    static ArrayList<Book> borrowedBooks = new ArrayList<>(addedBooks);

    public void addBooksAutomatically() {
        // Adding example books to the library on startup of program
        Book nineteenEightyFour = new Book("1984", "George Orwell", "9780451524935");
        Book fahrenheit451 = new Book ("Fahrenheit 451", "Ray Bradbury", "9781451673319");
        Book toKillAMockingbird = new Book("To Kill a Mockingbird", "Harper Lee", "0446310786");
        addedBooks.add(nineteenEightyFour);
        addedBooks.add(fahrenheit451);
        addedBooks.add(toKillAMockingbird);
    }



    public static void addedBooks(Book bookInformation) {
        // Taking information from addBooks() and adding the Book to addedBooks <ArrayList>
        addedBooks.add(bookInformation);
    }


    public static void addBooks() {
        // Method for adding books as Admin to addedBooks <ArrayList>
        String title, author, isbn;

        System.out.println("Enter title: ");
        title = scanner.nextLine();
        System.out.println("Enter author: ");
        author = scanner.nextLine();
        System.out.println("Enter ISBN: ");
        isbn = scanner.nextLine();
        System.out.println("\nAdded \"" + title + "\" to the library\n");

        Book bookInformation = new Book(title, author, isbn);
        addedBooks(bookInformation);
    }


    public static void removeBooks() {
        // Method for removing books as Admin from addedBooks <ArrayList>
        System.out.println("Which book would you like to remove?");
        String title = scanner.nextLine();

        Iterator<Book> bookIterator = addedBooks.iterator();

        while (bookIterator.hasNext()) {
            String titleToBeRemoved = bookIterator.next().getTitle();
            if (title.equals(titleToBeRemoved)) {
                bookIterator.remove();
                System.out.println("\n\"" + title + "\" has been removed from the library \n");
                break;
            } else if (!bookIterator.hasNext()) {
                System.out.println("No book with title \"" + title + "\" was found\n");
                break;
            }
        }
    }

    public static void borrowBooks() {
        // Method for borrowing books as User from addedBooks <ArrayList> to borrowedBooks <ArrayList>
        System.out.println("Which book would you like to borrow?");
        String title = scanner.nextLine();

        ListIterator<Book> bookIterator = addedBooks.listIterator();

        while (bookIterator.hasNext()) {
            String titleToBeBorrowed = bookIterator.next().getTitle();
            if (title.equals(titleToBeBorrowed)) {
                bookIterator.previous();
                borrowedBooks.add(bookIterator.next());
                bookIterator.remove();
                System.out.println("\n\"" + title + "\" has been borrowed \n");
                break;
            }
        }

    }

    public static void returnBooks() {
        // Method for returning books as User from borrowedBooks <ArrayList> to addedBooks <ArrayList>
        System.out.println("Which book would you like to return?");
        String title = scanner.nextLine();

        ListIterator<Book> bookIterator = borrowedBooks.listIterator();

        while (bookIterator.hasNext()) {
            String titleToBeReturned = bookIterator.next().getTitle();
            if (title.equals(titleToBeReturned)) {
                bookIterator.previous();
                addedBooks.add(bookIterator.next());
                bookIterator.remove();
                System.out.println("\n\"" + title + "\" has been returned to the library \n");
                break;
            }
        }
    }


    public String printBorrowedBooks() {
        // Taking information from borrowedBooks <ArrayList> and printing the contents to the terminal
        String totalBooks = " ";
        for (int i = 0; i < borrowedBooks.size(); i++) {
            Book localBook = borrowedBooks.get(i);
            totalBooks = totalBooks + localBook.toString();
        }
        return totalBooks;
    }

    public String printAvailableBooks() {
        // Taking information from addedBooks <ArrayList> and printing the contents to the terminal
        String totalBooks = " ";
        for (int i = 0; i < addedBooks.size(); i++) {
            Book localBook = addedBooks.get(i);
            totalBooks = totalBooks + localBook.toString();
        }
        return totalBooks;
    }

}
