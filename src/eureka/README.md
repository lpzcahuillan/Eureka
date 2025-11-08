# 🧪 Laboratorio de Inventos Fracasados "Eureka"

Sistema de gestión para el Laboratorio Eureka, donde se catalogan los inventos más memorables (por sus fracasos) en las categorías: Explosivos, Domésticos y Conceptuales.

## 📋 Estructura del Proyecto

```
src/
├── Invento.java                    # Clase base abstracta
├── InventoExplosivo.java           # Inventos que hacen BOOM 💥
├── InventoDomestico.java           # Inventos para el hogar 🏠
├── InventoConceptual.java          # Ideas brillantes (en teoría) 💡
├── Eureka.java                     # Gestor principal con menú
└── PruebaDatos.java                # Archivo de prueba con datos precargados
```

## 🚀 Cómo Ejecutar

### Compilar:
```bash
cd /Users/lpzcahuillan/projects/eureka/src ## Tu ruta de trabajo
javac *.java
```

### Ejecutar el programa principal (menú interactivo):
```bash
java Eureka
```

### Ejecutar pruebas con datos precargados:
```bash
java PruebaDatos
```

## 📖 Funcionalidades

### Menú Principal:
1. **Registrar invento** - Permite agregar inventos de cualquier tipo
2. **Mostrar valor final** - Busca un invento por código y muestra su valor calculado
3. **Aplicar ajuste de valor** - Aplica descuento a inventos del año 2000
4. **Contar inventos útiles** - Cuenta domésticos con utilidad "Alta" y versión "3.0"
5. **Listar conceptuales destacados** - Muestra inventos con prototipo Y viabilidad "Alta"
6. **Salir** - Finaliza el programa

## 💡 Tipos de Inventos

### 🔥 Invento Explosivo
- **Atributos**: codigo, nombre, valorBase, marca, anioCreacion, tipoExplosivo
- **Tipos**: Transporte o Energia
- **Reglas**:
  - Año 2000: -10.5% del valor base
  - Más de 20 años: -2% adicional
  - Tipo Energia: -8.5% por reparación

### 🏠 Invento Doméstico
- **Atributos**: codigo, nombre, valorBase, version, consumoElectrico, nivelUtilidad
- **Niveles**: Alta o Baja
- **Reglas**:
  - Utilidad Alta + consumo < 200W: +$450,000

### 💡 Invento Conceptual
- **Atributos**: codigo, nombre, valorBase, autorTeorico, nivelViabilidad, tienePrototipo
- **Viabilidades**: Alta, Media, Baja
- **Reglas**:
  - Viabilidad Baja: -5% del valor base
  - Viabilidad Alta O prototipo: +$300,000

## 📝 Ejemplos de Uso

### Ejemplo 1: Invento Explosivo
```
Código: EXP001
Nombre: Cohete a Vapor
Valor base: 1000000
Marca: Rocket
Año: 2000
Tipo: Transporte

Valor final = 1000000 - 105000 (10.5%) - 20000 (2%) = $875,000
```

### Ejemplo 2: Invento Doméstico
```
Código: DOM001
Nombre: Tostadora Cuántica
Valor base: 200000
Versión: 3.0
Consumo: 150W
Utilidad: Alta

Valor final = 200000 + 450000 = $650,000
```

### Ejemplo 3: Invento Conceptual
```
Código: CON001
Nombre: Máquina del Tiempo
Valor base: 5000000
Autor: Dr. Whoo
Viabilidad: Alta
Prototipo: true

Valor final = 5000000 + 300000 = $5,300,000
```

## 📊 Fórmula General

```
valorFinal = valorBase - ajusteValor + incremento - descuento
```

## 🧪 Pruebas Automáticas

El archivo `PruebaDatos.java` incluye ejemplos precargados de todos los tipos de inventos:

### Inventos Explosivos de Prueba:
- **EXP001**: Cohete a Vapor Retro (año 2000, tipo Transporte)
- **EXP002**: Generador de Antimateria (tipo Energía, descuento adicional)
- **EXP003**: Propulsor de Plasma V2 (reciente, sin descuentos antiguos)

### Inventos Domésticos de Prueba:
- **DOM001**: Tostadora Cuántica 3.0 (Alta utilidad, < 200W, +$450,000)
- **DOM002**: Aspiradora de Bolsillo (Alta utilidad, eficiente)
- **DOM003**: Calentador de Agua Fría (Baja utilidad)

### Inventos Conceptuales de Prueba:
- **CON001**: Máquina del Tiempo (Alta viabilidad + prototipo, +$300,000)
- **CON002**: Teletransportador Molecular (Alta viabilidad sin prototipo)
- **CON003**: Motor de Movimiento Perpetuo (Baja viabilidad, -5%)
- **CON004**: Traductor Universal (Media viabilidad con prototipo)

Ejecutar `java PruebaDatos` mostrará todos los cálculos detallados.

## 📊 Fórmula General

```

## 🛠️ Tecnologías

- Java (JDK 8 o superior)
- Programación Orientada a Objetos
- Herencia y Polimorfismo
- Colecciones (ArrayList)

---

**¡Recuerda!** En el Laboratorio Eureka, el fracaso es solo el éxito en progreso. 🧪✨


