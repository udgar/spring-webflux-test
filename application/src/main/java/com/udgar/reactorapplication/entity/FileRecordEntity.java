package com.udgar.reactorapplication.entity;


import lombok.Data;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "file_record")
@Data
public class FileRecordEntity {
    @Id
    private Long id;
    @Column("file_name")
    private String fileName;
    @Column("file_content")
    private DataBuffer blobFile;
}
