package by.meearlyam.jazzteam.controller;

import by.meearlyam.jazzteam.model.AbstractNumberToStringConverter;
import by.meearlyam.jazzteam.model.DefaultNumberToStringConverter;

import java.util.Scanner;

/**
 * JazzTeam test task controller class
 *
 * @author Vera Shavela
 * @version 1.0
 */
public class ConverterController {

    public static final AbstractNumberToStringConverter CONVERTER = new DefaultNumberToStringConverter();

    public static void main(String... args) {

        Scanner sc = new Scanner(System.in);
        boolean isInDemand = true;

        System.out.println("Введите число, и нажмите Enter, чтобы увидеть его строковое представление.\n" +
                "Если хотите завершить программу, нажмите \"x\", а затем Enter.\n");
        while (isInDemand) {
            System.out.print("Число или \"х\": ");
            String input = sc.nextLine();
            long numbIn;
            try {
                numbIn = Long.parseLong(input);
                System.out.println(numbIn + " = " + CONVERTER.getName(numbIn));
            } catch (NumberFormatException e) {
                if(input.equals("x")) {
                    isInDemand = false;
                }
                else {
                    System.out.println("Вы можете ввести только число или английское \"х\"!!");
                }
            }
        }
    }
}
