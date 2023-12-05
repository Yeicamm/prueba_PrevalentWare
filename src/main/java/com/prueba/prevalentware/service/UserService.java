package com.prueba.prevalentware.service;

import com.prueba.prevalentware.entity.User;

import java.util.List;

public interface UserService {
    //User findByRoleIdWithCountriesAndMonitoring(String rolId);

    List<User> getUserRol(String roleId);
}
