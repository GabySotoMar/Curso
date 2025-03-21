package com.mx.Denominacion.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Denominacion.Service.DenominacionService;

@RestController
@RequestMapping("/Cajero")
@CrossOrigin("*")
public class DenominacionController {
	@Autowired
    private DenominacionService denominacionService;

	//http://localhost:8006/Cajero/retiro
    @PostMapping("/retiro")
    public String realizarRetiro(@Param("monto") double monto) {
        return denominacionService.realizarRetiro(monto);
    }

}
