package com.udgar.reactorfilesystem.controller;

import com.udgar.reactorfilesystem.service.FileGetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/file-import")
public class FileController {

    private final FileGetService service;

    public FileController(FileGetService service) {
        this.service = service;
    }

    @GetMapping("/import")
    public Flux<String> getFile() {
        return service.getFile();
    }
}
