public class Main {
    // Variable necesaria para la validación (debe ser estática si se usa en un método estático)
    static int contador = 0;
    static int generaciones = 5;

    public static void main(String[] args) {
        int[][] matrix = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        System.out.println(); // Espacio entre filas

        System.out.println("Matriz inicial");

        // Rellena la matriz inicial con 0 y 1 aleatorios e imprime
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) Math.round(Math.random());
                if (matrix[i][j] == 1) {
                    System.out.print('\u2B1C');
                } else {
                    System.out.print('\u2B1B');
                }
            }
            System.out.println();
        }

        //For para la generacion de matrices

        for (int gen = 1; gen <= generaciones; gen++) {
            System.out.println("\nGeneración " + gen + ":");

            // Crear matriz para vecinos
            int[][] vecinosMatrix = new int[matrix.length][matrix[0].length];

            // Calcular cantidad de vecinos por celda
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    vecinosMatrix[i][j] = validarVecinos(matrix, i, j);
                }
            }

            // Calcular nueva generación
            nuevaGeneracion(matrix, vecinosMatrix);
        }

        //Crear matriz para en la que se guardaran la cantidad de vecinos por celda

        int[][] vecinosMatrix = new int[matrix.length][matrix[0].length];

        // Validar células y gestionar su siguiente estado
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int cantidadVecinas = validarVecinos(matrix, i, j);
                vecinosMatrix[i][j] = cantidadVecinas;
                //System.out.print(cantidadVecinas + " "); permite visualizar la matriz con el conteo
            }
            System.out.println();
        }
    
    }

    // Método para validar vecinos
    static int validarVecinos(int[][] matrix, int i, int j) {
        int contador = 0; // Reiniciamos contador en cada llamada

        if (i == 0 && j == 0) { // Esquina superior izquierda
            if (matrix[9][9] == 1) contador++;
            if (matrix[0][9] == 1) contador++;
            if (matrix[1][9] == 1) contador++;
            if (matrix[9][0] == 1) contador++;
            if (matrix[1][0] == 1) contador++;
            if (matrix[9][1] == 1) contador++;
            if (matrix[0][1] == 1) contador++;
            if (matrix[1][1] == 1) contador++;
        } else if (i == 9 && j == 0) { // Esquina Superior Derecha
            if (matrix[i - 1][9] == 1) contador++;
            if (matrix[i][9] == 1) contador++;
            if (matrix[0][9] == 1) contador++;
            if (matrix[i - 1][j] == 1) contador++;
            if (matrix[0][j] == 1) contador++;
            if (matrix[i - 1][j + 1] == 1) contador++;
            if (matrix[i][j + 1] == 1) contador++;
            if (matrix[0][j + 1] == 1) contador++;
        } else if (i == 9 && j == 9) { // Esquina inferior derecha
            if (matrix[i - 1][j - 1] == 1) contador++;
            if (matrix[i][j - 1] == 1) contador++;
            if (matrix[0][j - 1] == 1) contador++;
            if (matrix[i - 1][j] == 1) contador++;
            if (matrix[0][j] == 1) contador++;
            if (matrix[i - 1][0] == 1) contador++;
            if (matrix[i][0] == 1) contador++;
            if (matrix[0][0] == 1) contador++;
        } else if (i == 0 && j == 9) { // Esquina Inferior Izquierda
            if (matrix[9][j - 1] == 1) contador++;
            if (matrix[i][j - 1] == 1) contador++;
            if (matrix[i + 1][j - 1] == 1) contador++;
            if (matrix[9][j] == 1) contador++;
            if (matrix[i + 1][j] == 1) contador++;
            if (matrix[9][0] == 1) contador++;
            if (matrix[i][0] == 1) contador++;
            if (matrix[i + 1][0] == 1) contador++;
        } else if (i == 0 && j != 0) { // Columna izquierda
            if (matrix[9][j - 1] == 1) contador += 1;
            if (matrix[i][j - 1] == 1) contador += 1;
            if (matrix[i + 1][j - 1] == 1) contador += 1;
            if (matrix[9][j] == 1) contador += 1;
            if (matrix[i + 1][j] == 1) contador += 1;
            if (matrix[9][j + 1] == 1) contador += 1;
            if (matrix[i][j + 1] == 1) contador += 1;
            if (matrix[i + 1][j + 1] == 1) contador += 1;
        } else if (i == 9 && j != 0) { // Columna derecha
            if (matrix[i - 1][j - 1] == 1) contador += 1;
            if (matrix[i][j - 1] == 1) contador += 1;
            if (matrix[0][j - 1] == 1) contador += 1;
            if (matrix[i - 1][j] == 1) contador += 1;
            if (matrix[0][j] == 1) contador += 1;
            if (matrix[i - 1][j + 1] == 1) contador += 1;
            if (matrix[i][j + 1] == 1) contador += 1;
            if (matrix[0][j + 1] == 1) contador += 1;
        } else if (j == 0 && i != 0) { // Fila superior
            if (matrix[i - 1][9] == 1) contador += 1;
            if (matrix[i][9] == 1) contador += 1;
            if (matrix[0][9] == 1) contador += 1;
            if (matrix[i - 1][j] == 1) contador += 1;
            if (matrix[i + 1][j] == 1) contador += 1;
            if (matrix[i - 1][j + 1] == 1) contador += 1;
            if (matrix[i][j + 1] == 1) contador += 1;
            if (matrix[i + 1][j + 1] == 1) contador += 1;
        } else if (j == 0 && i != 0) { // Fila inferior
            if (matrix[i - 1][j - 1] == 1) contador += 1;
            if (matrix[i][j - 1] == 1) contador += 1;
            if (matrix[i + 1][j - 1] == 1) contador += 1;
            if (matrix[i - 1][j] == 1) contador += 1;
            if (matrix[i + 1][j] == 1) contador += 1;
            if (matrix[i - 1][0] == 1) contador += 1;
            if (matrix[i][0] == 1) contador += 1;
            if (matrix[i + 1][0] == 1) contador += 1;
        } else if (i != 0 && j != 0 && i != 9 && j != 9){ // Cualquier otra celda
            if (matrix[i - 1][j - 1] == 1) contador++;
            if (matrix[i][j - 1] == 1) contador++;
            if (matrix[i + 1][j - 1] == 1) contador++;
            if (matrix[i - 1][j] == 1) contador++;
            if (matrix[i + 1][j] == 1) contador++;
            if (matrix[i - 1][j + 1] == 1) contador++;
            if (matrix[i][j + 1] == 1) contador++;
            if (matrix[i + 1][j + 1] == 1) contador++;
        }

        return contador; // Retornamos el número de vecinos vivos
    }

    //Metodo para la siguiente generacion aplicacion de reglas
    static void nuevaGeneracion( int[][] estado, int[][] vecinos){
        for (int i = 0; i < estado.length; i++) {
            for (int j = 0; j < estado[i].length; j++) {
                if ((estado[i][j] == 1 && vecinos[i][j] <2) || (estado[i][j] == 1 && vecinos[i][j] >3) ) {
                    estado[i][j] = 0;
                    System.out.print('\u2B1B');
                } else if ((estado[i][j] == 1 && vecinos[i][j] == 2) || (estado[i][j] == 1 && vecinos[i][j] == 3)) {
                    estado[i][j] = 1;
                    System.out.print('\u2B1C');
                } else if (estado[i][j] == 0 && vecinos[i][j] == 3){
                    estado[i][j] = 1;
                    System.out.print('\u2B1C');
                } else{
                    estado[i][j] = 0;
                    System.out.print('\u2B1B');
                }
            }
            System.out.println();
        }
    }

    
}
