package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String content;
    private LocalDate createdAt;
    private Boolean published;

    // Default constructor (required for JPA)
    public Element() {
    }

    // Constructor with all fields except id (useful for creating new instances)
    public Element(String title, String description, String content, LocalDate createdAt, Boolean published) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.createdAt = createdAt;
        this.published = published;
    }

    // Constructor with all fields (useful for testing and manipulation)
    public Element(Long id, String title, String description, String content, LocalDate createdAt, Boolean published) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.createdAt = createdAt;
        this.published = published;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    // Override toString (optional, for debugging purposes)
    @Override
    public String toString() {
        return "Element{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                ", published=" + published +
                '}';
    }
}
