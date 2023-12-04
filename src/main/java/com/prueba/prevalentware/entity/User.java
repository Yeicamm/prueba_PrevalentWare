package com.prueba.prevalentware.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    private String id;
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
    @OneToMany(mappedBy = "user")
    private List<UserMonitoring> userMonitoringList;
    @ManyToOne
    @JoinColumn(name = "rol", referencedColumnName = "id")
    private Role rol;
    @ManyToMany
    @JoinTable(
            name = "_CountryToUser",
            joinColumns = @JoinColumn(name = "A"),
            inverseJoinColumns = @JoinColumn(name = "B")
    )
    private List<Country> countries;
}
