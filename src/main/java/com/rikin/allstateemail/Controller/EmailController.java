package com.rikin.allstateemail.Controller;

import com.rikin.allstateemail.model.Email;
import com.rikin.allstateemail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/email")
@CrossOrigin
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/getAll")
    public List<Email> getAllEmails() {
        return emailService.getAllEmails();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmail(@PathVariable int id){
        return emailService.deleteEmail(id);
    }

    @PutMapping("/update")
    public Email updateEmailIsRead(@RequestBody Email email){
        return emailService.updateEmailIsRead(email);
    }

    @PostMapping("/add")
    public Email addEmail(@RequestBody Email email){
        return emailService.addEmail(email);
    }

}
