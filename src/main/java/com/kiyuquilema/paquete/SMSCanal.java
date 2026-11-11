package com.kiyuquilema.paquete;

import jakarta.inject.Named;
import jakarta.inject.Singleton;

@Singleton 
@Named("sms")
public class SMSCanal implements Canal {

    @Override
    public void enviar(String destinatario, String mensaje) {
        System.out.println("Enviando SMS a " + destinatario + ": " + mensaje);
    }

}
