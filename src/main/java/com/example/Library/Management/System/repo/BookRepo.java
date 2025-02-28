package com.example.Library.Management.System.repo;

import com.example.Library.Management.System.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo  extends JpaRepository<Book, Integer> {
}
