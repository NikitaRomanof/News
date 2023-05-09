package com.news.news.controller;

import com.news.news.model.DtoModelNews;
import com.news.news.service.NewsService;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.validation.constraints.NotNull;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

// Main controller.
@Controller
public class MainController {
    private final NewsService service;
    public MainController(NewsService service) {
        this.service = service;
    }

    // Mapping of the main page.
    @GetMapping("/")
    public String home(@NotNull Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {

        //  Getting all fields of a table.
        List<DtoModelNews> trModel = service.getAllNews();

        //  Getting the current page number.
        Pageable paging = PageRequest.of(page - 1, size);

        //  Calculate the number of elements on the current page.
        int currentPage = paging.getPageNumber() + 1;
        long totalItems = trModel.size();
        int pageSize = paging.getPageSize();
        long totalPages = totalItems % pageSize == 0 ? totalItems / pageSize : totalItems / pageSize + 1;
        int startItem = paging.getPageNumber() * pageSize;
        int toIndex = Math.min(startItem + pageSize, trModel.size());

        //  Trim the extra elements and leave only the elements on the current page.
        trModel = trModel.subList(startItem, toIndex);

        //  Adding all calculated parameters to the model.
        model.addAttribute("news", trModel);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pageSize", pageSize);
        return "home";
    }
}
