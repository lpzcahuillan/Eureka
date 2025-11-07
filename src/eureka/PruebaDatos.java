/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eureka;

import java.util.ArrayList;

/**
 *
 * @author lpzcahuillan
 */
public class PruebaDatos {

    public static void main(String[] args) {
        ArrayList<Invento> inventos = new ArrayList<>();

        
        System.out.println("=== INVENTOS EXPLOSIVOS ===\n");

        // Invento explosivo del año 2000 (aplicará descuento de 10.5% + 2% por antigüedad)
        InventoExplosivo exp1 = new InventoExplosivo(
            "EXP001",
            "Cohete a Vapor Retro",
            1000000,
            "Rocket",
            2000,
            "Transporte"
        );
        inventos.add(exp1);
        imprimirDetallesExplosivo(exp1);

        // Invento explosivo tipo Energía (descuento adicional del 8.5%)
        InventoExplosivo exp2 = new InventoExplosivo(
            "EXP002",
            "Generador de Antimateria Portátil",
            2000000,
            "PowerEurope",
            2015,
            "Energia"
        );
        inventos.add(exp2);
        imprimirDetallesExplosivo(exp2);

        // Invento explosivo reciente
        InventoExplosivo exp3 = new InventoExplosivo(
            "EXP003",
            "Propulsor de Plasma V2",
            1500000,
            "FutureTech",
            2023,
            "Transporte"
        );
        inventos.add(exp3);
        imprimirDetallesExplosivo(exp3);


        // ============ INVENTOS DOMÉSTICOS ============
        System.out.println("\n=== INVENTOS DOMÉSTICOS ===\n");

        // Invento doméstico útil (Alta + < 200W = +$450,000)
        InventoDomestico dom1 = new InventoDomestico(
            "DOM001",
            "Tostadora Cuántica 3.0",
            200000,
            "3.0",
            150,
            "Alta"
        );
        inventos.add(dom1);
        imprimirDetallesDomestico(dom1);

        // Invento doméstico eficiente
        InventoDomestico dom2 = new InventoDomestico(
            "DOM002",
            "Aspiradora de Bolsillo",
            300000,
            "2.5",
            180,
            "Alta"
        );
        inventos.add(dom2);
        imprimirDetallesDomestico(dom2);

        // Invento doméstico de baja utilidad
        InventoDomestico dom3 = new InventoDomestico(
            "DOM003",
            "Calentador de Agua Fría",
            100000,
            "1.0",
            500,
            "Baja"
        );
        inventos.add(dom3);
        imprimirDetallesDomestico(dom3);


        // ============ INVENTOS CONCEPTUALES ============
        System.out.println("\n=== INVENTOS CONCEPTUALES ===\n");

        // Invento conceptual destacado (Alta + prototipo = +$300,000)
        InventoConceptual con1 = new InventoConceptual(
            "CON001",
            "Máquina del Tiempo de Bolsillo",
            5000000,
            "Dr. Who",
            "Alta",
            true
        );
        inventos.add(con1);
        imprimirDetallesConceptual(con1);

        // Invento conceptual viable sin prototipo
        InventoConceptual con2 = new InventoConceptual(
            "CON002",
            "Teletransportador Molecular",
            3000000,
            "Prof. Einstein Jr.",
            "Alta",
            false
        );
        inventos.add(con2);
        imprimirDetallesConceptual(con2);

        // Invento conceptual de baja viabilidad (-5%)
        InventoConceptual con3 = new InventoConceptual(
            "CON003",
            "Motor de Movimiento Perpetuo",
            800000,
            "Inventor Anónimo",
            "Baja",
            false
        );
        inventos.add(con3);
        imprimirDetallesConceptual(con3);

        // Invento conceptual con prototipo pero viabilidad media
        InventoConceptual con4 = new InventoConceptual(
            "CON004",
            "Traductor Universal de Idiomas Animales",
            1200000,
            "Dra. Doolittle",
            "Media",
            true
        );
        inventos.add(con4);
        imprimirDetallesConceptual(con4);


        // ============ RESUMEN ============
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║              RESUMEN GENERAL                     ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
        System.out.println("Total de inventos registrados: " + inventos.size());
        System.out.println("- Explosivos: 3");
        System.out.println("- Domésticos: 3");
        System.out.println("- Conceptuales: 4");

        double valorTotal = 0;
        for (Invento inv : inventos) {
            valorTotal += inv.valorFinal();
        }
        System.out.println("\nValor total del laboratorio: $" + String.format("%.2f", valorTotal));
    }

    private static void imprimirDetallesExplosivo(InventoExplosivo inv) {
        System.out.println("┌─────────────────────────────────────────────┐");
        System.out.println("│ Código: " + inv.getCodigo());
        System.out.println("│ Nombre: " + inv.getNombre());
        System.out.println("│ Marca: " + inv.getMarca());
        System.out.println("│ Año: " + inv.getAnioCreacion());
        System.out.println("│ Tipo: " + inv.getTipoExplosivo());
        System.out.println("│ Valor base: $" + String.format("%.2f", inv.getValorBase()));
        System.out.println("│ Ajuste valor: -$" + String.format("%.2f", inv.ajusteValor()));
        System.out.println("│ Descuento reparación: -$" + String.format("%.2f", inv.descuentoReparacion()));
        System.out.println("│ VALOR FINAL: $" + String.format("%.2f", inv.valorFinal()));
        System.out.println("└─────────────────────────────────────────────┘\n");
    }

    private static void imprimirDetallesDomestico(InventoDomestico inv) {
        System.out.println("┌─────────────────────────────────────────────┐");
        System.out.println("│ Código: " + inv.getCodigo());
        System.out.println("│ Nombre: " + inv.getNombre());
        System.out.println("│ Versión: " + inv.getVersion());
        System.out.println("│ Consumo: " + inv.getConsumoElectrico() + "W");
        System.out.println("│ Utilidad: " + inv.getNivelUtilidad());
        System.out.println("│ Valor base: $" + String.format("%.2f", inv.getValorBase()));
        System.out.println("│ Bono eficiencia: +$" + String.format("%.2f", inv.bonoEficiencia()));
        System.out.println("│ VALOR FINAL: $" + String.format("%.2f", inv.valorFinal()));
        System.out.println("└─────────────────────────────────────────────┘\n");
    }

    private static void imprimirDetallesConceptual(InventoConceptual inv) {
        System.out.println("┌─────────────────────────────────────────────┐");
        System.out.println("│ Código: " + inv.getCodigo());
        System.out.println("│ Nombre: " + inv.getNombre());
        System.out.println("│ Autor: " + inv.getAutorTeorico());
        System.out.println("│ Viabilidad: " + inv.getNivelViabilidad());
        System.out.println("│ Prototipo: " + (inv.isTienePrototipo() ? "Sí" : "No"));
        System.out.println("│ Valor base: $" + String.format("%.2f", inv.getValorBase()));
        System.out.println("│ Ajuste valor: -$" + String.format("%.2f", inv.ajusteValor()));
        System.out.println("│ Bono innovación: +$" + String.format("%.2f", inv.bonoInnovacion()));
        System.out.println("│ VALOR FINAL: $" + String.format("%.2f", inv.valorFinal()));
        System.out.println("└─────────────────────────────────────────────┘\n");
    }
}
