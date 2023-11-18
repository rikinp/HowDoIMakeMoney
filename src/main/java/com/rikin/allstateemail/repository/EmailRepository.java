package com.rikin.allstateemail.repository;

import com.rikin.allstateemail.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Post,Integer> {
    List<Post> findAllByOrderByIdDesc();

}