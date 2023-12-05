package com.prueba.prevalentware.entity;

import com.prueba.prevalentware.ENUM.Enum_RoleName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name", nullable = false)
    @Enumerated(EnumType.STRING)
    private Enum_RoleName roleName;
    @Column(name = "createdAt")
    private Timestamp createdAt;
}
