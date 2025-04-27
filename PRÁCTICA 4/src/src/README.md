# Calculadora de Distancias

## Descripción General

Este proyecto implementa una herramienta para calcular la distancia de edición entre dos cadenas utilizando una versión modificada del algoritmo de Levenshtein, siguiendo la descripción propuesta por Jurafsky. El objetivo es determinar la cantidad mínima de operaciones necesarias (inserción, borrado o sustitución de caracteres) para transformar una cadena en otra.

## Teoría del Método

### Algoritmo de Levenshtein

La distancia de edición, comúnmente conocida como distancia de Levenshtein, mide qué tan diferentes son dos cadenas contando la cantidad mínima de operaciones básicas requeridas para transformar una cadena en otra. Las operaciones permitidas son:

Inserción de un carácter.

Eliminación de un carácter.

Sustitución de un carácter.

En esta implementación específica, siguiendo la propuesta de Jurafsky, se asigna un costo distinto a la sustitución dependiendo de si los caracteres comparados son iguales (costo 0) o distintos (costo 2). Las operaciones de inserción y eliminación tienen un costo de 1.

## Estructura del Proyecto

proyecto/
├── distancias/
│   └── CalculadoraDistancias.java
└── main/
    └── Main.java

distancias: Paquete que contiene la clase CalculadoraDistancias, responsable del cálculo.

main: Paquete que contiene la clase Main, utilizada para probar y ejecutar el proyecto.

## Ejemplos de Uso

El método principal incluye ejemplos para calcular distancias de forma sensible e insensible a mayúsculas/minúsculas:

String palabra1 = "Alejandro";
String palabra2 = "Alejandras";

int distancia = CalculadoraDistancias.calcularDistancia(palabra1, palabra2);
System.out.println(distancia);

int distancia2 = CalculadoraDistancias.calcularDistancia(palabra1, palabra2, false);
System.out.println(distancia2);

# Consideraciones adicionales

El parámetro caseSensitive permite decidir si la comparación debe ser sensible o insensible a mayúsculas.

El proyecto puede extenderse para incorporar otros algoritmos de comparación o análisis de cadenas.