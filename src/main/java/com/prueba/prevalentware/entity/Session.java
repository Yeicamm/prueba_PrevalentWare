package com.prueba.prevalentware.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "Session")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Session {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "sessionToken")
    private String sessionToken;
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;
    @Column(name = "expiresAt")
    private Timestamp expiresAt;
    @Column(name = "createdAt")
    private Timestamp createdAt;

}
