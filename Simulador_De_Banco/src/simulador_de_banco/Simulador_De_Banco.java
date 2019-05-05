/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador_de_banco;

import ClasesClientes.CrearClientes;
import Fomularios.SalaDeEspera;
import Fomularios.VariasBarrasDeProgreso;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author Edwin
 */
public class Simulador_De_Banco extends Thread {

    //Iniciadores de las Barras
    //Barra 1
    private static int seg1 = 0;
    private static Thread Cajero1 = new Thread() {
        public void run() {
            System.out.println("Iniciando el proceso en el Cajero 1");
            try {
                for (seg1 = 0; seg1 < 100; seg1++) {
                    BarrasDeProgreso.get(0).setValue(seg1);
                    Cajero1.sleep(1000);
                }
            } catch (Exception e) {

            }
        }
    };
    //Barra 2
    private static int seg2 = 0;
    private static Thread Cajero2 = new Thread() {
        public void run() {
            System.out.println("Iniciando el proceso en el Cajero 2");
            try {
                for (seg2 = 0; seg2 < 100; seg2++) {
                    BarrasDeProgreso.get(1).setValue(seg2);
                    Cajero1.sleep(500);
                }
            } catch (Exception e) {

            }
        }
    };

    //Barra 3
    private static int seg3 = 0;
    private static Thread Cajero3 = new Thread() {
        public void run() {
            System.out.println("Iniciando el proceso en el Cajero 3");
            try {
                for (seg3 = 0; seg3 < 100; seg3++) {
                    BarrasDeProgreso.get(2).setValue(seg3);
                    Cajero1.sleep(2000);
                }
            } catch (Exception e) {

            }
        }
    };
    //Variables PUBLIC STATIC
    public static int TiempoCajero1 = -1;
    public static int TiempoCajero2 = -1;
    public static int TiempoCajero3 = -1;

    //PRIVADAS STATIC
    //ArrayList
    private static ArrayList<JLabel> Asientos = new ArrayList<>();
    private static ArrayList<JLabel> Montos = new ArrayList<>();
    private static ArrayList<JLabel> TipoDeClientes = new ArrayList<>();
    private static ArrayList<JLabel> Operaciones = new ArrayList<>();
    private static ArrayList<JLabel> EspaciosDeClientes = new ArrayList<>();
    private static ArrayList<JProgressBar> BarrasDeProgreso = new ArrayList<>();
    //objetos 
    private static SalaDeEspera Formulario = new SalaDeEspera();
    private static CrearClientes Clientes = new CrearClientes();
    private static VariasBarrasDeProgreso barras = new VariasBarrasDeProgreso();
    //Variables 
    private static Random rdm = new Random(System.currentTimeMillis());
    private static int NumeroDeClientesACrear = 5;
    public static String MensajeFinal = "Este es el final del Programa>>>>>*****************";

    /**
     * ***********************************************
     */
    public static void main(String[] args) throws InterruptedException {

        CosasIniciales();
        //For Para Crear Clientes a voluntad
        for (int i = 0; i < NumeroDeClientesACrear; i++) {
            if (Continuar(rdm.nextInt(10 + 1), rdm.nextInt(2 + 1))) {
                System.out.println("Se esta creando el Cliente NUMERO: " + (i + 1));
                Clientes.CreandoCliente();
            }
        }

        //Mensaje final
        System.out.println(MensajeFinal);
    }

    private static void CosasIniciales() throws InterruptedException//En esta funcion se realizan las operaciones basicas e iniciales de todo el sistema
    {
        System.out.println("Se Esta incializando el sistema. Haciendo las operaciones basicas");
        //barras.setVisible(true);
        Formulario.setVisible(true);
        Formulario.EstablecerCaracteristicas();
        Asientos = Formulario.GuardarArrayListDeAsientos(Asientos);
        BarrasDeProgreso = Formulario.GuardarBarraDeProgresoDeCajeros(BarrasDeProgreso);
        Montos = Formulario.GuardarArrayListDeMonto(Montos);
        TipoDeClientes = Formulario.GuardarArrayListDeTipoDeCliente(TipoDeClientes);
        Operaciones = Formulario.GuardarArrayListDeOperacion(Operaciones);
        EspaciosDeClientes = Formulario.GuardarArrayListDeEspacioDeClientes(EspaciosDeClientes);
        //Probando el comportamiento
        for (int i = 0; i < Asientos.size(); i++) {

            if (i < 1) {
                Asientos.get(i).setBackground(Color.red);
                Asientos.get(i).setForeground(Color.white);
                Asientos.get(i).setOpaque(true);
                Cajero3.start();
                
            } else {
                Asientos.get(i).setBackground(Color.red);
                Asientos.get(i).setForeground(Color.white);
                Asientos.get(i).setOpaque(true);
                Asientos.get(i - 1).setBackground(Color.LIGHT_GRAY);
                Asientos.get(i - 1).setForeground(Color.RED);
                Asientos.get(i - 1).setOpaque(true);
            }
            if (i == Asientos.size() - 1) {
                Cajero2.start();
                i = -1;
            }
            Thread.sleep(1000);
            if (i == -1) {
                Cajero1.start();
                Asientos.get(Asientos.size() - 1).setBackground(Color.LIGHT_GRAY);
                Asientos.get(Asientos.size() - 1).setForeground(Color.red);
                Asientos.get(Asientos.size() - 1).setOpaque(true);
                i = Asientos.size();
            }

        }

    }

    private static boolean Continuar(int CantidadAEsperar, int TurnoDecajero) throws InterruptedException {
        System.out.println("<*<*Se esta iniciando un proceso de CAJERO");

        switch (TurnoDecajero) {
            case 1:
                System.out.println("*Se esta haciendo la espera en el cajero 1");
                System.out.println("El tiempo de Espera es" + (CantidadAEsperar) + " Segundos");
                Thread.sleep(CantidadAEsperar * 1000);
                return true;
            case 2:
                System.out.println("**Se esta haciendo la espera en el cajero 2");
                System.out.println("El tiempo de Espera es " + (CantidadAEsperar) + " Segundos");
                Thread.sleep(CantidadAEsperar * 1000);
                return true;
            case 3:
                System.out.println("**Se esta haciendo la espera en el cajero 2");
                System.out.println("El tiempo de Espera es " + (CantidadAEsperar) + " Segundos");
                Thread.sleep(CantidadAEsperar * 1000);
                return true;

        }
        return true;
    }

}
