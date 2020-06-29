/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Win 8.1
 */
public class BancoExterno {
    
    String nombre;
    ArrayList<Cuenta> cuentas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
    
    public Cuenta buscarCuenta(String num){
        for (Cuenta c: cuentas)
            if (c.getNumCuenta().equals(num)) return c;
        return null;
    }
}
