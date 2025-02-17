package com.example.Library.Management.System.repo;

import com.example.Library.Management.System.entity.Auther;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthRepo extends JpaRepository< Auther,Integer> {
}
