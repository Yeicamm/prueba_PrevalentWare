package com.prueba.prevalentware.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "_CountryToUser")
@Data
public class _CountryToUser implements Serializable {
    @Id
    private String A;
    @Id
    private String B;

}
