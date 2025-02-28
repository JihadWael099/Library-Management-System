package com.example.Library.Management.System.repo;

import com.example.Library.Management.System.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
}
