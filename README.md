# Cálculo de π mediante el método de Montecarlo

Este programa permite aproximar el valor del número π utilizando el método de Montecarlo. Para ello, se simula el lanzamiento de "dardos" dentro de un cuadrado de área 4 y se cuenta cuántos caen dentro de un círculo inscrito en dicho cuadrado.

## Funcionamiento

1 El usuario introduce la cantidad de dardos a lanzar.

2 Cada dardo es representado por un par de coordenadas aleatorias (x, y) dentro del cuadrado de lado 2 (área = 4).

3 Se verifica si el dardo cae dentro del círculo de radio 1, usando la ecuación:

𝑥^2 + 𝑦^2 ≤ 1

4 Se cuenta el número de aciertos (dardos dentro del círculo).

5 La aproximación de π se calcula con la fórmula:

𝜋 ≈ Aciertos × 4 / Total de dardos lanzados​

## Estructura del código

El código está compuesto por dos clases:

Principal: Gestiona la entrada del usuario y muestra el resultado. Matematicas: Contiene el método generarNumeroPiIterativo(long pasos), que realiza la simulación y devuelve la aproximación de π.
