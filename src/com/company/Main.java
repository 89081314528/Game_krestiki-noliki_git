package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**1) написать метод, который принимает поле(лист) и игрока(х или 0) и проверяет, победил ли игрок
 * 2) написать метод, который принимает поле, игрока, и номер ячейки. если игрок может поставить туда символ, то ставим
 * символ в поле и вернуть из метода  инт 0
 * если такой ячейки нет, вернуть минус 1
 * если нельзя поставить символ в ячейку, вернуть минус 2
 * 3) предлагать игроку сделать ход 5 раз
 * 4) почему после выигрыша печатает еще строку, хотя там есть ретерн?????????
 * 5) дописать ничью
 */

public class Main {

    public static void main(String[] args) {
        List<String> field = new ArrayList<>(List.of(
                "1 ", "2 ", "3 ",
                "4 ", "5 ", "6 ",
                "7 ", "8 ", "9 "));
        printField(field);
        for (int i = 0; i < 9; i++) {
            System.out.println("Ход игрока Х, введите номер ячейки, в которой хотите поставить Х");
            Scanner inputNumberOfCell = new Scanner(System.in);
            int numberOfCell = inputNumberOfCell.nextInt();
            int countWrongInput = 0;
            for (int g = 0; g < 5; g++) {
                if (fillCell(field, "x ", numberOfCell) == -1) {
                    System.out.println("Можно вносить только числа от 1 до 9");
                    countWrongInput = countWrongInput + 1;
                    System.out.println("Неверных попыток ввода данных " + countWrongInput);
                    if (countWrongInput == 3) {
                        System.out.println("Вы превысили лимит попыток ввода, победил игрок 0");
                        return;
                    }
                    numberOfCell = inputNumberOfCell.nextInt();
                } else if (fillCell(field, "x ", numberOfCell) == -2) {
                    System.out.println("Эта ячейка уже занята, выберите другую ячейку");
                    countWrongInput = countWrongInput + 1;
                    System.out.println("Неверных попыток ввода данных " + countWrongInput);
                    if (countWrongInput == 3) {
                        System.out.println("Вы превысили лимит попыток ввода, победил игрок 0");
                        return;
                    }
                    numberOfCell = inputNumberOfCell.nextInt();
                } else
                   if (fillCell(field, "x ", numberOfCell) == 0) {
                       field.set((numberOfCell - 1), "x ");
                       break;
                   }
            }
            printField(field);
            isPlayerWin(field, "x");
            System.out.println("Ход игрока 0, введите номер ячейки, в которой хотите поставить 0");
            numberOfCell = inputNumberOfCell.nextInt();
            countWrongInput = 0;
            for (int g = 0; g < 5; g++) {
                if (numberOfCell > 9 || numberOfCell < 1) {
                    System.out.println("Можно вносить только числа от 1 до 9");
                    countWrongInput = countWrongInput + 1;
                    System.out.println("Неверных попыток ввода данных " + countWrongInput);
                    if (countWrongInput == 3) {
                        System.out.println("Вы превысили лимит попыток ввода, победил игрок 0");
                        return;
                    }
                    numberOfCell = inputNumberOfCell.nextInt();
                } else if (field.get(numberOfCell - 1).equals("0 ") || field.get(numberOfCell - 1).equals("x ")) {
                    System.out.println("Эта ячейка уже занята, выберите другую ячейку");
                    countWrongInput = countWrongInput + 1;
                    System.out.println("Неверных попыток ввода данных " + countWrongInput);
                    if (countWrongInput == 3) {
                        System.out.println("Вы превысили лимит попыток ввода, победил игрок x");
                        return;
                    }
                    numberOfCell = inputNumberOfCell.nextInt();
                } else
                    break;
            }
            field.set((numberOfCell - 1), "0 ");
            printField(field);
            isPlayerWin(field, "0");
        }
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

    public static void isPlayerWin(List<String> field, String player) {
        if (player.equals("x") && ((field.get(0).equals("x ") && field.get(1).equals("x ") && field.get(2).equals("x "))
                || (field.get(3).equals("x ") && field.get(4).equals("x ") && field.get(5).equals("x "))
                || (field.get(6).equals("x ") && field.get(7).equals("x ") && field.get(8).equals("x "))
                || (field.get(0).equals("x ") && field.get(3).equals("x ") && field.get(6).equals("x "))
                || (field.get(1).equals("x ") && field.get(4).equals("x ") && field.get(7).equals("x "))
                || (field.get(2).equals("x ") && field.get(5).equals("x ") && field.get(8).equals("x "))
                || (field.get(0).equals("x ") && field.get(4).equals("x ") && field.get(8).equals("x "))
                || (field.get(2).equals("x ") && field.get(4).equals("x ") && field.get(6).equals("x ")))) {
            System.out.println("Выиграл игрок Х");
            return;
        }
        if (player.equals("0") && ((field.get(0).equals("0 ") && field.get(1).equals("0 ") && field.get(2).equals("0 "))
                || (field.get(3).equals("0 ") && field.get(4).equals("0 ") && field.get(5).equals("0 "))
                || (field.get(6).equals("0 ") && field.get(7).equals("0 ") && field.get(8).equals("0 "))
                || (field.get(0).equals("0 ") && field.get(3).equals("0 ") && field.get(6).equals("0 "))
                || (field.get(1).equals("0 ") && field.get(4).equals("0 ") && field.get(7).equals("0 "))
                || (field.get(2).equals("0 ") && field.get(5).equals("0 ") && field.get(8).equals("0 "))
                || (field.get(0).equals("0 ") && field.get(4).equals("0 ") && field.get(8).equals("0 "))
                || (field.get(2).equals("0 ") && field.get(4).equals("0 ") && field.get(6).equals("0 ")))) {
            System.out.println("Выиграл игрок 0");
            return;
        }
    }

    public static int fillCell(List<String> field, String player, int numberOfCell) {
        if (numberOfCell > 9 || numberOfCell < 1) {
            return -1;
        } else if (field.get(numberOfCell - 1).equals("0 ") || field.get(numberOfCell - 1).equals("x ")) {
            return -2;
        } else
//            field.set((numberOfCell - 1), player);
//        не получается заполнить ячейку
        return 0;
    }
}


