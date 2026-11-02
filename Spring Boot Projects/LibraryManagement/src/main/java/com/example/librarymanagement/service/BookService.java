
package com.example.librarymanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.librarymanagement.model.Book;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();

    // Add a new book
    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    // View all books
    public List<Book> getAllBooks() {
        return books;
    }

    // Search book by ID
    public Book getBookById(int bookId) {

        for (Book book : books) {

            if (book.getBookId() == bookId) {
                return book;
            }
        }

        return null;
    }

    // Update book availability
    public Book updateAvailability(int bookId, boolean available) {

        Book book = getBookById(bookId);

        if (book != null) {
            book.setAvailable(available);
        }

        return book;
    }

    // Delete book
    public String deleteBook(int bookId) {

        Book book = getBookById(bookId);

        if (book != null) {
            books.remove(book);
            return "Book deleted successfully";
        }

        return "Book not found";
    }
}
