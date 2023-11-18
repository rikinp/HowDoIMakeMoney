package com.rikin.allstateemail.service;

import com.rikin.allstateemail.model.Email;
import com.rikin.allstateemail.repository.EmailRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EmailServiceImplementationTest {

    @Mock
    private EmailRepository emailRepository;
    private EmailService underTest;

    @BeforeEach
    void setUp() {
        underTest = new EmailServiceImplementation(emailRepository);
    }

    @Test
    void canGetAllStoreItems() {
        //when
        underTest.getAllEmails();
        //then
        verify(emailRepository).findAllByOrderByIdDesc();
    }

    @Test
    void saveOrder() {
        //given
        Email email = new Email(
                2,
                "sender@gmail.com",
                "Test email",
                "This is test email",
                false
        );

        //when
        underTest.addEmail(email);

        //then
        ArgumentCaptor<Email> ordersArgumentCaptor =
                ArgumentCaptor.forClass(Email.class);
        verify(emailRepository).save(ordersArgumentCaptor.capture());
        Email capturedOrder = ordersArgumentCaptor.getValue();
        assertThat(capturedOrder).isEqualTo(email);

    }

}