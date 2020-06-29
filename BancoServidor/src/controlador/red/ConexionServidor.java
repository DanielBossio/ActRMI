/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.red;

import controlador.Pago;
import controlador.Transferencia;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import librerias.IPagos;
import librerias.ITransferencias;
import modelo.Banco;
import modelo.Usuario;
import net.sf.lipermi.exception.LipeRMIException;
import net.sf.lipermi.handler.CallHandler;
import net.sf.lipermi.net.Server;

/**
 *
 * @author Win 8.1
 */
public class ConexionServidor {
    private Usuario u;
    private Banco b;
    private String ipServ, nombreServ;
    private int puertoServ;
    private Server servRMI;
    private CallHandler manejadorRMI;
    private IPagos pagoRemoto;
    private ITransferencias transferRemoto;

    public ConexionServidor(Usuario u, Banco b) {
        this.b = b;
        this.u = u;
        try{
            //Obtener host local
            ipServ = InetAddress.getLocalHost().getHostAddress();
            nombreServ = InetAddress.getLocalHost().getHostName();
            this.puertoServ = 5003;
        } catch (UnknownHostException ex) {
            System.out.println("IP inaccesible");
        }
    }
    
    public ConexionServidor(int puertoServ) {
        try{
            ipServ = InetAddress.getLocalHost().getHostAddress();
            nombreServ = InetAddress.getLocalHost().getHostName();
            this.puertoServ = puertoServ;
        } catch (UnknownHostException ex) {
            System.out.println("IP inaccesible");
        }
    }
    
    public void conectarPago(){
        try{
            this.pagoRemoto = new Pago(u, b);
            this.manejadorRMI = new CallHandler();
            this.servRMI = new Server();
           //Exportar el objeto. Se debe conocer la clase del objeto y el objeto en sí 
            manejadorRMI.registerGlobal(Object.class, pagoRemoto);
            //Conectar
            servRMI.bind(puertoServ, manejadorRMI);
        } catch (LipeRMIException ex) {
            //Error al exportar el objeto
            Logger.getLogger(ConexionServidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Error en la conexión
            Logger.getLogger(ConexionServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void conectarTransfer(){
        try{
            this.transferRemoto = new Transferencia(u, b);
            this.manejadorRMI = new CallHandler();
            this.servRMI = new Server();
           //Exportar el objeto. Se debe conocer la clase del objeto y el objeto en sí 
            manejadorRMI.registerGlobal(Object.class, transferRemoto);
            //Conectar
            servRMI.bind(puertoServ, manejadorRMI);
        } catch (LipeRMIException ex) {
            //Error al exportar el objeto
            Logger.getLogger(ConexionServidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Error en la conexión
            Logger.getLogger(ConexionServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void desconectar(){
        this.servRMI.close();
    }
}
