package com.sgomezr.msusermanagement.Msusermanagement.service;
import com.sgomezr.msusermanagement.Msusermanagement.web.dto.UserDTO;

import java.util.List;

public interface IUsersService {
    /**
     * Metodo para crear un usuario en la base de datos
     * @param user
     * @param pass
     * @return
     */
    UserDTO createUser(String user, String pass);

    /**
     * Method to create a user in the database (H2 in this case)
     * @return
     */
    List<UserDTO> getUsersList();

    /**
     * Method that returns a user given its user and pass
     * @param user
     * @param pass
     * @return
     */
    UserDTO getUser(String user, String pass);

    /**
     * Method that returns a given user id
     * @param idUser
     * @return
     */
    UserDTO getUser(Long idUser);

    /**
     * Method that updates a given user
     * @param userUpdated
     * @return
     */
    UserDTO updateUser(UserDTO userUpdated);

    /**
     * Method that deletes a given user and detonates the deletion of all
     * your data calling other dependent services.
     * @param idUser
     * @return
     */
    UserDTO deleteUser(Long idUser);
}
