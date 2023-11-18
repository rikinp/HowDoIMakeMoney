package com.rikin.allstateemail.Controller;

import com.rikin.allstateemail.model.Post;
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
    public List<Post> getAllEmails() {
        return emailService.getAllEmails();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmail(@PathVariable int id){
        return emailService.deleteEmail(id);
    }

    @PutMapping("/update")
    public Post updateEmailIsRead(@RequestBody Post post){
        return emailService.updateEmailIsRead(post);
    }

    @PostMapping("/add")
    public Post addEmail(@RequestBody Post post){
        return emailService.addEmail(post);
    }

}
