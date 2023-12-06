package com.prueba.prevalentware.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "Country")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name", nullable = false)
    private String countryName;
    @Column(name = "createdAt")
    private Timestamp createdAt;
    @Column(name = "updatedAt")
    private Timestamp updatedAt;
}
