package com.mx.Denominacion.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Denominacion.Entity.Denominacion;
import com.mx.Denominacion.Repository.IDenominacionRepository;

@Service
public class DenominacionService {
	@Autowired
	private IDenominacionRepository denominacionRepository;
	
	public String realizarRetiro(Double montoSolicitado) {
        List<String> denominacionesEntregadas = new ArrayList<>();
        Double montoRestante = montoSolicitado;

        List<Denominacion> denominaciones = denominacionRepository.findAll();
        for (Denominacion denom : denominaciones) {
            int cantidadBilletes = (int) (montoRestante / denom.getDenominacion());
            if (cantidadBilletes > denom.getCantidad()) {
                cantidadBilletes = denom.getCantidad();
            }
            if (cantidadBilletes > 0) {
                denominacionesEntregadas.add(cantidadBilletes + " billetes de $" + denom.getDenominacion());
                montoRestante -= cantidadBilletes * denom.getDenominacion();
                denom.setCantidad(denom.getCantidad() - cantidadBilletes);
                denominacionRepository.save(denom);
            }
            if (montoRestante == 0) break;
        }

        if (montoRestante > 0) {
            return "No se pudo entregar la cantidad solicitada con las denominaciones disponibles.";
        }

        // Registrar transacción
        String denominacionesStr = String.join(", ", denominacionesEntregadas);
        registrarTransaccion(montoSolicitado, denominacionesStr);

        return "Retiro exitoso: " + denominacionesStr;
    }

    private void registrarTransaccion(Double monto, String denominaciones) {
        // Aquí se registraría la transacción en la base de datos
        // Se puede utilizar una entidad de transacción para ello
    }
	

}
