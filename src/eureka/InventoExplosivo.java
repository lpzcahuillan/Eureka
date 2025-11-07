/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eureka;

/**
 *
 * @author lpzcahuillan
 */
public class InventoExplosivo extends Invento {
    private String marca;
    private int anioCreacion;
    private String tipoExplosivo; 
    
    //constructor

    public InventoExplosivo(String codigo, String nombre, double valorBase, 
                           String marca, int anioCreacion, String tipoExplosivo) {
        super(codigo, nombre, valorBase);
        this.marca = marca;
        this.anioCreacion = anioCreacion;
        this.tipoExplosivo = tipoExplosivo;
    }


    // Getter y setter

    public String getMarca() {
        return marca;
    }

    public int getAnioCreacion() {
        return anioCreacion;
    }

    public String getTipoExplosivo() {
        return tipoExplosivo;
    }

    
    
    
    //metodos 
    @Override
    public double ajusteValor() {
        double ajuste = 0;
        
        // Descuento año 2000, 10.5%
        if (anioCreacion == 2000) {
            ajuste += valorBase * 0.105;
        }
        
        // Más de 20 años, 2%
        int anioActual = 2025;
        if ((anioActual - anioCreacion) > 20) {
            ajuste += valorBase * 0.02;
        }
        
        return ajuste;
    }


 
    public double descuentoReparacion() {
        if (tipoExplosivo.equalsIgnoreCase("Energia")) {
            return valorBase * 0.085;
        }
        return 0;
    }

    @Override
    public double valorFinal() {
        return valorBase - ajusteValor() - descuentoReparacion();
    }
}
