package com.prueba.prevalentware.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "UserMonitoring")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserMonitoring {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "usage")
    private Long usage;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    @Column(name = "createdAt")
    private Timestamp timestamp;
}
