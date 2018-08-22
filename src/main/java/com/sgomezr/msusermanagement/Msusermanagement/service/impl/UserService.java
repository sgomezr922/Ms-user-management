package com.sgomezr.msusermanagement.Msusermanagement.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sgomezr.msusermanagement.Msusermanagement.entity.UserEntity;
import com.sgomezr.msusermanagement.Msusermanagement.feign.IFeignProduct;
import com.sgomezr.msusermanagement.Msusermanagement.repository.IUserRepository;
import com.sgomezr.msusermanagement.Msusermanagement.service.IUsersService;
import com.sgomezr.msusermanagement.Msusermanagement.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUsersService {

    @Autowired
    IUserRepository userRepository;

    /*@Autowired
    IFeignProduct feignProduct;*/

    @Override
    public UserDTO createUser(String user, String pass) {
        UserEntity userEntity = new UserEntity(null, user, pass);
        UserEntity result = userRepository.save(userEntity);

        return new UserDTO(result.getIdUser(), result.getUser(), result.getPass());
    }

    @Override
    public List<UserDTO> getUsersList() {
        return null;
    }

    @Override
    public UserDTO getUser(String user, String pass) {
        UserEntity userEntity = userRepository.findUserEntityByUserAndPass(user, pass);
        return new UserDTO(userEntity.getIdUser(), userEntity.getUser(), userEntity.getPass());
    }

    @Override
    public UserDTO getUser(Long idUser) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(idUser);
        UserDTO userDTO = null;
        if(userEntityOptional.isPresent()){
            userDTO = new UserDTO(
                    userEntityOptional.get().getIdUser(),
                    userEntityOptional.get().getUser(),
                    userEntityOptional.get().getPass()
            );
        }
        return userDTO;
    }

    @Override
    public UserDTO updateUser(UserDTO updatedUser) {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "deleteUserDefault")
    public UserDTO deleteUser(Long idUser) {
        //userRepository.deleteById(idUser);
       /*feignProduct.deleteProductByIdUser(idUser);*/
        new RestTemplate().delete("http.//localhost:8765/ms-product-management/product/{idUser}", idUser);
        return new UserDTO();
    }

    public UserDTO deleteUserDefault(Long idUser){
        System.out.println("Error");
        return null;
    }
}
