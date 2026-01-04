package com.udgar.reactorfilesystem.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class FileGetService {

    public Flux<String> getFile(){
        return Flux.just("I", "am", "sparta");
    }
}
