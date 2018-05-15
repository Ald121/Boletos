/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletos;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author Desarrollo
 */
public class User implements Serializable{
   public String _u;
   public String _pss;
   User(){
   };
   
   User (String _u_nw,String _pss_nw){
       _u = _u_nw;
       _pss = _pss_nw;
   }
   
   public boolean login(String _u_log,String _pss_log){
       if(_u.equals(_u_log) && _pss.equals(_pss_log)){
            return true;
       }else{
           return false;
       }
   }
   
   public String getU(){
           return _u;
   }
   
   public String getPss(){
           return _pss;
   }
   
    @Override
    public String toString() {
        return _u + ":" + _pss;
    }
   
}
