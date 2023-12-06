package com.prueba.prevalentware.controller;

import com.prueba.prevalentware.config.config.Exepcion;
import com.prueba.prevalentware.constante.Mensaje;
import com.prueba.prevalentware.entity.User;
import com.prueba.prevalentware.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    /**
     * Obtener todos los usuarios (users): Un endpoint que devuelva la información de todos los usuarios
     **/
    @GetMapping("/users")
    public ResponseEntity<?> getAllUser() {
        try {
            List<User> users = userRepository.findAllUsers();
            return new ResponseEntity<>(users,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(Mensaje.MENSAJE_ERROR, HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Obtener un usuario por correo electrónico: Un endpoint que devuelva la información de un usuario específico, identificado por su correo electrónico.
    **/
    @GetMapping("/users/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email){
        try {
            List<User> users = userRepository.findUserByEmail(email);
            return new ResponseEntity<>(users,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(Mensaje.MENSAJE_ERROR, HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Obtener todos los países (Countries): Este endpoint solo estará disponible para usuarios Admin o Manager, y devolverá información de todos los países.
     **/
    @GetMapping("/countries")
    public ResponseEntity<?> getAllCountry(){
        try {
            List<Object> objects = userRepository.findAllountry();
            return new ResponseEntity<>(objects,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(Mensaje.MENSAJE_ERROR, HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Obtener UserMonitoring de un usuario en un rango de tiempo: Este endpoint requerirá el correo
     * del usuario, la fecha inicial y la fecha final del rango de búsqueda para devolver los datos de
     * UserMonitoring.
    **/
    @GetMapping("/UserMonitoring/{email}")
    public ResponseEntity<?> getAllUserMonitoring(@PathVariable String email){
        try {
            List<Object> objects = userRepository.findUserMonitoringByRanchTime(email);
            return new ResponseEntity<>(objects,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(Mensaje.MENSAJE_ERROR, HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Obtener los tres usuarios con más registros en UserMonitoring en un rango de tiempo específico:
     * Este endpoint, reservado para administradores, requerirá la fecha inicial y la fecha final del rango
     * de búsqueda.
     **/
    @GetMapping("/users/three")
    public ResponseEntity<?> getThreeUsers(){
        try {
            List<Object> objects = userRepository.findthreeUser();
            return new ResponseEntity<>(objects,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(Mensaje.MENSAJE_ERROR, HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Obtener los principales usuarios por tipo de uso en un país específico en un rango de tiempo: Este
     * endpoint, también reservado para administradores, requerirá el tipo de monitoreo (signIn, print,
     * share), el ID del país y el rango de fechas para la búsqueda.
     **/
    @GetMapping("/users/type")
    public ResponseEntity<?> getUserType(){
        try {
            List<Object> objects = userRepository.findTypePais();
            return new ResponseEntity<>(objects,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(Mensaje.MENSAJE_ERROR, HttpStatus.NOT_FOUND);
        }
    }
}
