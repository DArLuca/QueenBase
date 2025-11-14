package com.queenbase.service;

import com.queenbase.entity.Content;
import com.queenbase.entity.ContentType;
import com.queenbase.repository.ContentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.mock.web.MockMultipartFile;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class ContentServiceTest {

    private ContentRepository repository;
    private ContentService service;

    @BeforeEach
    void setUp() {
        repository = mock(ContentRepository.class);
        service = new ContentService(repository);
    }

    @Test
    void saveContentShouldSetCorrectFields() throws IOException {
        MockMultipartFile file = new MockMultipartFile(
                "file", "game.pgn", "text/plain", "1.e4 e5".getBytes()
        );

        // Capture what gets saved
        ArgumentCaptor<Content> captor = ArgumentCaptor.forClass(Content.class);
        when(repository.save(captor.capture())).thenAnswer(i -> i.getArgument(0));

        service.saveContent("My Game", "GAME", file);

        Content saved = captor.getValue();
        assertEquals("My Game", saved.getTitle());
        assertEquals(ContentType.GAME, saved.getType());
        assertTrue(saved.getFilePath().contains("games/"));
    }

    @Test
    void saveContentShouldCreateFileOnFilesystem() throws IOException {
        MockMultipartFile file = new MockMultipartFile(
                "file", "game.pgn", "text/plain", "1.e4 e5".getBytes()
        );

        service.saveContent("My Game", "GAME", file);

        File savedFile = new File("data/games/game.pgn");
        assertTrue(savedFile.exists());

        // Cleanup after test
        savedFile.delete();
    }
}
