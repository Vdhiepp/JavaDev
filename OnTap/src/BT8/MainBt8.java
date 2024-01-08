package BT8;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MainBt8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.0");
        int dem = 0, demAm = 0, demDuong = 0, tong = 0, so;

        do {
            System.out.println("Nhập vào 1 số nguyên: ");
            so = scanner.nextInt();

            if (so > 0) {
                tong += so;
                demDuong++;
            }
            if (so < 0) {
                tong += so;
                demAm++;
            }
            dem++;
        } while (so != 0);
        System.out.println("\nCó " + demDuong + " số dương.");
        System.out.println("Có " + demAm + " số âm.");
        System.out.println("Tổng là: " + tong);
        System.out.println("Trung bình là: " + df.format(tong / (float) (dem - 1)));
    }
}
