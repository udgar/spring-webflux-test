package com.udgar.reactorapplication.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class FileImportService {

    public Flux<String> fileImport(){
        return Flux.just("This", "is","Sparta");
    }
}
