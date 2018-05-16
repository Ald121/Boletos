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
import java.util.Vector;
import java.io.*;

public class Data extends Vector {

    /*
  ** FIFO, first in first out
     */
    Data() {
        super();
    }

    void put(Object o) {
        addElement(o);
    }

    Object get() {
        if (isEmpty()) {
            return null;
        }
        Object o = firstElement();
        removeElement(o);
        return o;
    }

    boolean removeRowAt(Object objTodelete) {
        return removeElement(objTodelete);
    }

    Object getAt(int index) {
        return elementAt(index);
    }
    
    void setRowAt(Object objSet,int index) {
        setElementAt(objSet, index);
    }

    Object peek() {
        if (isEmpty()) {
            return null;
        }
        return firstElement();
    }
}