package com.library.libraryapp.controller;

import com.library.libraryapp.dto.book.BookDTO;
import com.library.libraryapp.model.book.Book;
import com.library.libraryapp.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Create a new book (HistoryBook, ScienceBook, or LiteratureBook)
    @PostMapping
    public ResponseEntity<Book> createBook( @Valid @RequestBody Book book) {
        Book createdBook = bookService.createBook(book);
        return ResponseEntity.ok(createdBook);
    }

    // Get a book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    // Get all books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    // Update a book by ID
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable String id, @Valid @RequestBody Book updatedBook) {
        Book book = bookService.updateBook(id, updatedBook);
        return ResponseEntity.ok(book);
    }

    /*@PatchMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable String id, @RequestBody Map<String, Object> updates) {
        Book book = bookService.updateBook(id, updates);
        return book != null ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
    }*/

    @PatchMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable String id,  @RequestBody BookDTO patchDTO) {
        Book book = bookService.updateBook(id, patchDTO);
        return ResponseEntity.ok(book);
    }


    // Delete a book by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
