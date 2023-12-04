package com.prueba.prevalentware.entity;

import com.prueba.prevalentware.ENUM.CountryEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

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
    @Enumerated(EnumType.STRING)
    private CountryEnum countryName;
    @Column(name = "createdAt")
    private Timestamp createdAt;
    @Column(name = "updatedAt")
    private Timestamp updatedAt;
    @ManyToMany(mappedBy = "countries")
    private List<User> users;
}
