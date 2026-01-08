package com.udgar.reactorapplication.controller;

import com.udgar.reactorapplication.service.FileImportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import static org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE;

@RestController
@RequestMapping("/api/v1/file")
public class FileImportController {

    private final FileImportService service;

    public FileImportController(FileImportService service) {
        this.service = service;
    }

    @GetMapping(value = "/import", produces = TEXT_EVENT_STREAM_VALUE)
    private Flux<String> getFileContent() {
        return service.fileImport();
    }
}
