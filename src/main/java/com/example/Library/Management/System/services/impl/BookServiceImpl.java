package com.example.Library.Management.System.services.impl;


import com.example.Library.Management.System.dto.*;
import com.example.Library.Management.System.entity.Book;
import com.example.Library.Management.System.entity.Publisher;
import com.example.Library.Management.System.repo.AuthRepo;
import com.example.Library.Management.System.repo.BookRepo;
import com.example.Library.Management.System.repo.PublisherRepo;
import com.example.Library.Management.System.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl  implements BookService {

    @Autowired
    BookRepo bookRepo;

    @Autowired
    PublisherRepo publisherRepo;

    @Autowired
    AuthRepo authRepo;


    @Override
    public String addBook(BookSaveDTO bookSaveDTO) {
      Book book = new Book(
                bookSaveDTO.getTitle(),
                authRepo.getById(bookSaveDTO.getAuther_id()),
                publisherRepo.getById(bookSaveDTO.getPublisher_id())
        );
       bookRepo.save(book);
        return book.getTitle();
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> getAllBooks = bookRepo.findAll();
        List<BookDTO> bookDTOS = new ArrayList<>();
        for (Book book : getAllBooks) {
            BookDTO bookDTO = new  BookDTO(
                    book.getBookID(),
                    book.getTitle(),
                    book.getAuther(),
                    book.getPublisher()
            );
            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
    }

    @Override
    public String updateBook(BookUpdateDTO bookUpdateDTO) {
        if(bookRepo.existsById(bookUpdateDTO.getBookID())) {
            Book book = bookRepo.getById(bookUpdateDTO.getBookID());
            book.setTitle(bookUpdateDTO.getTitle());
            book.setAuther(authRepo.getById(bookUpdateDTO.getAuther_id()));
            book.setPublisher(publisherRepo.getById(bookUpdateDTO.getPublisher_id()));
            bookRepo.save(book);
            return "Update Book Success : " + book.getTitle();
        }
        else {
            return "Update Book Fail publisher not found" ;
        }
    }

    @Override
    public String deleteBook(int id) {
        if (bookRepo.existsById(id)) {
            bookRepo.deleteById(id);
        }
        else
        {
            return "Delete Book Fail";
        }
        return "can,t delete book";
    }
}
