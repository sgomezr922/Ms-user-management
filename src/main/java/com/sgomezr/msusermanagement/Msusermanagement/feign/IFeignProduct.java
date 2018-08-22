package com.sgomezr.msusermanagement.Msusermanagement.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "ms-product-management")
public interface IFeignProduct {
    @RequestMapping(path = "/product/{idUser}", method = RequestMethod.DELETE)
    ResponseEntity<String> eliminarProductoByIdUsuario(@PathVariable("idUser") Long idUser);
}
