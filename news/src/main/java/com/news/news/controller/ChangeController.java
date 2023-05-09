package com.news.news.controller;

import com.news.news.model.ModelNews;
import com.news.news.service.NewsService;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

//  Controller for adding and removing news.
@Controller
public class ChangeController {
    private final NewsService service;
    public ChangeController(NewsService service) {
        this.service = service;
    }

    //  Page mapping with the form for adding news
    @GetMapping("/addNews")
    public String news(@NotNull Model model) {
        model.addAttribute("title", "Add news");
        return "addNews";
    }

    //  Mapping of adding news to the database.
    @PostMapping("/addNews")
    public String createNews(@RequestParam String title, @RequestParam LocalDate date,
                             @RequestParam String text, @RequestParam(required = false) MultipartFile file, Model model) {

        try {
            byte[] imageBytes = null;
            if (file != null) {
                imageBytes = file.getBytes();
            }
            service.create(new ModelNews(title, date, text, imageBytes));
        } catch (IOException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "redirect:/";
    }

    //  Mapping of the page with the news deletion form.
    @GetMapping("/delNews")
    public String deleteNews(@NotNull Model model) {
        model.addAttribute("news", service.getAllNews());
        return "deleteNews";
    }

    //  News deletion mapping.
    @GetMapping("/deleteNews/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/";
    }

}
