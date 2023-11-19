package com.example.intranet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String name;
    private String type;
    private String path;
    @Temporal(TemporalType.TIMESTAMP)

    private Date timestamp;

    @PrePersist
    private void cuurentDate() {
        timestamp = new Date();
    }


    public Post() {

    }}


