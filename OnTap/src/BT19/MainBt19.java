package BT19;

public class MainBt19 {
    public static int sumDigits(int n){
        int tong = 0;
        while (n != 0){
            tong = tong + n%10;
            n = n/10;
        }
        return tong;
    }

    public static void main(String[] args) {
        int n = 234;
        int kQua = sumDigits(n);
        System.out.println("Tổng của " + n + " là: " + kQua);
    }
}
