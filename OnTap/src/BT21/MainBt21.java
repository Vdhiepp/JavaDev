package BT21;

import java.util.Scanner;
import java.util.Stack;

public class MainBt21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào một số nguyên dương: ");
        int n = scanner.nextInt();

        Stack<Integer> primeFactors = new Stack<>();

        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                primeFactors.push(i);
                n /= i;
            }
        }

        // Hiển thị các thừa số theo thứ tự giảm dần
        System.out.print("Các thừa số nhỏ nhất theo thứ tự giảm dần: ");
        while (!primeFactors.isEmpty()) {
            System.out.print(primeFactors.pop() + " ");
        }
    }
}
