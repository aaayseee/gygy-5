package com.turkcell.library_system.dto;

import java.util.UUID;

public class GetByIdShelfResponse {
    private UUID id;
    private String shelfCode;
    private Integer floor;
    private String section;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getShelfCode() { return shelfCode; }
    public void setShelfCode(String shelfCode) { this.shelfCode = shelfCode; }
    public Integer getFloor() { return floor; }
    public void setFloor(Integer floor) { this.floor = floor; }
    public String getSection() { return section; }
    public void setSection(String section) { this.section = section; }

}
