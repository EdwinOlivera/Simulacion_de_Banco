/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesClientes;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/* 
 *
 * @author Edwin
 */
public class CrearClientes extends PropiedadesClientes {

    // Objetos 
    PropiedadesClientes Clientes = new PropiedadesClientes();
    //ArrayList
    private static ArrayList<PropiedadesClientes> GrupoClientes = new ArrayList<>();
    //Variables de usos
    private static final Random RMD = new Random();//La variable de Randon

    int MONTO = 0;
    int Turnos = 0;
    int DesignarTranaccion = -1;
    int DesignarTipoDeClientes = -1;

    public void CreandoCliente() {

        System.out.println("Se esta Creando un Cliente Nuevo");
        EstablecerTipoDeCliente();
        EstablcerTurno();
        EstablcerColor();
        EstablecerTransaccion();
        EstablecerMonto();

        GrupoClientes.add(Clientes);
        //GrupoClientes.get().Turno;
        if (!GrupoClientes.isEmpty()) {
            System.out.println("Se han guardado exitosamente un cliente");
        }
    }
public ArrayList<PropiedadesClientes> RecuperarClientes(){
    return GrupoClientes;
}
    private void EstablecerTransaccion() {
        System.out.println("*******************************************");
        System.out.println("Se esta Asignado La Transaccion");
        DesignarTranaccion = RMD.nextInt(3);

        switch (DesignarTranaccion) {
            case 0:
                Clientes.setTransaccion(TipoDeTransacciones.DEPOSITO);
                break;
            case 1:
                Clientes.setTransaccion(TipoDeTransacciones.PAGO);
                break;
            case 2:
                Clientes.setTransaccion(TipoDeTransacciones.RETIRO);
                break;
            default:
                System.out.println("La Asignacion de la Transaccion esta fuera de Rango");
                break;
        }
        System.out.println("*******************************************");
    }

    private void EstablecerMonto() {
        System.out.println("*******************************************");
        System.out.println("Se esta Asignado El Monto");
        MONTO = RMD.nextInt(6);
        MONTO++;
        System.out.println("La opcion establecida es: " + MONTO);

        switch (MONTO) {
            case 1:
                MONTO = RMD.nextInt(501);
                if (MONTO <= 0) {
                    MONTO++;
                }
                break;
            case 2:
                MONTO = RMD.nextInt(501);
                break;
            case 3:
                MONTO = RMD.nextInt(502 + 2001);
                break;
            case 4:
                MONTO = RMD.nextInt(2002 + 5001);
                break;
            case 5:
                MONTO = RMD.nextInt(5002 + 10001);
                break;
            case 6:
                MONTO = RMD.nextInt(10002 + 15001);
                break;
            default:
                System.out.println("La asignacion de monto se ha salido del rango");
                MONTO = 0;
                break;
        }
        System.out.println("*******************************************");
        Clientes.setDienero(MONTO);
    }

    private void EstablecerTipoDeCliente() {
        System.out.println("*******************************************");
        System.out.println("Se esta Asignado El Tipo de Cliente");
        DesignarTipoDeClientes = RMD.nextInt(4);

        switch (DesignarTipoDeClientes) {
            case 0:
                Clientes.setTipoDeCliente(TipoDeClientes.NORMAL);
                break;
            case 1:
                Clientes.setTipoDeCliente(TipoDeClientes.DISCAPACITADO);
                break;
            case 2:
                Clientes.setTipoDeCliente(TipoDeClientes.MUJER_EMBARAZADA);
                break;
            case 3:
                Clientes.setTipoDeCliente(TipoDeClientes.TERCERA_EDAD);
                break;
            default:
                System.out.println("La Asignacion del Tipo de Cliente esta fuera de Rango");
                break;

        }
        System.out.println("*******************************************");
    }

    private void EstablcerTurno() {
        System.out.println("Se Esta Estableciendo El Turno del Cliente");
        Turnos = 2;
        Clientes.setTurno(1);
    }

    private void EstablcerColor() {
        switch (Clientes.getTipoDeCliente()) {
            case NORMAL:
                Clientes.setColores(Color.ORANGE);
                break;
            case DISCAPACITADO:
                Clientes.setColores(Color.red);
                break;
            case MUJER_EMBARAZADA:
                Clientes.setColores(Color.GREEN);
                break;
            case TERCERA_EDAD:
                Clientes.setColores(Color.YELLOW);
                break;
            default:
                System.err.println("Se ha salido del Rango El establecimeinto de Colores");
                Clientes.setColores(Color.BLACK);
                break;
        }
    }
}
