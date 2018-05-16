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
    public String p_identification;
    public String p_name;
    public String p_type;
    public String p_edad;
    
    Pasajero( String nameP, String typeP,String identificacionP,String edadP){
            p_identification = identificacionP;
            p_name = nameP;
            p_type = typeP;
            p_edad = edadP;
    }
    
    @Override
    public String toString() {
        return p_identification + ":" + p_name + ":" +  p_type + ":" + p_edad;
    }
}
