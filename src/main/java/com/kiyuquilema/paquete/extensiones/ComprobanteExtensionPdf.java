package com.kiyuquilema.paquete.extensiones;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped 
public class ComprobanteExtensionPdf implements ComprobanteExtension {

    @Override
    public void enviarComprobante(String destinatario, String mensaje) {
        // Lógica para enviar el comprobante en formato PDF
        System.out.println("Enviando comprobante en PDF a " + destinatario + " con el mensaje: " + mensaje);
    }

}
