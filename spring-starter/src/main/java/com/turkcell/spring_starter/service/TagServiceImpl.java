package com.turkcell.spring_starter.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.spring_starter.dto.*;
import com.turkcell.spring_starter.entity.Tag;
import com.turkcell.spring_starter.repository.TagRepository;

@Service
public class TagServiceImpl {
    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public CreatedTagResponse create(CreateTagRequest request) {
        Tag tag = new Tag();
        tag.setName(request.getName());
        tag = tagRepository.save(tag);

        CreatedTagResponse response = new CreatedTagResponse();
        response.setId(tag.getId());
        response.setName(tag.getName());
        return response;
    }

    public List<ListTagResponse> getAll() {
        return tagRepository.findAll()
                .stream()
                .map(tag -> {
                    ListTagResponse response = new ListTagResponse();
                    response.setId(tag.getId());
                    response.setName(tag.getName());
                    return response;
                })
                .toList();
    }

    public GetByIdTagResponse getById(UUID id) {
        Tag tag = tagRepository.findById(id).orElseThrow();

        GetByIdTagResponse response = new GetByIdTagResponse();
        response.setId(tag.getId());
        response.setName(tag.getName());
        return response;
    }

    public UpdatedTagResponse update(UUID id, UpdateTagRequest request) {
        Tag tag = tagRepository.findById(id).orElseThrow();
        tag.setName(request.getName());
        tag = tagRepository.save(tag);

        UpdatedTagResponse response = new UpdatedTagResponse();
        response.setId(tag.getId());
        response.setName(tag.getName());
        return response;
    }

    public void delete(UUID id) {
        tagRepository.deleteById(id);
    }
}
