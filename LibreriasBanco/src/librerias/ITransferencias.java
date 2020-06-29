/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librerias;

/**
 *
 * @author Win 8.1
 */
public interface ITransferencias {
    
    public String realizarTransferencia(String banco, String numCuenta, String clave, float monto);
    public boolean validarClave(String clave);
    public Object buscarBancoExt(String nombre);
}
