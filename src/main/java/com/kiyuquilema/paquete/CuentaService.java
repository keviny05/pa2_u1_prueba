package com.kiyuquilema.paquete;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped 
public class CuentaService {

    public double descontarSaldo(Cuenta cuenta, double monto) {
        double nuevoSaldo = cuenta.getSaldo() - monto;
        cuenta.setSaldo(nuevoSaldo);
        return nuevoSaldo;
    }

    public double agregarSaldo(Cuenta cuenta, double monto) {
        double nuevoSaldo = cuenta.getSaldo() + monto;
        cuenta.setSaldo(nuevoSaldo);
        return nuevoSaldo;
    }

}
