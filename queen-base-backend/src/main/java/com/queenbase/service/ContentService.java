package com.queenbase.service;

import com.queenbase.entity.Content;
import com.queenbase.entity.ContentType;
import com.queenbase.repository.ContentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ContentService {

    private final ContentRepository repository;
    private final String baseFolder = "data/";

    public ContentService(ContentRepository repository) {
        this.repository = repository;
    }

    public Content saveContent(String title, String type, MultipartFile file) throws IOException{
        String folder = switch (type) {
            case "GAME" -> "games/";
            case "VARIANT" -> "variants/";
            case "THEORY" -> "theories/";
            default -> "others/";
        };

        File dir = new File(baseFolder + folder);
        if (!dir.exists()) dir.mkdirs();

       String filePath = folder + file.getOriginalFilename();
       File dest = new File(baseFolder + filePath);
       file.transferTo(dest);

       Content content = new Content();
       content.setTitle(title);
       content.setType(ContentType.valueOf(type));
       content.setFilePath(filePath);


       return repository.save(content);
    }

    public List<Content> findAll() {
        return repository.findAll();
    }
}
