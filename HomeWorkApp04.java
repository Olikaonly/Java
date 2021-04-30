package lesson04.online;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Olga Shestakova
 * Date 27.04.2021
 */
public class HomeWorkApp04 {
    public static char[][] map;
    public static int mapSizeX;
    public static int mapSizeY;

    public static char human = 'X';
    public static char ai = 'O';
    public static char empty_field = '_';

    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void createMap() {
        mapSizeX = 5;
        mapSizeY = 5;
        map = new char[mapSizeY][mapSizeX];

        for (int y = 0; y < mapSizeY; y++) {
            for (int x = 0; x < mapSizeX; x++) {
                map[y][x] = empty_field;
            }
        }
    }

    public static void showMap() {
        for (int y = 0; y < mapSizeY; y++) {
            for (int x = 0; x < mapSizeX; x++) {
                System.out.print(map[y][x] + "|");
            }
            System.out.println();
        }
        System.out.println("----------");
    }

    public static void humanTurn() {
        int x;
        int y;

        do {
            System.out.println("Enter your turn coordinates from 1 before " + mapSizeX + ":");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isValidCell(x, y) || !isEmptyCell(x, y));
        map[y][x] = human;
    }

    public static void aiTurn() {
        int x;
        int y;

        do {
            x = random.nextInt(mapSizeX); //[0;mapSize)
            y = random.nextInt(mapSizeY);
        } while (!isEmptyCell(x, y));
        System.out.println("AI turn is [" + (y + 1) + ":" + (x + 1) + "]");
        map[y][x] = ai;
    }

    public static boolean isValidCell(int x, int y) {
        return x >= 0 && x < mapSizeX && y >= 0 && y < mapSizeY;
    }

    public static boolean isEmptyCell(int x, int y) {
        return map[y][x] == empty_field;
    }
    public static boolean isDraw() {
        for (int y = 0; y < mapSizeY; y++) {
            for (int x = 0; x < mapSizeX; x++) {
                if (map[y][x] == empty_field) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean checkTheDiagonals(char player) { // Проверяем диагонали со смещением
        boolean toright, toleft;

        for (int offsetX = 0; offsetX < 2; offsetX++) {
            for (int offsetY = 0; offsetY < 2; offsetY++) {
                toright = true;
                toleft = true;
                for (int i = 0; i < 4; i++) {
                    toright &= (map[i + offsetX][i + offsetY] == player);
                    toleft &= (map[3 - i + offsetX][i + offsetY] == player);
                }
                if (toright || toleft) return true;
            }
        }
        return false;
    }
    public static boolean checkTheVerticalHorizontal(char player) { // Проверяем вертикали и горизонтали со смещением
        boolean cols, rows;

        for (int offsetX = 0; offsetX < 2; offsetX++) {
            for (int offsetY = 0; offsetY < 2; offsetY++) {

                for (int col = offsetX; col < 4 + offsetX; col++) {
                    cols = true;
                    rows = true;
                    for (int row = offsetY; row < 4 + offsetY; row++) {
                        cols &= (map[col][row] == player);
                        rows &= (map[row][col] == player);
                    }
                    if (cols || rows) return true;
                }
            }
        }
        return false;
    }

    public static void main (String[]args){

        createMap();
        showMap();

        while (true) {
            humanTurn();
            showMap();

            if (checkTheDiagonals(human)) {
                System.out.println("Human win!!!");
                break;
            }
            if (checkTheVerticalHorizontal(human)) {
                System.out.println("Human win!!!");
                break;
            }

            if (isDraw()) {
                System.out.println("Is Draw!!!");
                break;
            }

            aiTurn();
            showMap();

            if (checkTheDiagonals(ai)) {
                System.out.println("AI win!!!");
                break;
            }
            if (checkTheVerticalHorizontal(ai)) {
                System.out.println("AI win!!!");
                break;
            }

            if (isDraw()) {
                System.out.println("Is Draw!!!");
                break;
            }
        }
        System.out.println("Game over!");
    }
}
