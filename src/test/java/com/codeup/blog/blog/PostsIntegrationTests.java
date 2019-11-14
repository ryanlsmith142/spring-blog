package com.codeup.blog.blog;

import com.codeup.blog.blog.dao.PostRepository;
import com.codeup.blog.blog.dao.UserRepository;
import com.codeup.blog.blog.models.Post;
import com.codeup.blog.blog.models.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import javax.servlet.http.HttpSession;

import java.time.temporal.Temporal;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogApplication.class)
@AutoConfigureMockMvc
public class PostsIntegrationTests {
    private User testUser;
    private HttpSession httpSession;

    @Autowired
    private MockMvc mvc;

    @Autowired
    UserRepository userDao;

    @Autowired
    PostRepository postDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Before
    public void setup() throws Exception {
        testUser = userDao.findByUsername("testUser");

        if(testUser == null) {
            User newUser = new User();
            newUser.setUsername("testUser");
            newUser.setPassword(passwordEncoder.encode("password"));
            newUser.setEmail("testUser@codeup.com");
            testUser = userDao.save(newUser);
        }

        httpSession = this.mvc.perform(post("/login").with(csrf())
            .param("username", "testUser")
            .param("password", "password"))
            .andExpect(status().is(HttpStatus.FOUND.value()))
            .andExpect(redirectedUrl("/posts"))
            .andReturn()
            .getRequest()
            .getSession();
    }

    @Test
    public void contextLoads() {
        assertNotNull(mvc);
    }

    @Test
    public void testIfUserSessionIsActive() throws Exception {
        assertNotNull(httpSession);
    }


    @Test
    public void testCreatePost() throws Exception {
        this.mvc.perform(
                post("/posts/create").with(csrf())
                .session((MockHttpSession) httpSession)
                .param("title", "test")
                .param("body", "this is a blog post"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    public void testShowPost() throws Exception {
        Post existingPost = postDao.findAll().get(0);
        this.mvc.perform(get("/posts/" + existingPost.getId())
                .session((MockHttpSession) this.httpSession))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(existingPost.getTitle())));
//                .andExpect(content().string(containsString(existingPost.getBody())));
    }

    @Test
    public void testAdsIndex() throws Exception {
        Post existingPost = postDao.findAll().get(0);

        this.mvc.perform(get("/posts"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(existingPost.getTitle())));
    }

//    @Test
//    public void testEditPost() throws Exception {
//        Post existingPost = postDao.findAll().get(0);
//
//        this.mvc.perform(
//                post("/posts/" + )
//        )
//    }



}
