package com.turkcell.library_system.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.library_system.dto.*;
import com.turkcell.library_system.entity.Author;
import com.turkcell.library_system.exception.NotFoundException;
import com.turkcell.library_system.repository.AuthorRepository;

@Service
public class AuthorServiceImpl {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public CreatedAuthorResponse create(CreateAuthorRequest request) {
        Author author = new Author();
        author.setFirstName(request.getFirstName());
        author.setLastName(request.getLastName());
        author.setBirthYear(request.getBirthYear());
        author = authorRepository.save(author);

        CreatedAuthorResponse response = new CreatedAuthorResponse();
        response.setId(author.getId());
        response.setFirstName(author.getFirstName());
        response.setLastName(author.getLastName());
        response.setBirthYear(author.getBirthYear());
        return response;
    }

    public List<ListAuthorResponse> getAll() {
        return authorRepository.findAll()
                .stream()
                .map(author -> {
                    ListAuthorResponse response = new ListAuthorResponse();
                    response.setId(author.getId());
                    response.setFirstName(author.getFirstName());
                    response.setLastName(author.getLastName());
                    response.setBirthYear(author.getBirthYear());
                    return response;
                })
                .toList();
    }

    public GetByIdAuthorResponse getById(UUID id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Yazar bulunamadı. ID: " + id));


        GetByIdAuthorResponse response = new GetByIdAuthorResponse();
        response.setId(author.getId());
        response.setFirstName(author.getFirstName());
        response.setLastName(author.getLastName());
        response.setBirthYear(author.getBirthYear());
        return response;
    }

    public UpdatedAuthorResponse update(UUID id, UpdateAuthorRequest request) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Yazar bulunamadı. ID: " + id));
        author.setFirstName(request.getFirstName());
        author.setLastName(request.getLastName());
        author.setBirthYear(request.getBirthYear());
        author = authorRepository.save(author);

        UpdatedAuthorResponse response = new UpdatedAuthorResponse();
        response.setId(author.getId());
        response.setFirstName(author.getFirstName());
        response.setLastName(author.getLastName());
        response.setBirthYear(author.getBirthYear());
        return response;
    }

    public void delete(UUID id) {
        if (!authorRepository.existsById(id))
            throw new NotFoundException("Yazar bulunamadı. ID: " + id);
        authorRepository.deleteById(id);
    }
}
