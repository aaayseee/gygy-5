package com.turkcell.library_system.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.library_system.dto.*;
import com.turkcell.library_system.entity.*;
import com.turkcell.library_system.exception.NotFoundException;
import com.turkcell.library_system.repository.*;

@Service
public class BookServiceImpl {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final ShelfRepository shelfRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository,
            CategoryRepository categoryRepository, ShelfRepository shelfRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.shelfRepository = shelfRepository;
    }

    public CreatedBookResponse create(CreateBookRequest request) {
        Author author = authorRepository.findById(request.getAuthorId()).orElseThrow();
        Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow();
        Shelf shelf = shelfRepository.findById(request.getShelfId()).orElseThrow();

        Book book = new Book();
        book.setAuthor(author);
        book.setCategory(category);
        book.setShelf(shelf);
        book.setIsbn(request.getIsbn());
        book.setTitle(request.getTitle());
        book.setPublishYear(request.getPublishYear());
        book.setPublisher(request.getPublisher());
        book.setLanguage(request.getLanguage());
        book.setPageCount(request.getPageCount());
        book.setTotalCopies(request.getTotalCopies());
        book.setAvailableCopies(request.getAvailableCopies());
        book = bookRepository.save(book);

        CreatedBookResponse response = new CreatedBookResponse();
        response.setId(book.getId());
        response.setAuthorId(book.getAuthor().getId());
        response.setCategoryId(book.getCategory().getId());
        response.setShelfId(book.getShelf().getId());
        response.setIsbn(book.getIsbn());
        response.setTitle(book.getTitle());
        response.setPublishYear(book.getPublishYear());
        response.setPublisher(book.getPublisher());
        response.setLanguage(book.getLanguage());
        response.setPageCount(book.getPageCount());
        response.setTotalCopies(book.getTotalCopies());
        response.setAvailableCopies(book.getAvailableCopies());
        return response;
    }

    public List<ListBookResponse> getAll() {
        return bookRepository.findAll()
                .stream()
                .map(book -> {
                    ListBookResponse response = new ListBookResponse();
                    response.setId(book.getId());
                    response.setAuthorId(book.getAuthor().getId());
                    response.setCategoryId(book.getCategory().getId());
                    response.setShelfId(book.getShelf().getId());
                    response.setIsbn(book.getIsbn());
                    response.setTitle(book.getTitle());
                    response.setPublishYear(book.getPublishYear());
                    response.setPublisher(book.getPublisher());
                    response.setLanguage(book.getLanguage());
                    response.setPageCount(book.getPageCount());
                    response.setTotalCopies(book.getTotalCopies());
                    response.setAvailableCopies(book.getAvailableCopies());
                    return response;
                })
                .toList();
    }

    public GetByIdBookResponse getById(UUID id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Kitap bulunamadı. ID: " + id));

        GetByIdBookResponse response = new GetByIdBookResponse();
        response.setId(book.getId());
        response.setAuthorId(book.getAuthor().getId());
        response.setCategoryId(book.getCategory().getId());
        response.setShelfId(book.getShelf().getId());
        response.setIsbn(book.getIsbn());
        response.setTitle(book.getTitle());
        response.setPublishYear(book.getPublishYear());
        response.setPublisher(book.getPublisher());
        response.setLanguage(book.getLanguage());
        response.setPageCount(book.getPageCount());
        response.setTotalCopies(book.getTotalCopies());
        response.setAvailableCopies(book.getAvailableCopies());
        return response;
    }

    public UpdatedBookResponse update(UUID id, UpdateBookRequest request) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Kitap bulunamadı. ID: " + id));        Author author = authorRepository.findById(request.getAuthorId()).orElseThrow();
        Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow();
        Shelf shelf = shelfRepository.findById(request.getShelfId()).orElseThrow();

        book.setAuthor(author);
        book.setCategory(category);
        book.setShelf(shelf);
        book.setIsbn(request.getIsbn());
        book.setTitle(request.getTitle());
        book.setPublishYear(request.getPublishYear());
        book.setPublisher(request.getPublisher());
        book.setLanguage(request.getLanguage());
        book.setPageCount(request.getPageCount());
        book.setTotalCopies(request.getTotalCopies());
        book.setAvailableCopies(request.getAvailableCopies());
        book = bookRepository.save(book);

        UpdatedBookResponse response = new UpdatedBookResponse();
        response.setId(book.getId());
        response.setAuthorId(book.getAuthor().getId());
        response.setCategoryId(book.getCategory().getId());
        response.setShelfId(book.getShelf().getId());
        response.setIsbn(book.getIsbn());
        response.setTitle(book.getTitle());
        response.setPublishYear(book.getPublishYear());
        response.setPublisher(book.getPublisher());
        response.setLanguage(book.getLanguage());
        response.setPageCount(book.getPageCount());
        response.setTotalCopies(book.getTotalCopies());
        response.setAvailableCopies(book.getAvailableCopies());
        return response;
    }

    public void delete(UUID id) {
        if (!bookRepository.existsById(id))
            throw new NotFoundException("Kitap bulunamadı. ID: " + id);
        bookRepository.deleteById(id);
    }
}
