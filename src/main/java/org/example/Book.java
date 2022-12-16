package org.example;

public class Book {

    private final String title;
    private final String author;
    private final String isbn;

    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        // Prefixing the Books while printing with Title, Author, ISBN
        return "\nTitle: " + title + "\nAuthor: " + author + "\nISBN: " + isbn + "\n";
    }


}
