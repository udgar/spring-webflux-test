package com.udgar.reactorfilesystem.controller;

import com.udgar.reactorfilesystem.service.FileGetService;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequestMapping("/api/v1/file-import")
public class FileController {

    private final FileGetService service;

    public FileController(FileGetService service) {
        this.service = service;
    }

    @GetMapping(value = "/import",produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<Flux<DataBuffer>> getFile() {
        return ResponseEntity.ok(service.getFileFormPath());
    }
}
