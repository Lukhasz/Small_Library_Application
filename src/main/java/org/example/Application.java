package org.example;

import java.util.Scanner;

public class Application extends Library {

    static Library library = new Library();
    static Scanner scanner = new Scanner(System.in);
    static boolean running = true;


    public static void applicationMethod() {
        // Calling addBooksAutomatically in Library to have the books added on start
        library.addBooksAutomatically();

        while (running) {
            System.out.println("Enter 1 to sign in as Admin"
                    + "\nEnter 2 to sign in as User"
                    + "\nEnter 3 to see all available books"
                    + "\nEnter 4 to exit program");

            String answer = scanner.nextLine(); // I use String instead of int to be able to use scanner.nextLine when input for title and author is needed
            // (hops to next line when a space is input)
            // Also, so I don't get an error when user inputs something other than an int in the menu

            switch (answer) {
                case "1": // Calls on choiceAdmin
                    System.out.println("Press 1 to add a book"
                            + "\nPress 2 to remove a book");
                    choiceAdmin();
                    break;

                case "2": // Calls on choiceUser
                    System.out.println("Press 1 to borrow a book"
                            + "\nPress 2 to return a book"
                            + "\nPress 3 to see borrowed books");
                    choiceUser();
                    break;

                case "3": // Show all the books that have been added so far
                    System.out.println(library.printAvailableBooks());
                    break;

                case "4": // Sets running to false and thus exits the application
                    System.out.println("Thank you for using the tiny library."
                            + "\nNow quitting...");
                    running = false;
                    break;

                default: // If other input is entered, loop back to start
                    System.out.println("Please enter option 1 - 4\n");


            }
        }
    }

    static void choiceAdmin() {
        String answer = scanner.nextLine();
        switch (answer) {
            case "1":
                addBooks();
                break;

            case "2":
                removeBooks();
                break;
        }
    }

    static void choiceUser() {
        String answer = scanner.nextLine();
        switch (answer) {
            case "1":
                borrowBooks();
                break;

            case "2":
                returnBooks();
                break;

            case "3":
                System.out.println(library.printBorrowedBooks());
                break;
        }
    }
}