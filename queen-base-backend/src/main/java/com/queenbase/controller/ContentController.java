package com.queenbase.controller;

import com.queenbase.entity.Content;
import com.queenbase.service.ContentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentService service;

    public ContentController(ContentService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public ResponseEntity<Content> uploadContent(
            @RequestParam String title,
            @RequestParam String type,
            @RequestParam MultipartFile file
    ) throws IOException {
        Content content = service.saveContent(title, type, file);
        return ResponseEntity.ok(content);
    }

    @GetMapping
    public ResponseEntity<List<Content>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
