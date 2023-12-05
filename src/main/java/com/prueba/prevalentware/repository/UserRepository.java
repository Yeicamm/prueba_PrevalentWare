package com.prueba.prevalentware.repository;

import com.prueba.prevalentware.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    /**
    @Query("SELECT u FROM User u JOIN FETCH u.countries JOIN FETCH u.userMonitoringList WHERE u.rol = :roleId")
    User findByRoleIdWithCountriesAndMonitoring(@Param("roleId") String roleId);**/
    @Query(value = "SELECT id, email, \"emailVerified\", \"termsAndConditionsAccepted\", \"name\", image, \"position\", \"createdAt\", \"updatedAt\", \"roleId\" " +
            "FROM public.\"User\" " +
            "WHERE \"roleId\" = :roleId", nativeQuery = true)
    List<User> findByRoleId(String roleId);

}
