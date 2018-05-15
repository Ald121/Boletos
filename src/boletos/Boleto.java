/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletos;

import java.io.Serializable;

/**
 *
 * @author Desarrollo
 */
public class Boleto implements Serializable{
    String b_psj;
    String b_rt;
    String b_costo;
    String b_asiento;
    String b_distribucion;
    String b_fecha;
    Boleto(String p,String r,String _costo_nw,String asiento_nw,String distribucion_nw,String b_fecha_nw) {
        b_psj = p;
        b_rt = r;
        b_costo = _costo_nw;
        b_asiento = asiento_nw;
        b_distribucion = distribucion_nw;
        b_fecha = b_fecha_nw;
    };
    
    @Override
    public String toString() {
        return b_psj + ":" + b_rt + ":" + b_costo + ":" + b_asiento+ ":" + b_distribucion + ":" + b_fecha;
    }
}
