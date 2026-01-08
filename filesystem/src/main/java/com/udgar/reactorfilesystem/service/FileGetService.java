package com.udgar.reactorfilesystem.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class FileGetService {

    public Flux<DataBuffer> getFileFormPath() {
        Resource resource = new ClassPathResource("data/Report.pdf");
        return DataBufferUtils.read(resource, new DefaultDataBufferFactory(), 4096);
    }
}
