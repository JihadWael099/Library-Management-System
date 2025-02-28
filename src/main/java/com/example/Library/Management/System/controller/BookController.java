package com.example.Library.Management.System.controller;

import com.example.Library.Management.System.dto.*;
import com.example.Library.Management.System.services.AutherService;
import com.example.Library.Management.System.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(path = "/book")
    public String saveBook(@RequestBody BookSaveDTO bookSaveDTO) {
        return bookService.addBook(bookSaveDTO);
    }
    @GetMapping(path = "/books")
    public List<BookDTO> allAuthors() {
        return bookService.getAllBooks();
    }
    @PutMapping(path = "/book")
    public String updateBook(@RequestBody BookUpdateDTO bookUpdateDTO) {
        return bookService.updateBook(bookUpdateDTO);
    }

    @DeleteMapping(path = "/books/{id}")
    public String DeleteBook(@PathVariable(value="id") int id) {
        String bookName =bookService.deleteBook(id);
        return "deleted ";
    }
}
