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

    Object peek() {
        if (isEmpty()) {
            return null;
        }
        return firstElement();
    }
}

//Boletos boletosList;
//
//        boletosList = new Boletos();
//        boletosList.put("element 1");
//        boletosList.put("element 2");
//        boletosList.put("element 3");
//        boletosList.put("element 4");
//        System.out.println(boletosList.toString());
//
//        // serialize the Queue
//        System.out.println("serializing boletosList");
//        try {
//            FileOutputStream fout = new FileOutputStream("boletosList.dat");
//            ObjectOutputStream oos = new ObjectOutputStream(fout);
//            oos.writeObject(boletosList);
//            oos.close();
//            }
//         catch (Exception e) { e.printStackTrace(); }
//
//        // unserialize the Queue
//        System.out.println("unserializing boletosList");
//        try {
//         FileInputStream fin = new FileInputStream("boletosList.dat");
//         ObjectInputStream ois = new ObjectInputStream(fin);
//         boletosList = (Boletos) ois.readObject();
//         ois.close();
//         }
//        catch (Exception e) { e.printStackTrace(); }
//
//        System.out.println(boletosList.toString());
