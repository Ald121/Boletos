/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletos;

/**
 *
 * @author Desarrollo
 */
public class Pasajero {
    public String p_name;
    public String p_type;
    
    public Pasajero( String nameP, String typeP){
            p_name = nameP;
            p_type = typeP;
    }

    Pasajero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString() {
        return p_name + ":" + p_type;
    }
}
