package com.example.Library.Management.System.repo;

import com.example.Library.Management.System.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  BorrowRepo extends JpaRepository<Borrow,Integer> {
}
