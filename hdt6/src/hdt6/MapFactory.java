/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdt6;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Jose Andres Arenas 14470
 * @author Sebastian Arriola 11463
 * @author Fernando Figueroa 14175
 */
public class MapFactory {
    
    public static Map crearMapa(int opcion)
    {
        if(opcion == 0)
        {
            return new HashMap();
        }
        else if(opcion == 1)
        {
            return new LinkedHashMap();
        }
        else if(opcion == 2)
        {
            return new TreeMap();
        }
        else
        {
            return null;
        }
    }                
}