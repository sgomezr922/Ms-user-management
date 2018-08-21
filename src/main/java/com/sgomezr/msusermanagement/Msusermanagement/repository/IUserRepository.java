package com.sgomezr.msusermanagement.Msusermanagement.repository;


import com.sgomezr.msusermanagement.Msusermanagement.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUserRepository extends JpaRepository <UserEntity,Long> {
    @Query(value = "SELECT * FROM user WHERE user = :user AND pass = :pass", nativeQuery = true)
    UserEntity findUserEntityByUserAndPass(@Param("user") String user, @Param("pass") String pass);

}
