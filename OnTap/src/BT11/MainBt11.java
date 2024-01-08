package BT11;

import java.util.Scanner;

import static java.lang.Math.sqrt;

public class MainBt11 {
    public static boolean KiemTraSoNguyenTo(int n){
        if (n <= 3)
            return true;
        for (int i = 2; i <= sqrt(n); i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 2;
        int count = 0;
        while (count < 1000){
            if (KiemTraSoNguyenTo(n)){
                System.out.print(n + " ");
                count++;
                if (count % 10 == 0)
                    System.out.print("\n");
            }
            n++;
        }
    }
}
