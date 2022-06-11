package ru.skypro;

public class Main {

    public static void main(String[] args) {
           boolean result = Validator.check("test_13", "D_1hWiKjjP_d", "D_1hWiKjjP_аава");
           if (result) {
               System.out.println("Vse horosho!");
           } else {
               System.out.println("Parol ili login nekorrektny");
           }
    }



}
