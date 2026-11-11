package com.kiyuquilema.paquete;

import com.kiyuquilema.paquete.extensiones.ComprobanteExtensionPdf;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main implements QuarkusApplication{

    @Inject 
    TransferenciaService transfe;

    @Inject 
    ComprobanteExtensionPdf comprobanteExtension;


    public static void main(String[] args) {
        System.out.println("Hola Mundo");
        Quarkus.run(Main.class, args);
    }



    @Override
    public int run(String... args) throws Exception {

        Cuenta cuenta1 = new Cuenta("1234567890", 1000.0);
        Cuenta cuenta2 = new Cuenta("0987654321", 500.0);
        Transferencia transferencia = new Transferencia(cuenta1, cuenta2, 200.0, "correo@example.com", "093036485");

        transfe.realizarTransferencia(transferencia, comprobanteExtension);

        return 0;
    }


}
