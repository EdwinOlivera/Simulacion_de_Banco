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
public class CrearClientes extends PropiedadesClientes{
    PropiedadesClientes Clientes = new PropiedadesClientes();
    
    public void CreandoCliente(){
        
        Clientes.setDienero(2);
        Clientes.setTipoDeCliente(TipoDeClientes.MUJER_EMBARAZADA);
    }
}
