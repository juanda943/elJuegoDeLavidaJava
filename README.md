# Juego de la Vida de Conway

Este proyecto es una implementación del **Juego de la Vida de Conway** en **Java**. Se trata de un autómata celular diseñado por el matemático británico **John Horton Conway** en 1970. A pesar de su simplicidad, este "juego" es capaz de simular sistemas complejos y ha sido utilizado en múltiples áreas, como teoría de autómatas, matemáticas y computación.

## Contexto histórico
El Juego de la Vida fue desarrollado por Conway mientras investigaba sobre sistemas celulares y teoría de juegos. Se popularizó rápidamente debido a su capacidad para generar patrones complejos a partir de reglas simples. El juego ha sido utilizado en estudios sobre inteligencia artificial, biología teórica y en la simulación de sistemas dinámicos.

## Reglas del juego
El Juego de la Vida se basa en una cuadrícula donde cada celda puede estar **viva** (1) o **muerta** (0). En cada iteración, el estado de la celda cambia según las siguientes reglas:

1. **Una célula viva con menos de 2 o más de 3 vecinos vivos muere.**
2. **Una célula viva con exactamente 2 o 3 vecinos vivos sobrevive.**
3. **Una célula muerta con exactamente 3 vecinos vivos se convierte en una célula viva.**

## Descripción del proyecto
Este proyecto implementa el Juego de la Vida utilizando matrices en Java. Se inicializa una matriz de tamaño **10x10** con valores aleatorios (0 o 1), y se generan nuevas generaciones basadas en las reglas del juego.

## Instalación y ejecución
Para ejecutar este proyecto, necesitas tener instalado **Java**. Sigue estos pasos:

1. Clona el repositorio o descarga los archivos.
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd <NOMBRE_DEL_REPOSITORIO>
   ```
2. Compila el código con el siguiente comando:
   ```bash
   javac Main.java
   ```
3. Ejecuta el programa:
   ```bash
   java Main
   ```

## Ejemplo de salida
Al ejecutar el programa, verás la representación de la matriz inicial y sus actualizaciones en la consola, donde:
- ⬜ representa una célula viva.
- ⬛ representa una célula muerta.

```
⬛⬜⬜⬛⬛⬜⬜⬛⬛⬛
⬜⬛⬛⬜⬜⬜⬜⬛⬜⬛
⬜⬜⬛⬜⬜⬛⬜⬛⬜⬜
⬛⬜⬜⬜⬜⬛⬜⬜⬜⬛
...
```

## Materia y carrera
Este proyecto fue desarrollado como parte de la materia **Estructuras de Datos** dentro de la **ETITC** en la carrera de **Técnico Profesional en Computación**.

---

¡Espero que este README le ayude a comprender el proyecto! 🚀
