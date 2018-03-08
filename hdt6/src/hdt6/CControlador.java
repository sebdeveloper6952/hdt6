package hdt6;

import javax.swing.JFrame;

/**
 *
 * @author Jose Andres Arenas 14470
 * @author Sebastian Arriola 11463
 * @author Fernando Figueroa 14175
 */
public class CControlador 
{
    protected CModelo modelo;
    protected JFrame vista;
    
    public CControlador()
    {
        modelo = new CModelo();
        JFrame f = new CVista(modelo, this);
        f.setVisible(true);
    }
    
    public void agregarCartaAColeccion(String nombre)
    {
        modelo.agregarCarta(nombre);
    }
    
    public void buscarCarta(String nombre)
    {
        modelo.buscarTipo(nombre);
    }
}
