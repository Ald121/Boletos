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
public class Ruta implements Serializable{
   public String _from_to;
   public String _horario;
   Ruta(String _from_to_nw,String _horario_nw){
       _from_to = _from_to_nw;
       _horario = _horario_nw;
   };
      
    @Override
    public String toString() {
        return _from_to + ":" + _horario;
    }
   
}
