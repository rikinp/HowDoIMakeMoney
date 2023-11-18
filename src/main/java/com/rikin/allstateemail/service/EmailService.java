package com.rikin.allstateemail.service;

import com.rikin.allstateemail.model.Email;

import java.util.List;

public interface EmailService {
    public List<Email> getAllEmails();
    public String deleteEmail(int id);
    public Email updateEmailIsRead(Email email);
    public Email addEmail(Email email);
}
