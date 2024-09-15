import javafx.event.ActionEvent;

import java.util.Scanner;

public class Gato {

    static char[][] tablero = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    static char turno = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean juegoEnCurso = true;

        System.out.println("¡Bienvenidos al juego de 3 en raya!");
        mostrarTablero();

        while (juegoEnCurso) {
            System.out.println("Turno de " + turno + ". Introduce fila (1-3) y columna (1-3):");
            int fila = scanner.nextInt() - 1;
            int columna = scanner.nextInt() - 1;

            if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna] == ' ') {
                tablero[fila][columna] = turno;
                mostrarTablero();

                if (verificarVictoria()) {
                    System.out.println("¡El jugador " + turno + " ha ganado!");
                    juegoEnCurso = false;
                } else if (empate()) {
                    System.out.println("¡Es un empate!");
                    juegoEnCurso = false;
                } else {
                    cambiarTurno();
                }
            } else {
                System.out.println("Movimiento no válido. Inténtalo de nuevo.");
            }
        }

        scanner.close();
    }

    public static void mostrarTablero() {
        for (int i = 0; i < 3; i++) {
            System.out.println(tablero[i][0] + " | " + tablero[i][1] + " | " + tablero[i][2]);
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }

    public static void cambiarTurno() {
        turno = (turno == 'X') ? 'O' : 'X';
    }

    public static boolean verificarVictoria() {
        // Verificar filas, columnas y diagonales
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == turno && tablero[i][1] == turno && tablero[i][2] == turno) {
                return true;
            }
            if (tablero[0][i] == turno && tablero[1][i] == turno && tablero[2][i] == turno) {
                return true;
            }
        }

        if (tablero[0][0] == turno && tablero[1][1] == turno && tablero[2][2] == turno) {
            return true;
        }

        if (tablero[0][2] == turno && tablero[1][1] == turno && tablero[2][0] == turno) {
            return true;
        }

        return false;
    }

    public static boolean empate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void manejarBoton(ActionEvent actionEvent) {

    }
}
