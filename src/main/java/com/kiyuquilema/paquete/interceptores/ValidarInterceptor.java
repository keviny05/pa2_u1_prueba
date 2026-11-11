package com.kiyuquilema.paquete.interceptores;

import com.kiyuquilema.paquete.Cuenta;
import com.kiyuquilema.paquete.Transferencia;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Validar 
@Interceptor 
@Priority (Interceptor.Priority.APPLICATION + 1)
public class ValidarInterceptor {
    

    @AroundInvoke 
    public Object intercept(InvocationContext context) throws Exception {
        System.out.println("Validando antes de ejecutar el método: " + context.getMethod().getName());

        Object[] valores = context.getParameters();
        Transferencia transferencia = (Transferencia) valores[0];

        Cuenta cuentaOrigen = transferencia.getCuentaOrigen();
        double monto = transferencia.getMonto();

        if (cuentaOrigen.getSaldo() < monto || monto <= 0) {
            throw new IllegalArgumentException("Saldo insuficiente en la cuenta de origen.");
        }
        System.out.println("Validación exitosa: Saldo suficiente en la cuenta de origen.");

        Object result = context.proceed();

        System.out.println("Método ejecutado: " + context.getMethod().getName());

        return result;
    }

}
