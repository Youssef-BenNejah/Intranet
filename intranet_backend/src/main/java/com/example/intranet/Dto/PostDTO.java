package com.example.intranet.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class PostDTO {
    private String name;
    private String type;
    private String path;
    private byte[] fileData;
    private Date timestamp;
    public PostDTO() {
    }
}
