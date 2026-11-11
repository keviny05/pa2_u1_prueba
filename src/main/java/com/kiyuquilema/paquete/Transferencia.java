package com.kiyuquilema.paquete;

public class Transferencia {
    private Cuenta cuentaOrigen;
    private Cuenta cuentaDestino;
    private double monto;
    private String correo;
    private String telefono;

    public Transferencia() {
    }

    public Transferencia(Cuenta cuentaOrigen, Cuenta cuentaDestino, double monto, String correo, String telefono) {
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.monto = monto;
        this.correo = correo;
        this.telefono = telefono;
    }


    public Cuenta getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(Cuenta cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(Cuenta cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }




}
