/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoservidor;

import controlador.red.ConexionServidor;
import modelo.Banco;
import modelo.Usuario;

/**
 *
 * @author Win 8.1
 */
public class BancoServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Usuario u = new Usuario("Jane", "jane@gmail.com", "Mi Cuenta", "12345");
            Banco b = new Banco();
            b.addUsuario(u);
            ConexionServidor con = new ConexionServidor(u, b);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        // TODO code application logic here
    }
    
}
