package com.kiyuquilema.paquete;

import com.kiyuquilema.paquete.extensiones.ComprobanteExtension;
import com.kiyuquilema.paquete.interceptores.Auditoria;
import com.kiyuquilema.paquete.interceptores.MedirTiempo;
import com.kiyuquilema.paquete.interceptores.Validar;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped 
public class TransferenciaService {

    @Inject
    private CuentaService cuentaService; 

    @Inject 
    @Named ("correo")
    private Canal correocanal;

    @Inject 
    @Named ("sms")
    private Canal smsCanal;

    @Validar
    @Auditoria
    @MedirTiempo 
    public void realizarTransferencia(Transferencia transferencia, ComprobanteExtension comprobanteExtension) {

        System.out.println("Realizando transferencia de " + transferencia.getMonto() + " desde la cuenta " + transferencia.getCuentaOrigen().getNumeroCuenta() + " a la cuenta " + transferencia.getCuentaDestino().getNumeroCuenta());
        cuentaService.descontarSaldo(transferencia.getCuentaOrigen(), transferencia.getMonto());
        cuentaService.agregarSaldo(transferencia.getCuentaDestino(), transferencia.getMonto());
        comprobanteExtension.enviarComprobante(transferencia.getCorreo(), "Transferencia realizada con éxito.");

        correocanal.enviar(transferencia.getCorreo(), "Transferencia realizada con éxito.");
        smsCanal.enviar(transferencia.getTelefono(), "Transferencia realizada con éxito.");

    }



}
