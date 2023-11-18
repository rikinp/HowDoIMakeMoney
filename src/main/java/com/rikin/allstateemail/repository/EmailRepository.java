package com.rikin.allstateemail.repository;

import com.rikin.allstateemail.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email,Integer> {
    List<Email> findAllByOrderByIdDesc();

}