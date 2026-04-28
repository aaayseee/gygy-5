package com.turkcell.library_system.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.library_system.dto.*;
import com.turkcell.library_system.entity.Shelf;
import com.turkcell.library_system.repository.ShelfRepository;

@Service
public class ShelfServiceImpl {
    private final ShelfRepository shelfRepository;

    public ShelfServiceImpl(ShelfRepository shelfRepository) {
        this.shelfRepository = shelfRepository;
    }

    public CreatedShelfResponse create(CreateShelfRequest request) {
        Shelf shelf = new Shelf();
        shelf.setShelfCode(request.getShelfCode());
        shelf.setFloor(request.getFloor());
        shelf.setSection(request.getSection());
        shelf = shelfRepository.save(shelf);

        CreatedShelfResponse response = new CreatedShelfResponse();
        response.setId(shelf.getId());
        response.setShelfCode(shelf.getShelfCode());
        response.setFloor(shelf.getFloor());
        response.setSection(shelf.getSection());
        return response;
    }

    public List<ListShelfResponse> getAll() {
        return shelfRepository.findAll()
                .stream()
                .map(shelf -> {
                    ListShelfResponse response = new ListShelfResponse();
                    response.setId(shelf.getId());
                    response.setShelfCode(shelf.getShelfCode());
                    response.setFloor(shelf.getFloor());
                    response.setSection(shelf.getSection());
                    return response;
                })
                .toList();
    }

    public GetByIdShelfResponse getById(UUID id) {
        Shelf shelf = shelfRepository.findById(id).orElseThrow();

        GetByIdShelfResponse response = new GetByIdShelfResponse();
        response.setId(shelf.getId());
        response.setShelfCode(shelf.getShelfCode());
        response.setFloor(shelf.getFloor());
        response.setSection(shelf.getSection());
        return response;
    }

    public UpdatedShelfResponse update(UUID id, UpdateShelfRequest request) {
        Shelf shelf = shelfRepository.findById(id).orElseThrow();
        shelf.setShelfCode(request.getShelfCode());
        shelf.setFloor(request.getFloor());
        shelf.setSection(request.getSection());
        shelf = shelfRepository.save(shelf);

        UpdatedShelfResponse response = new UpdatedShelfResponse();
        response.setId(shelf.getId());
        response.setShelfCode(shelf.getShelfCode());
        response.setFloor(shelf.getFloor());
        response.setSection(shelf.getSection());
        return response;
    }

    public void delete(UUID id) {
        shelfRepository.deleteById(id);
    }
}
