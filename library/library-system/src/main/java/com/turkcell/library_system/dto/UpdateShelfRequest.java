package com.turkcell.library_system.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UpdateShelfRequest {
    @NotBlank(message = "Raf kodu boş olamaz.")
    @Size(max = 20, message = "Raf kodu en fazla 20 karakter olabilir.")
    private String shelfCode;

    private Integer floor;

    @Size(max = 50, message = "Bölüm adı en fazla 50 karakter olabilir.")
    private String section;

    public String getShelfCode() { return shelfCode; }
    public void setShelfCode(String shelfCode) { this.shelfCode = shelfCode; }
    public Integer getFloor() { return floor; }
    public void setFloor(Integer floor) { this.floor = floor; }
    public String getSection() { return section; }
    public void setSection(String section) { this.section = section; }
}
