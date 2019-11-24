package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 1) написать метод, который принимает поле(лист) и игрока(х или 0) и проверяет, победил ли игрок
 * 2) написать метод, который принимает поле, игрока, и номер ячейки. если игрок может поставить туда символ, то ставим
 * символ в поле и вернуть из метода  инт 0
 * если такой ячейки нет, вернуть минус 1
 * если нельзя поставить символ в ячейку, вернуть минус 2
 * 3) предлагать игроку сделать ход 5 раз, то есть возможность ошибиться 5 раз, потом игра заканчивается победой другого
 * игрока
 * 5) дописала ничью
 */

public class Main {

    public static void main(String[] args) {
        List<String> field = new ArrayList<>(List.of(
                "1 ", "2 ", "3 ",
                "4 ", "5 ", "6 ",
                "7 ", "8 ", "9 "));
        printField(field);
        for (int i = 0; i < 5; i++) {
            System.out.println("Ход игрока Х, введите номер ячейки, в которой хотите поставить Х");
            Scanner inputNumberOfCell = new Scanner(System.in);
            int numberOfCell = inputNumberOfCell.nextInt();
            int countWrongInput = 0;
            for (int g = 0; g < 5; g++) {
                int fillCellResult = fillCell(field,"x ", numberOfCell);
                if (fillCellResult == -1) {
                    System.out.println("Можно вносить только числа от 1 до 9");
                } else if (fillCellResult == -2) {
                    System.out.println("Эта ячейка уже занята, выберите другую ячейку");
                } else if (fillCellResult == 0) {
                    break;
                }
                countWrongInput = countWrongInput + 1;
                System.out.println("Неверных попыток ввода данных " + countWrongInput);
                if (countWrongInput == 5) {
                    System.out.println("Вы превысили лимит попыток ввода, победил игрок 0");
                    return;
                }
                numberOfCell = inputNumberOfCell.nextInt();
            }
            printField(field);
            int isPlayerWinResult = isPlayerWin(field, "x ");
            if (isPlayerWinResult == 1) {
                return;
            }
            if (i == 4) {
                break;
            }
            System.out.println("Ход игрока 0, введите номер ячейки, в которой хотите поставить 0");
            numberOfCell = inputNumberOfCell.nextInt();
            countWrongInput = 0;
            for (int g = 0; g < 5; g++) {
                int fillCellResult = fillCell(field,"0 ", numberOfCell);
                if (fillCellResult == -1) {
                    System.out.println("Можно вносить только числа от 1 до 9");
                } else if (fillCellResult == -2) {
                    System.out.println("Эта ячейка уже занята, выберите другую ячейку");
                } else if (fillCellResult == 0) {
                    break;
                }
                countWrongInput = countWrongInput + 1;
                System.out.println("Неверных попыток ввода данных " + countWrongInput);
                if (countWrongInput == 5) {
                    System.out.println("Вы превысили лимит попыток ввода, победил игрок 0");
                    return;
                }
                numberOfCell = inputNumberOfCell.nextInt();
            }
            printField(field);
            isPlayerWinResult = isPlayerWin(field, "0 ");
            if (isPlayerWinResult == 1) {
                return;
            }
        }
        System.out.println("Ничья");
    }

    public static void printField(List<String> field) {
        for (int i = 0; i < 3; i++) {
            System.out.print(field.get(i));
        }
        System.out.println();
        for (int i = 3; i < 6; i++) {
            System.out.print(field.get(i));
        }
        System.out.println();
        for (int i = 6; i < 9; i++) {
            System.out.print(field.get(i));
        }
        System.out.println();
    }

    public static int isPlayerWin(List<String> field, String player) {
        if ((field.get(0).equals(player) && field.get(1).equals(player) && field.get(2).equals(player))
                || (field.get(3).equals(player) && field.get(4).equals(player) && field.get(5).equals(player))
                || (field.get(6).equals(player) && field.get(7).equals(player) && field.get(8).equals(player))
                || (field.get(0).equals(player) && field.get(3).equals(player) && field.get(6).equals(player))
                || (field.get(1).equals(player) && field.get(4).equals(player) && field.get(7).equals(player))
                || (field.get(2).equals(player) && field.get(5).equals(player) && field.get(8).equals(player))
                || (field.get(0).equals(player) && field.get(4).equals(player) && field.get(8).equals(player))
                || (field.get(2).equals(player) && field.get(4).equals(player) && field.get(6).equals(player))) {
            System.out.println("Выиграл игрок " + player);
            return 1;
        }
        return -1;
    }

    public static int fillCell(List<String> field, String player, int numberOfCell) {
        if (numberOfCell > 9 || numberOfCell < 1) {
            return -1;
        } else if (field.get(numberOfCell - 1).equals("0 ") || field.get(numberOfCell - 1).equals("x ")) {
            return -2;
        } else
            field.set((numberOfCell - 1), player);
            return 0;
    }
}


