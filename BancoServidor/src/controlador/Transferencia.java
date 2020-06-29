/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import librerias.ITransferencias;
import modelo.Banco;
import modelo.BancoExterno;
import modelo.Cuenta;
import modelo.Usuario;

/**
 *
 * @author Win 8.1
 */
public class Transferencia implements ITransferencias{

    Usuario u;
    Banco b;

    public Transferencia(Usuario u, Banco b) {
        this.u = u;
        this.b = b;
    }
    
    @Override
    public String realizarTransferencia(String bancoExt, String numCuenta, String clave, float monto) {
        if (!this.validarClave(clave)) return "Clave Incorrecta";
        BancoExterno ban;
        if ((ban = (BancoExterno)buscarBancoExt(bancoExt)).equals(null)) return "Banco no afiliado";
        Cuenta c;
        if ((c = ban.buscarCuenta(numCuenta)).equals(null)) return "Cuenta inexistente";
        c.setMonto(c.getMonto()+monto);
        return "Operacion Exitosa";
    }

    @Override
    public boolean validarClave(String clave) {
        return clave.equals(u.getClave());
    }

    @Override
    public Object buscarBancoExt(String nombre) {
        return b.buscarBanco(nombre);
    }
    
}
