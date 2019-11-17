package com.codeup.blog.blog.dao;

import com.codeup.blog.blog.models.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {

}
