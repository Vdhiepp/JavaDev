package BT9;

import java.util.Scanner;

public class MainBt9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int so, thuaSo;
        System.out.println("Nhập vào 1 số nguyên: ");
        so = scanner.nextInt();
        thuaSo = 2;
        System.out.print("Kết quả là: ");
        while (thuaSo <= so){
            if (so % thuaSo ==0){
                so = so/thuaSo;
                System.out.print(thuaSo + " ");
            }else thuaSo++;
        }

    }
}
