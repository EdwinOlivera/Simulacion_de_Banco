/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador_de_banco;

import Fomularios.SalaDeEspera;

/**
 *
 * @author Edwin
 */
public class Simulador_De_Banco {
        private static  SalaDeEspera Formulario = new SalaDeEspera();
public static String MensajeFinal="*****************<<<<<<Este es el final del Programa>>>>>*****************";
    public static void main(String[] args) {

    Formulario.setVisible(true);
        System.out.println(MensajeFinal);
    }
    
}
