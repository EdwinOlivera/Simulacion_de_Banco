/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador_de_banco;

import ClasesClientes.CrearClientes;
import Fomularios.SalaDeEspera;

/**
 *
 * @author Edwin
 */
public class Simulador_De_Banco {

    public static String MensajeFinal = "*****************<<<<<<Este es el final del Programa>>>>>*****************";
    
    //objetos 
    private static SalaDeEspera Formulario = new SalaDeEspera();
    private static CrearClientes Clientes = new CrearClientes();
    //Variables 
    private static int NumeroDeClientesACrear = 5;

    public static void main(String[] args) {
        //For Para Crear Clientes a voluntad
        for (int i = 0; i < NumeroDeClientesACrear; i++) {
            System.out.println("Se esta creando el Cliente NUMERO: " + (i + 1));
            Clientes.CreandoCliente();
        }

        Formulario.setVisible(true);
        Formulario.HacerAlgo();
        //Mensaje final
        System.out.println(MensajeFinal);
    }

}
