package com.prueba.prevalentware.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "email")
    private String email;
    @Column(name = "emailVerified")
    private String emailVerified;
    @Column(name = "termsAndConditionsAccepted")
    private String termsAndConditionsAccepted;
    @Column(name = "name")
    private String name;
    @Column(name = "image")
    private String image;
    @Column(name = "position")
    private String position;
    @Column(name = "createdAt")
    private Timestamp createdAt;
    @Column(name = "updatedAt")
    private Timestamp updatedAt;
    @Column(name = "roleId")
    private String roleId;
}
