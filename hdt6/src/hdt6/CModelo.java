/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdt6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sevic69
 */
public class CModelo 
{
    
    protected Map<String, Integer >map;
    protected Map<String, String > cartas;
    protected List<ObservadorColeccion>observadores;
    protected String fileName = "src/cards_desc.txt";
    
    public CModelo(int opciones)
    {
        observadores = new ArrayList<>();
    }
    
    public void agregar(String nombre)
    {
     if(map.containsKey(nombre))
     {
         Integer val = map.get(nombre);
         map.replace(nombre, val+1);
     }   
     else 
         map.put(nombre, 1);    
    }
    
    
    public String buscar(String nombre)
    {  
       return cartas.get(nombre); 
    }
    
    
    private void actualizarLista()
    {
      for(ObservadorColeccion obs:observadores)
          obs.actualizarColeccion(map);
    }
    
}
