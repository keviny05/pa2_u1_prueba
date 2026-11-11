package com.kiyuquilema.paquete;

import jakarta.inject.Named;
import jakarta.inject.Singleton;

@Singleton 
@Named("correo")
public class CorreoCanal implements Canal {

    @Override
    public void enviar(String destinatario, String mensaje) {
        System.out.println("Enviando correo a " + destinatario + ": " + mensaje);
    }

}
