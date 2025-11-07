/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eureka;

/**
 *
 * @author lpzcahuillan
 */
public class InventoDomestico extends Invento {
    private String version;
    private double consumoElectrico; // en Watts
    private String nivelUtilidad; // "Alta" o "Baja"

    public InventoDomestico(String codigo, String nombre, double valorBase,
                           String version, double consumoElectrico, String nivelUtilidad) {
        super(codigo, nombre, valorBase);
        this.version = version;
        this.consumoElectrico = consumoElectrico;
        this.nivelUtilidad = nivelUtilidad;
    }
    
    
    // Getters
    public String getVersion() {
        return version;
    }

    public double getConsumoElectrico() {
        return consumoElectrico;
    }

    public String getNivelUtilidad() {
        return nivelUtilidad;
    }
    
    //Metodos

    @Override
    public double ajusteValor() {
        return 0;
    }

    /**
     * Bono de eficiencia según estándares de Europa
     */
    public double bonoEficiencia() {
        // Utilidad Alta y consumo menor a 200W, $450,000
        if (nivelUtilidad.equalsIgnoreCase("Alta") && consumoElectrico < 200) {
            return 450000;
        }
        return 0;
    }

    @Override
    public double valorFinal() {
        return valorBase - ajusteValor() + bonoEficiencia();
    }

}


