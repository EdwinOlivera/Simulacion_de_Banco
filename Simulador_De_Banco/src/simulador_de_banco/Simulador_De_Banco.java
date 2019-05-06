/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador_de_banco;

import ClasesClientes.CrearClientes;
import ClasesClientes.PropiedadesClientes;
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
    private static int ValorBarraCajero_1 = 0;
    private static int TiempoCajero_1 = 1;
    private static Thread Cajero1 = new Thread() {
        public void run() {
            System.out.println("Iniciando el proceso en el Cajero 1");
            try {
                for (ValorBarraCajero_1 = 0; ValorBarraCajero_1 < 100; ValorBarraCajero_1++) {
                    BarrasDeProgreso.get(0).setValue(ValorBarraCajero_1);
                    Cajero1.sleep(TiempoCajero_1 * 50);
                    if (ValorBarraCajero_1 == 100 - 1) {
                        ValorBarraCajero_1 = 0;
                        Continuar(1);
                    }
                }
            } catch (Exception e) {

            }
        }
    };
    //Barra 2
    private static int ValorBarraCajero_2 = 0;
    private static int TiempoCajero_2 = 1;
    private static Thread Cajero2 = new Thread() {
        public void run() {
            System.out.println("Iniciando el proceso en el Cajero 2");
            try {
                for (ValorBarraCajero_2 = 0; ValorBarraCajero_2 < 100; ValorBarraCajero_2++) {
                    BarrasDeProgreso.get(1).setValue(ValorBarraCajero_2);
                    Cajero1.sleep(TiempoCajero_2 * 70);
                    if (ValorBarraCajero_2 == 100 - 1) {
                        ValorBarraCajero_2 = 0;
                        Continuar(1);
                    }
                }
            } catch (Exception e) {

            }
        }
    };

    //Barra 3
    private static int ValorBarraCajero_3 = 0;
    private static int TiempoCajero_3 = 1;
    private static Thread Cajero3 = new Thread() {
        public void run() {
            System.out.println("Iniciando el proceso en el Cajero 3");
            try {
                for (ValorBarraCajero_3 = 0; ValorBarraCajero_3 < 100; ValorBarraCajero_3++) {
                    BarrasDeProgreso.get(2).setValue(ValorBarraCajero_3);
                    Cajero1.sleep(TiempoCajero_3 * 80);
                    if (ValorBarraCajero_3 == 100 - 1) {
                        ValorBarraCajero_3 = 0;
                        Continuar(1);
                    }
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
    private static ArrayList<PropiedadesClientes> TodosLosClientes = new ArrayList<PropiedadesClientes>();
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
    private static int NumeroDeClientesACrear = 10;
    public static String MensajeFinal = "Este es el final del Programa>>>>>*****************";

    /**
     * ***********************************************
     */
    public static void main(String[] args) throws InterruptedException {

        //For Para Crear Clientes a voluntad
        for (int i = 0; i < NumeroDeClientesACrear; i++) {
            System.out.println("Se esta creando el Cliente NUMERO: " + (i + 1));
            Thread.sleep(10);
            Clientes.CreandoCliente();
        }
        TodosLosClientes = Clientes.RecuperarClientes();
        System.out.println("Imprimiendo la informacion de Prueba");
        for (int i = 0; i < NumeroDeClientesACrear; i++) {
            System.out.println("Se esta imprimiendo el Cliente NUMERO: " + (i + 1));

            System.out.println("El tipo de Cliente del actual cliente es: " + TodosLosClientes.get(i).getTipoDeCliente());
        }
        CosasIniciales();

        //Iniciar los cajeros
        //IniciarLosCajeros();
        //Mensaje final
        System.out.println(MensajeFinal);
    }

    private static void CosasIniciales() throws InterruptedException//En esta funcion se realizan las operaciones basicas e iniciales de todo el sistema
    {
        System.out.println("Se Esta incializando el sistema. Haciendo las operaciones basicas");
        //barras.setVisible(true);
        TodosLosClientes = Clientes.RecuperarClientes();
        System.out.println("El tamaño de los clientes es: " + TodosLosClientes.size());
        Formulario.setVisible(true);
        Formulario.EstablecerCaracteristicas();//Establece la forma de verse inicialmente el formulario
        Asientos = Formulario.GuardarArrayListDeAsientos(Asientos);
        BarrasDeProgreso = Formulario.GuardarBarraDeProgresoDeCajeros(BarrasDeProgreso);
        Montos = Formulario.GuardarArrayListDeMonto(Montos);
        TipoDeClientes = Formulario.GuardarArrayListDeTipoDeCliente(TipoDeClientes);
        Operaciones = Formulario.GuardarArrayListDeOperacion(Operaciones);
        EspaciosDeClientes = Formulario.GuardarArrayListDeEspacioDeClientes(EspaciosDeClientes);

        //Probando el comportamiento
        for (int i = 0; i < Asientos.size(); i++) {

            if (i < 1) {

                Asientos.get(i).setBackground(TodosLosClientes.get(i).getColores());
                Asientos.get(i).setForeground(Color.BLACK);
                Asientos.get(i).setOpaque(true);
            Thread.sleep(10);

        }
        }
        IniciarLosCajeros();
    }

    private static void Continuar(int TurnoDecajero) throws InterruptedException {
        System.out.println("<*<*Se esta iniciando un proceso de CAJERO");

        switch (TurnoDecajero) {
            case 1:

                System.out.println("Cajero 1");
            case 2:
                System.out.println("Cajero 2");

            case 3:
                System.out.println("Cajero 3");

        }

    }

    private static void IniciarLosCajeros() throws InterruptedException {


        for (int L = 1; L < 4; L++) {
            Continuar(L);
        }
         Thread.sleep(500);
        Cajero1.start();
        Thread.sleep(500);
        Cajero2.start();
        Thread.sleep(500);
        Cajero3.start();
        Thread.sleep(500);
    }

}
