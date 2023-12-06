package com.prueba.prevalentware.repository;

import com.prueba.prevalentware.entity.Country;
import com.prueba.prevalentware.entity.User;
import com.prueba.prevalentware.entity.UserMonitoring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    /**
     * Obtener todos los usuarios (users):
     * Un endpoint que devuelva la información de todos los usuarios
     *
     **/
    @Query(value = "SELECT u.*, r.name, c.name, mo.usage, mo.description FROM \"User\" u INNER JOIN \"Role\" r ON u.\"roleId\" = r.id\n" +
            "INNER JOIN public.\"_CountryToUser\" CTU on u.id = CTU.\"B\"\n" +
            "INNER JOIN \"Country\" c On CTU.\"A\" = c.id\n" +
            "INNER JOIN \"UserMonitoring\" mo on mo.\"userId\" = u.id\n" +
            "WHERE\n" +
            "\"roleId\" = 'cllpn1mfp0002387eeudeornd'\n" +
            ";\n", nativeQuery = true)
    List<User> findAllUsers();
    /**
     * Obtener un usuario por correo electrónico:
     * Un endpoint que devuelva la información de un usuario específico, identificado por su correo electrónico.
     *
     **/
    @Query(value = "Select Distinct  u.*,c.name From \"User\" u INNER JOIN public.\"_CountryToUser\" CTU on u.id = CTU.\"B\"\n" +
            "INNER JOIN \"Country\" c On CTU.\"A\" = c.id\n" +
            "WHERE u.email =  :email ", nativeQuery = true)
    List<User> findUserByEmail(@Param("email") String email);
    /**
     * Obtener todos los países (Countries):
     * Este endpoint solo estará disponible para usuarios Admin o Manager, y devolverá información de todos los países.
     *
     **/
    @Query(value = "SELECT * FROM public.\"Country\" c", nativeQuery = true)
    List<Object> findAllountry();
    /**
     * Obtener UserMonitoring de un usuario en un rango de tiempo: Este endpoint requerirá el correo
     * del usuario, la fecha inicial y la fecha final del rango de búsqueda para devolver los datos de
     * UserMonitoring.
     **/
    @Query(value = "SELECT um.*\n" +
            "FROM \"UserMonitoring\" um\n" +
            "JOIN \"User\" u ON um.\"userId\" = u.id\n" +
            "WHERE u.email = :email\n" +
            "  AND um.\"createdAt\" BETWEEN '2023-03-24 00:00:00.000' AND '2023-04-05 00:00:00.000' ", nativeQuery = true)
    List<Object> findUserMonitoringByRanchTime(@Param("email") String email);
    /**
     * Obtener los tres usuarios con más registros en UserMonitoring en un rango de tiempo específico:
     * Este endpoint, reservado para administradores, requerirá la fecha inicial y la fecha final del rango
     * de búsqueda.
     **/
    @Query(value = "SELECT u.name AS user_name, u.email AS user_email, COUNT(um.id) AS total_registros\n" +
            "FROM \"User\" u\n" +
            "JOIN \"UserMonitoring\" um ON u.id = um.\"userId\"\n" +
            "WHERE um.\"createdAt\" BETWEEN '2023-03-24 00:00:00.000' AND '2023-04-05 00:00:00.000'\n" +
            "GROUP BY u.id, u.email\n" +
            "ORDER BY total_registros DESC\n" +
            "LIMIT 3;\n ", nativeQuery = true)
    List<Object> findthreeUser();

    /**
     * Obtener los principales usuarios por tipo de uso en un país específico en un rango de tiempo: Este
     * endpoint, también reservado para administradores, requerirá el tipo de monitoreo (signIn, print,
     * share), el ID del país y el rango de fechas para la búsqueda.
     **/
    @Query(value = " SELECT u.name AS user_id, u.email AS user_email, COUNT(um.id) AS total_usos\n" +
            "FROM \"User\" u\n" +
            "INNER JOIN \"UserMonitoring\" um ON u.id = um.\"userId\"\n" +
            "INNER JOIN public.\"_CountryToUser\" CTU on u.id = CTU.\"B\"\n" +
            "INNER JOIN \"Country\" c On CTU.\"A\" = c.id\n" +
            "WHERE um.description = 'signIn'\n" +
            "  AND c.id = 'cl8x4en430024lk556a8z7jyg'\n" +
            "  AND um.\"createdAt\"  BETWEEN '2023-03-24 00:00:00.000' AND '2023-04-05 00:00:00.000'\n" +
            "GROUP BY u.name, u.email\n" +
            "ORDER BY total_usos DESC\n" +
            "LIMIT 3; ", nativeQuery = true)
    List<Object> findTypePais();
}
