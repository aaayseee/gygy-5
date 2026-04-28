package com.turkcell.library_system.dto;

import java.util.UUID;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateBookRequest {
    @NotNull(message = "Yazar ID boş olamaz.")
    private UUID authorId;

    @NotNull(message = "Kategori ID boş olamaz.")
    private UUID categoryId;

    @NotNull(message = "Raf ID boş olamaz.")
    private UUID shelfId;

    @NotBlank(message = "ISBN boş olamaz.")
    @Size(max = 20, message = "ISBN en fazla 20 karakter olabilir.")
    private String isbn;

    @NotBlank(message = "Kitap adı boş olamaz.")
    @Size(max = 255, message = "Kitap adı en fazla 255 karakter olabilir.")
    private String title;

    private Integer publishYear;

    @Size(max = 100, message = "Yayınevi en fazla 100 karakter olabilir.")
    private String publisher;

    @Size(max = 30, message = "Dil en fazla 30 karakter olabilir.")
    private String language;

    @Min(value = 1, message = "Sayfa sayısı en az 1 olmalıdır.")
    private Integer pageCount;

    @Min(value = 1, message = "Toplam kopya sayısı en az 1 olmalıdır.")
    private Integer totalCopies;

    @Min(value = 0, message = "Mevcut kopya sayısı 0'dan küçük olamaz.")
    private Integer availableCopies;

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
