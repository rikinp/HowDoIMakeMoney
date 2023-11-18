package com.rikin.allstateemail.service;

import com.rikin.allstateemail.model.Post;
import com.rikin.allstateemail.repository.EmailRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EmailServiceImplementation implements EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Override
    public List<Post> getAllEmails() {
        List<Post> emailsList;
        emailsList = emailRepository.findAllByOrderByIdDesc();
        return emailsList;
    }

    @Override
    public String deleteEmail(int id){
        emailRepository.deleteById(id);
        return "Post deleted" + id;
    }

    @Override
    public Post updateEmailIsRead(Post post) {
        Post existingPost = emailRepository.findById(post.getId()).orElse(null);
        existingPost.setPost(post.getPost());
        existingPost.setSubject(post.getSubject());
        existingPost.setMessage(post.getMessage());
        existingPost.setSeen(true);
        return emailRepository.save(existingPost);
    }

    @Override
    public Post addEmail(Post post){
        return emailRepository.save(post);
    }
}
