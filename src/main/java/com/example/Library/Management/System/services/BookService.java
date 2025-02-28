package com.example.Library.Management.System.services;

import com.example.Library.Management.System.dto.AutherDTO;
import com.example.Library.Management.System.dto.BookDTO;
import com.example.Library.Management.System.dto.BookSaveDTO;
import com.example.Library.Management.System.dto.BookUpdateDTO;

import java.util.List;

public interface BookService  {
    String addBook(BookSaveDTO bookSaveDTO);

    List<BookDTO> getAllBooks();

    String updateBook(BookUpdateDTO bookUpdateDTO);

    String deleteBook(int id);
}
