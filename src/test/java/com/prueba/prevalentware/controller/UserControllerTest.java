package com.prueba.prevalentware.controller;

import com.prueba.prevalentware.constante.Mensaje;
import com.prueba.prevalentware.entity.User;
import com.prueba.prevalentware.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

class UserControllerTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void getAllUser() {
        List<User> mockUsers = Arrays.asList(new User(), new User());
        Mockito.when(userRepository.findAllUsers()).thenReturn(mockUsers);

        ResponseEntity<?> response = userController.getAllUser();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockUsers, response.getBody());
    }


    @Test
    void getUserByEmail() {
        List<User> mockUsers = Arrays.asList(new User());
        Mockito.when(userRepository.findUserByEmail(anyString())).thenReturn(mockUsers);

        ResponseEntity<?> response = userController.getUserByEmail("sophia.gonzalez@test.com");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockUsers, response.getBody());
    }

    @Test
    void getAllCountry() {
        List<Object> mockCountries = Arrays.asList();
        Mockito.when(userRepository.findAllountry()).thenReturn(mockCountries);

        ResponseEntity<?> response = userController.getAllCountry();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockCountries, response.getBody());
    }

    @Test
    void getAllUserMonitoring() {
        List<Object> mockUserMonitoring = Arrays.asList();
        Mockito.when(userRepository.findUserMonitoringByRanchTime(anyString())).thenReturn(mockUserMonitoring);

        ResponseEntity<?> response = userController.getAllUserMonitoring("sophia.gonzalez@test.com");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockUserMonitoring, response.getBody());
    }

    @Test
    void getThreeUsers() {
        List<Object> mockTopUsers = Arrays.asList();
        Mockito.when(userRepository.findthreeUser()).thenReturn(mockTopUsers);

        ResponseEntity<?> response = userController.getThreeUsers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockTopUsers, response.getBody());
    }

    @Test
    void getUserType() {
        List<Object> mockUsersByType = Arrays.asList();
        Mockito.when(userRepository.findTypePais()).thenReturn(mockUsersByType);

        ResponseEntity<?> response = userController.getUserType();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockUsersByType, response.getBody());
    }
    @Test
    void getAllUserError() {
        Mockito.when(userRepository.findAllUsers()).thenThrow(new RuntimeException(Mensaje.MENSAJE_ERROR));

        ResponseEntity<?> response = userController.getAllUser();

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(Mensaje.MENSAJE_ERROR, response.getBody());
    }
    @Test
    void getUserByEmailError() {
        Mockito.when(userRepository.findUserByEmail("sophia.gonzalez@test.com")).thenThrow(new RuntimeException(Mensaje.MENSAJE_ERROR));

        ResponseEntity<?> response = userController.getUserByEmail("sophia.gonzalez@test.com");

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(Mensaje.MENSAJE_ERROR, response.getBody());
    }
    @Test
    void getAllCountryError() {
        Mockito.when(userRepository.findAllountry()).thenThrow(new RuntimeException(Mensaje.MENSAJE_ERROR));

        ResponseEntity<?> response = userController.getAllCountry();

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(Mensaje.MENSAJE_ERROR, response.getBody());
    }
    @Test
    void getAllUserMonitoringError() {
        Mockito.when(userRepository.findUserMonitoringByRanchTime("sophia.gonzalez@test.com")).thenThrow(new RuntimeException(Mensaje.MENSAJE_ERROR));

        ResponseEntity<?> response = userController.getAllUserMonitoring("sophia.gonzalez@test.com");

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(Mensaje.MENSAJE_ERROR, response.getBody());
    }
    @Test
    void getThreeUsersError() {
        Mockito.when(userRepository.findthreeUser()).thenThrow(new RuntimeException(Mensaje.MENSAJE_ERROR));

        ResponseEntity<?> response = userController.getThreeUsers();

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(Mensaje.MENSAJE_ERROR, response.getBody());
    }
    @Test
    void getUserTypeError() {
        Mockito.when(userRepository.findTypePais()).thenThrow(new RuntimeException(Mensaje.MENSAJE_ERROR));

        ResponseEntity<?> response = userController.getUserType();

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(Mensaje.MENSAJE_ERROR, response.getBody());
    }

}