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
public class Banco {
    public ArrayList<Usuario> usuarios;
    public ArrayList<Servicio> servicios;
    public ArrayList<BancoExterno> bancos;

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }
    
    public Servicio buscarServ(String refPago){
        for (Servicio s: servicios)
            if (s.getRefPago().equals(refPago)) return s;
        return null;
    }
    
    public BancoExterno buscarBanco(String nom){
        for (BancoExterno b : this.bancos)
            if (b.getNombre().equals(nom)) return b;
        return null;
    }
    
    public void addUsuario(Usuario u){
        this.usuarios.add(u);
    }
}
