package com.example.Library.Management.System.repo;

import com.example.Library.Management.System.entity.Auther;
import com.example.Library.Management.System.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepo extends JpaRepository<Publisher,Integer> {
}
