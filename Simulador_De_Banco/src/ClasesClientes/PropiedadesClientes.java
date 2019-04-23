/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesClientes;

/**
 *
 * @author Edwin
 */
public class PropiedadesClientes {

    public PropiedadesClientes() {
    }

    public int Dienero = 0;
    public int Turno = -1;

    public enum TipoDeClientes {
        NORMAL, TERCERA_EDAD, MUJER_EMBARAZADA, DISCAPACITADO;
    }

    public enum TipoDeTransacciones {
        DEPOSITO, RETIRO, PAGO;
    }

    //set y get
    public TipoDeTransacciones getTipoDeTransacciones() {
        return Transaccion;
    }

    public void setTipoDeTransacciones(TipoDeTransacciones Transaccion) {
        this.Transaccion = Transaccion;
    }

    public TipoDeClientes getTipoDeCliente() {
        return TipoDeCliente;
    }

    public void setTipoDeCliente(TipoDeClientes TipoDeCliente) {
        this.TipoDeCliente = TipoDeCliente;
    }

    public int getDienero() {
        return Dienero;
    }

    public void setDienero(int Dienero) {
        this.Dienero = Dienero;
    }

    public int getTurno() {
        return Turno;
    }

    public void setTurno(int Turno) {
        this.Turno = Turno;
    }
    //objetos 
    TipoDeClientes TipoDeCliente = TipoDeClientes.NORMAL;
    TipoDeTransacciones Transaccion = TipoDeTransacciones.DEPOSITO;
}
