//package com.rikin.allstateemail.controller;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import com.rikin.allstateemail.model.Email;
//import com.rikin.allstateemail.repository.EmailRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.mockito.Mockito.verify;
//
//
//import com.rikin.allstateemail.Controller.EmailController;
//import com.rikin.allstateemail.model.Email;
//import com.rikin.allstateemail.service.EmailService;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.mockito.Mockito;
//import org.skyscreamer.jsonassert.JSONAssert;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(value = EmailController.class)
//@WithMockUser
//public class EmailControllerTests {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private EmailService emailService;
//
//    public List<Email> testList = new ArrayList<Email>();
//
//    Email mockemail = new Email(70, "test@gmail.com", "test", "test email message", false);
//    Email mockemail2 = new Email(71, "test2@gmail.com", "test 2", "test email message 2", false);
//
//    testList<Email>.add(mockemail);
//
//
//
//    String exampleemailJson = "{\"name\":\"Spring\",\"description\":\"10Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";
//
//    @Test
//    public void retrieveDetailsForemail() throws Exception {
//
//        Mockito.when(emailService.getAllEmails()).thenReturn(
//                (List<Email>) mockemail
//        );
//
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
//                "/emails/email1/emails/email1").accept(
//                MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//        System.out.println(result.getResponse());
//        String expected = "{\"id\":\"email1\",\"name\":\"Spring\",\"description\":\"10 Steps\"}";
//
//
//        // {"id":"email1","name":"Spring","description":"10 Steps, 25 Examples and 10K emails","steps":["Learn Maven","Import Project","First Example","Second Example"]}
//
//        JSONAssert.assertEquals(expected, result.getResponse()
//                .getContentAsString(), false);
//    }
//
//}
