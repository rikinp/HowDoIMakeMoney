package com.rikin.allstateemail.service;

import com.rikin.allstateemail.model.Post;
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
class PostServiceImplementationTest {

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
        Post post = new Post(
                2,
                "sender@gmail.com",
                "Test post",
                "This is test post",
                false
        );

        //when
        underTest.addEmail(post);

        //then
        ArgumentCaptor<Post> ordersArgumentCaptor =
                ArgumentCaptor.forClass(Post.class);
        verify(emailRepository).save(ordersArgumentCaptor.capture());
        Post capturedOrder = ordersArgumentCaptor.getValue();
        assertThat(capturedOrder).isEqualTo(post);

    }

}