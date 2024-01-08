package BT6;

import java.util.Scanner;

public class MainBt6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1, num2, num3, tam = 0;
        System.out.println("Nhập vào số thứ nhất: ");
        num1 = scanner.nextInt();
        System.out.println("Nhập vào số thứ hai: ");
        num2 = scanner.nextInt();
        System.out.println("Nhập vào số thứ ba: ");
        num3 = scanner.nextInt();

        if (num1 > num2){
            tam = num1;
            num1 = num2;
            num2 = tam;
        }if (num2 > num3){
            tam = num2;
            num2 = num3;
            num3 = tam;
        }if (num1 > num2){
            tam = num1;
            num1 = num2;
            num2 = tam;
        }
        System.out.println("\nKết quả: " + num1 + "<=" + num2 + "<=" + num3);
    }
}
