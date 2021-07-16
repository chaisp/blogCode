package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.dto.BookDto;
import com.example.demo.model.po.Book;
import com.example.demo.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void saveBook(BookDto bookDto) {
        Book book = bookDto.toEntity();
        bookRepository.save(book);
    }

    public void deleteBookById(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    public BookDto getBookById(Long bookId) {
        Optional<Book> book = bookRepository.findById(bookId);

        if (book.isPresent()) {
            return new BookDto(book.get());
        } else {
            throw new RuntimeException("book not exist");
        }

    }

}
