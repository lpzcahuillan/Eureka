/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eureka;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lpzcahuillan
 */
public class Eureka {
    private ArrayList<Invento> inventos;
    private Scanner scanner;

    public Eureka() {
        inventos = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Menú principal
     */
    public void mostrarMenu() {
        int opcion = 0;
        
        do {
            System.out.println("╔════════════════════════════════════════════════════════╗");
            System.out.println("║  🧪 Laboratorio Eureka (Casi)   Inventos Fracasados    ║");
            System.out.println("║       Desde los confines de Europa hasta aquí          ║");
            System.out.println("╚════════════════════════════════════════════════════════╝");
            System.out.println("1. Registrar invento");
            System.out.println("2. Mostrar valor final de un invento por código");
            System.out.println("3. Aplicar ajuste de valor (inventos creados en 2000)");
            System.out.println("4. Contar inventos domésticos útiles");
            System.out.println("5. Listar inventos conceptuales con prototipo y viabilidad Alta");
            System.out.println("\n9. Salir");
            System.out.print("\nSeleccione una opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                
                switch (opcion) {
                    case 1:
                        registrarInvento();
                        break;
                    case 2:
                        mostrarValorFinalPorCodigo();
                        break;
                    case 3:
                        aplicarAjusteValor2000();
                        break;
                    case 4:
                        contarInventosDomesticosUtiles();
                        break;
                    case 5:
                        listarInventosConceptualesDestacados();
                        break;
                    case 9:
                        System.out.println("\n¡Gracias por visitar el Laboratorio Eureka (Casi)!");
                        System.out.println("Recuerde: el fracaso es solo el éxito en progreso. 🧪");
                        break;
                    default:
                        System.out.println("❌ Opción inválida. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Por favor ingrese un número válido. 😡😡😡");
            }
        } while (opcion != 9);
    }

    /**
     * Registrar un nuevo invento
     */
    private void registrarInvento() {
        System.out.println("\n--- REGISTRAR NUEVO INVENTO ---");
        System.out.println("Tipo de invento:");
        System.out.println("1. Explosivo");
        System.out.println("2. Doméstico");
        System.out.println("3. Conceptual");
        System.out.print("Seleccione: ");
        
        try {
            int tipo = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Código: ");
            String codigo = scanner.nextLine();
            
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            
            System.out.print("Valor base: ");
            double valorBase = Double.parseDouble(scanner.nextLine());
            
            switch (tipo) {
                case 1:
                    registrarInventoExplosivo(codigo, nombre, valorBase);
                    break;
                case 2:
                    registrarInventoDomestico(codigo, nombre, valorBase);
                    break;
                case 3:
                    registrarInventoConceptual(codigo, nombre, valorBase);
                    break;
                default:
                    System.out.println("Tipo de invento inválido.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error en los datos ingresados.");
        }
    }

    private void registrarInventoExplosivo(String codigo, String nombre, double valorBase) {
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        
        System.out.print("Año de creación: ");
        int anioCreacion = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Tipo explosivo (Transporte/Energia): ");
        String tipoExplosivo = scanner.nextLine();
        
        InventoExplosivo invento = new InventoExplosivo(codigo, nombre, valorBase, 
                                                        marca, anioCreacion, tipoExplosivo);
        inventos.add(invento);
        System.out.println("Invento explosivo registrado exitosamente.");
    }

    private void registrarInventoDomestico(String codigo, String nombre, double valorBase) {
        System.out.print("Versión: ");
        String version = scanner.nextLine();
        
        System.out.print("Consumo eléctrico (W): ");
        double consumo = Double.parseDouble(scanner.nextLine());
        
        System.out.print("Nivel de utilidad (Alta/Baja): ");
        String nivelUtilidad = scanner.nextLine();
        
        InventoDomestico invento = new InventoDomestico(codigo, nombre, valorBase,
                                                        version, consumo, nivelUtilidad);
        inventos.add(invento);
        System.out.println("Invento doméstico registrado exitosamente.");
    }

    private void registrarInventoConceptual(String codigo, String nombre, double valorBase) {
        System.out.print("Autor teórico: ");
        String autor = scanner.nextLine();
        
        System.out.print("Nivel de viabilidad (Alta/Media/Baja): ");
        String viabilidad = scanner.nextLine();
        
        System.out.print("¿Tiene prototipo? (true/false): ");
        boolean tienePrototipo = Boolean.parseBoolean(scanner.nextLine());
        
        InventoConceptual invento = new InventoConceptual(codigo, nombre, valorBase,
                                                          autor, viabilidad, tienePrototipo);
        inventos.add(invento);
        System.out.println("Invento conceptual registrado exitosamente.");
    }

    /**
     * Mostrar el invento por código
     */
    private void mostrarValorFinalPorCodigo() {
        System.out.print("\nIngrese el código del invento: ");
        String codigo = scanner.nextLine();
        
        Invento invento = buscarInventoPorCodigo(codigo);
        
        if (invento != null) {
            System.out.println("\n--- INFORMACIÓN DEL INVENTO ---");
            System.out.println("Código: " + invento.getCodigo());
            System.out.println("Nombre: " + invento.getNombre());
            System.out.println("Valor base: $" + String.format("%.2f", invento.getValorBase()));
            System.out.println("Valor final: $" + String.format("%.2f", invento.valorFinal()));
            
            if (invento instanceof InventoExplosivo) {
                InventoExplosivo exp = (InventoExplosivo) invento;
                System.out.println("Tipo: Explosivo");
                System.out.println("Marca: " + exp.getMarca());
                System.out.println("Año: " + exp.getAnioCreacion());
                System.out.println("Tipo explosivo: " + exp.getTipoExplosivo());
            } else if (invento instanceof InventoDomestico) {
                InventoDomestico dom = (InventoDomestico) invento;
                System.out.println("Tipo: Doméstico");
                System.out.println("Versión: " + dom.getVersion());
                System.out.println("Consumo: " + dom.getConsumoElectrico() + "W");
                System.out.println("Utilidad: " + dom.getNivelUtilidad());
            } else if (invento instanceof InventoConceptual) {
                InventoConceptual con = (InventoConceptual) invento;
                System.out.println("Tipo: Conceptual");
                System.out.println("Autor: " + con.getAutorTeorico());
                System.out.println("Viabilidad: " + con.getNivelViabilidad());
                System.out.println("Prototipo: " + (con.isTienePrototipo() ? "Sí" : "No"));
            }
        } else {
            System.out.println("No se encontró un invento con el código: " + codigo);
        }
    }

    // Ajuste de valor a todos los inventos creados en el año 2000
     
    private void aplicarAjusteValor2000() {
        int count = 0;
        
        for (Invento invento : inventos) {
            if (invento instanceof InventoExplosivo) {
                InventoExplosivo exp = (InventoExplosivo) invento;
                if (exp.getAnioCreacion() == 2000) {
                    double ajuste = exp.ajusteValor();
                    System.out.println("Ajustando invento: " + exp.getNombre() + 
                                     " - Ajuste: $" + String.format("%.2f", ajuste));
                    count++;
                }
            }
        }
        
        System.out.println("\nSe aplicó ajuste a " + count + " invento(s) del año 2000.");
    }

    /**
     * Contar inventos domésticos con nivel Alta y versión 3.0
     */
    private void contarInventosDomesticosUtiles() {
        int count = 0;
        
        System.out.println("\n--- INVENTOS DOMÉSTICOS ÚTILES ---");
        System.out.println("(Nivel Alta, Versión 3.0)\n");
        
        for (Invento invento : inventos) {
            if (invento instanceof InventoDomestico) {
                InventoDomestico dom = (InventoDomestico) invento;
                if (dom.getNivelUtilidad().equalsIgnoreCase("Alta") && 
                    dom.getVersion().equals("3.0")) {
                    System.out.println("- " + dom.getNombre() + " (" + dom.getCodigo() + ")");
                    count++;
                }
            }
        }
        
        System.out.println("\nTotal: " + count + " invento(s) doméstico(s) útil(es).");
    }

    /**
     * Listar inventos conceptuales con prototipo y viabilidad Alta
     */
    private void listarInventosConceptualesDestacados() {
        System.out.println("\n--- INVENTOS CONCEPTUALES DESTACADOS ---");
        System.out.println("(Con prototipo Y viabilidad Alta)\n");
        
        int count = 0;
        for (Invento invento : inventos) {
            if (invento instanceof InventoConceptual) {
                InventoConceptual con = (InventoConceptual) invento;
                if (con.isTienePrototipo() && con.getNivelViabilidad().equalsIgnoreCase("Alta")) {
                    System.out.println("╔════════════════════════════════════════╗");
                    System.out.println("  Código: " + con.getCodigo());
                    System.out.println("  Nombre: " + con.getNombre());
                    System.out.println("  Autor: " + con.getAutorTeorico());
                    System.out.println("  Valor final: $" + String.format("%.2f", con.valorFinal()));
                    System.out.println("╚════════════════════════════════════════╝");
                    count++;
                }
            }
        }

        if (count == 0) {
            System.out.println("No hay inventos conceptuales con prototipo y viabilidad Alta.");
        } else {
            System.out.println("\nTotal: " + count + " invento(s) conceptual(es) destacado(s).");
        }
    }

    /**
     * Buscar un invento por su código
     */
    private Invento buscarInventoPorCodigo(String codigo) {
        for (Invento invento : inventos) {
            if (invento.getCodigo().equalsIgnoreCase(codigo)) {
                return invento;
            }
        }
        return null;
    }

    /**
     * Método principal para iniciar la aplicación
     */
    public static void main(String[] args) {
        Eureka laboratorio = new Eureka();
        laboratorio.mostrarMenu();
    }
}
