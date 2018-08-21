package com.sgomezr.msusermanagement.Msusermanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")

public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name = "idUser")
    private Long idUser;

    @Column(name = "user")
    private String user;

    @Column(name = "pass")
    private String pass;

}
