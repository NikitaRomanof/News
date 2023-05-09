package com.news.news;

import com.news.news.model.DtoModelNews;
import com.news.news.model.ModelNews;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DtoModelTest {

    @Test
    public void testToDtoNullImage() {
        ModelNews modelEntity = new ModelNews("title", LocalDate.now(), "body text", null);
        DtoModelNews dtoModel = new DtoModelNews(modelEntity);
        assertEquals("title", dtoModel.getTitle());
        assertEquals(LocalDate.now(), dtoModel.getDate());
        assertEquals("body text", dtoModel.getText());
        assertEquals("", dtoModel.getEncoderImg());
    }

    @Test
    public void testToDtoNotNullImage() {
        byte[] img = {1, 2, 3};
        ModelNews modelEntity = new ModelNews("title", LocalDate.now(), "body text", img);
        DtoModelNews dtoModel = new DtoModelNews(modelEntity);
        assertEquals("title", dtoModel.getTitle());
        assertEquals(LocalDate.now(), dtoModel.getDate());
        assertEquals("body text", dtoModel.getText());
        assertEquals("data:image/jpeg;base64,AQID", dtoModel.getEncoderImg());
    }

}
