package com.turkcell.library_system.dto;

import java.util.UUID;

public class CreatedBookResponse {
    private UUID id;
    private UUID authorId;
    private UUID categoryId;
    private UUID shelfId;
    private String isbn;
    private String title;
    private Integer publishYear;
    private String publisher;
    private String language;
    private Integer pageCount;
    private Integer totalCopies;
    private Integer availableCopies;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public UUID getAuthorId() { return authorId; }
    public void setAuthorId(UUID authorId) { this.authorId = authorId; }
    public UUID getCategoryId() { return categoryId; }
    public void setCategoryId(UUID categoryId) { this.categoryId = categoryId; }
    public UUID getShelfId() { return shelfId; }
    public void setShelfId(UUID shelfId) { this.shelfId = shelfId; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Integer getPublishYear() { return publishYear; }
    public void setPublishYear(Integer publishYear) { this.publishYear = publishYear; }
    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }
    public Integer getPageCount() { return pageCount; }
    public void setPageCount(Integer pageCount) { this.pageCount = pageCount; }
    public Integer getTotalCopies() { return totalCopies; }
    public void setTotalCopies(Integer totalCopies) { this.totalCopies = totalCopies; }
    public Integer getAvailableCopies() { return availableCopies; }
    public void setAvailableCopies(Integer availableCopies) { this.availableCopies = availableCopies; }

}
