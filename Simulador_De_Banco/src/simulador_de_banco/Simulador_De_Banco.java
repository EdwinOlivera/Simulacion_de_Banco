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

    public static String MensajeFinal = "*****************<<<<<<Este es el final del Programa>>>>>*****************";

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
        
        Montos= Formulario.GuardarArrayListDeMonto(Montos);
        TipoDeClientes = Formulario.GuardarArrayListDeTipoDeCliente(TipoDeClientes);
        Operaciones= Formulario.GuardarArrayListDeOperacion(Operaciones);
//        EspaciosDeClientes= Formulario.GuardarArrayListDe(EspaciosDeClientes);
        for (int i = 0;
                i < Asientos.size();
                i++) {

            if (i < 1) {
                Asientos.get(i).setBackground(Color.red);
                Asientos.get(i).setForeground(Color.white);
                Asientos.get(i).setOpaque(true);

            } else {
                Asientos.get(i).setBackground(Color.red);
                Asientos.get(i).setForeground(Color.white);
                Asientos.get(i).setOpaque(true);
                Asientos.get(i - 1).setBackground(Color.LIGHT_GRAY);
                Asientos.get(i - 1).setForeground(Color.RED);
                Asientos.get(i - 1).setOpaque(true);
            }
            if (i == Asientos.size() - 1) {
                i = -1;
            }
            Thread.sleep(1000);
            if (i == -1) {
                Asientos.get(Asientos.size() - 1).setBackground(Color.LIGHT_GRAY);
                Asientos.get(Asientos.size() - 1).setForeground(Color.red);
                Asientos.get(Asientos.size() - 1).setOpaque(true);
            }

        }

    }

    private static boolean Continuar(int CantidadAEsperar, int TurnoDecajero) throws InterruptedException {
        System.out.println("<*<*Se esta iniciando una pausa");

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

        }

        return true;
    }
}
