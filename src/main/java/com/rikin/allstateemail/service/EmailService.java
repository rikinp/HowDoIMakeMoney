package com.rikin.allstateemail.service;

import com.rikin.allstateemail.model.Post;

import java.util.List;

public interface EmailService {
    public List<Post> getAllEmails();
    public String deleteEmail(int id);
    public Post updateEmailIsRead(Post post);
    public Post addEmail(Post post);
}
