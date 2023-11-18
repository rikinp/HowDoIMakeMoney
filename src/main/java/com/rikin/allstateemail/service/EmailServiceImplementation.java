package com.rikin.allstateemail.service;

import com.rikin.allstateemail.model.Email;
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
    public List<Email> getAllEmails() {
        List<Email> emailsList;
        emailsList = emailRepository.findAllByOrderByIdDesc();
        return emailsList;
    }

    @Override
    public String deleteEmail(int id){
        emailRepository.deleteById(id);
        return "Email deleted" + id;
    }

    @Override
    public Email updateEmailIsRead(Email email) {
        Email existingEmail = emailRepository.findById(email.getId()).orElse(null);
        existingEmail.setEmail(email.getEmail());
        existingEmail.setSubject(email.getSubject());
        existingEmail.setMessage(email.getMessage());
        existingEmail.setSeen(true);
        return emailRepository.save(existingEmail);
    }

    @Override
    public Email addEmail(Email email){
        return emailRepository.save(email);
    }
}
