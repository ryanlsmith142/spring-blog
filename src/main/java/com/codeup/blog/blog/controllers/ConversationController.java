package com.codeup.blog.blog.controllers;

import com.codeup.blog.blog.dao.ConversationRepository;
import com.codeup.blog.blog.dao.UserRepository;
import com.codeup.blog.blog.models.Conversation;
import com.codeup.blog.blog.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConversationController {

    private final UserRepository userDao;
    private final ConversationRepository conversationDao;

    public ConversationController(UserRepository userDao, ConversationRepository conversationDao) {
        this.userDao = userDao;
        this.conversationDao = conversationDao;
    }

    @PostMapping("/conversation/startConversation")
    public String createConversation(Model vModel, @RequestParam(name="secondaryUserId") long secondaryUserId) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Conversation createdConversation = new Conversation(currentUser.getId(), secondaryUserId);
        vModel.addAttribute("createdConversation", createdConversation);
        conversationDao.save(createdConversation);
        return "redirect:/posts/createdConversation";
    }




}
