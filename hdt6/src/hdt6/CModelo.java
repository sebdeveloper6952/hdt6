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
 *
 * @author sevic69
 */
public class CModelo 
{
    protected Map<String, Integer> mapaColeccion;
    protected Map<String, String> mapaCartas;
    protected List<ObservadorColeccion> obsColeccion;
    protected String fileName = "src/cards_desc.txt";
    
    public CModelo()
    {
        obsColeccion = new ArrayList<>();
    }
    
    public void escogerImplementacion(int opcion)
    {
        // usar factory
        leerArchivoDeCartas(fileName);
    }
    
    public void agregar(String nombre)
    {
     if(mapaColeccion.containsKey(nombre))
     {
         Integer val = mapaColeccion.get(nombre);
         mapaColeccion.replace(nombre, val+1);
     }   
     else 
         mapaColeccion.put(nombre, 1);
     actualizarObservadoresColeccion();
    }
    
    
    public String buscar(String nombre)
    {  
       return mapaCartas.get(nombre); 
    }
    
    public void registrarObservador(ObservadorColeccion o)
    {
        obsColeccion.add(o);
    }
    
    private void actualizarObservadoresColeccion()
    {
      for(ObservadorColeccion obs: obsColeccion)
          obs.actualizarColeccion(mapaColeccion);
    }
    
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
