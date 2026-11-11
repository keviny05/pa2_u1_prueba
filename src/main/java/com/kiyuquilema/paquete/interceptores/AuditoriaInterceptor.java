package com.kiyuquilema.paquete.interceptores;

import com.kiyuquilema.paquete.Transferencia;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Auditoria 
@Interceptor
@Priority(Interceptor.Priority.APPLICATION + 2) 
public class AuditoriaInterceptor {

    @AroundInvoke
    public Object auditar(InvocationContext context) throws Exception {
        System.out.println("Auditoría: Antes de ejecutar el método " + context.getMethod().getName());
        Object[] parametros = context.getParameters();
        Transferencia transferencia = (Transferencia) parametros[0];

        System.out.println("Detalles de la transferencia: Monto = " + transferencia.getMonto() + ", Cuenta Origen = " + transferencia.getCuentaOrigen().getNumeroCuenta() + ", Cuenta Destino = " + transferencia.getCuentaDestino().getNumeroCuenta());
        System.out.println("Notificación enviada a: " + transferencia.getCorreo() + ", Teléfono: " + transferencia.getTelefono());

        Object resultado = context.proceed();
        System.out.println("Auditoría: Después de ejecutar el método " + context.getMethod().getName());
        return resultado;
    }

}
