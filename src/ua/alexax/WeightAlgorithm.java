package ua.alexax;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WeightAlgorithm {
    private int number;
    private double group1;
    private double group2;
    private ArrayList<Double> arr = new ArrayList<>();

    private void initFile() throws FileNotFoundException {
        Scanner input = new Scanner(new File("file2.txt"));
        number = input.nextInt();
        for (int i = 0; i < number; i++) {
            arr.add(input.nextDouble());
        }
        input.close();
    }

    private void initCons() {
        System.out.println("Введіть кількість людей: ");
        Scanner scanner = new Scanner(System.in);
        try {
            number = scanner.nextInt();

            System.out.println("Введіть вагу");
            for (int i = 1; i <= number; i++) {
                System.out.println("Вага особи" + i + ":");
                arr.add(scanner.nextDouble());
            }
        } catch (InputMismatchException e) {
            // e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();

        } finally {
            scanner.close();
        }

    }

    public void start() {
         initCons();//input with console
//        try {
//            initFile();//input with file
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        if (arr.size() == 0)  {
            System.out.println("Ви ввели не коректні дані.");
            System.exit(1);
        }
            System.out.println("Ви ввели: " + arr);
        System.out.println("Розподіл за групами: \n");

        Collections.sort(arr);
        Collections.reverse(arr);

        int count;
        if (number % 2 == 0) {
            group1 = arr.get(0);
            group2 = arr.get(1);
            System.out.println("Група 1: " + arr.get(0));
            System.out.println("Група 2: " + arr.get(1));
            count = 2;
        } else {
            double temp = number / 2;
            for (int i = 0; i < temp; i++) {
                System.out.println("Група 1: " + arr.get(i));
                group1 += arr.get(i);
            }
            count = (int) (number - temp - 1);
        }

        while (count < number) {
            if (group1 >= group2) {
                group2 += arr.get(count);
                System.out.println("Група 2: " + arr.get(count));
            } else {
                group1 += arr.get(count);
                System.out.println("Група 1: " + arr.get(count));
            }
            count++;
        }
        System.out.println("\nЗагальна вага групи 1: " + group1);
        System.out.println("Загальна вага групи 2: " + group2);
    }
}
