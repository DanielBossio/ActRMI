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
public interface IPagos {
    
    public String realizarPago(String refPago, String clave, float monto);
    public boolean validarClave(String clave);
    public Object buscarServicio(String nombre);
}
