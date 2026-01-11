package com.udgar.reactorapplication.service;

import com.udgar.reactorapplication.entity.FileRecordEntity;
import com.udgar.reactorapplication.repository.FileEntityRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.UUID;

import static reactor.core.publisher.Flux.just;

@Service
public class FileImportService {

    @Value("${filesystem.file-import.url}")
    private String fileSystemUrl;

    private final WebClient.Builder builder;

    private final FileEntityRepository repository;

    public FileImportService(WebClient.Builder builder, FileEntityRepository repository) {
        this.builder = builder;
        this.repository = repository;
    }

    public Flux<DataBuffer> fileImport() {
        WebClient client = builder.baseUrl(fileSystemUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
                .build();
        FileRecordEntity entity = new FileRecordEntity();
        entity.setFileName(UUID.randomUUID() + ".pdf");
        return client.get().accept(MediaType.APPLICATION_PDF).exchangeToFlux(response -> {
            var fluxBody = response.bodyToFlux(DataBuffer.class);
            return fluxBody.flatMap(body -> {
                entity.setBlobFile(body);
                return just(body);
            }).doOnComplete(()->{
                repository.save(entity);
            });
        });
    }
}
