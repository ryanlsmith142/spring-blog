package com.codeup.blog.blog.dao;

import com.codeup.blog.blog.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
