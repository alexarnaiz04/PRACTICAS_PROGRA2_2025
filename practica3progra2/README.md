# Cálculo de π mediante el Método de Montecarlo (con Streams en Java)

Este proyecto implementa un sencillo método de Montecarlo para aproximar el valor de π.  
La principal característica es el uso de la API de Streams de Java para generar y filtrar puntos (dardos) aleatorios.

---

## 1. Descripción general

El **método de Montecarlo** es una técnica estadística que permite resolver problemas de diversa índole (matemáticos, físicos, de optimización, etc.) mediante la generación y análisis de datos aleatorios.

En este caso, nos centramos en **aproximar el valor de π** de la siguiente manera:
1. Se lanzan “dardos” dentro de un cuadrado unidad en el primer cuadrante \([0,1) \times [0,1)\).
2. Se cuenta cuántos “dardos” caen dentro del círculo de radio 1 centrado en \((0,0)\) (primer cuadrante).
3. Aplicando la relación de áreas, se puede obtener una aproximación de π.

---

## 2. Teoría del método

### 2.1. Círculo unitario y cuadrado contenedor

- **Círculo unitario** (radio = 1) en el **primer cuadrante**:  
  \( x^2 + y^2 \le 1 \), con \( x \in [0, 1),\ y \in [0, 1) \).  

- **Cuadrado** que lo circunscribe:  
  Sus vértices van de \((0,0)\) a \((1,1)\), por lo que su área es 1.

### 2.2. Relación con π

En el primer cuadrante, el área de la porción de círculo es \(\frac{\pi}{4}\).  
Por lo tanto, si hacemos \( N \) lanzamientos (puntos aleatorios) y contamos cuántos caen dentro del círculo (aciertos), podemos estimar:

\[
\pi \approx 4 \times \frac{\text{aciertos}}{N}.
\]

---

## 3. Estructura del proyecto

El proyecto se compone principalmente de dos clases:

1. **Principal**:  
   - Define el `main`.
   - Solicita el número de dardos a lanzar.
   - Imprime el valor aproximado de π.
   - Muestra un ejemplo del uso de la clase `Mates`.

2. **Mates**:  
   - Contiene la lógica para calcular la aproximación de π mediante Montecarlo.
   - Emplea un `LongStream` para generar índices de 0 hasta \( N - 1 \) (N = número de pasos).
   - Genera las coordenadas aleatorias \((x, y)\) y cuenta cuántos puntos caen dentro del círculo unitario.

---

## 4. Implementación y uso de Streams

Para contar los aciertos, se utiliza la siguiente lógica con Streams:

1. `LongStream.range(0, pasosLambda)` crea un **stream** de valores `long` desde 0 hasta `pasosLambda - 1`.
2. Por cada elemento del stream, se generan dos números aleatorios `x` e `y` en \([0,1)\).
3. Se filtra (`filter(...)`) solo a aquellos puntos que satisfacen \( x^2 + y^2 \le 1 \) (dentro del círculo).
4. `count()` devuelve cuántos elementos quedaron tras el filtrado (i.e., cuántos “dardos” acertaron en el círculo).

La fórmula final para obtener π es:

\[
\pi \approx 4 \times \frac{\text{aciertos}}{\text{pasosLambda}}.
\]

---

## 5. Compilación y ejecución

### 5.1. Compilación

Si estás en la carpeta raíz del proyecto (que contenga los paquetes `aplicacion` y `dominio`):
```bash
javac aplicacion/Principal.java dominio/Mates.java