package battleship_angelrisso;

import java.util.Scanner;
import java.util.Random;

public class Battleship_AngelRisso {

    static Scanner sc = new Scanner(System.in);
    static Random ran = new Random();

    public static void main(String[] args) {
        int nave1 = 4, nave2 = 4;
        String[][] tablero1 = {
            {"   ", " 0 ", " 1 ", " 2 ", " 3 ", " 4 ", " 5 ", " 6 ", " 7 "},
            {"A |", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
            {"B |", "[ ]", "[#]", "[#]", "[#]", "[ ]", "[ ]", "[ ]", "[ ]"},
            {"C |", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[#]"},
            {"D |", "[ ]", "[ ]", "[ ]", "[ ]", "[#]", "[ ]", "[ ]", "[#]"},
            {"E |", "[ ]", "[ ]", "[ ]", "[ ]", "[#]", "[ ]", "[ ]", "[#]"},
            {"F |", "[ ]", "[ ]", "[ ]", "[ ]", "[#]", "[ ]", "[ ]", "[ ]"},
            {"G |", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
            {"H |", "[ ]", "[#]", "[#]", "[#]", "[ ]", "[ ]", "[ ]", "[ ]"}};
        String[][] tablero2 = {
            {"   ", " 0 ", " 1 ", " 2 ", " 3 ", " 4 ", " 5 ", " 6 ", " 7 "},
            {"A |", "[ ]", "[#]", "[#]", "[#]", "[ ]", "[ ]", "[ ]", "[ ]"},
            {"B |", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
            {"C |", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
            {"D |", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[#]", "[#]", "[#]"},
            {"E |", "[ ]", "[ ]", "[ ]", "[ ]", "[#]", "[ ]", "[ ]", "[ ]"},
            {"F |", "[ ]", "[#]", "[ ]", "[ ]", "[#]", "[ ]", "[ ]", "[ ]"},
            {"G |", "[ ]", "[#]", "[ ]", "[ ]", "[#]", "[ ]", "[ ]", "[ ]"},
            {"H |", "[ ]", "[#]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"}};
        juego(tablero1, tablero2);
    }

    public static void imp(String matriz[][], int filas, int cols) {
        if (filas == matriz.length - 1 && cols == matriz[0].length - 1) {
            System.out.print(matriz[filas][cols] + "   ");
        } else if (cols == matriz[0].length - 1) {
            System.out.println(matriz[filas][cols]);
            imp(matriz, filas + 1, 0);
        } else {
            System.out.print(matriz[filas][cols] + "   ");
            imp(matriz, filas, cols + 1);
        }
    }

    public static void juego(String[][] tabla1, String[][] tabla2) {
        int ganar = 0, jugador = 1, barco_p1 = 4, barco_p2 = 4, des1 = 0, des2 = 0, coordx, coordy, shot;
        String disparo;
        String[] shots = {"Cheap_tequila", "Jell-0", "Kamikaze", "MindEraser", "Bombs", "Fireballs", "Whiskey"};

        boolean turno = false, golpe;
        while (ganar == 0) {
            if (turno == false) {
                shot = 0 + ran.nextInt(6);
                disparo = shots[shot];
                System.out.println("Jugador: " + jugador + "       naves destruidas por jugador: " + des1);
                System.out.println("");
                imp(tabla1, 0, 0);
                System.out.println("");
                imp(tabla2, 0, 0);
                System.out.println();
                switch (disparo) {
                    case "Cheap_tequila":
                        System.out.println(disparo + " Con dinero, pero indio");
                        break;
                    case "Jell-0":
                        System.out.println(disparo + " Es aburrido, pero es lo que es");
                        break;
                    case "Kamikaze":
                        System.out.println(disparo + " ALLAHU AKBAR");
                        break;
                    case "MindErazer":
                        System.out.println(disparo + " Adonde estoy, y quien eres tu?");
                        break;
                    case "Bombs":
                        System.out.println(disparo + " asi si se empieza una guerra");
                        break;
                    case "Fireballs":
                        System.out.println(disparo + " peleando como los Romanos y los Griegos");
                        break;
                    default:
                        System.out.println(disparo + " y un buen puro van muy bien, asi se domina el mundo");
                        break;
                    
                }
                System.out.println("ingrese sus coordenadas de ataque, en el formato (x,y): ");
                coordx = sc.nextInt();
                coordy = sc.nextInt();
                golpe = ataque(tabla2, coordx, coordy);
                if (golpe = true) {
                    System.out.println("Ataque critico");
                    tabla2[coordy+1][coordx+1] = "[X]";
                    for (int i = 0; i < tabla2.length - 2; i++) {
                        for (int j = 0; j < tabla2[0].length - 2; j++) {
                            if (tabla2[i][j].equals("[X]") && tabla2[i + 1][j].equals("[X]") && tabla2[i - 1][j].equals("[X]")
                                    || tabla2[i][j].equals("[X]") && tabla2[i][j + 1].equals("[X]") && tabla2[i][j - 1].equals("[X]")) {
                                barco_p2--;
                                des1++;
                            }
                        }
                    }
                } else {
                    System.out.println("fallo");
                }
                if (barco_p2 == 0 || des1 == 4) {
                    System.out.println("GRAN HONOR AL JUGADOR 1");
                    ganar = 1;
                }
                turno = true;
                jugador=2;
            } else {
                System.out.println("Jugador: " + jugador + "       naves destruidas por jugador: " + des2);
                
                System.out.println("");
                imp(tabla1, 0, 0);
                System.out.println("");
                imp(tabla2, 0, 0);
                shot = 0 + ran.nextInt(6);
                disparo = shots[shot];
                switch (disparo) {
                    case "Cheap_tequila":
                        System.out.println(disparo + " Con dinero, pero indio");
                        break;
                    case "Jell-0":
                        System.out.println(disparo + " Es aburrido, pero es lo que es");
                        break;
                    case "Kamikaze":
                        System.out.println(disparo + " ALLAHU AKBAR");
                        break;
                    case "MindErazer":
                        System.out.println(disparo + " Adonde estoy, y quien eres tu?");
                        break;
                    case "Bombs":
                        System.out.println(disparo + " asi si se empieza una guerra");
                        break;
                    case "Fireballs":
                        System.out.println(disparo + " peleando como los Romanos y los Griegos");
                        break;
                    default:
                        System.out.println(disparo + " y un buen puro van muy bien, asi se domina el mundo");
                        break;
                }
                System.out.println("ingrese sus coordenadas de ataque, en el formato (x,y): ");
                coordx = sc.nextInt();
                coordy = sc.nextInt();
                golpe = ataque(tabla1, coordx, coordy);
                if (golpe = true) {
                    System.out.println("Ataque critico");
                    tabla1[coordy][coordx] = "[X]";
                    for (int i = 0; i < tabla2.length - 2; i++) {
                        for (int j = 0; j < tabla2[0].length - 2; j++) {
                            if (tabla2[i][j].equals("[X]") && tabla2[i + 1][j].equals("[X]") && tabla2[i - 1][j].equals("[X]")
                                    || tabla2[i][j].equals("[X]") && tabla2[i][j + 1].equals("[X]") && tabla2[i][j - 1].equals("[X]")) {
                                barco_p1--;
                                des2++;
                            }
                        }
                    }
                } else {
                    System.out.println("fallo");
                }
                if (barco_p1 == 0 || des2 == 4) {
                    System.out.println("GRAN HONOR AL JUGADOR 2");
                    ganar = 1;
                }
                turno = false;
                jugador=1;
            }
        }
    }

    public static boolean ataque(String[][] tabla, int cordx, int cordy) {
        boolean pegar = false;
        for (int i = 0; i < tabla.length - 2; i++) {
            for (int j = 0; j < tabla[0].length - 2; j++) {
                if (tabla[cordy][cordx].equals("[#]")) {
                    if (tabla[i + 1][j].equals("[#]") && tabla[i - 1][j].equals("[#]") || tabla[i][j + 1].equals("[#]") && tabla[i][j - 1].equals("[#]")) {
                        pegar = true;
                    }
                } else {
                    pegar = false;
                }
            }
        }
        return pegar;
    }
}
