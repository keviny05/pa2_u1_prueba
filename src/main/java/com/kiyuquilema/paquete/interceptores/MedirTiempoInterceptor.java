package com.kiyuquilema.paquete.interceptores;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@MedirTiempo 
@Interceptor 
@Priority (Interceptor.Priority.APPLICATION)
public class MedirTiempoInterceptor {

    @AroundInvoke
    public Object medirTiempo(InvocationContext context) throws Exception {
        long inicio = System.currentTimeMillis();
        
        Object resultado = context.proceed();

        long fin = System.currentTimeMillis();
        String metodo = context.getMethod().getName();
        System.out.println("Tiempo de ejecución del método " + metodo + ": " + (fin - inicio) + " ms");
        
        return resultado;
    }

}
