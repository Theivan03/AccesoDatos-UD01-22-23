package org.example;

import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("src/main/resources/viajes.dat");
        ListaViajes listica = new ListaViajes();
       try(FileInputStream fis = new FileInputStream(f);
           ObjectInputStream salida = new ObjectInputStream(fis)){
           try{
               while(true) {
                   Viaje viaje =(Viaje) salida.readObject();
                   listica.add(viaje);
                   System.out.println(viaje);
               }
           }catch(EOFException e){
                   System.out.println("Fin de fichero");
               }

       } catch (FileNotFoundException e) {
           System.out.println(e.getMessage());;
       } catch (IOException e) {
           System.out.println(e.getMessage());;
       } catch (ClassNotFoundException e) {
           System.out.println(e.getMessage());
       }


           XStream xStream = new XStream();

           xStream.processAnnotations(Viaje.class);
           xStream.processAnnotations(Etapa.class);
           xStream.processAnnotations(Lugar.class);
           xStream.processAnnotations(Hotel.class);
           xStream.processAnnotations(ListaViajes.class);

           xStream.addImplicitCollection(ListaViajes.class,"lista");

           xStream.toXML(listica, new FileOutputStream("src/main/resources/viajes.xml"));

    }
}