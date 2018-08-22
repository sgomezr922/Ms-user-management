package com.sgomezr.msusermanagement.Msusermanagement.web.rest;

import com.sgomezr.msusermanagement.Msusermanagement.service.IUsersService;
import com.sgomezr.msusermanagement.Msusermanagement.web.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@RestController
public class UserResource {
    @Autowired
    IUsersService usersService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Void> getStatus(){
        System.out.println("/status");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public ResponseEntity getHealt() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody UserDTO userDTO) throws URISyntaxException {

        log.info("User received: {}", userDTO.toString());
        UserDTO result = usersService.createUser(userDTO.getUser(), userDTO.getPass());
        String location = String.format("http://localhost:8089/user/%s", result.getIdUser());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(new URI(location));
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/user/{idUser}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long idUser){
        System.out.println(idUser);
        return ResponseEntity.ok(usersService.getUser(idUser));
    }

    @RequestMapping(value = "/user/{user}/{pass}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getRegisteredUser(@PathVariable String user, @PathVariable String pass) {
        UserDTO userDTO = usersService.getUser(user, pass);
        return ResponseEntity.ok(userDTO);
    }

    @RequestMapping(value = "/user/{idUser}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUserAndAllItsProducts(@PathVariable Long idUser){
        usersService.deleteUser(idUser);
        return ResponseEntity.ok("All is OK!...");
    }

}
