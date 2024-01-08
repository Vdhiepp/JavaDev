import java.util.Scanner;
import static java.lang.Math.sqrt;

public class Cau1 {
    public static int NhapSo(){
        Scanner scanner = new Scanner(System.in);
        int n;
        do{
            System.out.print("Nhập vào số nguyên dương >1: ");
            n = scanner.nextInt();
        } while (n <= 1);
        return n;
    }
    public static boolean KTSoNguyenTo(int n){
        if (n == 1)
            return false;
        if (n <= 3)
            return true;
        for (int i = 2; i <= sqrt(n); i++){
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            System.out.println("Nhập số phần tử của mảng 5<=n<=10: ");
            n = scanner.nextInt();
        }while (n < 5 || n > 10);
        int[] mang = new int[n];
        int tong = 0;
        for (int i = 0; i < n; i++){
            mang[i] = NhapSo();
            if (KTSoNguyenTo(mang[i]))
                tong = tong + mang[i];
        }
        System.out.println("Tổng các số nguyên tố của dãy trên là: " + tong);
    }
}
