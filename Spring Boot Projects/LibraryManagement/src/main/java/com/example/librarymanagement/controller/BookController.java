
package com.example.librarymanagement.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Add a new book
    @PostMapping
    public Book addBook(@Valid @RequestBody Book book) {
        return bookService.addBook(book);
    }

    // View all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // Search book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {

        Book book = bookService.getBookById(id);

        if (book != null) {
            return ResponseEntity.ok(book);
        }

        return ResponseEntity.notFound().build();
    }

    // Update book availability
    @PatchMapping("/{id}/availability")
    public ResponseEntity<Book> updateAvailability(
            @PathVariable int id,
            @RequestParam boolean available) {

        Book book = bookService.updateAvailability(id, available);

        if (book != null) {
            return ResponseEntity.ok(book);
        }

        return ResponseEntity.notFound().build();
    }

    // Delete book
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {

        Book book = bookService.getBookById(id);

        if (book != null) {
            bookService.deleteBook(id);
            return ResponseEntity.ok("Book deleted successfully");
        }

        return ResponseEntity.notFound().build();
    }
}
