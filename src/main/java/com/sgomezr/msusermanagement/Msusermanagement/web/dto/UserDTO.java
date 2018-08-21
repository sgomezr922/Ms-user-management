package com.sgomezr.msusermanagement.Msusermanagement.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long idUser;
    private String user;
    private String pass;
}
