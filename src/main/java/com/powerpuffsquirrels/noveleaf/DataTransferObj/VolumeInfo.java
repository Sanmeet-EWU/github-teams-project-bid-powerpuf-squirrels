package com.powerpuffsquirrels.noveleaf.DataTransferObj;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VolumeInfo {
    private String title;
    private List<String> authors;
    private String publisher;
    private String publishedDate;
    private String description;
    private Integer pageCount;
    private Double averageRating;
    private Integer ratingsCount;
    private ImageLinks imageLinks;

    // Getters and setters
    // ...
}
