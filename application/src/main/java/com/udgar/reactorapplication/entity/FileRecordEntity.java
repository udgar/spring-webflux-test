package com.udgar.reactorapplication.entity;


import io.r2dbc.spi.Blob;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "file_record")
public class FileRecordEntity {
    @Id
    private Long id;
    @Column("file_name")
    private String fileName;
    @Column("file_content")
    private Blob blobFile;
}
