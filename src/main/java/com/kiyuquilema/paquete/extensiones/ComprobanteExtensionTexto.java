package com.kiyuquilema.paquete.extensiones;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped 
public class ComprobanteExtensionTexto implements ComprobanteExtension {

    @Override
    public void enviarComprobante(String destinatario, String mensaje) {
        // Lógica para enviar el comprobante en formato de texto
        System.out.println("Enviando comprobante en texto a " + destinatario + " con el mensaje: " + mensaje);
    }

}
