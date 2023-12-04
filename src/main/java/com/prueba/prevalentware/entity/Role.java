package com.prueba.prevalentware.entity;

import com.prueba.prevalentware.ENUM.Enum_RoleName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name", nullable = false)
    @Enumerated(EnumType.STRING)
    private Enum_RoleName roleName;
    @OneToMany(mappedBy = "rol")
    private List<User> users;
}
