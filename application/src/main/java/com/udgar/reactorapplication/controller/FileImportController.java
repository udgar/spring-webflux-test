package com.udgar.reactorapplication.controller;

import com.udgar.reactorapplication.service.FileImportService;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_PDF_VALUE;

@RestController
@RequestMapping("/api/v1/file")
public class FileImportController {

    private final FileImportService service;

    public FileImportController(FileImportService service) {
        this.service = service;
    }

    @GetMapping(value = "/import", produces = APPLICATION_PDF_VALUE)
    private ResponseEntity<Flux<DataBuffer>> getFileContent() {
        return ResponseEntity.ok(service.fileImport());
    }
}
