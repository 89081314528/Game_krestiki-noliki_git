package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**1) написать метод, который принимает поле(лист) и игрока(х или 0) и проверяет, победил ли игрок
 * 2) написать метод, который принимает поле, игрока, и номер ячейки. если игрок может поставить туда символ, то ставим
 * символ в поле и вернуть из метода  инт 0
 * если такой ячейки нет, вернуть минус 1
 * если нельзя поставить символ в ячейку, вернуть минус 2
 * 3) предлагать игроку сделать ход 10 раз
 *
 * 1) сделать класс персон, с полями возраст и пол. у класса должен быть метод isAdult который возвращает взрослый человек или нет
 * девочки взрослые с 15, а мальчики с 35
 * поменять возраст используя метод set
 * лист с переменными класса персон
 * 2) сделать три класса - квадрат, прямоуголтник, треуголиник и круг. у каждого из них два метода - area, perimetеr
 *
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
            for (int g = 0; g < 3 ; g++) {
                if (numberOfCell > 9 || numberOfCell < 1) {
                    System.out.println("Можно вносить только числа от 1 до 9");
                    numberOfCell = inputNumberOfCell.nextInt();
                    if (numberOfCell > 9 || numberOfCell < 1) {
                        System.out.println("Можно вносить только числа от 1 до 9");
                        numberOfCell = inputNumberOfCell.nextInt();
                        if (numberOfCell > 9 || numberOfCell < 1) {
                            System.out.println("Прочитайте правила игры и возвращайтесь снова. Победил игрок 0");
                            return;
                        }
                    }
                }
                break;
            }
            for (int j = 0; j < 3 ; j++) {
                if (field.get(numberOfCell - 1).equals("0 ") || field.get(numberOfCell - 1).equals("x ")) {
                    System.out.println("Эта ячейка уже занята, выберите другую ячейку");
                    numberOfCell = inputNumberOfCell.nextInt();
                    if (field.get(numberOfCell - 1).equals("0 ") || field.get(numberOfCell - 1).equals("x ")) {
                        System.out.println("Эта ячейка уже занята, выберите другую ячейку");
                        numberOfCell = inputNumberOfCell.nextInt();
                        if (field.get(numberOfCell - 1).equals("0 ") || field.get(numberOfCell - 1).equals("x ")) {
                            System.out.println("Прочитайте правила игры и возвращайтесь снова. Победил игрок 0");
                            return;
                        }
                    }
                }
                break;
            }
            field.set((numberOfCell - 1),"x ");
            printField(field);
            if((field.get(0).equals("x ") && field.get(1).equals("x ") && field.get(2).equals("x "))
            || (field.get(3).equals("x ") && field.get(4).equals("x ") && field.get(5).equals("x "))
            || (field.get(6).equals("x ") && field.get(7).equals("x ") && field.get(8).equals("x "))
            || (field.get(0).equals("x ") && field.get(3).equals("x ") && field.get(6).equals("x "))
            || (field.get(1).equals("x ") && field.get(4).equals("x ") && field.get(7).equals("x "))
            || (field.get(2).equals("x ") && field.get(5).equals("x ") && field.get(8).equals("x "))
            || (field.get(0).equals("x ") && field.get(4).equals("x ") && field.get(8).equals("x "))
            || (field.get(2).equals("x ") && field.get(4).equals("x ") && field.get(6).equals("x "))) {
                System.out.println("Выиграл игрок Х");
                break;
            }
            System.out.println("Ход игрока 0, введите номер ячейки, в которой хотите поставить 0");
            numberOfCell = inputNumberOfCell.nextInt();
            for (int g = 0; g < 3 ; g++) {
                if (numberOfCell > 9 || numberOfCell < 1) {
                    System.out.println("Можно вносить только числа от 1 до 9");
                    numberOfCell = inputNumberOfCell.nextInt();
                    if (numberOfCell > 9 || numberOfCell < 1) {
                        System.out.println("Можно вносить только числа от 1 до 9");
                        numberOfCell = inputNumberOfCell.nextInt();
                        if (numberOfCell > 9 || numberOfCell < 1) {
                            System.out.println("Прочитайте правила игры и возвращайтесь снова. Победил игрок Х");
                            return;
                        }
                    }
                }
                break;
            }
            for (int h = 0; h < 3 ; h++) {
                if (field.get(numberOfCell - 1).equals("0 ") || field.get(numberOfCell - 1).equals("x ")) {
                    System.out.println("Эта ячейка уже занята, выберите другую ячейку");
                    numberOfCell = inputNumberOfCell.nextInt();
                    if (field.get(numberOfCell - 1).equals("0 ") || field.get(numberOfCell - 1).equals("x ")) {
                        System.out.println("Эта ячейка уже занята, выберите другую ячейку");
                        numberOfCell = inputNumberOfCell.nextInt();
                        if (field.get(numberOfCell - 1).equals("0 ") || field.get(numberOfCell - 1).equals("x ")) {
                            System.out.println("Прочитайте правила игры и возвращайтесь снова. Победил игрок Х");
                            return;
                        }
                    }
                }
                break;
            }
                field.set((numberOfCell - 1),"0 ");
            printField(field);
            if((field.get(0).equals("0 ") && field.get(1).equals("0 ") && field.get(2).equals("0 "))
                    || (field.get(3).equals("0 ") && field.get(4).equals("0 ") && field.get(5).equals("0 "))
                    || (field.get(6).equals("0 ") && field.get(7).equals("0 ") && field.get(8).equals("0 "))
                    || (field.get(0).equals("0 ") && field.get(3).equals("0 ") && field.get(6).equals("0 "))
                    || (field.get(1).equals("0 ") && field.get(4).equals("0 ") && field.get(7).equals("0 "))
                    || (field.get(2).equals("0 ") && field.get(5).equals("0 ") && field.get(8).equals("0 "))
                    || (field.get(0).equals("0 ") && field.get(4).equals("0 ") && field.get(8).equals("0 "))
                    || (field.get(2).equals("0 ") && field.get(4).equals("0 ") && field.get(6).equals("0 "))) {
                System.out.println("Выиграл игрок 0");
                break;
            }
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
}


