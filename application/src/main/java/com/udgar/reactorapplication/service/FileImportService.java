package com.udgar.reactorapplication.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class FileImportService {

    @Value("${filesystem.file-import.url}")
    private String fileSystemUrl;

    private final WebClient.Builder builder;

    public FileImportService(WebClient.Builder builder) {
        this.builder = builder;
    }

    public Flux<DataBuffer> fileImport() {
        WebClient client = builder.baseUrl(fileSystemUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
                .build();
        return client.get().accept(MediaType.APPLICATION_PDF).exchangeToFlux(response -> response.bodyToFlux(DataBuffer.class));
    }
}
