package hdt6;

import javax.swing.JFrame;

/**
 *
 * @author Jose Andres Arenas 14470
 * @author Sebastian Arriola 11463
 * @author Fernando Figueroa 14175
 * 
 * 
 * Esta clase es la que interpreta los inputs del usuario, como los clicks en
 * los botones. Es el objeto que sirve como puente entre la clase vista y la 
 * clase modelo.
 */




public class CControlador 
{
    protected CModelo modelo;
    protected JFrame vista;
    
    /**
     * Este es el constructor de la clase. Se encarga de instanciar el modelo, 
     * y hacer visible la vista.
     */
    public CControlador()
    {
        modelo = new CModelo();
        JFrame f = new CVista(modelo, this);
        f.setVisible(true);
    }
    
    public void escogerImplementacion(int opcion)
    {
        modelo.escogerImplementacion(opcion);
    }
    
    /**
     * Recibe el input del boton agregar, y lo envia a la clase modelo.
     * @param nombre El texto dentro del jTextfield que corresponde al nombre
     * de la carta que se quiere agregar. 
     */
    
    public void agregarCartaAColeccion(String nombre)
    {
        modelo.agregarCarta(nombre);
    }
    
    
    /**
     * Recibe el input del boton buscar y lo envia a la clase modelo.
     * @param nombre El texto dentro del jTextfield que corresponde al nombre
     * de la carta que se quiere agregar. 
     */
    public void buscarCarta(String nombre)
    {
        modelo.buscarTipo(nombre);
    }
}
