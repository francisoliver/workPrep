package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository repository;

    @InjectMocks
    private BookService service;

    @Test
    void findAll_returnsAllBooks() {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Test Book");
        book.setAuthor("Author");
        book.setIsbn("ISBN-1");
        book.setPrice(new BigDecimal("9.99"));

        when(repository.findAll()).thenReturn(List.of(book));

        List<Book> result = service.findAll();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getTitle()).isEqualTo("Test Book");
        verify(repository, times(1)).findAll();
    }

    @Test
    void save_delegatesToRepository() {
        Book book = new Book();
        book.setTitle("New Book");

        when(repository.save(book)).thenReturn(book);

        Book saved = service.save(book);

        assertThat(saved).isSameAs(book);
        verify(repository).save(book);
    }

    @Test
    void findById_returnsOptional() {
        Book book = new Book();
        book.setId(2L);
        when(repository.findById(2L)).thenReturn(Optional.of(book));

        Optional<Book> found = service.findById(2L);

        assertThat(found).isPresent().contains(book);
        verify(repository).findById(2L);
    }
}
