package com.news.news.model;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.time.LocalDate;

// Transfer object. Send the values of the table fields to the template.
public class DtoModelNews {
    public DtoModelNews(ModelNews modelEntity) {
        id = modelEntity.getId();
        title = modelEntity.getTitle();
        date = modelEntity.getDate();
        text = modelEntity.getText();
        if (modelEntity.getImage() != null) {

            // Convert an image from an array of bytes to a Base64 string
            String base64Encoded = new String(Base64.getEncoder().encode(modelEntity.getImage()), StandardCharsets.UTF_8);
            encoderImg = String.format("data:image/jpeg;base64,%s", base64Encoded);

        } else {
            encoderImg = "";
        }

    }
    private Long id;

    private String title;

    private LocalDate date;

    private String text;

    private String encoderImg;

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

    public String getEncoderImg() {
        return encoderImg;
    }

    public void setEncoderImg(String encoderImg) {
        this.encoderImg = encoderImg;
    }
}
