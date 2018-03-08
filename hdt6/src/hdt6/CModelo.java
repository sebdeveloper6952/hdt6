/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdt6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *Esta clase se encarga de leer todas las catas que tiene la coleccion. Para 
 * hacer esto busca la informacion de un archivo de texto que ya esta 
 * predeterminado. 
 * @author sevic69
 */
public class CModelo 
{
    protected Map<String, Integer> mapaColeccion;
    protected Map<String, String> mapaCartas;
    protected List<ObservadorColeccion> obsColeccion;
    protected List<ObservadorCartas> obsCartas;
    protected String fileName = "src/cards_desc.txt";
    
   /**
    * Este es el constructor de la clase Cmodelo, este se utiliza solo para 
    * incializar los arrays.
    */
    public CModelo()
    {
        obsColeccion = new ArrayList<>();
        obsCartas = new ArrayList<>();
    }
    
    /**
     * Metodo que utiliza el boton escoger, el cual le permite al usuario
     * escoger entre tres implementaciones distintas, hashMap, treeMap, 
     * LinkedHashMap. 
     * @param opcion 
     */
    public void escogerImplementacion(int opcion)
    {
        mapaCartas = MapFactory.crearMapa(opcion);
        mapaColeccion = MapFactory.crearMapa(opcion);
        leerArchivoDeCartas(fileName);
        actualizarObservadoresCartas();
    }
    
    
    /**
     * Metodo que se encarga de agregar una carta a la coleccion del usuario, 
     * mediante el nombre de ka carta. Este metodo lo utiliza el boton agregar
     * @param nombre 
     */
    
    public void agregarCarta(String nombre)
    {
        if(mapaCartas.containsKey(nombre))
        {
            if(mapaColeccion.containsKey(nombre))
            {
                Integer val = mapaColeccion.get(nombre);
                mapaColeccion.replace(nombre, val+1);
            }   
            else mapaColeccion.put(nombre, 1);
         actualizarObservadoresColeccion();
         return;
        }
        throw new IllegalStateException("La carta no existe.");
    }
    
    
    public String buscarTipo(String nombre)
    {  
       if(mapaCartas.containsKey(nombre))
        return mapaCartas.get(nombre);
       throw new IllegalStateException("La carta no existe.");
    }
    
    /**
     * Este metodo se encarga de registrar a los observadores quienes 
     * se encargan de revisar la coleccion del
     * usuario para cuando esta tenga un cambio 
     * @param o 
     */
    
    public void registrarObservadorColeccion(ObservadorColeccion o)
    {
        obsColeccion.add(o);
    }
    
    
    /**
     * se encarga de registrar los observadores para la 
     * coleccion completa  de cartas. 
     * 
     * @param o 
     */
    public void registrarObservadorCartas(ObservadorCartas o)
    {
        obsCartas.add(o);
    }
    
    
    /**
     * Les informa a los observadores de la coleccion del usuario 
     * que esta ha sido modificada 
     */
    private void actualizarObservadoresColeccion()
    {
      for(ObservadorColeccion obs: obsColeccion)
          obs.actualizarColeccion(mapaColeccion);
    }
    
    /**
     * Les informa a los observadores de la coleccion de cartas  
     * que esta ha sido modificada 
     */
    private void actualizarObservadoresCartas()
    {
      for(ObservadorCartas obs: obsCartas)
          obs.actualizarCartas(mapaCartas);
    }
    
    
    /**
     * se encarga de leer el archivo de texto el cual contiene la coleccion 
     * completa de cartas 
     * @param fileName 
     */
    
    private void leerArchivoDeCartas(String fileName)
    {
        Scanner scanner = null;
        try
        {
            scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
            while(scanner.hasNextLine())
            {
                String[] line = scanner.nextLine().split("\\|");
                // insertar carta a mapa de todas las cartas
                mapaCartas.put(line[0], line[1]);
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            if(scanner != null)
            {
                scanner.close();
            }
        }
    }
}
