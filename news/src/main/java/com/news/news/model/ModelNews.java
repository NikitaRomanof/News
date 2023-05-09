package com.news.news.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDate;

// Model news. Set the table name and column names from the database.
@Table(name = "news")
public class ModelNews {
    @Id
    private Long id;
    @Column("title")
    private String title;
    @Column("dt")
    private LocalDate date;
    @Column("body")
    private String text;
    @Column("image")
    private byte[] image;

    public ModelNews(String title, LocalDate date, String text, byte[] image) {
        this.title = title;
        this.date = date;
        this.text = text;
        this.image = image;
    }

    public ModelNews() {
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
