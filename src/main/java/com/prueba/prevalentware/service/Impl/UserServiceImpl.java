package com.prueba.prevalentware.service.Impl;

import com.prueba.prevalentware.entity.User;
import com.prueba.prevalentware.repository.UserRepository;
import com.prueba.prevalentware.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getUserRol(String roleId) {
        return userRepository.findByRoleId(roleId);
    }
    /**@Override
    public User findByRoleIdWithCountriesAndMonitoring(String roleId) {
        return userRepository.findByRoleIdWithCountriesAndMonitoring(roleId);
    }**/
}
