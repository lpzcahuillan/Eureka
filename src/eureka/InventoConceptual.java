/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eureka;

/**
 *
 * @author lpzcahuillan
 */
public class InventoConceptual extends Invento {
    private String autorTeorico;
    private String nivelViabilidad; // "Alta", "Media", "Baja"
    private boolean tienePrototipo;
    
    
    //constructor

    public InventoConceptual(String codigo, String nombre, double valorBase,
                            String autorTeorico, String nivelViabilidad, boolean tienePrototipo) {
        super(codigo, nombre, valorBase);
        this.autorTeorico = autorTeorico;
        this.nivelViabilidad = nivelViabilidad;
        this.tienePrototipo = tienePrototipo;
    }

    // Getters
    
    public String getAutorTeorico() {
        return autorTeorico;
    }

    public String getNivelViabilidad() {
        return nivelViabilidad;
    }

    public boolean isTienePrototipo() {
        return tienePrototipo;
    }
    
    
    
    //metodos
    @Override
    public double ajusteValor() {
        double ajuste = 0;
        
        // Viabilidad Baja, 5%
        if (nivelViabilidad.equalsIgnoreCase("Baja")) {
            ajuste = valorBase * 0.05;
        }
        
        return ajuste;
    }

    /**
     * Bono por innovación
     */
    public double bonoInnovacion() {
        // Viabilidad Alta o prototipo verdadero = $300,000
        if (nivelViabilidad.equalsIgnoreCase("Alta") || tienePrototipo) {
            return 300000;
        }
        return 0;
    }

    @Override
    public double valorFinal() {
        return valorBase - ajusteValor() + bonoInnovacion();
    }

    
}
