/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import librerias.IPagos;
import modelo.Banco;
import modelo.Servicio;
import modelo.Usuario;

/**
 *
 * @author Win 8.1
 */
public class Pago implements IPagos{
    Usuario u;
    Banco b;

    public Pago(Usuario u, Banco b) {
        this.u = u;
        this.b = b;
    }

    @Override
    public String realizarPago(String refPago, String clave, float monto) {
        float resto, deuda;
        if (!this.validarClave(clave)) return "Clave Incorrecta";
        Servicio s;
        if ((s = (Servicio)buscarServicio(refPago)).equals(null)) return "Referencia de Pago inexistente";
        if (monto < s.getMonto()) {
            s.setMonto(s.getMonto()-monto);
            deuda = s.getMonto();
            return "Operacion Exitosa. Deuda: "+deuda;
        }
        //return "Monto insuficiente";
        else if (monto > s.getMonto()){
            s.setMonto(0);
            resto = monto - s.getMonto();
            return "Operacion Exitosa. Resto: "+resto;
        }
        else{
            s.setMonto(0);
            return "Operacion Exitosa";
        }
    }

    @Override
    public boolean validarClave(String clave) {
        return clave.equals(u.getClave());
    }

    @Override
    public Object buscarServicio(String nombre) {
        return b.buscarServ(nombre);
    }
}
