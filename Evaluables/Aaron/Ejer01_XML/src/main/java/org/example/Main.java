package org.example;

import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {


    generateXML(leerFicheroDat());
        
    }


    public static List<Viaje> leerFicheroDat(){
        File ruta = new File("src/main/resources/viajes.dat");
        ArrayList<Viaje> listaViajes = new ArrayList<>();
        Viaje salidaViaje = new Viaje();

        try(FileInputStream fileInputStream = new FileInputStream(ruta);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            try{
                while (true){
                    salidaViaje = (Viaje) objectInputStream.readObject();
                    listaViajes.add(salidaViaje);
                }
            }catch (EOFException eofe){
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    return listaViajes;
    }

    public static void generateXML(List<Viaje> viajes) throws IOException {

        File crearXML = new File("src/main/resources/viajes.xml");
        if(!crearXML.exists()){
            crearXML.createNewFile();
        }

        XStream xStream = new XStream();

        xStream.processAnnotations(Viaje.class);
        xStream.processAnnotations(Etapa.class);
        xStream.processAnnotations(Lugar.class);
        xStream.processAnnotations(Hotel.class);

        xStream.addImplicitCollection(Viaje.class,"etapas");
        xStream.addImplicitCollection(Etapa.class,"puntosVisita");

        xStream.toXML(viajes, new FileOutputStream("src/main/resources/viajes.xml"));
    }
}