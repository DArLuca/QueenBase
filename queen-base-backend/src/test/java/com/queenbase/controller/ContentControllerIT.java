package com.queenbase.controller;

import com.queenbase.entity.Content;
import com.queenbase.repository.ContentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ContentControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ContentRepository contentRepository;

    @BeforeEach
    void setup() {
        contentRepository.deleteAll();
    }

    @Test
    void testUploadContent() throws Exception {
        MockMultipartFile file = new MockMultipartFile(
                "file",
                "test.txt",
                MediaType.TEXT_PLAIN_VALUE,
                "Hello World".getBytes()
        );

        mockMvc.perform(multipart("/api/content/upload")
                        .file(file)
                        .param("title", "My File")
                        .param("type", "GAME"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("My File"))
                .andExpect(jsonPath("$.type").value("GAME"));

        // Verify it was actually saved
        List<Content> contents = contentRepository.findAll();
        assertEquals(1, contents.size());
        assertEquals("My File", contents.get(0).getTitle());
    }
}
